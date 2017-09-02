package Controlador;

import Modelo.Campos;
import Modelo.HibernateUtil;
import Modelo.Propietario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.json.simple.JSONArray;

public class campos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI();
        String params[]=url.split("/");
        if(params.length>=3){
            switch(params[3]){
                case "registrarcampo":
                    registrarCampo(request,response);
                    break;
                case "eliminar":
                    eliminarCampo(request,response);
                    break;
                case "actualizarcampo":
                    actualizarCampo(request,response);
                    break;
                case "getJSONCampo":
                    getJSONCampo(request,response);
                    break;
                case "checkCampos":
                    checkCampos(request,response);
                    break;
            }    
        }       
    }
    
    protected void registrarCampo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Propietario prp = (Propietario)request.getSession().getAttribute("PropietarioIngresado");
            Propietario prop = new Propietario();
            prop.setIdPropietario(prp.getIdPropietario());
            String nombrecampo = request.getParameter("nombrecampo");
            String direccioncampo = request.getParameter("direccioncampo");
            String ubicacion = request.getParameter("ubicacion");
            String horarioapertura = request.getParameter("horarioapertura");
            String horariocierre = request.getParameter("horariocierre");
            String horario = horarioapertura+"/"+horariocierre;
            String foto = request.getParameter("fotocampo");
            if(foto.equals("")){
                foto="no_preview.jpg";
            }
            Session s = HibernateUtil.getSessionFactory().openSession();
            Campos cmp = new Campos(0,nombrecampo, direccioncampo, ubicacion, horario, 0, foto, prop);
            try{
                s.beginTransaction();
                s.save(cmp);
                s.getTransaction().commit();
                s.close();
                response.getWriter().write("1");
            }
            catch(HibernateException ex){
                response.getWriter().write("0");
            }    
        }
        catch(IOException | NumberFormatException | HibernateException ex){
            response.getWriter().write("0");
        }
    }
    
    protected void eliminarCampo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            int idcampo = Integer.valueOf(request.getParameter("idcampo"));
            Campos cmp = new Campos();
            cmp.setIdCampo(idcampo);
            Session s = HibernateUtil.getSessionFactory().openSession();
            try{
                s.beginTransaction();
                s.delete(cmp);
                s.getTransaction().commit();
                s.close();
                response.getWriter().write("1");
            }
            catch(IOException | HibernateException ex){
                response.getWriter().write("0");
            }
        }
        catch(NumberFormatException | HibernateException ex){
            response.getWriter().write("0");
        }
    }
    
    public List<Campos> getAll(HttpServletRequest request, HttpServletResponse response){
        List<Campos> listCampos = null;
        Propietario pr = (Propietario) request.getSession().getAttribute("PropietarioIngresado");
        try{
            Session s = HibernateUtil.getSessionFactory().openSession();   
            Query q = s.createQuery("FROM Campos WHERE Propietario = '"+pr.getIdPropietario()+"'");
            listCampos = q.list();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return listCampos;
    }
    
    protected void actualizarCampo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            int idcampo = (int) request.getSession().getAttribute("idcampoUP");
            String nombreUP = request.getParameter("nombrecampoUP");
            String direccionUP = request.getParameter("direccioncampoUP");
            String ubicacionUP = request.getParameter("ubicacionUP");
            String horarioabreUP = request.getParameter("horarioatencionabreUP");
            String horariocierreUP = request.getParameter("horarioatencioncierreUP");
            String horariosUP = horarioabreUP+"/"+horariocierreUP;
            String foto = request.getParameter("fotocampoUP");
            Propietario pr = new Propietario();
            Propietario prs = (Propietario) request.getSession().getAttribute("PropietarioIngresado");
            pr.setIdPropietario(prs.getIdPropietario());
            Campos cmp = new Campos(idcampo,nombreUP, direccionUP, ubicacionUP, horariosUP, 0, foto, pr);
            Session s = HibernateUtil.getSessionFactory().openSession();
            try{
                s.beginTransaction();
                s.update(cmp);
                s.getTransaction().commit();
                s.close();
                response.getWriter().write("1");
            }
            catch(HibernateException ex){
                response.getWriter().write("0");
                System.out.println(ex);
            }
        }
        catch(IOException | NumberFormatException | HibernateException ex){
            response.getWriter().write("0");
            System.out.println(ex);
        }
    }
    
    protected void getJSONCampo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JSONArray  campo = new JSONArray();
        int idcampo = Integer.valueOf(request.getParameter("idcampo"));
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("FROM Campos WHERE idCampo = '"+idcampo+"'");
        List<Campos> listCampo = q.list();
        
        for (Campos cm : listCampo) {
            campo.add(cm.getNombre());
            campo.add(cm.getDireccion());
            campo.add(cm.getHorario());
            campo.add(cm.getFoto());
        }
        response.setContentType("application/json");
        response.getWriter().write(campo.toJSONString());
        request.getSession().setAttribute("idcampoUP", idcampo);
    }
    
    protected void checkCampos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idProp = request.getParameter("idPropietario");
        String rt="0";
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("FROM Campos WHERE Propietario ='"+idProp+"'");
        List<Campos> list = q.list();
        if(list.size()>0){
            rt="1";
        }
        response.getWriter().write(rt);
    }
    //////////////// SE RETORNAN TODOS LOS CAMPOS EXISTENTES ////////////////////////7
    public List<Campos> verCampos(){
    
        List<Campos>listaCampos = null;
        
        try{
            
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            Query query = sesion.createQuery("FROM Campos");
            listaCampos = query.list();
            
        }catch(HibernateException ex){
        
            System.err.println(ex);
        }catch(Exception ex){
        
            System.err.println(ex);
        }
        return listaCampos;
    
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

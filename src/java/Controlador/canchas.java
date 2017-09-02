package Controlador;

import Modelo.Campos;
import Modelo.Canchas;
import Modelo.Calendar;
import Modelo.HibernateUtil;
import Modelo.calendarAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import org.json.simple.JSONObject;


public class canchas extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI();
        String [] param = url.split("/");
        if(param.length>=3){
            switch(param[3]){
                case "registrarCancha":
                    registrarCancha(request,response);
                    break;
                case "eliminarCancha":
                    eliminarCancha(request,response);
                    break;
                case "actualizarCancha":
                    actualizarCancha(request,response);
                    break;
                case "getJSONCancha":
                    getJSONCancha(request,response);
                    break;
                case "getJSONEncuentros":
                    getJSONEncuentros(request,response,param[4]);
                    break;
                case "checkCanchas":
                    checkCanchas(request,response);
                    break;
                case "guardarEncuentro":
                    guardarEncuentro(request,response);
                    break;
                case "eliminarEvento":
                    eliminarEvento(request,response);
                    break;
                case "getCanchasCalendar":
                    getCanchasCalendar(request,response);
                    break;
            }
        }
    }
    
    protected void registrarCancha(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            int campo = Integer.valueOf(request.getParameter("campo"));
            int numcancha = Integer.valueOf(request.getParameter("numcancha"));
            String tipocancha = request.getParameter("tipocancha");
            Campos cmp = new Campos();
            cmp.setIdCampo(campo);
            Canchas ch = new Canchas();
            ch.setCampo(cmp);
            ch.setNumero(numcancha);
            ch.setTipo_Cancha(tipocancha);
            try{
                Session s = HibernateUtil.getSessionFactory().openSession();
                s.beginTransaction();
                s.save(ch);
                s.getTransaction().commit();
                s.close();
                response.getWriter().write("1");
            }
            catch(IOException | HibernateException ex){
                response.getWriter().write("0");
            }
        }
        catch(IOException | NumberFormatException ex){
            response.getWriter().write("0");
        }
    }
    
    protected void eliminarCancha(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            try{
                int idcancha = Integer.valueOf(request.getParameter("idcancha"));
                Canchas chc = new Canchas();
                chc.setIdCancha(idcancha);
                Session s = HibernateUtil.getSessionFactory().openSession();
                s.beginTransaction();
                s.delete(chc);
                s.getTransaction().commit();
                s.close();        
                response.getWriter().write("1");
            }
            catch(IOException | NumberFormatException | HibernateException ex){
                response.getWriter().write("0");
            }
        }
        catch(IOException ex){
            response.getWriter().write("0");
        }
        
    }
    
    protected void getJSONCancha(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idcampo = request.getParameter("campo");
        JSONArray jsonCancha = new JSONArray();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("FROM Canchas WHERE Campo ='"+idcampo+"'");
        List<Canchas> listCancha = q.list();
        for (Canchas ch : listCancha) {
            jsonCancha.add("#"+ch.getNumero()+" "+ch.getTipo_Cancha());
        }
        JSONObject objCancha = new JSONObject();
        objCancha.put("canchas", jsonCancha);
        response.setContentType("application/json");
        response.getWriter().write(objCancha.toJSONString());
    }
    
    protected void actualizarCancha(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    public List<Canchas> getAll(int idcampo){
        List<Canchas> listCancha = null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("FROM Canchas WHERE Campo ="+idcampo+"");
        listCancha=q.list();
        return listCancha;
    }
    
    protected void getCanchasCalendar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    protected void getJSONEncuentros(HttpServletRequest request, HttpServletResponse response,String campo)
            throws ServletException, IOException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.registerTypeAdapter(Calendar.class, new calendarAdapter()).create();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("FROM Calendar WHERE campo ="+campo+"");
        List<Calendar> listEn = q.list();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(gson.toJson(listEn));
    }
    
    protected void checkCanchas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rt="0";
        String idcampo = request.getParameter("idcampo");
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("FROM Canchas WHERE Campo = '"+idcampo+"'");
        List<Canchas> listCan = q.list();
        if(listCan.size()>0){
            rt="1";
        }
        response.getWriter().write(rt);
    }
    
    protected void guardarEncuentro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{           
            String id = request.getParameter("id");
            String id2[] = id.split("_fc");
            String title = request.getParameter("title");
            String start = request.getParameter("start");
            String end = request.getParameter("end");
            String color = request.getParameter("color");
            int campo = Integer.valueOf(request.getParameter("campo"));
            if(id2[0].equals("")){
                Campos cmp = new Campos();
                cmp.setIdCampo(campo);
                Calendar cl = new Calendar();
                cl.setId(Integer.valueOf(id2[1]));
                cl.setTitle(title);
                cl.setStart(start);
                cl.setEnd(end);
                cl.setColor(color);
                cl.setCampo(cmp);
                try{
                    Session s = HibernateUtil.getSessionFactory().openSession();
                    s.beginTransaction();
                    s.saveOrUpdate(cl);
                    s.getTransaction().commit();
                    s.close();
                    response.getWriter().write("1");
                }
                catch(IOException | HibernateException ex){
                    response.getWriter().write("0");
                }
            }
            else{
                int id3 = Integer.valueOf(request.getParameter("id"));
                Campos cmp = new Campos();
                cmp.setIdCampo(campo);
                Calendar cl = new Calendar();
                cl.setId(id3);
                cl.setTitle(title);
                cl.setStart(start);
                cl.setEnd(end);
                cl.setColor(color);
                cl.setCampo(cmp);
                try{
                    Session s = HibernateUtil.getSessionFactory().openSession();
                    s.beginTransaction();
                    s.saveOrUpdate(cl);
                    s.getTransaction().commit();
                    s.close();
                    response.getWriter().write("1");
                }
                catch(IOException | HibernateException ex){
                    response.getWriter().write("0");
                }
                
            }
        }
        catch(IOException ex){
            response.getWriter().write("0");
        }
    }
    
    protected void eliminarEvento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            int id = Integer.valueOf(request.getParameter("idevento"));
            Calendar cal = new Calendar();
            cal.setId(id);
            Session s = HibernateUtil.getSessionFactory().openSession();
            try{
                s.beginTransaction();
                s.delete(cal);
                s.getTransaction().commit();
                s.close();
                response.getWriter().write("1");
            }
            catch(IOException | HibernateException ex){
                response.getWriter().write("0");
            }
        }
        catch(IOException | NumberFormatException | HibernateException ex){
            response.getWriter().write("0");
        }
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

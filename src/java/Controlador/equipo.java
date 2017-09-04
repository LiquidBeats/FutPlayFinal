/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Equipo;
import Modelo.HibernateUtil;
import Modelo.Jugador;
import Modelo.Notificacion;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Adsi-2k17
 */
public class equipo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url [] = request.getRequestURI().split("/");
        if (url.length >= 3) {
            
            switch (url[3]){
            
                case "crear":
                    crearEquipo(request, response);
                    break;
                    
                case "editar":
                    editarEquipo(request, response);
                    break;
                    
                case "verequipo":
                    verEquipo(request, response);
                    break;
                case "buscarEquipoEncuentro":
                    buscarEquipoEncuentro(request, response);
                    break;
                case "listarEquipo":
                    ListarEquipo(request, response);
                    break;
                    
            }
            
        }
        
    }
    protected void crearEquipo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try{
            Jugador objJugador = (Jugador) request.getSession().getAttribute("JugadorIngresado");
            String nombre = request.getParameter("Nombre");
            String ciudad = request.getParameter("Ciudad");
                        
            try{
                Session sesion = HibernateUtil.getSessionFactory().openSession();
                Query query = sesion.createQuery("FROM Equipo WHERE idEquipo = "+objJugador.getEquipo()+"");
                List<Equipo>ListaEquipo =  query.list();
                
                for(Equipo equipo : ListaEquipo){
                    
                    
                    if (equipo.getIdEquipo() == 1) {
                        
                        Equipo objEquipo = new Equipo(0, nombre, ciudad, objJugador.getIdJugador());
                        sesion.beginTransaction();
                        sesion.save(objEquipo);
                        sesion.getTransaction().commit();
                       

                        Query query1 = sesion.createQuery("FROM Equipo WHERE Capitan="+objJugador.getIdJugador()+"");
                        List<Equipo>ListaEquipoo = query1.list();
                        for(Equipo equip : ListaEquipoo){
                        
                            Query queryy = sesion.createSQLQuery("UPDATE jugador SET Capitan=1, Equipo="+equip.getIdEquipo()+" WHERE idJugador="+objJugador.getIdJugador()+"");
                            queryy.executeUpdate();
                            sesion.beginTransaction();
                            sesion.getTransaction().commit();
                            
                        }
                        
                        
                        /////////////////////////////////////////////// REINICIO DE LA SESION ////////////////////
                        Query queryJugador = sesion.createQuery("FROM Jugador WHERE idJugador="+objJugador.getIdJugador()+"");
                        List<Jugador>ListaJugador2 = queryJugador.list();
                        for(Jugador jugador : ListaJugador2){

                            Jugador objJugador2 = new Jugador(jugador.getIdJugador(), jugador.getAlias(), jugador.getPosicion(), jugador.getPierna(), jugador.getDescripcion(), jugador.getRankingSystem(), jugador.getRankingUsers(), jugador.getEstado(), jugador.getCapitan(), jugador.getEquipo(), jugador.getPersona());
                            request.getSession().setAttribute("JugadorIngresado", objJugador2);
                            
                            /////////////////// CREAR NOTIFICACION /////////////////
                            sesion.beginTransaction();
                            //Notificacion objNotificacion = new Notificacion(new Date(), "11:11 p.m", "CrearEquipo", "", objJugador, jugador.getEquipo());
                            
                            
                            int equipoop = Integer.parseInt(jugador.getEquipo().toString());
                            
                            Notificacion objNotificacion = new Notificacion(new Date(), "11:34", "CrearEquipo", "", objJugador.getIdJugador(), 0, 0, 0, "", 0, equipoop);
                            sesion.save(objNotificacion);
                            sesion.getTransaction().commit();

                        }
                        
                        response.setCharacterEncoding("UTF-8");
                        response.setContentType("text/plain");
                        response.getWriter().write("1");
                        
                    }else{
                        
                        response.setCharacterEncoding("UTF-8");
                        response.setContentType("text/plain");
                        response.getWriter().write("2");
                            
                    }
                    
                }
                sesion.close();
            }catch(HibernateException ex){
                
                System.err.println(ex);
                
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/plain");
                response.getWriter().write("0");
                
            }
        
        }catch(Exception ex){
            
            System.err.println(ex);
            
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/plain");
            response.getWriter().write("0");

        }
        
    }
    protected void verEquipo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            System.out.println("ESTOY EN VER EQUIPO FUTPLAY FINALLLLLLLLL......");
            ///////////FUTPLAYFINAL///////////
            Jugador objJugador = (Jugador) request.getSession().getAttribute("JugadorIngresado");
            
            try{
                Session sesion = HibernateUtil.getSessionFactory().openSession();
                Query query = sesion.createQuery("FROM Equipo WHERE idEquipo = "+objJugador.getEquipo()+"");
                List<String>ListaEquipo = query.list();
                
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/plain");
                String json = new Gson().toJson(ListaEquipo);
                response.getWriter().write(json);
                sesion.close();

            }catch(HibernateException ex){

                System.err.println(ex);

            }
            
        }catch(Exception ex){
        
            System.err.println(ex);
            
        }
        
    }
    protected void editarEquipo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        try{
            String idEquipo = request.getParameter("idEquipo");
            String Nombre = request.getParameter("Nombre");
            String Ciudad = request.getParameter("Ciudad");
            
            try{
                
                Session sesion = HibernateUtil.getSessionFactory().openSession();
                sesion.beginTransaction();
                Query query = sesion.createQuery("UPDATE Equipo SET Nombre = '"+Nombre+"', Ciudad = '"+Ciudad+"' WHERE idEquipo="+idEquipo+"");
                query.executeUpdate();
                sesion.getTransaction().commit();
                
                /////////////////// CREAR NOTIFICACION /////////////////
                Jugador objJugador =  (Jugador) request.getSession().getAttribute("JugadorIngresado");
                sesion.beginTransaction();
                
                
                //Notificacion objNotificacion = new Notificacion(new Date(), "11:11 p.m", "EditarEquipo", "", objJugador, objJugador.getEquipo());
                
                int equipo = Integer.valueOf(objJugador.getEquipo().toString());
                
                Notificacion objNotificacion = new Notificacion(new Date(), "11:29", "EditarEquipo", "", objJugador.getIdJugador(), 0, 0, 0, "", equipo, equipo);
                
                sesion.save(objNotificacion);
                sesion.getTransaction().commit();
                sesion.close();
                
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/plain");
                response.getWriter().write("1");
                
            }catch(HibernateException ex){
            
                System.err.println(ex);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/plain");
                response.getWriter().write("0");
            }
        
        }catch(Exception ex){
        
            System.err.println(ex);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/plain");
            response.getWriter().write("0");
            
        }
    }
    protected void buscarEquipoEncuentro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        try{
        
            //String tipo = request.getParameter("tipo");
            
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            Query query = sesion.createQuery("FROM Equipo");
            List<Equipo>listaEquipo = query.list();
            String json = new Gson().toJson(listaEquipo);
            
            response.getWriter().write(json);
            
        }catch(HibernateException ex){
        
            System.err.println(ex);
        }catch(Exception ex){
        
            System.err.println(ex);
        
        }
        
    }
    
    
    
    
    
    private void ListarEquipo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        try{
        
            Jugador objJugador = (Jugador) request.getSession().getAttribute("JugadorIngresado");
            
            int id =Integer.valueOf(request.getParameter("id"));
            String tipo = request.getParameter("tipo");
            System.out.println(tipo);


            Session s = HibernateUtil.getSessionFactory().openSession();
            Query q= s.createQuery("from Jugador WHERE Jugador.Equipo='"+id+"'");
            List elist = q.list();
                if (elist.size()>4) {

                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("text/plain");
                    response.getWriter().write("1");
                    
                    ////////// SE CREA LA NOTIFICACION PARA INFORMAR A EL ATRO EQUIPO ////////////
                    Notificacion objNotificacion = new Notificacion(new Date(), "7:23 P.M", "SolicitarEncuentro", "", 0, 0, 0, 0, "", Integer.parseInt(String.valueOf(objJugador.getEquipo())), id);
                    s.beginTransaction();
                    s.save(objNotificacion);
                    s.getTransaction().commit();
                    
                }else{
                      response.setCharacterEncoding("UTF-8");
                    response.setContentType("text/plain");
                    response.getWriter().write("0");
                }
            System.out.println(elist);
            System.out.println("id -------------------->"+id);
            
            s.close();
            
        }catch(HibernateException ex){
            System.out.println(ex);
        }catch(Exception ex){
            System.err.println(ex);
        }
         
          /*
        if (tipo.equals("Futbol 5")) {
            SQLQuery q = s.createSQLQuery(" SELECT * from Jugador where (SELECT( COUNT(Jugador.Equipo)>4 AND COUNT(Jugador.Equipo)<8) FROM Jugador WHERE Jugador.Equipo='"+id+"'");
           
            List<Equipo> listE = q.list();
            for (Equipo listE1 : listE) {
                System.out.println(listE1.getNombre());  
            }
         for (Equipo equi:listE) {
            jsonEq.add(equi.getIdEquipo());
            jsonEq.add(equi.getNombre());
            jsonEq.add(equi.getCiudad());
            jsonEq.add(equi.getImagen());
               System.out.println(jsonEq);
                    }
            //System.out.println(listE);
           s.close();
   }else if (tipo.equals("Futbol 8")) {
            Query q = s.createQuery("SELECT Equipo.Nombre,Equipo.Ciudad,Equipo.imagen FROM Equipo WHERE (SELECT (COUNT(idJugador)>7) AND (COUNT(idJugador)<12) FROM Jugador WHERE Jugador.Equipo = Equipo.idEquipo)");
          
            List<Equipo> listE = q.list();
           for (Equipo equi:listE) {
            jsonEq.add(equi.getIdEquipo());
            jsonEq.add(equi.getNombre());
            jsonEq.add(equi.getCiudad());
            jsonEq.add(equi.getImagen());
        }
   }else if (tipo.equals("Futbol 12")) {
        Query q = s.createQuery("SELECT Equipo.Nombre,Equipo.Ciudad,Equipo.imagen FROM Equipo WHERE (SELECT (COUNT(idJugador)>11) AND (COUNT(idJugador)<22) FROM Jugador WHERE Jugador.Equipo = Equipo.idEquipo)");
          
            List<Equipo> listE = q.list();
           for (Equipo equi:listE) {
            jsonEq.add(equi.getIdEquipo());
            jsonEq.add(equi.getNombre());
            jsonEq.add(equi.getCiudad());
            jsonEq.add(equi.getImagen());
        }
}
        response.setContentType("application/json");
        response.getWriter().write(jsonEq.toJSONString());
       // request.getSession().setAttribute("", idcampo);
    
    */
          
    }
    
    
    
    
    ////////// RETORNA TODOS LOS EQUIPOS EXISTENTES /////////////////////
    public List<Equipo> getAllEquipo(HttpServletRequest request, HttpServletResponse response){
        List<Equipo> listE = null;
      
        try{
            Session s = HibernateUtil.getSessionFactory().openSession();   
            Query q = s.createQuery("FROM Equipo");
            listE = q.list();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return listE;
    }
    //////////// RETORNA TODOS LOS EQUIPOS ENXISTENTES, HAY UNA REDUNDANCIA ///////////
    public List<Equipo> getAllE(HttpServletRequest request, HttpServletResponse response){
        List<Equipo> listEq = null;
       // Propietario pr = (Propietario) request.getSession().getAttribute("PropietarioIngresado");
        try{
            
            Jugador objJugador = (Jugador) request.getSession().getAttribute("JugadorIngresado");
            
            Session s = HibernateUtil.getSessionFactory().openSession();   
            Query q = s.createQuery("FROM Equipo WHERE idEquipo != 1 AND idEquipo != "+objJugador.getEquipo()+" ");
            //Query q = s.createQuery("FROM Equipo");
            listEq = q.list();
            System.out.println(listEq);
        }
        catch(HibernateException ex){
            System.out.println(ex);
        }catch(Exception ex){
            System.err.println(ex);
        }
        return listEq;
        
    }
    /////////// RETORNA TODOS LOS QUIPOS DISPONIBLES //////////////////////
    public List<Equipo> getAllEquiposDisponibles(HttpServletRequest request, HttpServletResponse response){
        List<Equipo> listE = null;
  
        try{
            Session s = HibernateUtil.getSessionFactory().openSession();   
            Query q = s.createQuery("FROM Equipo");
            listE = q.list();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return listE;
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

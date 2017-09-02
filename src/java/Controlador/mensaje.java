/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Equipo;
import Modelo.HibernateUtil;
import Modelo.Jugador;
import Modelo.Mensaje;
import java.io.IOException;
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
 * @author Andres
 */
public class mensaje extends HttpServlet {

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
            
            switch(url[3]){
            
                case "ingresarmesaje":
                    ingresarMensaje(request, response);
                    break;
                    
                case "vermensajes":
                    verMensajes(request, response);
                    break;
            
            }
            
        }
    }
    protected void ingresarMensaje(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
    
        try{
            Jugador objJugador = (Jugador)request.getSession().getAttribute("JugadorIngresado");
            if (String.valueOf(objJugador.getEquipo()).equals("1")) {
                System.err.println("siiii");
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/plain");
                response.getWriter().write("0");
                
            }else{
                
                String Contenido = request.getParameter("contenido");

                try{

                    Session sesion = HibernateUtil.getSessionFactory().openSession();
                    Mensaje objMensaje = new Mensaje(Contenido, new Date(), "11:11 p.m", objJugador, objJugador.getEquipo());
                    sesion.beginTransaction();
                    sesion.save(objMensaje);
                    sesion.getTransaction().commit();
                    sesion.close();
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("text/plain");
                    response.getWriter().write("1");

                 }catch(HibernateException ex){
                     
                     System.err.println(ex);
                     response.setCharacterEncoding("UTF-8");
                     response.setContentType("text/plain");
                     response.getWriter().write("2");
                
                 }
             }
        
        }catch(Exception ex){
        
            System.err.println(ex);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/plain");
            response.getWriter().write("2");
            
        }
    
    }
    protected void verMensajes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        System.out.println("VVVVVVer MMMMMENSAJES");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain");
        try{
            
            Jugador objJugador = (Jugador) request.getSession().getAttribute("JugadorIngresado");
            System.out.println("JUGADOR MENSAJES----------------------------> "+objJugador.getAlias()+ " equipo ---> "+objJugador.getEquipo());
            if (String.valueOf(objJugador.getEquipo()).equals("1")) {
                
                response.getWriter().write("0");
                
            }else{
            
                try{

                    Session sesion = HibernateUtil.getSessionFactory().openSession();
                    Query query = sesion.createQuery("FROM Mensaje WHERE Equipo = "+objJugador.getEquipo()+" ORDER BY Fecha ASC");
                    List<Mensaje> ListaMensaje = query.list();
                    if (ListaMensaje.size() > 0) {
                        
                            for(Mensaje mensaje: ListaMensaje){
                            System.out.println("ID MENSAJE-----------------------> "+mensaje.getIdMensaje());
                            Query queryJugador = sesion.createQuery("FROM Jugador WHERE idJugador = "+mensaje.getJugador()+"");
                            List<Jugador>ListaJugador = queryJugador.list();
                            for(Jugador jugador : ListaJugador){
                                String tipo = "", remitente = "", user = "";

                                if (jugador.getIdJugador() == objJugador.getIdJugador()) {

                                    tipo = "<li class='timeline-inverted'>";
                                    remitente = "Tú";
                                    user = "zmdi zmdi-account";

                                }else{

                                    tipo = "<li>";
                                    remitente = jugador.getAlias();
                                    user = "zmdi zmdi-accounts-list";
                                }
                                String Respuestamensaje = tipo
                                        + "<div class='timeline-badge success'>"
                                            + "<i class='material-icons'>card_travel</i>"
                                        + "</div>"
                                        + "<div class='timeline-panel'>"
                                            + "<div class='timeline-heading'>"
                                                + "<span class='label label-danger'>"+remitente+"</span>"
                                            + "</div>"
                                            + "<div class='timeline-body'>"
                                                + "<p>"+mensaje.getContenido()+"</p>"
                                            + "</div>"
                                            + "<h6>"
                                                + "<i class='ti-time'></i> "+mensaje.getHora()+" via FutPlay"
                                            + "</h6>"
                                        + "</div>"
                                        + "</li>";
                                /*response.getWriter().write(tipo
                                        + "<div class='timeline-badge bg-info'><i class='"+user+"'></i></div>"
                                            + "<div class='timeline-panel'>"
                                                + "<div class='timeline-heading'>"
                                                    + "<h5 class='timeline-title'>"+remitente+"</h5>"
                                                    + "<p><small class='text-muted'><i class='zmdi zmdi-time'></i> "+mensaje.getHora()+" via FutPlay</small></p>"
                                                + "</div>"
                                                + "<div class='timeline-body'>"
                                                    + "<p>"+mensaje.getContenido()+"</p>"
                                                + "</div>"
                                            + "</div>"
                                        + "</li>");*/
                                response.getWriter().write(Respuestamensaje);

                            }

                        }
                    }else{
                    
                        response.getWriter().write("2");
                        
                    }
                    

                    sesion.close();

                }catch(HibernateException ex){

                    System.err.println(ex);
                    response.getWriter().write("1");

                }
            }
        }catch(Exception ex){
        
            System.err.println(ex);
            response.getWriter().write("1");
            
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

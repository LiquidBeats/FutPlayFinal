/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Campos;
import Modelo.Encuentros;
import Modelo.HibernateUtil;
import Modelo.Jugador;
import Modelo.Notificacion;
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
public class encuentros extends HttpServlet {

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
        
        String url = request.getRequestURI();
        String params[]=url.split("/");
        if(params.length>=3){
            switch(params[3]){
                case "ingresarencuentro":
                    registrarEncuentro(request,response);
                    break;
                case "aceptarencuentro":
                    aceptarEncuentro(request,response);
                    break;
            
            }    
        }
    }
    protected void registrarEncuentro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
        
            Jugador objJugador = (Jugador) request.getSession().getAttribute("JugadorIngresado");
            
            int sePuede = 0;
            
            int tipo = Integer.parseInt(request.getParameter("tipo"));
            String equipo = request.getParameter("equipo");
            String campo = request.getParameter("campo");
            
            
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            
            Query EquipoJugadorSesion = sesion.createQuery("FROM Jugador WHERE Equipo = "+objJugador.getEquipo()+"");
            List<Jugador>listaJugadorSesion = EquipoJugadorSesion.list();
            if (listaJugadorSesion.size() >= tipo) {
            
                Query query = sesion.createQuery("FROM Jugador WHERE Equipo = "+equipo+"");
                List<Jugador>listaJugador = query.list();


                if (listaJugador.size() >= tipo) {

                    Notificacion objNotificacion = new Notificacion(new Date(), "07:45", "SolicitarEncuentro", "", 0, 0, 0, 0, campo+"/"+String.valueOf(tipo), Integer.parseInt(String.valueOf(objJugador.getEquipo())), Integer.parseInt(equipo));
                    sesion.beginTransaction();
                    sesion.save(objNotificacion);
                    sesion.getTransaction().commit();

                    response.getWriter().write("1");

                }else{

                    response.getWriter().write("2");

                }
                
            }else{
            
                response.getWriter().write("3");
            }
            
            sesion.close();
            
        }catch(HibernateException ex){
            System.err.println(ex);
        }catch(Exception ex){
            System.err.println(ex);
        }
    }
    protected void aceptarEncuentro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            
            Jugador objJugador = (Jugador) request.getSession().getAttribute("JugadorIngresado");
        
            String equipo = request.getParameter("equipo");
            String campo = request.getParameter("campo");
            String tipo = request.getParameter("tipo");
            
            
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            
            
            Query queryCampo = sesion.createQuery("FROM Campos WHERE idCampo = "+campo+"");
            List<Campos>listaCampo = queryCampo.list();
            for (Campos campos : listaCampo) {
                
                System.out.println(campos.getPropietario());
                
                Notificacion objNotificacion = new Notificacion(new Date(), "01:28 P.M", "ConfirmarEncuentro", "", 0, 0, 0, Integer.parseInt(String.valueOf(campos.getPropietario())), tipo+"/"+equipo+"/"+objJugador.getEquipo(), Integer.parseInt(equipo), 0);
                sesion.beginTransaction();
                sesion.save(objNotificacion);
                sesion.getTransaction().commit();
                
                response.getWriter().write("1");
            }
            
            sesion.close();
            
        }catch(HibernateException ex){
            System.err.println(ex);
        }catch(Exception ex){
            System.err.println(ex);
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

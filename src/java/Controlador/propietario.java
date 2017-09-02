package Controlador;

import Modelo.HibernateUtil;
import Modelo.Persona;
import Modelo.Propietario;
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


public class propietario extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url [] = request.getRequestURI().split("/");
        if (url.length>=3) {
            switch (url[3]){
            
                case "registrar":
                    registrarPropietario(request, response);
                    break;
                    
                case "actualizar":
                    actualizarPropietario(request, response);
                    break;
            }
            
        }
    }
    
    protected void registrarPropietario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Session s = HibernateUtil.getSessionFactory().openSession();
            Persona person = new Persona();
            Propietario prop = new Propietario();
            String correo = request.getParameter("UCorreo");
            Query q = s.createQuery("FROM Persona WHERE Correo = '"+correo+"'");
            List<Persona> listPe = q.list();
            for (Persona pr : listPe) {
                person.setIdPersona(pr.getIdPersona());
            }
            prop.setPersona(person);
            s.beginTransaction();
            s.save(prop);
            s.getTransaction().commit();
            s.close();
            response.getWriter().write("1");
        }
        catch(HibernateException ex){
            System.out.println(ex);
            response.getWriter().write("0");
        }
    }
    
    protected void actualizarPropietario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Session s = HibernateUtil.getSessionFactory().openSession();
            int id = Integer.valueOf(request.getParameter("UId"));
            Date dt = new Date(request.getParameter("UFechaNacimiento"));
            Persona per = new Persona(id, request.getParameter("UNombre"), request.getParameter("UApellido"), dt, request.getParameter("UTelefono"), request.getParameter("UGenero"), request.getParameter("UCorreo"), request.getParameter("UContrasenia"), request.getParameter("UAvatar"));
            try{
                s.beginTransaction();
                s.update(per);
                s.getTransaction().commit();
                s.close();
                response.getWriter().write("1");
            }
            catch(IOException | HibernateException ex){
                response.getWriter().write("0");
            }
        }
        catch(IOException | HibernateException ex){
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.HibernateUtil;
import Modelo.Persona;
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
public class usuario extends HttpServlet {

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
        if (url.length>=3) {
            switch (url[3]){
            
                case "registrar":
                    registrarPersona(request, response);
                    break;
                    
                case "editar":
                    editarPersona(request, response);
                    break;
                
                case "verificarEmail":
                    verificarEmail(request,response);
                    break;
            }
            
        }
    }

    protected void registrarPersona(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try{
            String nombre = request.getParameter("UNombre");
            String apellido = request.getParameter("UApellido");
            Date fechaNacimiento = new Date(request.getParameter("UFechaNacimiento"));
            String telefono = request.getParameter("UTelefono");
            String genero = request.getParameter("UGenero");
            String correo = request.getParameter("UCorreo");
            String contrasenia = request.getParameter("UContrasenia");
            String avatar = request.getParameter("UAvatar");
            if(avatar.equals("")){
                avatar="av.jpg";
            }
            
            try{
            
                Session sesion = HibernateUtil.getSessionFactory().openSession();
                Persona objPersona = new Persona(0, nombre, apellido, fechaNacimiento, telefono, genero, correo, contrasenia, avatar);
                sesion.beginTransaction();
                sesion.save(objPersona);
                sesion.getTransaction().commit();
                sesion.close();
                
                
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/plain");
                response.getWriter().write("1");
                
                /////////////////Sesion para continuar con el registro del jugador NO BORRAR/////////////////
                request.getSession().setAttribute("UsuarioRegistrado", objPersona);
                
            }catch(HibernateException ex){
            
                //response.sendRedirect("/FutPlay/PAGES/Usuario/RegistrarUsuario.jsp");
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/plain");
                response.getWriter().write("0");
                
            }
            
            
            
        }catch(Exception ex){
        
            //response.sendRedirect("/FutPlay/PAGES/Usuario/RegistrarUsuario.jsp");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/plain");
            response.getWriter().write("0");
            
        }
        
    }
    protected void editarPersona(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        try{
            Persona objPersona = (Persona) request.getSession().getAttribute("UsuarioIngresado");
            String nombre = request.getParameter("UNombre");
            System.out.println("------------------->pppppppppppppppppppppppeeeeeeeeeeerrrrrrrsssssssooooonnnnnnnnaaaaaa"+nombre);
            String apellido = request.getParameter("UApellido");
            String fechaNacimiento = request.getParameter("UFechaNacimiento");
            String telefono = request.getParameter("UTelefono");
            String genero = request.getParameter("UGenero");
            String correo = request.getParameter("UCorreo");
            String contrasenia = request.getParameter("UContrasenia");
            
            String avatar = request.getParameter("UAvatar");
            
            try{
                System.out.println("-------------------- objPersona "+objPersona.getIdPersona());
                Session sesion = HibernateUtil.getSessionFactory().openSession();
                sesion.beginTransaction();
                ///////////////////////////// agregar a la consulta  Fecha_Nacimiento='"+fechaNacimiento+"'////////////////////
                Query query = sesion.createSQLQuery("UPDATE persona SET Nombres='"+nombre+"', Apellidos='"+apellido+"', Telefono='"+telefono+"', Genero='"+genero+"', Correo='"+correo+"', Contrasenia='"+contrasenia+"' WHERE idPersona='"+objPersona.getIdPersona()+"'");
                query.executeUpdate();
                sesion.getTransaction().commit();;
                //sesion.close();
                
                Query queryy = sesion.createQuery("FROM Persona WHERE idPersona="+objPersona.getIdPersona()+"");
                List<Persona>ListaPersona = queryy.list();
                for(Persona persona : ListaPersona){
                
                    Persona objPersonaa = new Persona(persona.getIdPersona(), persona.getNombres(), persona.getApellidos(), persona.getFecha_Nacimiento(), persona.getTelefono(), persona.getGenero(), persona.getCorreo(), persona.getContrasenia(), persona.getAvatar());
                    request.getSession().setAttribute("UsuarioIngresado", objPersonaa);
                
                }
                
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
    
    protected void verificarEmail(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try{
            String email = request.getParameter("UCorreo");
            Session s = HibernateUtil.getSessionFactory().openSession();
            Query q = s.createQuery("FROM Persona WHERE Correo = '"+email+"'");
            List listEmail = q.list();
            if(listEmail.size()>0){
                response.getWriter().write("0");
            }
            else{
                response.getWriter().write("1");
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

package Controlador;

import Modelo.HibernateUtil;
import Modelo.Jugador;
import Modelo.Persona;
import Modelo.Propietario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class inicio extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url[] = request.getRequestURI().split("/");
        
        if (url.length>=3) {
            
            switch(url[3]){
            
                case "iniciar":
                    
                    IniciarSesion(request, response);
                    
                    break;
            
                case "cerrar":
                    
                    CerrarSesion(request, response);
                    
                    break;
                    
                default:
            }
            
        }
        
        
    }
    protected void IniciarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            String Email = request.getParameter("email");
            String Contrasenia = request.getParameter("pass");
            try{

                Session sesion = HibernateUtil.getSessionFactory().openSession();
                Query query = sesion.createQuery("FROM Persona WHERE Correo='"+Email+"' AND Contrasenia='"+Contrasenia+"'");

                List<Persona> listaPersona = query.list();

                if (listaPersona.size() > 0) {

                    for(Persona persona : listaPersona){

                        Persona objPersona = new Persona(persona.getIdPersona(), persona.getNombres(), persona.getApellidos(), persona.getFecha_Nacimiento(), persona.getTelefono(), persona.getGenero(), persona.getCorreo(), persona.getContrasenia(), persona.getAvatar());
                        request.getSession().setAttribute("UsuarioIngresado", objPersona);
                        
                        Query queryy = sesion.createQuery("FROM Jugador WHERE Persona = "+objPersona.getIdPersona()+"");
                        List<Jugador> ListaJugador = queryy.list();
                        
                        if (ListaJugador.size() > 0) {
                            
                            for(Jugador jugador : ListaJugador){
                        
                                Jugador objJugador = new Jugador(jugador.getIdJugador(), jugador.getAlias(), jugador.getPosicion(), jugador.getPierna(), jugador.getDescripcion(), jugador.getRankingSystem(), jugador.getRankingUsers(), jugador.getEstado(), jugador.getCapitan(), jugador.getEquipo(), jugador.getPersona());
                                request.getSession().setAttribute("JugadorIngresado", objJugador);
                            }

                                response.getWriter().write("indexJugador");
                            
                        }else{
                            Query q = sesion.createQuery("FROM Propietario WHERE Persona = "+objPersona.getIdPersona()+"");
                            List<Propietario> ListPropietario = q.list();
                            if(ListPropietario.size()>0){
                                for (Propietario propietario : ListPropietario) {
                                    Persona per = new Persona(propietario.getPersona().getIdPersona(), propietario.getPersona().getNombres(), propietario.getPersona().getApellidos(), propietario.getPersona().getFecha_Nacimiento(), propietario.getPersona().getTelefono(), propietario.getPersona().getGenero(), propietario.getPersona().getCorreo(), propietario.getPersona().getContrasenia(), propietario.getPersona().getAvatar());
                                    Propietario prp = new Propietario(propietario.getIdPropietario(), per);
                                    request.getSession().setAttribute("PropietarioIngresado", prp);
                                }
                                response.getWriter().write("indexPropietario");
                            }
                        }     
                    }

                }else{
                    response.getWriter().write("0");
                }

            }catch(HibernateException ex){
                response.getWriter().write("1");
                System.err.println(ex);
            }
            
        }catch(IOException ex){
            response.sendRedirect("/FutPlay/index.jsp");    
        }
        
    }
    protected void CerrarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            HttpSession logout = request.getSession();
            logout.removeAttribute("UsuarioIngresado");
            logout.removeAttribute("JugadorIngresado");
            logout.removeAttribute("PropietarioIngresado");
            logout.invalidate();
            response.getWriter().write("1");
        }
        catch(Exception ex){
            response.getWriter().write("0");
            System.out.println("Error "+ex);
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

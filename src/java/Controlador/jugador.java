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
import Modelo.Persona;
import com.google.gson.Gson;
import com.mchange.v2.async.StrandedTaskReporting;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Adsi-2k17
 */
public class jugador extends HttpServlet {

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
            switch(url[3]){
            
                case "registrar":
                    registrarJugador(request, response);
                    break;
                    
                case "editar":
                    editarJugador(request, response);
                    break;
                    
                case "verjugadores":
                    verJugadores(request, response);
                    break;
                
                case "verjugador":
                    verJugador(request, response, url[4]);
                    break;
                    
                case "eliminarjugador":
                    eliminarJugador(request, response);
                    break;
                    
                case "buscarpersona":
                    buscarJugador(request, response);
                    break;
                    
                case "agregarequipo":
                    //agregarEquipo(request, response, url[4]);
                    aceptarFichaje(request, response);
                    break;
                case "ficharjugador":
                    ficharJugador(request, response);
                    break;
                case "likejugador":
                    likeJugador(request, response);
                    break;
                case "dislikejugador":
                    dislikeJugador(request, response);
                    break;
            }
        }
        
    }
   protected void registrarJugador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        try{
            
            //Persona objPersona = (Persona) request.getSession().getAttribute("UsuarioRegistrado");
            String correo = request.getParameter("UCorreo");
            
            int ranking1 = Integer.valueOf(request.getParameter("rankingSystem1"));
            int ranking2 = Integer.valueOf(request.getParameter("rankingSystem2"));
            int ranking3 = Integer.valueOf(request.getParameter("rankingSystem3"));
            double RankingSystem = (ranking1+ranking2+ranking3)/3;
            
            String alias = request.getParameter("Alias");
            String posicion = request.getParameter("Posicion");
            String pierna = request.getParameter("Pierna");
            String descripcion = request.getParameter("Descripcion");
            
            double ranking = Double.valueOf(RankingSystem);
            String da = "";
            
            try{
                
                Session sesion = HibernateUtil.getSessionFactory().openSession();
                Query query = sesion.createQuery("FROM Persona WHERE Correo ='"+correo+"'");
                List<Persona> ListaPersona = query.list();
                for(Persona persona : ListaPersona){
                    Session sesionn = HibernateUtil.getSessionFactory().openSession();
                    Equipo eq = new Equipo();
                    eq.setIdEquipo(1);
                    System.out.println("-------------------->"+eq);
                    System.out.println("----------------------->"+persona.getIdPersona());
                    //////////////////////////// SESSION PARA REALIZAR LA NOTIFICACION DEL REGISTRO 
                    Persona objPersonaa = new Persona(persona.getIdPersona(), persona.getNombres(), persona.getApellidos(), persona.getFecha_Nacimiento(), persona.getTelefono(), persona.getTelefono(), persona.getContrasenia(), persona.getContrasenia(), persona.getAvatar());
                    request.getSession().setAttribute("UsuarioRegistrado", objPersonaa);
                    
                    
                    Jugador objJugador = new Jugador(0, alias, posicion, pierna, descripcion, ranking, da, "Activo", false, eq, objPersonaa);
                    sesionn.beginTransaction();
                    sesionn.save(objJugador);
                    sesionn.getTransaction().commit();
                    sesionn.close();
                    
                    //request.getSession().setAttribute("JugadorRegistrado", objJugador);
                    
//                    try{
//                        
//                        //////////////////////////// CERRAR LA SESION DEL REGISTRO DEL USUARIO/////////////////////
//                        HttpSession logout = request.getSession();
//                        logout.removeAttribute("UsuarioRegistrado");
//                        logout.invalidate();
//                    
//                    }catch(Exception ex){
//                    
//                        System.err.println(ex);
//                    
//                    }
                    
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("text/plain");
                    response.getWriter().write("1");

                }
            
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
    protected void editarJugador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            
            System.out.println("---------------------->EDITAR");
            Jugador objJugador = (Jugador) request.getSession().getAttribute("JugadorIngresado");
            String alias = request.getParameter("Alias");
            String posicion = request.getParameter("Posicion");
            String pierna = request.getParameter("Pierna");
            String descripcion = request.getParameter("Descripcion");
            
            try{
                
                Session sesion = HibernateUtil.getSessionFactory().openSession();
                sesion.beginTransaction();
                Query query = sesion.createSQLQuery("UPDATE jugador SET Alias='"+alias+"', Posicion='"+posicion+"',Pierna='"+pierna+"',Descripcion='"+descripcion+"' WHERE idJugador="+objJugador.getIdJugador()+"");
                query.executeUpdate();
                sesion.getTransaction().commit();
                
                Query queryy = sesion.createQuery("FROM Jugador WHERE idJugador = "+objJugador.getIdJugador()+"");
                List<Jugador>ListaJugador = queryy.list();
                for (Jugador jugador : ListaJugador) {
                    
                    Jugador objJugadorr = new Jugador(jugador.getIdJugador(), jugador.getAlias(), jugador.getPosicion(), jugador.getPierna(), jugador.getDescripcion(), jugador.getRankingSystem(), jugador.getRankingUsers(), jugador.getEstado(), jugador.getCapitan(), jugador.getEquipo(), jugador.getPersona());
                    request.getSession().setAttribute("JugadorIngresado", objJugadorr);
                }
                
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/plain");
                response.getWriter().write("1");
                
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
    protected void verJugadores(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
        try{
        
            Jugador objJugador = (Jugador)request.getSession().getAttribute("JugadorIngresado");
            if (String.valueOf(objJugador.getEquipo()).equals("1")) {
                
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/plain");
                response.getWriter().write("0");
                
                
            }else{
                
                try{
                    Session sesion = HibernateUtil.getSessionFactory().openSession();
                    Query query = sesion.createQuery("FROM Jugador WHERE Equipo = "+objJugador.getEquipo()+"");
                    
                    // TENER EN CUENTA EL ERRO DE LA QUERY ANTERIOR /////
                    //Query query = sesion.createQuery("FROM Jugador WHERE idJugador='1'");
                    ArrayList<Jugador>ListaJugadores = (ArrayList)query.list();

                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("text/plain");

                    for(Jugador jugador : ListaJugadores){
                        
                        int likes = 0;
                        int dislike = 0;
                        double rankingUsuariosFinal=0;
                        
                        Query queryPersona = sesion.createQuery("FROM Persona WHERE idPersona = "+jugador.getPersona()+"");
                        List<Persona>ListaPersona = queryPersona.list();
                        
                        
                        String [] calificado = jugador.getRankingUsers().split("/");
                        if (calificado[0] != "") {

                            for (int i = 0; i < calificado.length; i++) {

                                String[] ranking = calificado[i].split("~");
                                if (ranking[1] == "1") {

                                    likes++;

                                }else if (ranking[1] == "0") {

                                    dislike++;
                                }
                            }
                        }
                        /////////// COMPLETAR LAS CONDICIONES PARA EL RATING ///////
                        if (likes <= 5 & dislike <= 5) {
                            
                            rankingUsuariosFinal=20;
                            
                        }else if (likes > 5 & likes <= 10 & dislike <=5) {
                            rankingUsuariosFinal=25;
                        }
                        
                        double ranking = (jugador.getRankingSystem()+rankingUsuariosFinal) / 2;
                        String colorStar1 ="#d8bb21",colorStar2 ="#d8bb21",colorStar3 ="#d8bb21",colorStar4 ="#d8bb21",colorStar5 ="#d8bb21";
                        if (ranking > 0 & ranking <= 20) {
                            
                            colorStar2 = "#999999";
                            colorStar3 = "#999999";
                            colorStar4 = "#999999";
                            colorStar5 = "#999999";
                        }else if (ranking > 20 & ranking <= 40) {
                            colorStar3 = "#999999";
                            colorStar4 = "#999999";
                            colorStar5 = "#999999";
                        }else if (ranking > 40 & ranking <= 60) {
                            colorStar4 = "#999999";
                            colorStar5 = "#999999";
                        }else if (ranking > 60 & ranking <= 80) {
                            colorStar5 = "#999999";
                        }
                        
                        for(Persona persona : ListaPersona){
                            response.getWriter().write("<div class='col-lg-4'>"
                                        + "<div class='card card-pricing card-raised'>"
                                            + "<div class='content'>"
                                                + "<h6 class='category'>"+jugador.getAlias()+"</h6>"
                                                + "<div class='icon icon-rose'>"
                                                        + "<img class='avatar' src='../../assets/img/avatares/"+persona.getAvatar()+"' style='width: 150px;height: 150px;'>"
                                                + "</div>"
                                                + "<h3 class='card-title'>"+jugador.getPosicion()+"</h3>"
                                                + "<i class='material-icons' style='font-size: 25px; color: "+colorStar1+"'>stars</i>"
                                                + "<i class='material-icons' style='font-size: 25px; color: "+colorStar2+"'>stars</i>"
                                                + "<i class='material-icons' style='font-size: 25px; color: "+colorStar3+"'>stars</i>"
                                                + "<i class='material-icons' style='font-size: 25px; color: "+colorStar4+"'>stars</i>"
                                                + "<i class='material-icons' style='font-size: 25px; color: "+colorStar5+"'>stars</i><br>"
                                                //+ "<p class='card-description'>"+jugador.getDescripcion()+"</p>"
                                                + "<a href='/FutPlayFinal/jugador/verjugador/"+jugador.getIdJugador()+"' class='btn btn-rose btn-round'>Ver perfil</a>"
                                            + "</div>"
                                        + "</div>"
                                    + "</div>");
                            //response.getWriter().write("<div class='tile  z-depth-2'><div class='tile-icon'><img src='../../MaterialDark/assets/img/"+persona.getAvatar()+"' class='responsive-img'></div><div class='tile-caption'><span class='center-align'>"+jugador.getAlias()+"</span><p class='center-align'>"+jugador.getPosicion()+"</p></div><a href='/FutPlay/jugador/verjugador/"+jugador.getIdJugador()+"' class='tile-link waves-effect waves-light'>&nbsp;&nbsp; Ver Perfil &nbsp;<i class='zmdi zmdi-caret-right-circle'></i></a></div>");
                        }

                    }
                    sesion.close();

                }catch(HibernateException ex){

                    System.err.println(ex);

                }
            
            }
            
        }catch(Exception ex){
        
            System.out.println(ex);
            
        }
        
    }
    protected void verJugador(HttpServletRequest request, HttpServletResponse response, String id)
            throws ServletException, IOException {
    
        try{
            
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            Query query = sesion.createQuery("FROM Jugador WHERE idJugador="+id+"");
            List<Jugador>ListaJugador = query.list();
            for(Jugador jugador : ListaJugador){
            
                Jugador objJugador = new Jugador(jugador.getIdJugador(), jugador.getAlias(), jugador.getPosicion(), jugador.getPierna(), jugador.getDescripcion(), jugador.getRankingSystem(), jugador.getRankingUsers(), jugador.getEstado(), jugador.getCapitan(), jugador.getEquipo(), jugador.getPersona());
                request.getSession().setAttribute("JugadorVisto", objJugador);
                
                Query queryPersona = sesion.createQuery("FROM Persona WHERE idPersona = "+jugador.getPersona()+"");
                List<Persona>ListaPersona = queryPersona.list();
                for(Persona persona : ListaPersona){
                
                    Persona objPersona = new Persona(persona.getIdPersona(), persona.getNombres(), persona.getApellidos(), persona.getFecha_Nacimiento(), persona.getTelefono(), persona.getGenero(), persona.getCorreo(), persona.getContrasenia(), persona.getAvatar());
                    request.getSession().setAttribute("UsuarioVisto", objPersona);
                
                }
            
            }
            response.sendRedirect("/FutPlayFinal/material-dashboard/pages/jugador/verJugador.jsp");
            sesion.close();
        
        }catch(HibernateException ex){
        
            System.err.println(ex);
        }
    }
    protected void eliminarJugador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Jugador objJugadorVisto = (Jugador)request.getSession().getAttribute("JugadorVisto");
            
            try{
            
                Session sesion = HibernateUtil.getSessionFactory().openSession();
                sesion.beginTransaction();
                Query query = sesion.createSQLQuery("UPDATE Jugador SET Equipo=1 WHERE idJugador="+objJugadorVisto.getIdJugador()+"");
                query.executeUpdate();
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
    protected void buscarJugador(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    
        try{
            Jugador objJugador = (Jugador) request.getSession().getAttribute("JugadorIngresado");
            String valor = request.getParameter("Valor");
            System.out.println("-------------------------->Valor  "+valor);
            try{
                if (valor.equals("") || valor == null) {
                    
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write("0");
                    
                }else{
                    
                    Session sesion = HibernateUtil.getSessionFactory().openSession();
                    Query query = sesion.createQuery("FROM Jugador WHERE Alias like '%"+valor+"%'");
                    List<Jugador>ListaJugador = query.list();

                    response.setCharacterEncoding("UTF-8");
                    for(Jugador jugador : ListaJugador){
                        
                        Query queryPersona = sesion.createQuery("FROM Persona WHERE idPersona = "+jugador.getPersona()+"");
                        List<Persona>ListaPersona = queryPersona.list();
                            for(Persona persona : ListaPersona){
                            
                                response.getWriter().write("<div class='col-md-4'>"
                                                    + "<div class='card card-pricing card-raised'>"
                                                        + "<div class='content'>"
                                                            + "<h6>"+jugador.getAlias()+"</h6>"
                                                            +"<div class='icon'>"
                                                                + "<img src='../../assets/img/avatares/"+persona.getAvatar()+"'>"
                                                            + "</div>"
                                                            +"<button class='btn label label-info' onclick='ficharJugador(this.value)' style='margin: 0;' value='"+objJugador.getIdJugador()+"/"+jugador.getIdJugador()+"/"+jugador.getAlias()+"'>Fichar</button><br>"
                                                            +"<a href='/FutPlayFinal/jugador/verjugador/"+jugador.getIdJugador()+"' class='text-muted'>Ver perfil</a>"
                                                        + "</div>"
                                                    + "</div>"
                                                 + "</div>");
                            
                            }

                    }
                    sesion.close();

                }
                
            }catch(HibernateException ex){
            
                System.err.println(ex);
            
            }
        
        }catch(Exception ex){
        
            System.err.println(ex);
            
        }
    
    }
    protected void aceptarFichaje(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            
            String equipo = request.getParameter("equipo");
            
            Jugador objJugador = (Jugador) request.getSession().getAttribute("JugadorIngresado");
            
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            Query query = sesion.createQuery("FROM Jugador WHERE idJugador = "+objJugador.getIdJugador()+"");
            List<Jugador>listaJugador = query.list();
            for(Jugador jugador : listaJugador){
            
                if (jugador.getEquipo().toString().equals(equipo)) {
                    
                    response.getWriter().write("1");
                    
                }else{
                
                    ////////// HACER EL UPDATE AL CAMPO EQUIPO DEL JUGADOR ///////
                    Query actualizarEquipo = sesion.createSQLQuery("UPDATE Jugador SET Equipo="+equipo+" WHERE idJugador="+objJugador.getIdJugador()+"");
                    sesion.beginTransaction();
                    actualizarEquipo.executeUpdate();
                    sesion.getTransaction().commit();
                    
                    
                    Equipo objEquipo = new Equipo();
                    objEquipo.setIdEquipo(Integer.parseInt(equipo));
                    Jugador Newjugador = new Jugador(objJugador.getIdJugador(), objJugador.getAlias(), objJugador.getPosicion(), objJugador.getPierna(), objJugador.getDescripcion(), objJugador.getRankingSystem(), objJugador.getRankingUsers(), objJugador.getEstado(), objJugador.getCapitan(), objEquipo, objJugador.getPersona());
                    request.getSession().setAttribute("JugadorIngresado", Newjugador);
                    
                    /////// SE CREA LA NOTIFICACION QUE INDICA QUE EL JUGADOR FUE AGREGADO AL EQIPO ///////
                    //////// AGREGAR EL ID DEL JUGADOR QUE ENVIA /////////
                    Notificacion objNotificacion = new Notificacion(new Date(), "08:58 P.M", "JugadorAgregado", "", 0, objJugador.getIdJugador(), 0, 0, "", 0, Integer.parseInt(equipo));
                    sesion.beginTransaction();
                    sesion.save(objNotificacion);
                    sesion.getTransaction().commit();
                    
                    
                    response.getWriter().write("2");
                }
                
            }
            
            sesion.close();
            
        }catch(HibernateException ex){
        
            System.out.println(ex);
            
        }catch(Exception ex){
        
            System.out.println(ex);
        }
    
    }
    /*protected void agregarEquipo(HttpServletRequest request, HttpServletResponse response, String id)
            throws ServletException, IOException {
        
        try{
            
            Jugador objJugador = (Jugador) request.getSession().getAttribute("JugadorIngresado");
            
            try{
                
                Session sesion = HibernateUtil.getSessionFactory().openSession();
                Query query = sesion.createQuery("FROM Jugador WHERE idJugador = "+id+"");
                List<Jugador> ListaJugador = query.list();
                for(Jugador jugador : ListaJugador){
                    
                    if (String.valueOf(jugador.getEquipo()).equals("1")) {
                        
                        /*sesion.beginTransaction();
                        Notificacion objNotificacion = new Notificacion(new Date(), "10:29 a.m", "FicharJugador", "", objJugador, jugador.getEquipo());
                        sesion.save(objNotificacion);
                        sesion.getTransaction().commit();*/
                        
                        /*sesion.beginTransaction();
                        Query queryJugador = sesion.createQuery("UPDATE Jugador SET Equipo="+objJugador.getEquipo()+" WHERE idJugador="+jugador.getIdJugador()+"");
                        queryJugador.executeUpdate();
                        sesion.getTransaction().commit();
                        
                        
                        //////////////////////////// CREAR LA NOTIFICACION DEL FICHAJE ////////////////////////
                        System.out.println("jugador      --------------------------------------------------------- > CREARC NOTIFICACION FICHAJE");
                        sesion.beginTransaction();
                        //Notificacion objNotificacion = new Notificacion(new Date(), "10:23 a.m", "FicharJugador", "", objJugador, objJugador.getEquipo());
                        
                        String equipo = objJugador.getEquipo().toString();
                        int eq = Integer.parseInt(equipo);
                        
                        Notificacion objNotificacion = new Notificacion(new Date(), "11:21", "", "", objJugador.getIdJugador(), jugador.getIdJugador(), 0, 0, "", eq, eq);
                        sesion.save(objNotificacion);
                        sesion.getTransaction().commit();
                        response.sendRedirect("/FutPlay/PAGES/Equipo/CrearEquipo.jsp");
                        
                    }else{
                        
                        System.out.println("jugador ---------------------------> Jugador no fichado");
                        //response.sendRedirect("/FutPlay/PAGES/Jugador/VerJugadores.jsp");
                        
                    }
                    
                }
                sesion.close();
            }catch(HibernateException ex){
            
                System.err.println(ex);
            
            }
        
        }catch(Exception ex){
        
            System.err.println(ex);
            
        }
       
    }*/
    protected void ficharJugador(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        try{
            String recibe = request.getParameter("recibe");
            Jugador objJugador = (Jugador) request.getSession().getAttribute("JugadorIngresado");
            
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            Query query = sesion.createQuery("FROM Jugador WHERE idJugador="+recibe+"");
            List<Jugador> listaJugador = query.list();
            
            for(Jugador jugador : listaJugador){
            
                if (jugador.getEquipo().toString().equals(objJugador.getEquipo().toString())) {
                    response.getWriter().write("1");
                }else{
                    ////////// CODIGO PARA CREAR UNA LA NOTIFICACIN DE FICHAJE ///////////////////
                    
                    Query queryNotificaion = sesion.createQuery("FROM Notificacion WHERE Tipo = 'FicharJugador' AND JugadorEnvia="+objJugador.getIdJugador()+" AND JugadorRecibe='"+jugador.getIdJugador()+"'");
                    List<Notificacion>listaNotificacion = queryNotificaion.list();
                    
                    if (listaNotificacion.size() > 0) {
                        
                        response.getWriter().write("2");
                        
                    }else{
                    
                        Notificacion objNotificacion = new Notificacion(new Date(), "01:07 P.M", "FicharJugador", "", objJugador.getIdJugador(), jugador.getIdJugador(), 0, 0, objJugador.getEquipo().toString(), 0, 0);
                        sesion.beginTransaction();
                        sesion.save(objNotificacion);
                        sesion.getTransaction().commit();

                        response.getWriter().write("3");
                    }
                }
            
            }
            
            sesion.close();
        
        }catch(HibernateException ex){
        
            System.err.println(ex);
            
        }catch(Exception ex){
        
            System.err.println(ex);
        }
    
    }
    protected void likeJugador(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    
        try{
        
            System.out.println("ESTOY HACIENDOLE UN LIKE A EL JUGADOR.");
            
            String finalCalf = "";
            int tipoDeCalificacion = 0;
            
            Jugador objJugadorSesion = (Jugador) request.getSession().getAttribute("JugadorIngresado");
            Jugador objJugadorVisto = (Jugador) request.getSession().getAttribute("JugadorVisto");
            
            
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            if (!"".equals(objJugadorVisto.getRankingUsers())) {
                
                String rankingUsers = objJugadorVisto.getRankingUsers();
                String calificados[] = rankingUsers.split("/");
                if (calificados.length >= 1) {
                    
                    for (int i = 0; i < calificados.length; i++) {
                        
                        String usuario[] = calificados[i].split("~");
                        
                        if (usuario[0].equals(String.valueOf(objJugadorSesion.getIdJugador())) & usuario[1].equals("1")) {
                            
                            response.getWriter().write("1");
                            //////////// INDICA QUE YA ESTA CALIFICADO //////////
                            System.out.println("EL JUGADOR YA TIENE UN LIKE..");
                            
                        }else{
                            System.out.println("    no tiene lo que quire hacer");
                            if (usuario[0].equals(String.valueOf(objJugadorSesion.getIdJugador())) & usuario[1].equals("0")) {
                                
                                String contenedor = "";
                                System.out.println("23232232232323223232");
                                System.out.println("HAY QUE CAMBIAR DE DISLIKE A LIKE. hjGASJagsjhs");
                                /////////// HAY QUE DESARMAR Y VOLVER A ARMAR EL STRING ////////
                                for (int j = 0; j < calificados.length; j++) {
                                    
                                    String desarmar[] = calificados[j].split("~"); 
                                    
                                    if (desarmar[0].equals(String.valueOf(objJugadorSesion.getIdJugador()))) {
                                        
                                        contenedor += ""+String.valueOf(objJugadorSesion.getIdJugador())+"~1/";
                                        System.out.println("CONTENECOR 1---> "+contenedor);
                                    }else{
                                    
                                        contenedor += calificados[j]+"/";
                                        System.out.println("CONTENEDOR 2----> "+contenedor);
                                    }
                                    
                                }
                                System.out.println("ESTE EL EL ERROR MAS GAY ---> " + contenedor);
                                System.out.println("cacacacacacacacacacacacacacacacacacacca....cacacac...caca...ca");
                                
                                finalCalf = "";
                                finalCalf = contenedor;
                                
                                System.out.println("ESTE EL EL FINAL CALF ---> " +finalCalf);
                                
                                tipoDeCalificacion = 1;
                                
                            }else{
                                ////// HAY QUE AGREGAR LA NUEVA CALIFICACION ///////////
                                finalCalf = ""+objJugadorVisto.getRankingUsers()+String.valueOf(objJugadorSesion.getIdJugador())+"~1/";
                                System.out.println("olpoopopo ---> " +i);
                                if (i+1 == calificados.length) {
                                
                                    tipoDeCalificacion = 2;
                                }
                            
                            }
                        }
                        
                    }
                    
                    if (tipoDeCalificacion == 1) {
                        
                        System.out.println("HACIENDO EL INSERT %%%%%%%%%%% -->  " + finalCalf);
                        
                        ////// SE EJECUTA LA ACTUALIZACION O EL INGRESO DE LA CALIFICACION ////
                        Query actualizarJugador = sesion.createSQLQuery("UPDATE jugador SET RankingUsers='"+finalCalf+"' WHERE idJugador="+objJugadorVisto.getIdJugador()+"");
                        sesion.beginTransaction();
                        actualizarJugador.executeUpdate();
                        sesion.getTransaction().commit();

                        ///// METODO PARA ACTUALIZAR LA SESIN DEL JUGADORVISTO O DEL JUGADOR INGRESADO ////
                        atualizarSesionUsuarioVisto(request, response, objJugadorVisto.getIdJugador(), "Visto");

                        response.getWriter().write("2");
                        
                    }else if (tipoDeCalificacion == 2) {
                        
                        System.out.println("TIPO DE CALIFICACION #2 -----<>");
                        ////// SE EJECUTA LA ACTUALIZACION O EL INGRESO DE LA CALIFICACION ////
                        Query actualizarJugador = sesion.createSQLQuery("UPDATE jugador SET RankingUsers='"+finalCalf+"' WHERE idJugador="+objJugadorVisto.getIdJugador()+"");
                        sesion.beginTransaction();
                        actualizarJugador.executeUpdate();
                        sesion.getTransaction().commit();

                        ///// METODO PARA ACTUALIZAR LA SESIN DEL JUGADORVISTO O DEL JUGADOR INGRESADO ////
                        atualizarSesionUsuarioVisto(request, response, objJugadorVisto.getIdJugador(), "Visto");
                        
                        response.getWriter().write("2");
                        
                    }
                    
                }
                
            }else{
            
                finalCalf = ""+String.valueOf(objJugadorSesion.getIdJugador())+"~1/";
                Query actualizarJugador = sesion.createSQLQuery("UPDATE jugador SET RankingUsers='"+finalCalf+"' WHERE idJugador="+objJugadorVisto.getIdJugador()+"");
                sesion.beginTransaction();
                actualizarJugador.executeUpdate();
                sesion.getTransaction().commit();
            
                ///// METODO PARA ACTUALIZAR LA SESIN DEL JUGADORVISTO O DEL JUGADOR INGRESADO ////
                atualizarSesionUsuarioVisto(request, response, objJugadorVisto.getIdJugador(), "Visto");
                
                response.getWriter().write("2");
                
            }
        
            sesion.close();
            
            
        }catch(HibernateException ex){
        
            System.err.println(ex);
        }catch(Exception ex){
        
            System.err.println(ex);
        }
        
    }
    protected void dislikeJugador(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        try{
            
            System.out.println("ESTOY HACIENDOLE UN DISLIKE A EL JUGADOR.");
            
            String finalCalf = "";
            int tipoDeCalificacion = 0;
            
            Jugador objJugadorSesion = (Jugador) request.getSession().getAttribute("JugadorIngresado");
            Jugador objJugadorVisto = (Jugador) request.getSession().getAttribute("JugadorVisto");
            
            
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            if (!"".equals(objJugadorVisto.getRankingUsers())) {
                
                String rankingUsers = objJugadorVisto.getRankingUsers();
                String calificados[] = rankingUsers.split("/");
                System.out.println("LLLLLOOOOOOOOOLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL"+calificados[0]);
                if (calificados.length >= 1) {
                    
                    for (int i = 0; i < calificados.length; i++) {
                        
                        String usuario[] = calificados[i].split("~");
                        
                        if (usuario[0].equals(String.valueOf(objJugadorSesion.getIdJugador())) & usuario[1].equals("0")) {
                            
                            response.getWriter().write("1");
                            //////////// INDICA QUE YA ESTA CALIFICADO //////////
                            System.out.println("EL JUGADOR YA TIENE UN DISLIKE..");
                            
                        }else{
                            System.out.println("    no tiene lo que quire hacer");
                            if (usuario[0].equals(String.valueOf(objJugadorSesion.getIdJugador())) & usuario[1].equals("1")) {
                                
                                String contenedor = "";
                                System.out.println("HAY QUE CAMBIAR DE LIKE A DISLIKE. lol");
                                /////////// HAY QUE DESARMAR Y VOLVER A ARMAR EL STRING ////////
                                for (int j = 0; j < calificados.length; j++) {
                                    
                                    String desarmar[] = calificados[j].split("~"); 
                                    
                                    if (desarmar[0].equals(String.valueOf(objJugadorSesion.getIdJugador()))) {
                                        
                                        contenedor += ""+String.valueOf(objJugadorSesion.getIdJugador())+"~0/";
                                    }else{
                                    
                                        contenedor += calificados[j]+"/";
                                    }
                                    System.out.println("ESTE EL EL ERROR MAS GAY ---> " + contenedor);
                                    System.out.println("cke");
                                    finalCalf = contenedor;
                                    tipoDeCalificacion = 1;
                                    
                                }
                            }else{
                                ////// HAY QUE AGREGAR LA NUEVA CALIFICACION ///////////
                                finalCalf = ""+objJugadorVisto.getRankingUsers()+String.valueOf(objJugadorSesion.getIdJugador())+"~0/";
                                System.out.println("olpoopopo ---> " +i);
                                if (i+1 == calificados.length) {
                                
                                    tipoDeCalificacion = 2;
                                }
                            
                            }
                        }
                        
                    }
                    
                    if (tipoDeCalificacion == 1) {
                        
                        ////// SE EJECUTA LA ACTUALIZACION O EL INGRESO DE LA CALIFICACION ////
                        Query actualizarJugador = sesion.createSQLQuery("UPDATE jugador SET RankingUsers='"+finalCalf+"' WHERE idJugador="+objJugadorVisto.getIdJugador()+"");
                        sesion.beginTransaction();
                        actualizarJugador.executeUpdate();
                        sesion.getTransaction().commit();

                        ///// METODO PARA ACTUALIZAR LA SESIN DEL JUGADORVISTO O DEL JUGADOR INGRESADO ////
                        atualizarSesionUsuarioVisto(request, response, objJugadorVisto.getIdJugador(), "Visto");

                        response.getWriter().write("2");
                        
                    }else if (tipoDeCalificacion == 2) {
                        
                        
                        ////// SE EJECUTA LA ACTUALIZACION O EL INGRESO DE LA CALIFICACION ////
                        Query actualizarJugador = sesion.createSQLQuery("UPDATE jugador SET RankingUsers='"+finalCalf+"' WHERE idJugador="+objJugadorVisto.getIdJugador()+"");
                        sesion.beginTransaction();
                        actualizarJugador.executeUpdate();
                        sesion.getTransaction().commit();

                        ///// METODO PARA ACTUALIZAR LA SESIN DEL JUGADORVISTO O DEL JUGADOR INGRESADO ////
                        atualizarSesionUsuarioVisto(request, response, objJugadorVisto.getIdJugador(), "Visto");
                        
                        response.getWriter().write("2");
                        
                    }
                    
                }
                
            }else{
            
                finalCalf = ""+String.valueOf(objJugadorSesion.getIdJugador())+"~0/";
                Query actualizarJugador = sesion.createSQLQuery("UPDATE jugador SET RankingUsers='"+finalCalf+"' WHERE idJugador="+objJugadorVisto.getIdJugador()+"");
                sesion.beginTransaction();
                actualizarJugador.executeUpdate();
                sesion.getTransaction().commit();
            
                ///// METODO PARA ACTUALIZAR LA SESIN DEL JUGADORVISTO O DEL JUGADOR INGRESADO ////
                atualizarSesionUsuarioVisto(request, response, objJugadorVisto.getIdJugador(), "Visto");
                
                response.getWriter().write("2");
                
            }
        
            sesion.close();
            
        }catch(HibernateException ex){
        
            System.err.println(ex);
            
        }catch(Exception ex){
        
            System.err.println(ex);
        }
    
    }
    /////////////////////// METODO PARA ACTUALIZAR LAS SESIONES DE EL JUGADOR ///////////////////////777
    public void atualizarSesionUsuarioVisto(HttpServletRequest request, HttpServletResponse response, int idJugador, String tipo){
    
        try{
            System.out.println("ACTUALIZAR LA SESION DEL JUGADOR");
        
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            Query query = sesion.createQuery("FROM Jugador WHERE idJugador="+idJugador+"");
            List<Jugador> listaJugador = query.list();
            for(Jugador jugador : listaJugador){
            
                Jugador objJugador = new Jugador(jugador.getIdJugador(), jugador.getAlias(), jugador.getPosicion(), jugador.getPierna(), jugador.getDescripcion(), jugador.getRankingSystem(), jugador.getRankingUsers(), jugador.getEstado(), jugador.getCapitan(), jugador.getEquipo(), jugador.getPersona());
                
                if (tipo == "Ingresado") {
                    
                    request.getSession().setAttribute("JugadorIngresado", objJugador);
                    
                }else if (tipo == "Visto") {
                    request.getSession().setAttribute("JugadorVisto", objJugador);
                }
                
            }
            sesion.close();
        }catch(HibernateException ex){
            System.out.println(ex);
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

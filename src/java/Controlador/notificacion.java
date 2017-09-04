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
import Modelo.Propietario;
import com.google.gson.Gson;
import java.io.IOException;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
public class notificacion extends HttpServlet {

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
            
                case "notificacionregistro":
                        NotificacinRegistro(request, response);
                    break;
                    
                case "cargarnotificaciones":
                        
                        CargarNotificaciones(request, response);
                    
                    break;
                
                case "vernotificaciones":
                        VerNotificaciones(request, response);
                    break;
                    
                case "vistonotificacion":
                        vistoNotificacion(request, response);
                    break;
                case "cargarnotificacionespropietario":
                        CargarNotificacionesPropietario(request, response);
                    break;
                case "vernotificacionespropietario":
                        VerNotificacionesPropietario(request, response);
                    break;
                case "vistonotificacionpropietario":
                        VistoNotificacionesPropietario(request, response);
                    break;
                    
                        
            }
        }
        
        
    }
    protected void NotificacinRegistro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            System.out.println("NOTIFICACION -----------------------------> Notificacion Registro");
            Persona objPersona = (Persona) request.getSession().getAttribute("UsuarioRegistrado");
            
            try{
                Session sesion = HibernateUtil.getSessionFactory().openSession();
                Query query = sesion.createQuery("FROM Jugador WHERE Persona = "+objPersona.getIdPersona()+"");
                List<Jugador> ListaJugador = query.list();
                for(Jugador jugador : ListaJugador){
                    
                    /////// ESTA CONVERCION NO ESTA PROVADA!! //////
                    String equipo = String.valueOf(jugador.getEquipo());
                    int eq = Integer.parseInt(equipo);
                    //Notificacion objNotificacion = new Notificacion(new Date(), "11:11 p.m", "Registro", "", jugador, jugador.getEquipo());
                    Notificacion objNotificacion = new Notificacion(new Date(), "11:00 A.M", "Registro", "", 0, jugador.getIdJugador(), 0, 0, "", 0, 0);
                    sesion.beginTransaction();
                    sesion.save(objNotificacion);
                    sesion.getTransaction().commit();
                    
                    
                }
                
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
    protected void CargarNotificaciones(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{

            int numeroVisto = 0, noVistos = 0;
            Jugador objJugador = (Jugador) request.getSession().getAttribute("JugadorIngresado");

            try{

                Session sesion = HibernateUtil.getSessionFactory().openSession();
                
                Query primeraNotificacion = sesion.createQuery("FROM Notificacion WHERE Tipo='Registro' AND JugadorRecibe="+objJugador.getIdJugador()+"");
                List<Notificacion>listaPrimeraNotificacion = primeraNotificacion.list();
                for (Notificacion notificacionn : listaPrimeraNotificacion) {
                  
                    Query query = sesion.createQuery("FROM Notificacion WHERE idNotificacion >= "+notificacionn.getIdNotificacion()+" AND EquipoRecibe ="+objJugador.getEquipo()+" OR JugadorRecibe = "+objJugador.getIdJugador()+"");
                    List<Notificacion> ListaNotificacion = query.list();

                    System.out.println("NUMERO DE NOTIFICACIONES RECIBIDAS -------> "+ListaNotificacion.size());

                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("text/plain");
                    for(Notificacion notificacion : ListaNotificacion){
                        //System.out.println("CARGANDO LAS NOTIFICACIONES ------>     "+notificacion.getTipo());
                        String visto [] = notificacion.getVisto().split("/");
                        for (int i = 0; i < visto.length; i++) {

                            if (visto[i].equals(String.valueOf(objJugador.getIdJugador()))) {

                                numeroVisto++;

                            }
                        }
                    }
                    /////////// REDUNDANCIA ENCONTRADA, ARREGLAR ///////////////
                    noVistos = ListaNotificacion.size() - numeroVisto;
                    if (noVistos != 0) {

                        response.getWriter().write("<span class='notification'>"+noVistos+"</span>");

                    }
                    
                    
                }
                
                
                //sesion.close();

            }catch(HibernateException ex){

                System.out.println(ex);

            }
            
        }catch(Exception ex){
        
            System.out.println(ex);
            
        }
    }
    protected void VerNotificaciones(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        try{
            //System.out.println("---------------> VER NOTIFICACIONESssssssssssssssssssssssssssss");
            Jugador objJugador = (Jugador) request.getSession().getAttribute("JugadorIngresado");
            
            try{
                
                Session sesion = HibernateUtil.getSessionFactory().openSession();
                
                Query primeraNotificacion = sesion.createQuery("FROM Notificacion WHERE Tipo='Registro' AND JugadorRecibe="+objJugador.getIdJugador()+"");
                List<Notificacion>listaPrimeraNotificacion = primeraNotificacion.list();
                for (Notificacion notificacionn : listaPrimeraNotificacion) {
                
                    Query query = sesion.createQuery("FROM Notificacion WHERE idNotificacion >= "+notificacionn.getIdNotificacion()+" AND EquipoRecibe ="+objJugador.getEquipo()+" OR JugadorRecibe = "+objJugador.getIdJugador()+" ORDER BY (idNotificacion) DESC");
                    List<Notificacion>ListaNotificacion = query.list();
                    
                    for(Notificacion notificacion : ListaNotificacion){

                        System.out.println("TIPO DE NOTIFICAICON ------>    "+notificacion.getTipo());


                        System.out.println("EQUIPO JUGADOR NOTIFICACIONES------------------>" + objJugador.getEquipo());
                        System.out.println(notificacion.getTipo());
                        String href = "", contenido = "", icono = "", color="", onclick="";

                        Query queryNotificacion = sesion.createQuery("FROM Jugador WHERE idJugador="+notificacion.getJugadorEnvia()+"");
                        List<Jugador>ListaJugador = queryNotificacion.list();
                        if (ListaJugador.size() > 0) {

                            System.out.println("NOTIFICACION DEL JUGADOR QUE ENVIA --------)");

                            for(Jugador jugador : ListaJugador){
                                switch (notificacion.getTipo()){

                                    case "Registro":

                                            icono = "group";
                                            href="#";
                                            contenido="¡FutPlay te da la bienvenida!";
                                            color="00BCD4";
                                        break;

                                    case "EditarEquipo":

                                            icono = "mode_edit";
                                            href="/FutPlayFinal/material-dashboard/pages/equipo/verEquipo.jsp";
                                            contenido=""+jugador.getAlias()+" ha cambiado la informacion del equipo.";
                                            color="FF9800";
                                        break;

                                    case "AgregarJugador":

                                            icono = "person_add";
                                            href="/FutPlayFinal/material-dashboard/pages/jugador/verJugadores.jsp";
                                            contenido=""+jugador.getAlias()+" quiere que hagas parte de su quipo.";
                                            color="00BCD4";
                                        break;

                                    case "CrearEquipo":

                                            icono = "group_work";
                                            href="/FutPlayFinal/material-dashboard/pages/equipo/verEquipo.jsp";
                                            contenido=""+jugador.getAlias()+" ha creado el equipo.";
                                            color="4CAF50";

                                        break;

                                    case "FicharJugador":
                                            ////// HACER LA QUEY PARA QUE EN EL CONTENIDO SE MUETRE EL JUGADOR QUE ENVIA ///
                                            Query queryJugadorEnvia = sesion.createQuery("FROM Jugador WHERE idJugador="+notificacion.getJugadorEnvia()+"");
                                            List<Jugador>listaJugadorEnvia = queryJugadorEnvia.list();
                                            for(Jugador jugadorr : listaJugadorEnvia){

                                                icono = "person_add";
                                                href="#";
                                                contenido=""+jugadorr.getAlias()+" quiere que hagas parte de su equipo.";
                                                color="00BCD4";
                                                /// EL ORDEN EL LA INFORMACION DEL ID ES: quien lo invita,id del equipo al que va a pertenecer ///
                                                onclick="onclick='agregarJugador(this)' id='"+jugadorr.getAlias()+"/"+jugadorr.getEquipo()+"'";

                                            }

                                        break;

                                    case "JugadorAgregado":
                                            icono = "check_circle";
                                            href = "/FutPlayFinal/material-dashboard/pages/equipo/verEquipo.jsp";
                                            contenido = ""+jugador.getAlias()+" fue agregado al equipo.";
                                            color="4CAF50";
                                        break;

                                }
                                String fecha [] = notificacion.getFecha().toString().split(" ");

                                response.getWriter().write("<a href='"+href+"' "+onclick+" class='NotificationP'>"
                                                                +"<div class='Notification-iconP'>"
                                                                    +"<i class='material-icons' style='background-color: #"+color+"; font-size: 25px;'>"+icono+"</i>"
                                                                +"</div>"
                                                                +"<div class='Notification-textP' style='margin-left: 70px;'>"
                                                                    +"<p style='padding-top: 10px;'>"
                                                                        +"<strong class='description'>"+contenido+"</strong><br>"
                                                                        +"<small>"+fecha[0]+"</small>"    
                                                                    +"</p>"
                                                                +"</div>"
                                                           +"</a>");


                            }

                        }else{

                            Query queryJugador = sesion.createQuery("FROM Jugador WHERE idJugador="+notificacion.getJugadorRecibe()+"");
                            List<Jugador>ListaJugadorr = queryJugador.list();
                            for(Jugador jugador : ListaJugadorr){

                                System.out.println("JUGADOR QUE RECIBE °°°°°°°°°°°°");

                                switch (notificacion.getTipo()){

                                    case "Registro":

                                            icono = "group";
                                            href="#";
                                            contenido="¡FutPlay te da la bienvenida!";
                                            color="00BCD4";
                                        break;

                                    case "EditarEquipo":

                                            icono = "mode_edit";
                                            href="/FutPlayFinal/material-dashboard/pages/equipo/verEquipo.jsp";
                                            contenido=""+jugador.getAlias()+" ha cambiado la informacion del equipo.";
                                            color="FF9800";
                                        break;

                                    case "AgregarJugador":

                                            icono = "person_add";
                                            href="/FutPlayFinal/material-dashboard/pages/jugador/verJugadores.jsp";
                                            contenido=""+jugador.getAlias()+" quiere que hagas parte de su quipo.";
                                            color="00BCD4";
                                        break;

                                    case "CrearEquipo":

                                            icono = "group_work";
                                            href="/FutPlayFinal/material-dashboard/pages/equipo/verEquipo.jsp";
                                            contenido=""+jugador.getAlias()+" ha creado el equipo.";
                                            color="4CAF50";

                                        break;

                                    case "FicharJugador":
                                            ////// HACER LA QUEY PARA QUE EN EL CONTENIDO SE MUETRE EL JUGADOR QUE ENVIA ///
                                            Query queryJugadorEnvia = sesion.createQuery("FROM Jugador WHERE idJugador="+notificacion.getJugadorEnvia()+"");
                                            List<Jugador>listaJugadorEnvia = queryJugadorEnvia.list();
                                            for(Jugador jugadorr : listaJugadorEnvia){

                                                icono = "person_add";
                                                href="#";
                                                contenido=""+jugadorr.getAlias()+" quiere que hagas parte de su equipo.";
                                                color="00BCD4";
                                                /// EL ORDEN EL LA INFORMACION DEL ID ES: quien lo invita,id del equipo al que va a pertenecer ///
                                                onclick="onclick='agregarJugador(this)' id='"+jugadorr.getAlias()+"/"+jugadorr.getEquipo()+"'";

                                            }

                                        break;

                                    case "JugadorAgregado":
                                            icono = "check_circle";
                                            href = "/FutPlayFinal/material-dashboard/pages/equipo/verEquipo.jsp";
                                            contenido = ""+jugador.getAlias()+" fue agregado al equipo.";
                                            color="4CAF50";
                                        break;

                                }
                                String fecha [] = notificacion.getFecha().toString().split(" ");

                                response.getWriter().write("<a href='"+href+"' "+onclick+" class='NotificationP'>"
                                                                +"<div class='Notification-iconP'>"
                                                                    +"<i class='material-icons' style='background-color: #"+color+"; font-size: 25px;'>"+icono+"</i>"
                                                                +"</div>"
                                                                +"<div class='Notification-textP' style='margin-left: 70px;'>"
                                                                    +"<p style='padding-top: 10px;'>"
                                                                        +"<strong class='description'>"+contenido+"</strong><br>"
                                                                        +"<small>"+fecha[0]+"</small>"    
                                                                    +"</p>"
                                                                +"</div>"
                                                           +"</a>");

                            }
                        }
                        if (notificacion.getTipo().equals("SolicitarEncuentro")) {
                            
                            System.out.println("ARMANDO LA NOTIFICACION CUANDO HAY UN ENCUENTRO ");
                            
                            ////////////// HACEMOS UNA CONSULTA PARA VERIFICAR SI EL EQUIPO TIENE O NO NOTIFICACIONES ////////
                            Query queryEquipoNotificaciones = sesion.createQuery("FROM Equipo WHERE idEquipo="+notificacion.getEquipoEnvia()+"");
                            List<Equipo>listaEquipo = queryEquipoNotificaciones.list();
                            for (Equipo equipo : listaEquipo) {
                                
                                String fecha [] = notificacion.getFecha().toString().split(" ");
                                String contenidoNot[] = notificacion.getDatosAdicionales().split("/");
                                
                                response.getWriter().write("<a href='#' onclick='aceptarEncuentro(this)' id='"+equipo.getNombre()+"/"+notificacion.getEquipoEnvia()+"/"+notificacion.getDatosAdicionales()+"' class='NotificationP'>"
                                                                +"<div class='Notification-iconP'>"
                                                                    +"<i class='material-icons' style='background-color: #FF9800; font-size: 25px;'>flash_on</i>"
                                                                +"</div>"
                                                                +"<div class='Notification-textP' style='margin-left: 70px;'>"
                                                                    +"<p style='padding-top: 10px;'>"
                                                                        +"<strong class='description'>El equipo "+equipo.getNombre()+" quiere participar en un encuentro contra tu equipo.</strong><br>"
                                                                        +"<small>"+fecha[0]+"</small>"    
                                                                    +"</p>"
                                                                +"</div>"
                                                           +"</a>");
                                
                            }
                        }
                    }
                
                }
                
                /////FALTA CERRAR LA SESION ///////
                //sesion.close();
                
            }catch(HibernateException ex){
                System.err.println(ex);
            }
            
        }catch(Exception ex){
        
            System.err.println(ex);
            
        }
    
    }
    protected void vistoNotificacion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            System.out.println("NOTIFICACION ---------------------------------> ACTUALIZAR NOTIFICACION");
            Jugador objJugador = (Jugador) request.getSession().getAttribute("JugadorIngresado");
            
            try{
                Session sesion = HibernateUtil.getSessionFactory().openSession();
                Query query = sesion.createQuery("FROM Notificacion WHERE EquipoRecibe="+objJugador.getEquipo()+" OR JugadorRecibe = "+objJugador.getIdJugador()+"");
                List<Notificacion>ListaNotificaion = query.list();
                for(Notificacion notificacion : ListaNotificaion){
                    
                    String personasVisto [] = notificacion.getVisto().split("/");
                    int numero = 0;
                    for (int i = 0; i < personasVisto.length; i++) {
                        
                        if (personasVisto[i].equals(String.valueOf(objJugador.getIdJugador()))) {
                            
                            numero++;
                            
                        }
                    }
                    
                    if (numero == 0) {
                        
                        sesion.beginTransaction();
                        Query actualizarNotificacion = sesion.createSQLQuery("UPDATE Notificacion SET Visto='"+notificacion.getVisto()+"/"+objJugador.getIdJugador()+"' WHERE idNotificacion = "+notificacion.getIdNotificacion()+"");
                        actualizarNotificacion.executeUpdate();
                        sesion.getTransaction().commit();
                    }
                }
                
                sesion.close();
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/plain");
                response.getWriter().write("1");
                
            }catch(HibernateException ex){
            
                System.err.println(ex);
            }
        }catch (Exception ex){
        
            System.err.println(ex);
        }
    }
    ////////////////////////////// METODOS PARA LAS NOTIFICACIONES DE EL PROPIETARIO ///////////////////////////////////
    protected void CargarNotificacionesPropietario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        try{
            
            int numeroVisto = 0, noVistos = 0;

            Propietario objPropietario = (Propietario) request.getSession().getAttribute("PropietarioIngresado");
            
            Session sesion = HibernateUtil.getSessionFactory().openSession();
                

            Query query = sesion.createQuery("FROM Notificacion WHERE PropietarioRecibe = "+objPropietario.getIdPropietario()+"");
            List<Notificacion> ListaNotificacion = query.list();

            for(Notificacion notificacion : ListaNotificacion){
                //System.out.println("CARGANDO LAS NOTIFICACIONES ------>     "+notificacion.getTipo());
                String visto [] = notificacion.getVisto().split("/");
                for (int i = 0; i < visto.length; i++) {

                    if (visto[i].equals(String.valueOf(objPropietario.getIdPropietario()))) {

                        numeroVisto++;

                    }
                }
            }
            /////////// REDUNDANCIA ENCONTRADA, ARREGLAR ///////////////
            noVistos = ListaNotificacion.size() - numeroVisto;
            if (noVistos != 0) {

                response.getWriter().write("<span class='notification'>"+noVistos+"</span>");

            }
            
        }catch(HibernateException ex){
            System.err.println(ex);
        }catch(Exception ex){
            System.err.println(ex);
        }
        
    }
    protected void VerNotificacionesPropietario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            
            System.out.println("VER NOTIFICAIONES DEL PROPIETARIO");
            
            Propietario objPropietario = (Propietario) request.getSession().getAttribute("PropietarioIngresado");
            
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            Query query = sesion.createQuery("FROM Notificacion WHERE PropietarioRecibe = "+objPropietario.getIdPropietario()+"");
            List<Notificacion> ListaNotificacion = query.list();

            for(Notificacion notificacion : ListaNotificacion){
                
                
                switch (notificacion.getTipo()){
                
                    case "ConfirmarEncuentro":
                        
                        String fecha [] = notificacion.getFecha().toString().split(" ");
                        String contenidoNot[] = notificacion.getDatosAdicionales().split("/");

                        Query queryEquipo1 = sesion.createQuery("FROM Equipo WHERE idEquipo = "+contenidoNot[1]+"");
                        List<Equipo>listaEquipo1 = queryEquipo1.list();
                        Query queryEquipo2 = sesion.createQuery("FROM Equipo WHERE idEquipo = "+contenidoNot[2]+"");
                        List<Equipo>listaEquipo2 = queryEquipo2.list();
                        
                        for(Equipo equipo : listaEquipo1){
                            
                            for(Equipo eq : listaEquipo2){
                            
                                response.getWriter().write("<a href='#' data-toggle='modal' data-target='#noticeModal' id='"+notificacion.getDatosAdicionales()+"' class='NotificationP'>"
                                                                +"<div class='Notification-iconP'>"
                                                                    +"<i class='material-icons' style='background-color: #FF9800; font-size: 25px;'>flash_on</i>"
                                                                +"</div>"
                                                                +"<div class='Notification-textP' style='margin-left: 70px;'>"
                                                                    +"<p style='padding-top: 10px;'>"
                                                                        +"<strong class='description'>Los equipos "+equipo.getNombre()+" y "+eq.getNombre()+" desean progamar un encuentro.</strong><br>"
                                                                        +"<small>"+fecha[0]+"</small>"    
                                                                    +"</p>"
                                                                +"</div>"
                                                           +"</a>"
                                                           + "<div class='modal fade' id='noticeModal' tabindex='-1' role='dialog' aria-labelledby='myModalLabel' aria-hidden='true' style='display: none'>"
                                                                +"<div class='modal-dialog modal-notice'>"
                                                                    +"<div class='modal-content'>"
                                                                        +"<div class='modal-header'>"
                                                                            +"<button type='button' class='close' data-dismiss='modal' aria-hidden='true'><i class='material-icons'>clear</i></button>"
                                                                            +"<h5 class='modal-title' id='myModalLabel'>Confirmar encuentro</h5>"
                                                                        +"</div>"
                                                                    +"</div>"
                                                                    +"<div class='modal-body'>"
                                                                        +"<div class='row'>"
                                                                            +"<div class='col-md-10 col-md-offset-1'>"
                                                                                +"<div class='form-group label-floating is-empty'>"
                                                                                    +"<label class='control-label'>Nombre</label>"
                                                                                    +"<input type='text' class='form-control' id='txtNombreEquipo'>"
                                                                                    +"<span class='help-block'>Ingresa el nombre de tu equipo</span>"
                                                                                    +"<span class='material-input'></span>"
                                                                                +"</div>"
                                                                            +"</div>"
                                                                        +"</div>"
                                                                    +"</div>"
                                                                +"</div>"
                                                            +"</div>");
                                                                
                                                            
                            }
                        
                        
                        }
                        
                    break;
                    
                }
                
            }
            
        }catch(HibernateException ex){
            System.err.println(ex);
        }catch(Exception ex){
            System.err.println(ex);
        }
    }
    protected void VistoNotificacionesPropietario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        try{
            
            Propietario objPropietario = (Propietario) request.getSession().getAttribute("PropietarioIngresado");
            
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            Query query = sesion.createQuery("FROM Notificacion WHERE PropietarioRecibe="+objPropietario.getIdPropietario()+"");
            List<Notificacion>ListaNotificaion = query.list();
            for(Notificacion notificacion : ListaNotificaion){

                String personasVisto [] = notificacion.getVisto().split("/");
                int numero = 0;
                for (int i = 0; i < personasVisto.length; i++) {

                    if (personasVisto[i].equals(String.valueOf(objPropietario.getIdPropietario()))) {

                        numero++;

                    }
                }

                if (numero == 0) {

                    sesion.beginTransaction();
                    Query actualizarNotificacion = sesion.createSQLQuery("UPDATE Notificacion SET Visto='"+notificacion.getVisto()+"/"+objPropietario.getIdPropietario()+"' WHERE idNotificacion = "+notificacion.getIdNotificacion()+"");
                    actualizarNotificacion.executeUpdate();
                    sesion.getTransaction().commit();
                }
            }

            sesion.close();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/plain");
            response.getWriter().write("1");
            
            
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

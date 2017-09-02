/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Mensaje;
import Modelo.RecibirMensajes;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
//import javax.json.Json;
//import javax.json.JsonObject;
//import javax.json.JsonWriter;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Andres
 */
@ServerEndpoint("/salaChat")
public class socketsala {
    /////// INICIALISAMOS LA SALA PARA RECIVIR CLIENTES ////////////
    static Set<Session> chatroomUsers = Collections.synchronizedSet(new HashSet<Session>());
    static RecibirMensajes objMensajes = new RecibirMensajes();
    
    /////// METODO PARA AGREGAR A LOS CLIENTES A LA SALA ////////////
    @OnOpen
    public void onOpen(Session UserSession) {
        
        System.out.println("ON OPEN   " + UserSession);
        chatroomUsers.add(UserSession); 
        
    }

    /////// METODO PARA CERRAR LA CONEXION DE LA SALA //////////////////
    @OnClose
    public void onClose(Session UserSession) {
        
        chatroomUsers.remove(UserSession);
        
    }

    /////7 METODO PARA CUANDO RECIBIMOS UN MENSAJE //////////////////////
    @OnMessage
    public void onMessage(String mensaje, Session UserSession) throws IOException {
        System.out.println("ON MESSAGE   " +mensaje +"           "+ UserSession);
        String userName = (String) UserSession.getUserProperties().get("username");
        
        
        String[] accion = mensaje.split("/");
        
        switch (accion[0]){
        
            case "usuario":
                
                System.out.println("CONECTANDO AL USUARIO");
               
                
                UserSession.getUserProperties().put("username", accion[1]);
                List<Mensaje>ListaMensajes = objMensajes.listarMensajes(accion[1]);
                String json = new Gson().toJson(ListaMensajes);
                UserSession.getBasicRemote().sendText(json);
                /*for(Mensaje mensajee : ListaMensajes){
                
                    System.out.println(mensajee.getContenido());
                    String json = new Gson().toJson(ListaMensajes);
                    UserSession.getBasicRemote().sendText(json);
                    //UserSession.getBasicRemote().sendText(hacerJSON("System", mensajee.getContenido()+"~"+mensajee.getFecha()));
                
                }*/
                
                
            break;
            
            case "mensaje":
                
                System.out.println("Mirando los mensajes");
                Iterator<Session> iterador = chatroomUsers.iterator();
                /////// ITERADOR PARA RETORNAR LOS MENSAJES A LOS CLIENTES CONECTADOS //////////77
                Iterator<Session> iteradorMSJ = chatroomUsers.iterator();
                
                String []campos = accion[1].split("~");
                int soloUnMensaje = 0;
                while(iterador.hasNext()){
                    
                    String equipoo = (String)iterador.next().getUserProperties().get("username");
                    
                    System.out.println(equipoo);
                    if (equipoo.equals(campos[2])) {
                        System.out.println("SE DEBE ACTUALIZAR LOS MENSAJES.");
                        
                        if (soloUnMensaje == 0) {
                            
                            objMensajes.ingresarMensaje(accion[1]);
                        
                        }
                        soloUnMensaje++;
                        
                        List<Mensaje>ListaUltimoMensaje = objMensajes.ListarUltimoMensaje(accion[1]);
                        String jsonUltimo = new Gson().toJson(ListaUltimoMensaje);
                        iteradorMSJ.next().getBasicRemote().sendText(jsonUltimo);
                        
                    }else{
                        String equipo = (String)iteradorMSJ.next().getUserProperties().get("username");
                    }
                }
                
            break;
        }
        
        /*if (userName == null) {
            System.out.println("CONECTANDO AL USUARIO");
            UserSession.getUserProperties().put("username", mensaje);
            UserSession.getBasicRemote().sendText(hacerJSON("System","Estas conectado con el nickname: "+mensaje));
            
        }else{
            System.out.println("Mirando los mensajes");
            Iterator<Session> iterador = chatroomUsers.iterator();
            while (iterador.hasNext()) iterador.next().getBasicRemote().sendText(hacerJSON(userName, mensaje));
        }*/
        
    }
    ///// MMETODO PARA CONVERTIR LOS DATOS EN UN FORMATO JSON ////////////7
    /*private String hacerJSON(String UserName, String Mensaje){
    
        System.out.println("CONVIRTIENDO JSON............");
        
        JsonObject jsonObject = Json.createObjectBuilder().add("messaje", UserName+": "+Mensaje).build();
        
        StringWriter stringWriter = new StringWriter();
        
        try(JsonWriter jsonWriter = Json.createWriter(stringWriter)){
        
            jsonWriter.write(jsonObject);
        
        }
        
        return stringWriter.toString();
    }*/
    
    ///// METODO EN CASO DE ERROR O EXSEPCION ///////////////////
    @OnError
    public void onError(Throwable t) {
        
        System.err.println(t);
        
    }
}

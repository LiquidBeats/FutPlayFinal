<%@page import="Modelo.Persona"%>
<%@page import="Modelo.Jugador"%>
<%

    Jugador objJugadorVisto = (Jugador) request.getSession().getAttribute("JugadorVisto");
    Persona objPersonaVisto = (Persona) request.getSession().getAttribute("UsuarioVisto");
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FutPlay - Perfil del jugador</title>
        <%@include file="../includes/importsCSS.jsp" %>
    </head>
    <body>
        <div class="wrapper">
            <%@include file="../includes/notificaciones.jsp" %>
            <%@include file="../includes/sidebarJugador.jsp" %>
            <div class="main-panel">
                <%@include file="../includes/header.jsp" %>
                <div class="content">
                    <div class="container-fluid">
                        <div class="col-md-8 col-md-offset-2">
                            <div class="card card-profile">
                                <div class="card-avatar">
                                    <a href="#pablo">
                                        <img class="img" src="../../assets/img/avatares/<%=objPersonaVisto.getAvatar()%>">
                                    </a>
                                </div>
                                <div class="card-content">
                                    <h6 class="category text-gray"><%=objJugadorVisto.getPosicion()%></h6>
                                    <h4 class="card-title"><%=objJugadorVisto.getAlias()%></h4>
                                    <p class="description"><%=objJugadorVisto.getDescripcion()%></p>
                                    <%
                                        int likes = 0;
                                        int dislike = 0;
                                        double rankingUsuariosFinal=0;
                                        int visto = 0;
                                        
                                        System.out.println("''''''''''''''''''''''''''''''...");
                                        System.out.println("PTA MIERDA  "+objJugadorVisto.getRankingUsers());
                                        if (!"".equals(objJugadorVisto.getRankingUsers())) {
                                            
                                            String bd = objJugadorVisto.getRankingUsers();
                                            String calificado [] = bd.split("/");
                                            
                                            for (int i = 0; i < calificado.length; i++) {
                                                
                                                String[] ranking = calificado[i].split("~");
                                                System.out.println("ESTADO DEL LA CALIFICACION -> " + ranking[1]);
                                                if (ranking[1].equals("1")) {

                                                    likes++;

                                                }else if (ranking[1].equals("0")) {

                                                    dislike++;
                                                }
                                                
                                                ///////// VERIFICAMOS SI EL USUARIO EN SESION YA LE DIO LIKE ////
                                                if (ranking[0].equals(String.valueOf(objJugador.getIdJugador())) & ranking[1].equals("1")) {
                                                    
                                                    System.out.println("YA LO CALIFICO EL USUARIO EN SESION");
                                                    visto=1;
                                                        
                                                }else if(ranking[0].equals(String.valueOf(objJugador.getIdJugador())) & ranking[1].equals("0")){
                                                    visto=2;   
                                                }
                                            }
                                        }
                                        System.out.println("VER JUGADOR JSP -------> NUMERO DE LIKES -> " + likes);
                                        /////////// COMPLETAR LAS CONDICIONES PARA EL RATING ///////
                                        if (likes > 0 & likes <= 5 & dislike > 0 & dislike <= 5) {

                                            rankingUsuariosFinal=20;

                                        }else if (likes > 5 & likes <= 10 & dislike <=5) {
                                            rankingUsuariosFinal=25;
                                        }
                                        System.out.println("VALOR DEL SISTEMA -> "+objJugadorVisto);
                                        double rankingFinal = (objJugadorVisto.getRankingSystem() + rankingUsuariosFinal) / 2;
                                        if (rankingFinal >0 & rankingFinal <= 20) {%>
                                        
                                            <i class="material-icons" style="font-size: 30px; color: #d8bb21">stars</i>
                                            <i class="material-icons" style="font-size: 30px; color: #999999">stars</i>
                                            <i class="material-icons" style="font-size: 30px; color: #999999">stars</i>
                                            <i class="material-icons" style="font-size: 30px; color: #999999">stars</i>
                                            <i class="material-icons" style="font-size: 30px; color: #999999">stars</i><br>
                                        
                                        <%}else if(rankingFinal > 20 & rankingFinal <=40){%>
                                            <i class="material-icons" style="font-size: 30px; color: #d8bb21">stars</i>
                                            <i class="material-icons" style="font-size: 30px; color: #d8bb21">stars</i>
                                            <i class="material-icons" style="font-size: 30px; color: #999999">stars</i>
                                            <i class="material-icons" style="font-size: 30px; color: #999999">stars</i>
                                            <i class="material-icons" style="font-size: 30px; color: #999999">stars</i><br>
                                        <%}else if(rankingFinal > 40 & rankingFinal <= 60){%>
                                            <i class="material-icons" style="font-size: 30px; color: #d8bb21">stars</i>
                                            <i class="material-icons" style="font-size: 30px; color: #d8bb21">stars</i>
                                            <i class="material-icons" style="font-size: 30px; color: #d8bb21">stars</i>
                                            <i class="material-icons" style="font-size: 30px; color: #999999">stars</i>
                                            <i class="material-icons" style="font-size: 30px; color: #999999">stars</i><br>
                                        <%}else if(rankingFinal > 60 & rankingFinal <= 80){%>
                                            <i class="material-icons" style="font-size: 30px; color: #d8bb21">stars</i>
                                            <i class="material-icons" style="font-size: 30px; color: #d8bb21">stars</i>
                                            <i class="material-icons" style="font-size: 30px; color: #d8bb21">stars</i>
                                            <i class="material-icons" style="font-size: 30px; color: #d8bb21">stars</i>
                                            <i class="material-icons" style="font-size: 30px; color: #999999">stars</i><br>
                                        <%}else if(rankingFinal > 80 & rankingFinal <= 100){%>
                                            <i class="material-icons" style="font-size: 30px; color: #d8bb21">stars</i>
                                            <i class="material-icons" style="font-size: 30px; color: #d8bb21">stars</i>
                                            <i class="material-icons" style="font-size: 30px; color: #d8bb21">stars</i>
                                            <i class="material-icons" style="font-size: 30px; color: #d8bb21">stars</i>
                                            <i class="material-icons" style="font-size: 30px; color: #d8bb21">stars</i><br>
                                        <%}%>
                                        <div class="row">
                                            <div class="col-lg-12">
                                                <div class="col-md-2 col-md-offset-2" style="margin-top: 25px; margin-right: 40px;">
                                                    <button class="dropdown-toggle btn btn-simple likeJugador" data-toggle="dropdown" rel="tooltip" data-placement="bottom" data-original-title="Like">
                                                        <%if (visto == 1) {%>
                                                            <i class="material-icons" style="font-size: 50px; color: #00abc0;">thumb_up</i>
                                                        <%}else{%>
                                                            <i class="material-icons" style="font-size: 50px; color: #999999;">thumb_up</i>
                                                        <%}%>
                                                    </button>
                                                </div>
                                                <div class="col-md-2" class="dropdown-toggle" data-toggle="dropdown" rel="tooltip" data-placement="bottom" data-original-title="Nivel futnolistico">
                                                    <div style="background-color: #00bbff;width: 100px;height: 100px; color: white; border-radius: 50%;">
                                                        <h2 class="text-center" style="padding-top: 24px;">
                                                            <%=rankingFinal%>
                                                        </h2>
                                                    </div>
                                                </div>
                                                <div class="col-md-3" style="margin-top: 25px;">
                                                    <button class="dropdown-toggle btn btn-simple dislikeJugador" data-toggle="dropdown" rel="tooltip" data-placement="bottom" data-original-title="Dislike">
                                                        <%if (visto == 2) {%>
                                                            <i class="material-icons" style="font-size: 50px; color: #00abc0;">thumb_down</i>
                                                        <%}else{%>
                                                            <i class="material-icons" style="font-size: 50px; color: #999999;">thumb_down</i>
                                                        <%}%>
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                        <!--<a href="#pablo" class="btn btn-rose btn-round">Follow</a>-->
                                </div><br>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../includes/importsJS.jsp" %>
        <script>
            $("#nombrepagina").text("Perfil de <%=objJugadorVisto.getAlias()%>");
            window.onload = function (){
                
                CargarNotificaciones();
                
            }
        </script>
    </body>
</html>

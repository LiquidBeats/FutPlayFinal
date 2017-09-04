<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FurPlay - Charla Tecnica</title>
        <%@include file="../includes/importsCSS.jsp" %>
    </head>
    <body>
        <div class="wrapper">
            <%@include file="../includes/notificaciones.jsp" %>
            <%@include file="../includes/sidebarJugador.jsp" %>
            <div class="main-panel">
                <%@include file="../includes/header.jsp" %>
                <div class="content">
                    <div class="container-fluid" id="containercharla">
                        <%if (objJugador.getEquipo().toString().equals("1")) {%>
                        <div class="col-md-8 col-md-offset-2">
                            <div class='card card-profile'>
                                <div class='card-header card-header-icon' data-background-color='rose'>
                                    <i class="material-icons">speaker_notes_off</i>
                                </div>
                                <div class="card-content">
                                    <div class="clearfix"></div>
                                    <h6 class="category text-gray">¿No tienes mensajes?</h6>
                                    <h4 class="card-title">FutPlay te informa</h4>
                                    <p class="description">
                                        Hola, por el momento no haces parte de un equipo. Nos gustaria que crearass tu propio equipo con el que podras competir en los torneo, on en su defecto pidele a un amigo que te agregue su equipo :).
                                    </p>
                                    <a href="/FutPlayFinal/material-dashboard/pages/equipo/verEquipo.jsp" class="btn btn-rose btn-round">Ir a crear equipo</a>
                                </div>
                            </div>
                        </div>
                        <p id="sinMSJ" style="display: none">no</p>
                        <%}else{%>
                        <div class="card">
                            <div class="card-header card-header-icon" data-background-color="rose">
                                <i class="material-icons">message</i>
                            </div>
                            <div class="card-content">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="card card-plain">
                                            <div class="card-content" id="mensajesContainer" style="height: 300px;overflow-y: auto;background-color: #e7e6e6;">
                                                <ul class="timeline" id="mensajes">
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--<textarea id="mensajesArea" readonly="readonly" rows="10" cols="45"></textarea><br>-->
                            <div class="col-md-12">
                                <div class="row">
                                    <div class="col-md-10 col-lg-offset-1">
                                        <div class="form-group">
                                            <label>Escribe un mensaje</label>
                                            <div class="form-group label-floating is-empty">
                                                <textarea class="form-control" rows="3" id="txtContenidoMensaje"></textarea>
                                            <span class="material-input"></span></div>
                                        </div>
                                        <button class="btn btn-rose pull-right" onclick="enviarMensaje()">Enviar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%}%>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../includes/importsJS.jsp" %>
        <script>
            $("#charla").addClass('active');
            $("#nombrepagina").text("Charla tecnica");
           
            var contenido;
            var mensaje;
           
            if($("#sinMSJ").text() == "no"){
                
                $.notify({
                    icon: "speaker_notes_off",
                    message: "Tus mensaje apareceran cuando hagas parte de un equipo."

                },{
                    type: 'warning',
                    timer: 2500,
                    placement: {
                        from: 'bottom',
                        align: 'right'
                    }
                });
                
            }else{
                
                var websocket = new WebSocket("ws://localhost:8080/FutPlayFinal/salaChat");
                websocket.onmessage = function (message){
                    //console.log(message.data);
                    var jsonData = JSON.parse(message.data);
                    //console.log(jsonData);
                    $("#mensajes").html("");
                    
                    if(jsonData.length == 0){
                        
                        $.notify({
                            icon: "speaker_notes_off",
                            message: "Por el momento no tienes mensajes en tu bandeja de entrada."

                        },{
                            type: 'danger',
                            timer: 2500,
                            placement: {
                                from: 'bottom',
                                align: 'right'
                            }
                        });
                        $("#mensajes").html("<li>"
                                                + "<div class='timeline-badge danger'>"
                                                    + "<i class='material-icons'>speaker_notes_off</i>"
                                                + "</div>"
                                                + "<div class='timeline-panel'>"
                                                    + "<div class='timeline-heading'>"
                                                        + "<span class='label label-danger'>FutPlay</span>"
                                                    + "</div>"
                                                    + "<div class='timeline-body'>"
                                                        + "<p>Por el momento no tienes mensajes en tu bandeja de entrada.</p>"
                                                    + "</div>"
                                                    + "<small class='category text-gray'>"
                                                        + "<i class='ti-time'></i> Justo ahora"
                                                    + "</small>"
                                                + "</div>"
                                            +"</li>");
                    }else{
                        
                        for (var i = 0; i < jsonData.length; i++) {
                        //mensajesArea.value += jsonData[i].Contenido + "\n";

                        var tipo="";
                        var remitente="";
                        var icono="";
                        var color = "";
                        if (jsonData[i].Jugador.idJugador == <%=objJugador.getIdJugador()%>) {

                            tipo = "<li class='timeline-inverted'>";
                            remitente = "Tú";
                            icono = "person";
                            color = "info";
                        }else{

                            tipo = "<li>";
                            remitente = jsonData[i].Jugador.Alias;
                            icono = "people";
                            color="warning";
                        }

                        $("#mensajes").append(tipo
                                                + "<div class='timeline-badge "+color+"'>"
                                                    + "<i class='material-icons'>"+icono+"</i>"
                                                + "</div>"
                                                + "<div class='timeline-panel'>"
                                                    + "<div class='timeline-heading'>"
                                                        + "<span class='label label-"+color+"'>"+remitente+"</span>"
                                                    + "</div>"
                                                    + "<div class='timeline-body'>"
                                                        + "<p>"+jsonData[i].Contenido+"</p>"
                                                    + "</div>"
                                                    + "<small class='category text-gray'>"
                                                        + "<i class='ti-time'></i> "+jsonData[i].Fecha
                                                    + "</small>"
                                                + "</div>"
                                            +"</li>");
                        }
                        var div_msg = document.getElementById('mensajesContainer');
                        div_msg.scrollTop = div_msg.scrollHeight;
                        
                    }
                    
                };
                
            }
            
            function enviarMensaje(){
                //alert("enviando mensaje...");
                websocket.send("mensaje/"+txtContenidoMensaje.value+"~<%=objJugador.getIdJugador()%>~<%=objJugador.getEquipo()%>");
                txtContenidoMensaje.value = "";
                //alert("mensaje enviado");
            }
            
            window.onload = function (){
                
                //alert("Iniciando la sala...");
                websocket.send("usuario/"+<%=objJugador.getEquipo()%>);
                //alert("Sala iniciada.");
                
                CargarNotificaciones();
            };
            
        </script>
    </body>
</html>

<%@page import="Modelo.Campos"%>
<%@page import="Controlador.campos"%>
<%@page import="Modelo.Equipo"%>
<%@page import="java.util.List"%>
<%@page import="Controlador.equipo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FutPlay - Ingresar Encuentro</title>
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
                        <%if (objJugador.getEquipo().toString().equals("1")) {%>
                        <div class="col-md-8 col-md-offset-2">
                            <div class='card card-profile'>
                                <div class='card-header card-header-icon' data-background-color='rose'>
                                    <i class="material-icons">speaker_notes_off</i>
                                </div>
                                <div class="card-content">
                                    <div class="clearfix"></div>
                                    <h6 class="category text-gray">¿No tienes encuentros?</h6>
                                    <h4 class="card-title">FutPlay te informa</h4>
                                    <p class="description">
                                        Hola, por el momento no haces parte de un equipo. Nos gustaria que crearass tu propio equipo con el que podras competir en los torneo, on en su defecto pidele a un amigo que te agregue su equipo :).
                                    </p>
                                    <a href="/FutPlayFinal/material-dashboard/pages/equipo/verEquipo.jsp" class="btn btn-rose btn-round">Ir a crear equipo</a>
                                </div>
                            </div>
                        </div>
                        <p id="noEncuentros">no</p>
                        <%}else{%>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="card card-product">
                                        <div class="card-image" data-header-animation="true">
                                            <img src="/FutPlayFinal/material-dashboard/assets/img/jugadorimg/Pirlo-redimensionado.jpg" class="responsive-img">
                                            <!--<span class="card-title">Los mejores campos</span>-->
                                            <div class="ripple-container"></div>
                                        </div>
                                        <div class="card-content">
                                            <div class="card-actions">
                                                <a class="btn btn-danger btn-simple fix-broken-card" rel="tooltip" data-placement="bottom" title="" data-original-title="Ver de nuevo">
                                                    <i class="material-icons" style="font-size: 25px;">replay</i>
                                                    <div class="ripple-container"></div>
                                                </a>
                                                <a href="../encuentro/registroEncuentro.jsp" class="btn btn-default btn-simple btn-success" rel="tooltip" data-placement="bottom" title="" data-original-title="Ver jugadores">
                                                    <i class="material-icons" style="font-size: 25px;">remove_red_eye</i>
                                                    <div class="ripple-container"></div>
                                                </a>

                                            </div>
                                            <div class="card-title">
                                                <span>Encuentros realizados</span>
                                            </div>
                                            <div class="card-description">
                                                <p>Colocar en la descripcion los encuentros realizados y cambiar la imagen.</p>
                                            </div>
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
            $("#encuentro").addClass('active');
            CargarNotificaciones();
            
            if($("#noEncuentros").text() == "no"){
                
                $.notify({
                    icon: "perm_identity",
                    message: "Podras administrar tus encuentros cuando hagas parte de un equipo."

                },{
                    type: 'warning',
                    timer: 2500,
                    placement: {
                        from: 'bottom',
                        align: 'right'
                    }
                });
            }
            
        </script>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FutPlay - Inicio</title>
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
                                            <a href="#" class="btn btn-default btn-simple btn-success" rel="tooltip" data-placement="bottom" title="" data-original-title="Ver jugadores">
                                                <i class="material-icons" style="font-size: 25px;">remove_red_eye</i>
                                                <div class="ripple-container"></div>
                                            </a>
                                            
                                        </div>
                                        <div class="card-title">
                                            <span>Jugadores destacados</span>
                                        </div>
                                        <div class="card-description">
                                            <p>En FutPlay nos gusta que compitas con los mejores por eso hemos destacado a los mejores jugadores para que los mires y te sorprendas del nivel funbolistico que tenemos aquí.</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="card card-product">
                                    <div class="card-image" data-header-animation="true">
                                        <img src="../../../GaiaTemplate/assets/img/soccer-wallpaper-hd-18.jpg" class="responsive-img">
                                        <div class="ripple-container"></div>
                                    </div>
                                    <div class="card-content">
                                        <div class="card-actions">
                                            <a class="btn btn-danger btn-simple fix-broken-card" rel="tooltip" data-placement="bottom" title="" data-original-title="Ver de nuevo">
                                                <i class="material-icons" style="font-size: 25px;">replay</i>
                                                <div class="ripple-container"></div>
                                            </a>
                                            <a href="#" class="btn btn-default btn-simple btn-success" rel="tooltip" data-placement="bottom" title="" data-original-title="Ver equipos">
                                                <i class="material-icons" style="font-size: 25px;">remove_red_eye</i>
                                                <div class="ripple-container"></div>
                                            </a>
                                            
                                        </div>
                                        <div class="card-title">
                                            <span>Equipos sobresalientes</span>
                                        </div>
                                        <div class="card-description">
                                            <p>En FutPlay nos gusta que compitas con los mejores por eso hemos destacado a los mejores jugadores para que los mires y te sorprendas del nivel funbolistico que tenemos aquí.</p>
                                            <br>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="card card-product">
                                    <div class="card-image" data-header-animation="true">
                                        <img src="../../assets/img/jugadorimg/campofooter-iloveimg-cropped (1).jpg" class="responsive-img">
                                        <div class="ripple-container"></div>
                                    </div>
                                    <div class="card-content">
                                        <div class="card-actions">
                                            <a class="btn btn-danger btn-simple fix-broken-card" rel="tooltip" data-placement="bottom" title="" data-original-title="Ver de nuevo">
                                                <i class="material-icons" style="font-size: 25px;">replay</i>
                                                <div class="ripple-container"></div>
                                            </a>
                                            <a href="#" class="btn btn-default btn-simple btn-success" rel="tooltip" data-placement="bottom" title="" data-original-title="Ver campos">
                                                <i class="material-icons" style="font-size: 25px;">remove_red_eye</i>
                                                <div class="ripple-container"></div>
                                            </a>
                                            
                                        </div>
                                        <div class="card-title">
                                            <span>Los mejores campos</span>
                                        </div>
                                        <div class="card-description">
                                            <p>En FutPlay nos gusta que compitas con los mejores por eso hemos destacado a los mejores jugadores para que los mires y te sorprendas del nivel funbolistico que tenemos aquí.</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../includes/importsJS.jsp" %>
        <script>
            $("#iniciojugador").addClass('active');
            CargarNotificaciones();
        </script>
    </body>
</html>

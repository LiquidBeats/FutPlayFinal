<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FutPlay - Jugadores</title>
        <%@include file="../includes/importsCSS.jsp" %>
    </head>
    <body>
        <div class="wrapper">
            <%@include file="../includes/notificaciones.jsp" %>
            <%@include file="../includes/sidebarJugador.jsp" %>
            <div class="main-panel">
                <%@include file="../includes/header.jsp" %>
                <div class="content">
                    <div class="container-fluid" id="contenedorJugadores">
                        <!--<div class="row">
                            <div class="col-md-12">
                                <div class="card card-product">
                                    <div class="card-image" data-header-animation="true">
                                        <img src="../../assets/img/jugadorimg/messi.png" class="responsive-img">
                                        <span class="card-title">Jugadores</span>
                                        <div class="ripple-container"></div>
                                    </div>
                                    <div class="card-content">
                                        <div class="card-actions">
                                            <a class="btn btn-danger btn-simple fix-broken-card" rel="tooltip" data-placement="bottom" title="" data-original-title="Ver de nuevo">
                                                <i class="material-icons" style="font-size:30px;">replay</i>
                                                <div class="ripple-container"></div>
                                            </a>
                                            <a href="#" data-toggle="modal" data-target="#noticeModal" class="btn btn-info btn-simple" rel="tooltip" data-placement="bottom" title="" data-original-title="Agregar nuevo jugador">
                                                <i class="material-icons" style="font-size:30px;">add_circle</i>
                                                <div class="ripple-container"></div>
                                            </a>
                                            
                                        </div>
                                        <div class="card-title">
                                            <span>Jugadores</span>
                                        </div>
                                        <div class="card-description" id="JugadoresVer">
                                            
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>-->
                    </div>
                </div>
            </div>
        </div>
        <!-- MODAL PARA AGREGAR UN JUGADOR -->
        <div class="modal fade" id="noticeModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
            <div class="modal-dialog modal-notice">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><i class="material-icons">clear</i></button>
                        <h5 class="modal-title" id="myModalLabel">Fichar jugador</h5>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-10 col-md-offset-1">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label">Alias</label>
                                    <input type="text" class="form-control buscarJugador" id="txtBuscarJugador">
                                    <span class="help-block">Ingresa el alias del jugador</span>
                                    <span class="material-input"></span><br><br>
                                </div>
                                <div id="busquedaContainer" style="max-height: 300px;overflow-y: scroll;">
                                    <!--<div class="col-md-4">
                                        <div class="card card-pricing card-raised">
                                            <div class="content">
                                                <h6>Nombre del jugador</h6>
                                                <div class="icon">
                                                    <img src="../../assets/img/avatares/av.jpg">
                                                </div>
                                                <a href="#" class="">Fichar</a>
                                            </div>
                                        </div>
                                    </div>-->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../includes/importsJS.jsp" %>
        <script>
            $("#jugadores").addClass('active');
            $("#nombrepagina").text("Jugadores");
            window.onload = function (){
              
                JugadoresVer();
                CargarNotificaciones();
            };
        </script>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FutPlay - Mi equipo</title>
        <%@include file="../includes/importsCSS.jsp" %>
    </head>
    <body>
        <div class="wrapper">
            <%@include file="../includes/notificaciones.jsp" %>
            <%@include file="../includes/sidebarJugador.jsp" %>
            <div class="main-panel">
                <%@include file="../includes/header.jsp" %>
                <div class="content">
                    <div class="container-fluid" id="contenedorEquipo">
                        <!--<div class="col-md-8 col-md-offset-2">
                            <div class="card card-profile">
                                <div class="card-header card-header-icon" data-background-color="rose">
                                    <i class="material-icons">perm_identity</i>
                                </div>
                                <div class="card-content">
                                    <div class="clearfix"></div>
                                    <h6 class="category text-gray" style="">FutPlay te informa</h6>
                                    <h4 class="card-title">Alec Thompson</h4>
                                    <p class="description">
                                        Hola <%=objJugador.getAlias()%>, por el momento no haces parte de un equipo. Nos gustaria que crearass tu propio equipo con el que podras competir en los torneo, on en su defecto pidele a un amigo que te agregue su equipo :).
                                    </p>
                                    <button class="btn btn-rose btn-round" data-toggle="modal" data-target="#noticeModal">Crear equipo</button>
                                </div>
                            </div>
                        </div>-->
                       <!--<div class="row">
                            <div class="col-md-12">
                                <div class="card card-product">
                                    <div class="card-image" data-header-animation="true">
                                        <img src="../../assets/img/jugadorimg/brasilteam.png" class="responsive-img">
                                        <span class="card-title" id="nombreEquipo"></span>
                                        <div class="ripple-container"></div>
                                    </div>
                                    <div class="card-content">
                                        <div class="card-title">
                                            <span>Jugadores</span>
                                        </div>
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
                                        <div class="card-description">
                                            <div class="col-md-12" id="jugadoesEquipo">
                                            
                                            </div>
                                        </div>
                                        <div class="card-footer pull-right">
                                            <div class="text-center">
                                                <button type="submit" class="btn btn-rose btn-fill btn-wd">Agregar jugador</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>-->
                    </div>
                </div>
            </div>
        </div>
        <!-- MODAL PARA CREAR UN NUEVO EQUIPO -->
        <div class="modal fade" id="noticeModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
            <div class="modal-dialog modal-notice">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><i class="material-icons">clear</i></button>
                        <h5 class="modal-title" id="myModalLabel">Crea tu equipo</h5>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-10 col-md-offset-1">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label">Nombre</label>
                                    <input type="text" class="form-control" id="txtNombreEquipo">
                                    <span class="help-block">Ingresa el nombre de tu equipo</span>
                                    <span class="material-input"></span>
                                </div>
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label">Ciudad</label>
                                    <input type="text" class="form-control" id="txtCiudadEquipo">
                                    <span class="help-block">Ingresa la ciudad en la que se encuetra ubicado tu equipo</span>
                                    <span class="material-input"></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer text-center">
                        <button class="btn btn-rose btn-round crearEquipo">Crear equipo</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- MODAL PARA EDITAR EL EQUIPO -->
        <div class="modal fade" id="editarEquipo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
            <div class="modal-dialog modal-notice">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><i class="material-icons">clear</i></button>
                        <h5 class="modal-title" id="myModalLabel">Editar equipo</h5>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <!-- CAMPO PARA DEFINIR EL ID DEL EQUIPO -->
                            <p id="lblIdEquipo" style="display: none;"></p>
                            <!-- FINAL -->
                            <div class="col-md-10 col-md-offset-1">
                                <div class="form-group is-empty">
                                    <label class="control-label">Nombre</label>
                                    <input type="text" class="form-control" id="txtNombreEditarEquipo">
                                    <span class="help-block">Ingresa el nombre de tu equipo</span>
                                    <span class="material-input"></span>
                                </div>
                                <div class="form-group is-empty">
                                    <label class="control-label">Ciudad</label>
                                    <input type="text" class="form-control" id="txtCiudadEditarEquipo">
                                    <span class="help-block">Ingresa la ciudad en la que se encuetra ubicado tu equipo</span>
                                    <span class="material-input"></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer text-center">
                        <button class="btn btn-rose btn-round editarEquipo">Editar</button>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../includes/importsJS.jsp" %>
        <script>
            $("#equipo").addClass('active');
            $("#nombrepagina").text("Mi equipo");
            window.onload = function (){
                verEquipo();
                CargarNotificaciones();
            };
        </script>
    </body>
</html>

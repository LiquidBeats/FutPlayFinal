<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FutPlay - Editar perfil</title>
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
                        <div class="col-md-10 col-md-offset-1">
                            <div class="card">
                                <div class="card-header card-header-icon" data-background-color="rose">
                                    <i class="material-icons">perm_identity</i>
                                </div>
                                <div class="card-content">
                                    <h4 class="card-title">Editar perfil -
                                        <small class="category">Complete su perfil</small>
                                    </h4>
                                    <form>
                                        <div class="col-sm-4 col-sm-offset-1">
                                            <div class="picture-container">
                                                <div class="picture">
                                                    <img src="../../assets/img/avatares/av.jpg" class="picture-src" id="wizardPicturePreview" title="">
                                                    <input type="file" id="avatarJugador">
                                                    <input type="text" hidden id="avatarJugadorNombre">
                                                </div>
                                                <h6>Selecciona tu avatar</h6>
                                            </div>
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label class="control-label active">Alias</label>
                                                        <input type="text" value="<%=objJugador.getAlias()%>" class="form-control" id="txtAliasEditarJugador">
                                                    <span class="material-input"></span></div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label class="control-label">Posicion</label>
                                                        <select class="form-control" id="cmbPosicionEditarJugador">
                                                            <%if (objJugador.getPosicion().equals("Portero")) {%>
                                                                <option value="Portero">Portero</option>
                                                                <option value="Defensor">Defensa</option>
                                                                <option value="Mediocampista">Mediocampista</option>
                                                                <option value="Delantero">Delantero</option>
                                                            <%}else if(objJugador.getPosicion().equals("Defensor")) {%>
                                                                <option value="Defensor">Defensa</option>
                                                                <option value="Portero">Portero</option>
                                                                <option value="Mediocampista">Mediocampista</option>
                                                                <option value="Delantero">Delantero</option>
                                                            <%}else if (objJugador.getPosicion().equals("Mediocampista")){%>

                                                                <option value="Mediocampista">Mediocampista</option>
                                                                <option value="Defensor">Defensa</option>
                                                                <option value="Portero">Portero</option>
                                                                <option value="Delantero">Delantero</option>
                                                            <%}else if (objJugador.getPosicion().equals("Delantero")) {%>

                                                                <option value="Delantero">Delantero</option>
                                                                <option value="Mediocampista">Mediocampista</option>
                                                                <option value="Defensor">Defensa</option>
                                                                <option value="Portero">Portero</option>
                                                            <%}%>

                                                        </select>
                                                    <span class="material-input"></span></div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label class="control-label">Pierna hábil</label>
                                                        <select class="form-control" id="cmbPiernaEditarJugador">
                                                            <%if(objJugador.getPierna().equals("Derecha")){%>
                                                                <option value="Derecha">Derecha</option>
                                                                <option value="Izquierda">Izquierda</option>
                                                                <option value="Ambas">Ambas</option>
                                                            <%}else if(objJugador.getPierna().equals("Izquierda")){%>
                                                                <option value="Izquierda">Izquierda</option>
                                                                <option value="Derecha">Derecha</option>
                                                                <option value="Ambas">Ambas</option>
                                                            <%}else if(objJugador.getPierna().equals("Ambas")){%>
                                                                <option value="Ambas">Ambas</option>
                                                                <option value="Derecha">Derecha</option>
                                                                <option value="Izquierda">Izquierda</option>
                                                            <%}%>
                                                        </select>
                                                    <span class="material-input"></span></div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label class="control-label">Descripcion</label>
                                                        <textarea class="form-control" id="txtDescripcionEditarJugador"><%=objJugador.getDescripcion()%></textarea>
                                                    <span class="material-input"></span></div>
                                                </div>
                                            </div>
                                            <button type="submit" class="btn btn-rose pull-right editarJugador">Actualizar Perfil</button>
                                            <div class="clearfix"></div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../includes/importsJS.jsp" %>
        <script>
            $("#nombrepagina").text("Editar perfil");
            window.onload = function (){
                
                CargarNotificaciones();
                
            }
        </script>
    </body>
</html>

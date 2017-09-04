<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FutPlay</title>
        <%@include file="../includes/importsCSS.jsp"%>
    </head>
    <body>
        <div class="wrapper">
            <%@include file="../includes/sidebarPropietario.jsp"%>
            <div class="main-panel">
                <%@include file="../includes/headerPropietario.jsp"%>
                <div class="content">
                    <div class="container-fluid">
                        <div class="col-md-10 col-md-offset-1">
                            <div class="card">
                                <div class="card-header card-header-icon" data-background-color="red">
                                    <i class="material-icons">perm_identity</i>
                                </div>
                                <div class="card-content">
                                    <h4 class="card-title">Editar perfil -
                                        <small class="category">Complete su perfil</small>
                                    </h4>
                                    <form method="post" id="frmEditarPropietario">   
                                        <input type="text" hidden="" id="idPropietarioUP" value="<%=objPropietario.getPersona().getIdPersona()%>">
                                        <input type="password" hidden="" id="passwordPropietarioUP" value="<%=objPropietario.getPersona().getContrasenia()%>">
                                        <div class="col-sm-4 col-sm-offset-1">
                                            <div class="picture-container">
                                                <div class="picture">
                                                    <img src="/FutPlayFinal/material-dashboard/assets/img/avatares/<%=objPropietario.getPersona().getAvatar()%>" class="picture-src" id="wizardPicturePreview" title="">
                                                    <input type="file" id="avatarPropietarioUP">
                                                    <input type="text" hidden id="avatarPropietarioNombreUP">
                                                </div>
                                                <h6>Selecciona tu avatar</h6>
                                                <small>(Opcional)</small>
                                            </div>
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="material-icons">face</i>
                                                </span>
                                                <div class="form-group label-floating is-empty">
                                                    <label class="label-control">Nombres 
                                                    </label>
                                                    <input name="nombresPropietarioUP" id="nombresPropietarioUP" type="text" class="form-control" value="<%=objPropietario.getPersona().getNombres()%>">
                                                <span class="material-input"></span></div>                                            
                                            </div>
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="material-icons">record_voice_over</i>
                                                </span>
                                                <div class="form-group label-floating is-empty">
                                                    <label class="label-control">Apellidos
                                                    </label>
                                                    <input name="apellidosPropietarioUP" id="apellidosPropietarioUP" type="text" class="form-control" value="<%=objPropietario.getPersona().getApellidos()%>">
                                                <span class="material-input"></span></div>
                                            </div>
                                        </div>
                                       
                                        <div class="col-lg-10 col-lg-offset-1">     
                                           <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="material-icons">today</i>
                                                </span>
                                                <div class="form-group label-floating is-empty">
                                                    <label class="label-control">Fecha nacimiento
                                                    </label>
                                                    <input name="fechanacimientoPropietarioUP" id="fechanacimientoPropietarioUP" type="text" class="form-control datepicker" value="<%=objPropietario.getPersona().getFecha_Nacimiento()%>">
                                                <span class="material-input"></span></div>

                                                <span class="input-group-addon">
                                                    <i class="material-icons">call</i>
                                                </span>
                                                <div class="form-group label-floating is-empty">
                                                    <label class="label-control">Telefono
                                                    </label>
                                                    <input name="telefonoPropietarioUP" id="telefonoPropietarioUP" type="text" class="form-control" value="<%=objPropietario.getPersona().getTelefono()%>">
                                                <span class="material-input"></span></div>
                                            </div>
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="material-icons">perm_identity</i>
                                                </span>
                                                <div class="form-group label-floating is-empty">
                                                    <label class="label-control">Genero
                                                    </label>
                                                    <select name="generoPropietarioUP" id="generoPropietarioUP" class="form-control">
                                                        <option disabled="" selected=""></option>
                                                        <option value="Masculino"> Masculino </option>
                                                        <option value="Femenino"> Femenino </option>
                                                    </select>
                                                <span class="material-input"></span></div>
                                            </div>
                                            <div class="form-group">
                                                <button type="submit" class="btn btn-danger pull-right">Actualizar Perfil</button>
                                            </div>
                                        </div>                           
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <style>
            .error{
                color:red;
                font-size:12px;
            }
        </style>
        <%@include file="../includes/importsJS.jsp"%>
        <script type="text/javascript">
            $("#nombrepagina").text("Editar perfil");
            $("#editarperfil").addClass("active");
        </script>
    </body>
</html>

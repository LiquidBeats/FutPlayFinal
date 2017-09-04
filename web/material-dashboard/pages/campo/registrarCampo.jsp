<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
    response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
    response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
    response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
    try{      
        if(session.getAttribute("UsuarioIngresado") == null || session.getAttribute("PropietarioIngresado") == null){
            response.sendRedirect("/FutPlayFinal/index.html");
        }     
    }  
    catch(Exception ex){
        response.sendRedirect("/FutPlayFinal/index.html");
    }
%>
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
                        <div class="row">
                            <div class="col-md-12">
                                <div class="card">
                                <form action="" method="post" id="frmRCampo" enctype="multipart/form-data">
                                    <div class="card-header card-header-icon" data-background-color="red">
                                        <i class="material-icons">aspect_ratio</i>
                                    </div>
                                    <div class="card-content">
                                        <h4 class="card-title">Registra tu campo</h4>
                                        <div class="col-sm-4 col-sm-offset-1">
                                            <div class="fileinput fileinput-new text-center" style="margin-top:22px;" data-provides="fileinput">
                                                <div class="fileinput-new thumbnail">
                                                    <img src="/FutPlayFinal/material-dashboard/assets/img/register.jpeg" alt="...">
                                                </div>
                                                <div class="fileinput-preview fileinput-exists thumbnail"></div>
                                                <div>
                                                    <span class="btn btn-danger btn-round btn-file">
                                                        <span class="fileinput-new">Seleccionar imagen</span>
                                                        <span class="fileinput-exists">Cambiar</span>
                                                        <input type="file" name="fotocampoupload" id="fotocampoupload"/>
                                                        <input type="text" hidden name="campoFotoNombre" id="campoFotoNombre"/>
                                                    </span>
                                                    <a href="#pablo" class="btn btn-danger btn-round fileinput-exists" data-dismiss="fileinput"><i class="fa fa-times"></i> Cancelar</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group label-floating">
                                                <label class="label-control">
                                                    Nombre del campo
                                                </label>
                                                <input class="form-control" type="text" name="nombrecampo" id="nombrecampo"/>
                                            </div>
                                            <div class="form-group label-floating">
                                                <label class="label-control">
                                                    Direccion del campo
                                                </label>
                                                <input class="form-control" type="text" id="direccioncampo" name="direccioncampo"/>
                                            </div>
                                        </div>
                                        <div class="col-lg-10 col-lg-offset-1">
                                            <div class="form-group label-floating">
                                                <label class="label-control">
                                                    Horario de atencion (Apertura)
                                                </label>
                                                <input class="form-control timepicker" type="text" name="horarioatencionabre" id="horarioatencionabre"/>
                                            </div>
                                            <div class="form-group label-floating">
                                                <label class="label-control">
                                                    Horario de atencion (Cierre)
                                                </label>
                                                <input class="form-control timepicker" type="text" name="horarioatencioncierre" id="horarioatencioncierre"/>
                                            </div>                        
                                            <div class="form-group">
                                                <div class="form-footer text-right">
                                                    <button type="submit" class="btn btn-danger btn-fill btnCampo">Registrar</button>
                                                </div>
                                            </div>
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
            $("#nombrepagina").text("Agregar campo");
            $("#campos").addClass("active");
        </script>
    </body>
</html>

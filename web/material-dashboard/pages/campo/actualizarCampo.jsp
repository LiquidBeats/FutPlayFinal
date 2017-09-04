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
                        <div class="row">
                            <div class="col-md-12">
                                <div class="card">
                                <form action="" method="post" id="frmRCampoUP" enctype="multipart/form-data">
                                    <div class="card-header card-header-icon" data-background-color="red">
                                        <i class="material-icons">aspect_ratio</i>
                                    </div>
                                    <div class="card-content">
                                        <h4 class="card-title">Registra tu campo</h4>
                                        <div class="col-sm-4 col-sm-offset-1">
                                            <div class="fileinput fileinput-new text-center" style="margin-top:22px;" data-provides="fileinput">
                                                <div class="fileinput-new thumbnail">
                                                    <img src="" id="imgCampoUP" alt="...">
                                                </div>
                                                <div class="fileinput-preview fileinput-exists thumbnail"></div>
                                                <div>
                                                    <span class="btn btn-info btn-round btn-file">
                                                        <span class="fileinput-new">Seleccionar imagen</span>
                                                        <span class="fileinput-exists">Cambiar</span>
                                                        <input type="file" name="fotocampouploadUP" id="fotocampouploadUP"/>
                                                        <input type="text" hidden name="campoFotoNombreUP" id="campoFotoNombreUP"/>
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
                                                <input class="form-control" type="text" name="nombrecampoUP" id="nombrecampoUP"/>
                                            </div>
                                            <div class="form-group label-floating">
                                                <label class="label-control">
                                                    Direccion del campo
                                                </label>
                                                <input class="form-control" type="text" id="direccioncampoUP" name="direccioncampoUP"/>
                                            </div>
                                        </div>
                                        <div class="col-lg-10 col-lg-offset-1">
                                            <div class="form-group label-floating">
                                                <label class="label-control">
                                                    Horario de atencion (Apertura)
                                                </label>
                                                <input class="form-control timepicker" type="text" name="horarioatencionabreUP" id="horarioatencionabreUP"/>
                                            </div>
                                            <div class="form-group label-floating">
                                                <label class="label-control">
                                                    Horario de atencion (Cierre)
                                                </label>
                                                <input class="form-control timepicker" type="text" name="horarioatencioncierreUP" id="horarioatencioncierreUP"/>
                                            </div>                        
                                            <div class="form-group">
                                                <div class="form-footer text-right">
                                                    <button type="submit" class="btn btn-danger btn-fill">Actualizar</button>
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
            var data = localStorage.getItem('JSONCampo');
            var dt = JSON.parse(data);
            var horariossplit = dt[2];
            var horarios = horariossplit.split("/");
            if (data !== undefined) {
                $("#nombrecampoUP").val(dt[0]);
                $("#direccioncampoUP").val(dt[1]);
                $("#horarioatencionabreUP").val(horarios[0]);
                $("#horarioatencioncierreUP").val(horarios[1]);
                $("#campoFotoNombreUP").val(dt[3]);
                $("#imgCampoUP").attr("src","/FutPlayFinal/Imagenes/"+dt[3]+"");
            }
        </script>
    </body>
</html>

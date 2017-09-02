<%@page import="Modelo.Canchas"%>
<%@page import="Modelo.Canchas"%>
<%@page import="Controlador.canchas"%>
<%@page import="java.util.List"%>
<%@page import="Controlador.campos"%>
<%@page import="Modelo.Campos"%>
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
                        <div id="external-events">
                            <%
                               campos cmp = new campos();
                               List<Campos> listCmp = cmp.getAll(request, response);
                            %>  
                            <div class="col-lg-3">
                                <select name="cmbCampos" id="cmbCampos" class="form-control">
                                    <option disabled="" selected="">Selecciona tu campo</option>
                                    <%for (Campos cp : listCmp) {%>       
                                        <option value="<%=cp.getIdCampo()%>"><%=cp.getNombre()%></option>
                                    <%}%>
                                </select>

                                <div class="card">
                                    <div class="card-title">
                                        <h4 class="text-center" style="padding: 15px; font-size:23px;">CANCHAS</h4>   
                                    </div>
                                    <div class="card-content" id="cardEvents">
                                        
                                    </div>
                                </div>
                                <div class="text-center">
                                    <button class="btn btn-primary btn-lg btn-round btnGuardarCambios">Guardar cambios</button>
                                </div>
                            </div>
                            <div class="col-lg-9">
                                <div class="card card-calendar">
                                    <div class="card-content" class="ps-child">
                                        <div id="calendar"></div>
                                    </div>
                                </div>
                            </div>                    
                        </div>                         
                   </div>
                </div>
            </div>
        </div>
        <style>
            .fc h2{
                font-size:20px;
                text-transform: uppercase;
            }
        </style>
        <%@include file="../includes/importsJS.jsp"%> 
        <script src="../../assets/lang/es.js"></script>          		
        <script src="../../assets/js/canchasCalendar.js"></script>
        <script type="text/javascript">
            $("#nombrepagina").text("Cronograma");
            $("#cronograma").addClass("active");
        </script>
    </body>
</html>

<%@page import="Modelo.Equipo"%>
<%@page import="Controlador.equipo"%>
<%@page import="java.util.List"%>
<%@page import="Controlador.campos"%>
<%@page import="Modelo.Campos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <meta charset="utf-8">
    <title>FutPlay - Encuentro</title>
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
                    <div class="col-sm-10 col-sm-offset-1">
                        <!--      Wizard container        -->
                        <div class="wizard-container">
                            <div class="card wizard-card" data-color="rose" id="wizardProfile">
                                <form novalidate="novalidate">
                                    <!--        You can switch " data-color="purple" "  with one of the next bright colors: "green", "orange", "red", "blue"       -->
                                    <div class="wizard-header">
                                        <h3 class="wizard-title">
                                            Programar tu encuentro
                                        </h3>
                                        
                                    </div>
                                    <div class="wizard-navigation">
                                        <ul class="nav nav-pills">
                                            <li style="width: 33.3333%;" class="active">
                                                <a href="#about" data-toggle="tab" aria-expanded="true">Tipo</a>
                                            </li>
                                            <li style="width: 33.3333%;">
                                                <a href="#account" data-toggle="tab">Equipos</a>
                                            </li>
                                            <li style="width: 33.3333%;">
                                                <a href="#address" data-toggle="tab">Campos</a>
                                            </li>
                                        </ul>
                                    <div class="moving-tab" style="width: 142.49px; transform: translate3d(-8px, 0px, 0px); transition: transform 0s;">About</div></div>
                                    <div class="tab-content">
                                        <div class="tab-pane active" id="about">
                                            <div class="row">
                                                <h4 class="info-text"> Seleccione un Tipo de partida</h4>
                                                <div class="col-sm-4">
                                                    <div class="choice" data-toggle="wizard-checkbox">
                                                        <input class="btnEquipo" type="checkbox" name="tipo" id="tipo" value="Futbol 5">
                                                        <div class="icon">
                                                            <i class="fa fa-facebook"></i>
                                                        </div>
                                                        <h6>Futbol 5</h6>
                                                    </div>
                                                </div>
                                                <div class="col-sm-4">
                                                    <div class="choice" data-toggle="wizard-checkbox">
                                                        <input class="btnEquipo" type="checkbox" name="tipo" id="tipo" value="Futbol 5">
                                                        <div class="icon">
                                                            <i class="fa fa-terminal"></i>
                                                        </div>
                                                        <h6>Futbol 8</h6>
                                                    </div>
                                                </div>
                                                <div class="col-sm-4">
                                                    <div class="choice" data-toggle="wizard-checkbox">
                                                        <input class="btnEquipo" type="checkbox" name="tipo" id="tipo" value="Futbol 5">
                                                        <div class="icon">
                                                            <i class="fa fa-terminal"></i>
                                                        </div>
                                                        <h6>Futbol 12</h6>
                                                    </div>
                                                </div>

                                            </div>
                                            <div class="row">
                                                <h4 class="info-text"> Seleccione un Tipo de partida</h4>
                                                <div class="col-sm-4">
                                                        <div class="choice" data-toggle="wizard-checkbox">
                                                            <input class="btnEquipo" type="checkbox" name="tipo" id="tipo" value="Futbol 5">
                                                            <div class="icon">
                                                                <i class="fa fa-facebook"></i>
                                                            </div>
                                                            <h6>Futbol 5</h6>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <div class="choice" data-toggle="wizard-checkbox">
                                                            <input class="btnEquipo" type="checkbox" name="tipo" id="tipo" value="Futbol 8">
                                                            <div class="icon">
                                                                <i class="fa fa-terminal"></i>
                                                            </div>
                                                            <h6>Futbol 8</h6>
                                                        </div>
                                                    </div>
                                                       <div class="col-sm-4">
                                                        <div class="choice" data-toggle="wizard-checkbox">
                                                            <input type="checkbox" name="tipo" id="tipo" value="Futbol 12">
                                                            <div class="btnEquipo" class="icon">
                                                                <i class="fa fa-terminal"></i>
                                                            </div>
                                                            <h6>Futbol 12</h6>
                                                        </div>
                                                    </div>
                                            </div>
                                        </div>
                                        <div class="tab-pane" id="account">
                                            <h4 class="info-text">Elige un equipo Para jugar </h4>
                                            <div class="row">
                                                <div class="col-lg-10 col-lg-offset-1">
                                                                               
                                            <%  equipo equipos = new equipo();
                                                  List<Equipo> list = equipos.getAllE(request,response);
                                                if (list==null) {
                                            %>
                                                         <h2> No hay Campos para Mostrar</h2>     
                                                   <% } %>
                                              
                                               <%for (Equipo LEquipo : list) {

                                               %>   
                                                                                     
                                            <div class="card-description" id="" >
                                                <div class="col-lg-4">
                                                    <div class="card card-pricing card-raised">
                                                        <div class="content">
                                                            <h6 class="category"><%=LEquipo.getNombre()%></h6>
                                                            <div class="icon icon-rose">
                                                                <!--<img class="avatar" src="../../assets/img/Equipo/COLOCAR EL EQUIPO.GETIMAGEN LEquipo.getImagen()" style="width: 120px;height: 120px;">-->
                                                            </div>
                                                            <h3 class="card-title"><%=LEquipo.getCiudad()%></h3>
                                                            
                                                            <a id="idEquipo" value="<%=LEquipo.getIdEquipo()%>" class="btnEquipo btn btn-fill btn-rose btn-wd">Enfrentar Equipo</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                             <%}%> 
                                                </div>
                                            </div>
                                        </div>
                                        <div class="tab-pane" id="address">
                                                     <div class="row">
                                                <div class="col-lg-10 col-lg-offset-1">
                                                                            
                                            <%  campos campo = new campos();
                                                List<Campos> lista = campo.getAll(request,response);
                                                if (list==null) {
                                            %>
                                                         <h2> No hay Campos para Mostrar</h2>     
                                                   <% } %>
                                              
                                               <%for (Campos LCampo : lista) {

                                               %>   
                                                                                     
                                            <div class="card-description" id="" >
                                                <div class="col-lg-4">
                                                    <div class="card card-pricing card-raised">
                                                        <div class="content">
                                                            <h6 class="category"><%=LCampo.getNombre()%></h6>
                                                            <div class="icon icon-rose">
                                                                <img class="avatar" src="../../assets/img/canchas/<%=LCampo.getFoto()%>" style="width: 120px;height: 120px;">
                                                            </div>
                                                            <h3 class="card-title"><%=LCampo.getUbicacion()%></h3>
                                                            <p class="card-description"><%=LCampo.getDireccion()%></p>
                                                            <a id="idCampo" value="<%=LCampo.getIdCampo()%>" class="btnCampo btn btn-next btn-fill btn-rose btn-wd">Elegir Campo</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                             <%}%> 
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="wizard-footer">
                                        <div class="pull-right">
                                            <input type="button" class="btnTipo btn btn-next btn-fill btn-rose btn-wd" name="next" value="Next">
                                            <input type="button" class="btn btn-finish btn-fill btn-rose btn-wd" name="finish" value="Finish" style="display: none;">
                                        </div>
                                        <div class="pull-left">
                                            <input type="button" class=" btn btn-previous btn-fill btn-default btn-wd disabled" name="previous" value="Previous">
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <!-- wizard container -->
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@include file="../includes/importsJS.jsp" %>
    <script>
        $("#encuntro").addClass('active');
        CargarNotificaciones();
    </script>                                                
</body>
</html>
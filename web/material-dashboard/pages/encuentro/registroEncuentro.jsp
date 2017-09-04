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
                                                    <h4 class="info-text"> Selecciona el tipo de encuentro</h4>
                                                    <div class="col-sm-4">
                                                        <div class="choice" onclick="tipoSeleccionado(5)" data-toggle="wizard-radio">
                                                            <input type="radio">
                                                            <div class="icon text-center">
                                                                <h1>5</h1>
                                                            </div>
                                                            <h6>Futbol 5</h6>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <div class="choice" onclick="tipoSeleccionado(8)" data-toggle="wizard-radio">
                                                            <input type="radio">
                                                            <div class="icon text-center">
                                                                <h1>8</h1>
                                                            </div>
                                                            <h6>Futbol 8</h6>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <div class="choice" onclick="tipoSeleccionado(12)" data-toggle="wizard-radio">
                                                            <input type="radio">
                                                            <div class="icon text-center">
                                                                <h1>12</h1>
                                                            </div>
                                                            <h6>Futbol 12</h6>
                                                        </div>
                                                    </div>
                                                        
                                                </div>
                                            </div>
                                            <div class="tab-pane" id="account">
                                                <h4 class="info-text">Elige el equipo con el que deseas jugar</h4>
                                                <div class="row">
                                                    <div class="col-lg-10 col-lg-offset-1">
                                                        
                                                        <%  equipo equipos = new equipo();
                                                            List<Equipo> list = equipos.getAllE(request,response);
                                                            if (list.equals(null)) {%>
                                                                <h2> No hay Campos para Mostrar</h2>     
                                                        <%  }else{ %>

                                                             <%for (Equipo LEquipo : list) {%>   

                                                                <div class="card-description">
                                                                    <div class="col-lg-4">
                                                                        <div class="card card-pricing card-raised">
                                                                            <div class="content">
                                                                                <h6 class="category"><%=LEquipo.getNombre()%></h6>
                                                                                <!--<div class="icon icon-rose">
                                                                                    <img class="avatar" src="../../assets/img/jugadorimg/Manchester-City-stats1.png" style="width: 120px;height: 120px;">
                                                                                </div>-->
                                                                                <h3 class="card-title"><%=LEquipo.getCiudad()%></h3>
                                                                                <div class="radio">
                                                                                  <label>
                                                                                      <input id="equipoEncuentro" name="equipo" type="radio" onclick="equipoSeleccionado(this)" value="<%=LEquipo.getIdEquipo()%>"/>
                                                                                      <span class="circle"></span>
                                                                                      <span class="check"></span> Selecionar
                                                                                  </label>
                                                                              </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <%}
                                                            }%> 
                                                
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="tab-pane" id="address">
                                                <h4 class="info-text">Selecciona el campo el el que deseas jugar</h4>
                                                <div class="row">
                                                    <div class="col-lg-10 col-lg-offset-1">
                                                        
                                                        <%  campos campo = new campos();
                                                            List<Campos> lista = campo.verCampos();
                                                            if (list==null) {
                                                        %>
                                                                     <h2> No hay Campos para Mostrar</h2>     
                                                               <% } %>

                                                           <%for (Campos LCampo : lista) {

                                                           %>   

                                                        <div class="card-description">
                                                            <div class="col-lg-4">
                                                                <div class="card card-pricing card-raised">
                                                                    <div class="content">
                                                                        <h6 class="category"><%=LCampo.getNombre()%></h6>
                                                                        <div class="icon icon-rose">
                                                                            <img class="avatar" src="../../assets/img/canchas/<%=LCampo.getFoto()%>" style="width: 120px;height: 120px;">
                                                                        </div>
                                                                        <h3 class="card-title"><%=LCampo.getUbicacion()%></h3>
                                                                        <p class="card-description"><%=LCampo.getDireccion()%></p>
                                                                        <div class="radio">
                                                                            <label>
                                                                                <input id="campoEncuentro" name="campo" type="radio" onclick="campoSeleccionado(this)" value="<%=LCampo.getIdCampo()%>">
                                                                                <span class="circle"></span>
                                                                                <span class="check"></span> Selecionar
                                                                            </label>
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
                                        <div class="wizard-footer">
                                            <div class="pull-right">
                                                <input type="button" class="btnTipo btn btn-next btn-fill btn-rose btn-wd" name="next" value="Next">
                                                <input type="button" class="btn btn-finish btn-fill btn-rose btn-wd ingresarEncuentro" name="finish" value="Finish" style="display: none;">
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

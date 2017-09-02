<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FutPlay</title>
        <%@include file="../includes/importsCSS.jsp" %>
    </head>
    <body>
        <div class="wrapper">
            <%@include file="../includes/sidebarPropietario.jsp" %>
            <div class="main-panel">
                <%@include file="../includes/headerPropietario.jsp" %>
                <div class="content">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-lg-6">
                              <div class="card card-product">
                                <div class="card-image" data-header-animation="true">
                                    <img src="/FutPlayFinal/material-dashboard/assets/img/corner.JPG">
                                    <span class="card-title">Campos</span>
                                </div>
                                <div class="card-content">
                                    <div class="card-actions">
                                        <a href="/FutPlayFinal/material-dashboard/pages/campo/registrarCampo.jsp" type="button" class="btn btn-info btn-simple" rel="tooltip" data-placement="bottom" title="Añadir campo">
                                             <i class="material-icons" style="font-size: 30px;">add</i>
                                        </a>
                                        <button type="button" class="btn btn-danger btn-simple fix-broken-card" rel="tooltip" data-placement="bottom" title="Ver de nuevo">
                                          <i class="material-icons" style="font-size: 25px;">loop</i>
                                        </button>
                                    </div>
                                  <p>Añade tus campos y canchas, comienza a conectarte con jugadores y planea encuentos</p>
                                </div>
                                  <%Propietario prop = (Propietario) session.getAttribute("PropietarioIngresado");%>
                                  <div class="card-footer">
                                      <button class="btn btn-danger btnVerCampos" value="<%=prop.getIdPropietario()%>">Administrar campos</button>
                                  </div>
                              </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="card card-product">
                                  <div class="card-image" data-header-animation="true">
                                    <img src="/FutPlayFinal/material-dashboard/assets/img/cronograma.jpg">
                                    <span class="card-title">Cronograma de encuentros</span>
                                  </div>
                                  <div class="card-content">
                                    <div class="card-actions">
                                      <button type="button" class="btn btn-danger btn-simple fix-broken-card" rel="tooltip" title="Ver de nuevo">
                                          <i class="material-icons">loop</i>
                                      </button>
                                    </div>
                                    <p>Lleva un control especifico y organizado de tus canchas dia a dia</p>
                                  </div>
                                    <div class="card-footer">
                                        <a href="/FutPlayFinal/material-dashboard/pages/cancha/administrarCanchas.jsp" class="btn btn-danger">Administrar canchas</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../includes/importsJS.jsp" %>
        <script type="text/javascript">
            $("#nombrepagina").text("Inicio");
            $("#inicio").addClass("active");
        </script>
    </body>
</html>

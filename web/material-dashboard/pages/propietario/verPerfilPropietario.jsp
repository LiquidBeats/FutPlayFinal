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
                        <div class="col-md-8 col-md-offset-2">
                            <div class="card card-profile">
                                <div class="card-avatar">
                                    <a href="#pablo">
                                        <img class="img" src="../../assets/img/avatares/<%=objPropietario.getPersona().getAvatar()%>">
                                    </a>
                                </div>
                                <div class="card-content">
                                    <h6 class="category text-gray"><%=objPropietario.getPersona().getNombres()%></h6>
                                    <h4 class="card-title"><%=objPropietario.getPersona().getApellidos()%></h4>
                                    <p class="description"><%=objPropietario.getPersona().getCorreo()%></p>
                                    
                                    <a href="/FutPlayFinal/material-dashboard/pages/propietario/editarPerfilPropietario.jsp" class="btn btn-danger btn-round">Editar perfil</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../includes/importsJS.jsp"%>
        <script type="text/javascript">
            $("#nombrepagina").text("Mi perfil");
            $("#verperfil").addClass("active");
        </script>
    </body>
</html>

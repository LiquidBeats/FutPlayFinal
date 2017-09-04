<%@page import="Modelo.Propietario"%>
<%  
    Propietario objPropietario = new Propietario();
    objPropietario=(Propietario)session.getAttribute("PropietarioIngresado");
    response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
    response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
    response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
    response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
    try{      
        if(objPropietario==null){
            response.sendRedirect("/FutPlayFinal/index.html");
        }     
    }  
    catch(Exception ex){
        response.sendRedirect("/FutPlayFinal/index.html");
    }
%>
<div class="sidebar" data-active-color="red" data-background-color="black" data-image="../../assets/img/sidebar-1.jpg">
    <div class="logo">
        <a href="http://localhost:8080/FutPlayFinal/material-dashboard/pages/propietario/indexPropietario.jsp" class="simple-text">
            FutPlay
        </a>
    </div>
    <div class="logo logo-mini">
        <a href="http://localhost:8080/FutPlayFinal/material-dashboard/pages/propietario/indexPropietario.jsp" class="simple-text">
            <img src="../../assets/img/favicon.png" style="width:35px;height: 35px;"/>
        </a>
    </div>
    <div class="sidebar-wrapper">
        <div class="user">
            <div class="photo">
                <img src="/FutPlayFinal/Imagenes/<%=objPropietario.getPersona().getAvatar()%>" />
            </div>
            <div class="info">
                <a data-toggle="collapse" href="#collapseExample" class="collapsed">
                    <%=objPropietario.getPersona().getNombres()+" "+objPropietario.getPersona().getApellidos()%>
                    <b class="caret"></b>
                </a>
                <div class="collapse" id="collapseExample">
                    <ul class="nav">
                        <li id="verperfil">
                            <a href="/FutPlayFinal/material-dashboard/pages/propietario/verPerfilPropietario.jsp">Ver perfil</a>
                        </li>
                        <li id="editarperfil">
                            <a href="/FutPlayFinal/material-dashboard/pages/propietario/editarPerfilPropietario.jsp">Editar perfil</a>
                        </li>
                        <li>
                            <a href="#">Ajustes</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <ul class="nav">
            <li id="inicio">
                <a href="/FutPlayFinal/material-dashboard/pages/propietario/indexPropietario.jsp">
                    <i class="material-icons">dashboard</i>
                    <p>Inicio</p>
                </a>
            </li>
            <li id="campos">
                <a data-toggle="collapse" href="#camposOptions">
                    <i class="material-icons">aspect_ratio</i>
                    <p>Campos
                        <b class="caret"></b>
                    </p>
                </a>
                <div class="collapse" id="camposOptions">
                    <ul class="nav">
                        <li>
                            <a href="http://localhost:8080/FutPlayFinal/material-dashboard/pages/campo/registrarCampo.jsp">Agregar campo</a>
                        </li>
                        <li>
                            <a href="http://localhost:8080/FutPlayFinal/material-dashboard/pages/campo/administrarCampo.jsp">Administrar campos</a>
                        </li>
                    </ul>
                </div>
            </li>
            <li>
                <a data-toggle="collapse" href="#formsExamples">
                    <i class="material-icons">content_paste</i>
                    <p>Torneos
                        <b class="caret"></b>
                    </p>
                </a>
                <div class="collapse" id="formsExamples">
                    <ul class="nav">
                        <li>
                            <a href="./forms/regular.html">Regular Forms</a>
                        </li>
                        <li>
                            <a href="./forms/extended.html">Extended Forms</a>
                        </li>
                        <li>
                            <a href="./forms/validation.html">Validation Forms</a>
                        </li>
                        <li>
                            <a href="./forms/wizard.html">Wizard</a>
                        </li>
                    </ul>
                </div>
            </li>
            <li id="cronograma">
                <a href="http://localhost:8080/FutPlayFinal/material-dashboard/pages/cancha/administrarCanchas.jsp">
                    <i class="material-icons">today</i>
                    <p>Cronograma</p>
                </a>
            </li>           
        </ul>
    </div>
</div>
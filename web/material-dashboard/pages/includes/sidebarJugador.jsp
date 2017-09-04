<%@page import="Modelo.Persona"%>
<%@page import="Modelo.Jugador"%>
<%

    Jugador objJugador = (Jugador) request.getSession().getAttribute("JugadorIngresado");
    Persona objPersona = (Persona) request.getSession().getAttribute("UsuarioIngresado");
    
%>
<div class="sidebar" data-active-color="red" data-background-color="black" data-image="../../assets/img/sidebar-1.jpg">
    <div class="logo">
        <a href="http://localhost:8080/FutPlayFinal/material-dashboard/pages/jugador/indexJugador.jsp" class="simple-text">
            FutPlay
        </a>
    </div>
    <div class="logo logo-mini">
        <a href="http://localhost:8080/FutPlayFinal/material-dashboard/pages/jugador/indexJugador.jsp" class="simple-text">
            <img src="../../assets/img/favicon.png" style="width:35px;height: 35px;"/>
        </a>
    </div>
    <div class="sidebar-wrapper">
        <div class="user">
            <div class="photo">
                <img src="/FutPlayFinal/material-dashboard/assets/img/avatares/<%=objPersona.getAvatar()%>" />
            </div>
            <div class="info">
                <a data-toggle="collapse" href="#collapseExample" class="collapsed">
                    <%= objJugador.getAlias()%>
                    <b class="caret"></b>
                </a>
                <div class="collapse" id="collapseExample">
                    <ul class="nav">
                        <li>
                            <a href="../jugador/verPerfilJugador.jsp">Ver perfil</a>
                        </li>
                        <li>
                            <a href="../jugador/editarPerfilJugador.jsp">Editar perfil</a>
                        </li>
                        <li>
                            <a href="#">Ajustes</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <ul class="nav">
            <li id="iniciojugador">
                <a href="../jugador/indexJugador.jsp">
                    <i class="material-icons">dashboard</i>
                    <p>Inicio</p>
                </a>
            </li>
            <li id="equipo">
                <a href="../equipo/verEquipo.jsp">
                    <i class="material-icons">people</i>
                    <p>Mi equipo</p>
                </a>
            </li>
            <li id="jugadores">
                <a href="../jugador/verJugadores.jsp">
                    <i class="material-icons">person</i>
                    <p>Jugadores</p>
                </a>
            </li>
            <li id="charla">
                <a href="../mensaje/charlaSockets.jsp">
                    <i class="material-icons">message</i>
                    <p>Charla tecnica</p>
                </a>
            </li>
            <li id="encuentro">
                <a href="../encuentro/registroEncuentro.jsp">
                    <i class="material-icons">flash_on</i>
                    <p>Encunetros</p>
                </a>
            </li>
        </ul>
    </div>
</div>
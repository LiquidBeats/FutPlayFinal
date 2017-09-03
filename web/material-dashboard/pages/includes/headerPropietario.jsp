<nav class="navbar navbar-transparent navbar-absolute">
    <div class="container-fluid">
        <div class="navbar-minimize">
            <button id="minimizeSidebar" class="btn btn-round btn-white btn-fill btn-just-icon">
                <i class="material-icons visible-on-sidebar-regular">more_vert</i>
                <i class="material-icons visible-on-sidebar-mini">view_list</i>
            </button>
        </div>
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse">
                <span class="sr-only">Menu</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#" id="nombrepagina"> Inicio </a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <!--<a href="#pablo" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="material-icons">dashboard</i>
                        <p class="hidden-lg hidden-md">Dashboard</p>
                    </a>-->
                </li>
                <li class="dropdown">
                    <!-- ESPACIO PARA LAS NOTIFICACIONES -->   
                    <!-- AGREGAR A LAS NOTIFICACIONES ETIQUETE A.class: verNotificaciones,actualizarNotificaciones-->
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" rel="tooltip" data-placement="bottom" data-original-title="Notificaciones">
                        <i class="material-icons">notifications</i>
                        <div id="numeroNotificacionesContainer"></div>
                        <p class="hidden-lg hidden-md">
                            Notificaciones
                            <!--<b class="caret"></b>-->
                        </p>
                    </a>
                
                </li>
                <li>
                    <a href="#" class="dropdown-toggle" rel="tooltip" title="Cerrar sesión" data-placement="bottom" id="btnCerrarSesion" data-toggle="dropdown">
                        <i class="material-icons">power_settings_new</i>
                        <p class="hidden-lg hidden-md">Cerrar sesión</p>
                    </a>
                </li>
                <li class="separator hidden-lg hidden-md"></li>
            </ul>
        </div>
    </div>
</nav>

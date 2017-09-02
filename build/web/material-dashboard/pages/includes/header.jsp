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
                <li><!-- AGREGAR A LAS NOTIFICACIONES ETIQUETE A.class: verNotificaciones,actualizarNotificaciones-->
                    <a href="#" class="dropdown-toggle btn-Notification verNotificaciones actualizarNotificaciones" data-toggle="dropdown" rel="tooltip" data-placement="bottom" data-original-title="Notificaciones">
                        <i class="material-icons">notifications</i>
                        <div id="numeroNotificacionesContainer"></div>
                        <p class="hidden-lg hidden-md">
                            Notificaciones
                            <!--<b class="caret"></b>-->
                        </p>
                    </a>
                </li>
                <li>
                    <a href="#pablo" class="dropdown-toggle btn-ExitSystem" data-toggle="dropdown" rel="tooltip" data-placement="bottom" title="" data-original-title="Cerrar Sesión">
                        <i class="material-icons" style="font-size: 25px;">power_settings_new</i>
                        <p class="hidden-lg hidden-md">Profile</p>
                    </a>
                </li>
                <li class="separator hidden-lg hidden-md"></li>
            </ul>
            <form class="navbar-form navbar-right" role="search">
                <!--<div class="form-group form-search is-empty">
                    <input type="text" class="form-control" placeholder="Search">
                    <span class="material-input"></span>
                </div>-->
                <!--<button type="submit" class="btn btn-white btn-round btn-just-icon">
                    <i class="material-icons">search</i>
                    <div class="ripple-container"></div>
                </button>-->
            </form>
        </div>
    </div>
</nav>

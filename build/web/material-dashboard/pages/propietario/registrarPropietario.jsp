<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>FutPlay - Registro</title>
    <%@include file="../includes/importsCSS.jsp" %>
</head>

<body>
    <nav class="navbar navbar-primary navbar-transparent navbar-absolute">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/FutPlayFinal/index.html">FutPlay</a>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">             
                    <li class="">
                        <a href="/FutPlayFinal/material-dashboard/pages/usuario/login.html">
                            <i class="material-icons">fingerprint</i> Inicia Sesión
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="wrapper wrapper-full-page">
        <div class="full-page login-page" filter-color="black" data-image="/FutPlayFinal/GaiaTemplate/assets/img/bannerIndex.jpg">
            <!--   you can change the color of the filter page using: data-color="blue | purple | green | orange | red | rose " -->
            <div class="content">
                <div class="container-fluid">
                    <div class="col-sm-8 col-sm-offset-2">
                        <!--      Wizard container        -->
                        <div class="wizard-container">
                            <div class="card wizard-card" data-color="red" id="wizardProfile">
                                <form action="" method="post" novalidate="novalidate" id="frmPropietario" enctype="multipart/form-data">
                                    <!--        You can switch " data-color="purple" "  with one of the next bright colors: "green", "orange", "red", "blue"       -->
                                    <div class="wizard-header">
                                        <h3 class="wizard-title">
                                            Ingresa tu datos
                                        </h3>
                                        <h5>Completa la informacion de tu perfil.</h5>
                                    </div>
                                    <div class="wizard-navigation">
                                        <ul class="nav nav-pills">
                                            <li style="width: 33.3333%;" class="active">
                                                <a href="#cuenta" data-toggle="tab" aria-expanded="true">Cuenta</a>
                                            </li>
                                            <li style="width: 33.3333%;">
                                                <a href="#informacion" data-toggle="tab">Información</a>
                                            </li>
                                        </ul>
                                    <div class="moving-tab" style="width: 142.49px; transform: translate3d(-8px, 0px, 0px); transition: transform 0s;">About</div></div>
                                    <div class="tab-content">
                                        <div class="tab-pane" id="informacion">
                                            <div class="row">
                                                <div class="col-sm-12">
                                                    <div class="input-group">
                                                        <span class="input-group-addon">
                                                            <i class="material-icons">face</i>
                                                        </span>
                                                        <div class="form-group label-floating is-empty">
                                                            <label class="label-control">Nombres 
                                                            </label>
                                                            <input name="nombresPropietario" id="nombresPropietario" type="text" class="form-control">
                                                        <span class="material-input"></span></div>
                                                    
                                                        <span class="input-group-addon">
                                                            <i class="material-icons">record_voice_over</i>
                                                        </span>
                                                        <div class="form-group label-floating is-empty">
                                                            <label class="label-control">Apellidos
                                                            </label>
                                                            <input name="apellidosPropietario" id="apellidosPropietario" type="text" class="form-control">
                                                        <span class="material-input"></span></div>
                                                    </div>
                                                    <div class="input-group">
                                                        <span class="input-group-addon">
                                                            <i class="material-icons">today</i>
                                                        </span>
                                                        <div class="form-group label-floating is-empty">
                                                            <label class="label-control">Fecha nacimiento
                                                            </label>
                                                            <input name="fechanacimientoPropietario" id="fechanacimientoPropietario" type="text" class="form-control datepicker">
                                                        <span class="material-input"></span></div>
                                                        
                                                        <span class="input-group-addon">
                                                            <i class="material-icons">call</i>
                                                        </span>
                                                        <div class="form-group label-floating is-empty">
                                                            <label class="label-control">Telefono
                                                            </label>
                                                            <input name="telefonoPropietario" id="telefonoPropietario" type="text" class="form-control">
                                                        <span class="material-input"></span></div>
                                                        
                                                    </div>
                                                    
                                                    <div class="input-group">
                                                        <span class="input-group-addon">
                                                            <i class="material-icons">perm_identity</i>
                                                        </span>
                                                        <div class="form-group label-floating is-empty">
                                                            <label class="label-control">Genero
                                                            </label>
                                                            <select name="generoPropietario" id="generoPropietario" class="form-control">
                                                                <option disabled="" selected=""></option>
                                                                <option value="Masculino"> Masculino </option>
                                                                <option value="Femenino"> Femenino </option>
                                                            </select>
                                                        <span class="material-input"></span></div>
                                                    </div>
                                                </div>                                        
                                            </div>
                                        </div>
                                        <div class="tab-pane active" id="cuenta">
                                            <div class="col-sm-4 col-sm-offset-1">
                                                    <div class="picture-container">
                                                        <div class="picture">
                                                            <img src="../../assets/img/avatares/av.jpg" class="picture-src" id="wizardPicturePreview" title="">
                                                            <input type="file" id="avatarPropietario">
                                                            <input type="text" id="avatarFotoNombre" hidden="">
                                                        </div>
                                                        <h6>Selecciona tu avatar</h6>
                                                        <small>(Opcional)</small>
                                                    </div>
                                                </div>
                                                <div class="col-sm-6">
                                                    <div class="input-group">
                                                        <span class="input-group-addon">
                                                            <i class="material-icons">lock</i>
                                                        </span>
                                                        <div class="form-group label-floating is-empty">
                                                            <label class="label-control">Contraseña
                                                                <small class="error"></small>
                                                            </label>
                                                            <input name="passwordPropietario" id="passwordPropietario" type="password" class="form-control">
                                                        <span class="material-input"></span></div>
                                                    </div>
                                                    <div class="input-group">
                                                        <span class="input-group-addon">
                                                            <i class="material-icons">lock_outline</i>
                                                        </span>
                                                        <div class="form-group label-floating is-empty">
                                                            <label class="label-control">Confirmar contraseña
                                                                <small class="error"></small>
                                                            </label>
                                                            <input name="passwordPropietarioConfirm" type="password" class="form-control">
                                                        <span class="material-input"></span></div>
                                                    </div>
                                                </div>
                                                <div class="col-lg-10 col-lg-offset-1">
                                                    <div class="input-group">
                                                        <span class="input-group-addon">
                                                            <i class="material-icons">email</i>
                                                        </span>
                                                        <div class="form-group label-floating is-empty">
                                                            <label class="label-control">Email
                                                                <small class="error"></small>
                                                            </label>
                                                            <input name="emailPropietario" id="emailPropietario" type="email" class="form-control">
                                                        <span class="material-input"></span></div>
                                                    </div>
                                                </div>
                                        </div>                                        
                                    </div>
                                    <div class="wizard-footer">
                                        <div class="pull-right">
                                            <input type="button" class="btn btn-next btn-fill btn-danger btn-wd" name="next" value="Siguiente">
                                            <input type="submit" class="btn btn-finish btn-fill btn-danger btn-wd btnRegistrarPropietario" name="finish" value="Finalizar" style="display: none;">
                                        </div>
                                        <div class="pull-left">
                                            <input type="button" class="btn btn-previous btn-fill btn-default btn-wd disabled" name="previous" value="Volver">
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
            <footer class="footer">
                <div class="container">
                    <nav class="pull-left">
                        <ul>
                            <li>
                                <a href="#">
                                    Home
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    Company
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    Portfolio
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    Blog
                                </a>
                            </li>
                        </ul>
                    </nav>
                    <p class="copyright pull-right">
                        &copy;
                        <script>
                            document.write(new Date().getFullYear())
                        </script>
                        <a href="#">FutPlay Team</a>, hecho con amor
                    </p>
                </div>
            </footer>
        </div>
    </div>
    <style>
        .error{
            color:red;
            font-size:12px;
        }
    </style>
    <!--   Core JS Files   -->
    <script src="../../assets/js/jquery-3.1.1.min.js" type="text/javascript"></script>
    <script src="../../assets/js/jquery-ui.min.js" type="text/javascript"></script>
    <script src="../../assets/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="../../assets/js/material.min.js" type="text/javascript"></script>
    <script src="../../assets/js/perfect-scrollbar.jquery.min.js" type="text/javascript"></script>
    <!-- Forms Validations Plugin -->
    <script src="../../assets/js/jquery.validate.min.js"></script>
    <!--  Plugin for Date Time Picker and Full Calendar Plugin-->
    <script src="../../assets/js/moment.min.js"></script>
    <!--  Charts Plugin -->
    <script src="../../assets/js/chartist.min.js"></script>
    <!--  Plugin for the Wizard -->
    <script src="../../assets/js/jquery.bootstrap-wizard.js"></script>
    <!--  Notifications Plugin    -->
    <script src="../../assets/js/bootstrap-notify.js"></script>
    <!--   Sharrre Library    -->
    <script src="../../assets/js/jquery.sharrre.js"></script>
    <!-- DateTimePicker Plugin -->
    <script src="../../assets/js/bootstrap-datetimepicker.js"></script>
    <!-- Vector Map plugin -->
    <script src="../../assets/js/jquey-jvectormap.js"></script>
    <!-- Sliders Plugin -->
    <script src="../../assets/js/nouislider.min.js"></script>
    <!-- Select Plugin -->
    <script src="../../assets/js/jquery.select-bootstrap.js"></script>
    <!--  DataTables.net Plugin    -->
    <script src="../../assets/js/jquery.datatables.js"></script>
    <!-- Sweet Alert 2 plugin -->
    <script src="../../assets/js/sweetalert2.js"></script>
    <!--	Plugin for Fileupload, full documentation here: http://www.jasny.net/bootstrap/javascript/#fileinput -->
    <script src="../../assets/js/jasny-bootstrap.min.js"></script>
    <!--  Full Calendar Plugin    -->
    <script src="../../assets/js/fullcalendar.min.js"></script>
    <!-- TagsInput Plugin -->
    <script src="../../assets/js/jquery.tagsinput.js"></script>
    <!-- Material Dashboard javascript methods -->
    <script src="../../assets/js/material-dashboard.js"></script>
    <!-- Material Dashboard DEMO methods, don't include it in your project! -->
    <script src="../../assets/js/demo.js"></script>
    <!--Gmaps API-->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAAZnaZBXLqNBRXjd-82km_NO7GUItyKek"></script>  

    <script type="text/javascript">
        $().ready(function() {
            demo.checkFullPageBackgroundImage();
            demo.initFormExtendedDatetimepickers();
        });
    </script>

    <!-- Scripts Personalizados -->
    <script src="../../assets/js/base.js"></script>
    <script src="../../assets/js/basePropietario.js"></script>
</body>
</html>
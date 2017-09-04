<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>FutPlay - Registro</title>
    <%@include file="../includes/importsCSS.jsp"%>
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
                                <form action="" method="" novalidate="novalidate" id="frmJugador">
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
                                            <li style="width: 33.3333%;">
                                                <a href="#perfil" data-toggle="tab">Perfil</a>
                                            </li>
                                            <li style="width: 33.3333%;">
                                                <a href="#preguntas" data-toggle="tab">Preguntas</a>
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
                                                            <input name="nombresJugador" id="nombresJugador" type="text" class="form-control">
                                                        <span class="material-input"></span></div>
                                                    
                                                        <span class="input-group-addon">
                                                            <i class="material-icons">record_voice_over</i>
                                                        </span>
                                                        <div class="form-group label-floating is-empty">
                                                            <label class="label-control">Apellidos
                                                            </label>
                                                            <input name="apellidosJugador" id="apellidosJugador" type="text" class="form-control">
                                                        <span class="material-input"></span></div>
                                                    </div>
                                                    <div class="input-group">
                                                        <span class="input-group-addon">
                                                            <i class="material-icons">today</i>
                                                        </span>
                                                        <div class="form-group label-floating is-empty">
                                                            <label class="label-control">Fecha nacimiento
                                                            </label>
                                                            <input name="fechanacimientoJugador" id="fechanacimientoJugador" type="text" class="form-control datepicker">
                                                        <span class="material-input"></span></div>
                                                        
                                                        <span class="input-group-addon">
                                                            <i class="material-icons">call</i>
                                                        </span>
                                                        <div class="form-group label-floating is-empty">
                                                            <label class="label-control">Telefono
                                                            </label>
                                                            <input name="telefonoJugador" id="telefonoJugador" type="text" class="form-control">
                                                        <span class="material-input"></span></div>
                                                        
                                                    </div>
                                                    
                                                    <div class="input-group">
                                                        <span class="input-group-addon">
                                                            <i class="material-icons">perm_identity</i>
                                                        </span>
                                                        <div class="form-group label-floating is-empty">
                                                            <label class="label-control">Genero
                                                            </label>
                                                            <select name="generoJugador" id="generoJugador" class="form-control">
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
                                                            <input type="file" id="avatarJugador">
                                                            <input type="text" hidden id="avatarJugadorNombre">
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
                                                            <input name="passwordJugador" id="passwordJugador" type="password" class="form-control">
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
                                                            <input name="passwordJugadorConfirm" type="password" class="form-control">
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
                                                            <input name="emailJugador" id="emailJugador" type="email" class="form-control">
                                                        <span class="material-input"></span></div>
                                                    </div>
                                                </div>
                                        </div>   
                                        <div class="tab-pane" id="preguntas">
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="material-icons">question_answer</i>
                                                </span>
                                                <div class="form-group label-floating is-empty">
                                                    <label class="label-control">¿Eres capaz de patear el balon 30 veces sin dejarlo caer?
                                                        <small class="error"></small>
                                                    </label>
                                                    <select name="pregunta1" id="pregunta1" class="form-control">
                                                        <option disabled="" selected=""></option>
                                                        <option value="100"> Si </option>
                                                        <option value="0"> No </option>
                                                        <option value="50"> Tal vez </option>
                                                    </select>
                                                <span class="material-input"></span></div>
                                            </div>
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="material-icons">question_answer</i>
                                                </span>
                                                <div class="form-group label-floating is-empty">
                                                    <label class="label-control">¿Que tan buena es tu condicion fisica?
                                                        <small class="error"></small>
                                                    </label>
                                                    <select name="pregunta2" id="pregunta2" class="form-control">
                                                        <option disabled="" selected=""></option>
                                                        <option value="100"> Buena </option>
                                                        <option value="0"> Mala </option>
                                                        <option value="50"> Regular </option>
                                                    </select>
                                                <span class="material-input"></span></div>
                                            </div>
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="material-icons">question_answer</i>
                                                </span>
                                                <div class="form-group label-floating is-empty">
                                                    <label class="label-control">¿Con que frecuencia practicas este deporte?
                                                        <small class="error"></small>
                                                    </label>
                                                    <select name="pregunta3" id="pregunta3" class="form-control">
                                                        <option disabled="" selected=""></option>
                                                        <option value="100"> Todos los dias </option>
                                                        <option value="50"> Una vez por semana </option>
                                                        <option value="25"> Una vez por mes </option>
                                                        <option value="0"> No practico este deporte </option>
                                                    </select>
                                                <span class="material-input"></span></div>
                                            </div>
                                        </div>
                                        <div class="tab-pane" id="perfil">
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="material-icons">account_circle</i>
                                                </span>
                                                <div class="form-group label-floating is-empty">
                                                    <label class="label-control">Alias
                                                        <small class="error"></small>
                                                    </label>
                                                    <input name="txtAliasJugador" id="txtAliasJugador" type="text" class="form-control">
                                                <span class="material-input"></span></div>
                                            </div>
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="material-icons">question_answer</i>
                                                </span>
                                                <div class="form-group label-floating is-empty">
                                                    <label class="label-control">Posicion en la que juegas
                                                        <small class="error"></small>
                                                    </label>
                                                    <select class="form-control" id="cmbPosicionJugador" name="cmbPosicionJugador">
                                                        <option disabled="" selected=""></option>
                                                        <option value="Portero">Portero</option>
                                                        <option value="Defensor">Defensa</option>
                                                        <option value="Mediocampista">Mediocampista</option>
                                                        <option value="Delantero">Delantero</option>
                                                    </select>
                                                <span class="material-input"></span></div>
                                            </div>
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="material-icons">question_answer</i>
                                                </span>
                                                <div class="form-group label-floating is-empty">
                                                    <label class="label-control">Pierna con la que juegas
                                                        <small class="error"></small>
                                                    </label>
                                                    <select name="cmbPiernaJugador" id="cmbPiernaJugador" class="form-control">
                                                        <option disabled="" selected=""></option>
                                                        <option value="Derecha">Derecha</option>
                                                        <option value="Izquierda">Izquierda</option>
                                                        <option value="Ambas">Ambas</option>
                                                    </select>
                                                <span class="material-input"></span></div>
                                            </div>
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="material-icons">description</i>
                                                </span>
                                                <div class="form-group label-floating is-empty">
                                                    <label class="label-control">Descripcion
                                                        <small class="error"></small>
                                                    </label>
                                                    <input name="txtDescripcionJugador" id="txtDescripcionJugador" type="text" class="form-control">
                                                <span class="material-input"></span></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="wizard-footer">
                                        <div class="pull-right">
                                            <input type="button" class="btn btn-next btn-fill btn-danger btn-wd" name="next" value="Siguiente">
                                            <input type="submit" class="btn btn-finish btn-fill btn-danger btn-wd btnRegistrarJugador" name="finish" value="Finalizar" style="display: none;">
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
    <%@include file="../includes/importsJS.jsp"%>
</body>
</html>
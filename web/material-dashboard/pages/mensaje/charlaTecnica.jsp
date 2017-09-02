<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FutPlay - Charla tecnica</title>
        <%@include file="../includes/importsCSS.jsp" %>
    </head>
    <body>
        <div class="wrapper">
            <%@include file="../includes/sidebarJugador.jsp" %>
            <div class="main-panel">
                <%@include file="../includes/header.jsp" %>
                <div class="content">
                    <div class="container-fluid" id="containercharla">
                        
                        <!--<div class="col-md-8 col-md-offset-2">
                            <div class="card card-profile">
                                <div class="card-header card-header-icon" data-background-color="rose">
                                    <i class="material-icons">perm_identity</i>
                                </div>
                                <div class="card-content">
                                    <div class="clearfix"></div>
                                    <h6 class="category text-gray" style="">¿No tienes mensajes?</h6>
                                    <h4 class="card-title">FutPlay te informa</h4>
                                    <p class="description">
                                        Hola <%=objJugador.getAlias()%>, por el momento no haces parte de un equipo. Nos gustaria que crearass tu propio equipo con el que podras competir en los torneo, on en su defecto pidele a un amigo que te agregue su equipo :).
                                    </p>
                                    <button class="btn btn-rose btn-round" data-toggle="modal" data-target="#noticeModal">Crear equipo</button>
                                </div>
                            </div>
                        </div>-->
                        
                        
                        
                        
                        <!--<div class="col-md-12">
                            <div class="card">
                                <div class="card-header card-header-icon" data-background-color="rose">
                                    <i class="material-icons">perm_identity</i>
                                </div>
                                <div class="card-content">
                                    <h4 class="card-title">
                                        Mensajes - 
                                        <small class="category">Mensajes enviados</small>
                                    </h4>
                                    <div class="card-content" id="mensajesContainer" style="height:200px;overflow-y:scroll;background-color: #e7e6e6;">
                                        <ul class="timeline" id="mensajes">
                                            <li class="timeline-inverted">
                                                <div class="timeline-badge">
                                                    <!--<i class="material-icons">card_travel</i>
                                                    <img class="avatar" src="../../assets/img/faces/avatar.jpg" style="border-radius: 50%;">

                                                </div>
                                                <div class="timeline-panel">
                                                    <div class="timeline-heading">
                                                        <span class="label label-danger">Alias</span>
                                                    </div>
                                                    <div class="timeline-body">
                                                        <p>Wifey made the best Father's Day meal ever. So thankful so happy so blessed. Thank you for making my family We just had fun with the �future� theme !!! It was a fun night all together ... The always rude Kanye Show at 2am Sold Out Famous viewing @ Figueroa and 12th in downtown.</p>
                                                    </div>
                                                    <h6>
                                                        <i class="ti-time"></i> 11 hours ago via FutPlay
                                                    </h6>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="timeline-badge success">
                                                    <i class="material-icons">extension</i>
                                                </div>
                                                <div class="timeline-panel">
                                                    <div class="timeline-heading">
                                                        <span class="label label-success">Another One</span>
                                                    </div>
                                                    <div class="timeline-body">
                                                        <p>Thank God for the support of my wife and real friends. I also wanted to point out that it�s the first album to go number 1 off of streaming!!! I love you Ellen and also my number one design rule of anything I do from shoes to music to homes is that Kim has to like it....</p>
                                                    </div>
                                                </div>
                                            </li>
                                            <li class="timeline-inverted">
                                                <div class="timeline-badge info">
                                                    <i class="material-icons">fingerprint</i>
                                                </div>
                                                <div class="timeline-panel">
                                                    <div class="timeline-heading">
                                                        <span class="label label-info">Another Title</span>
                                                    </div>
                                                    <div class="timeline-body">
                                                        <p>Called I Miss the Old Kanye That�s all it was Kanye And I love you like Kanye loves Kanye Famous viewing @ Figueroa and 12th in downtown LA 11:10PM</p>
                                                        <p>What if Kanye made a song about Kanye Roy�re doesn't make a Polar bear bed but the Polar bear couch is my favorite piece of furniture we own It wasn�t any Kanyes Set on his goals Kanye</p>
                                                        <hr>
                                                        <div class="dropdown pull-left">
                                                            <button type="button" class="btn btn-round btn-info dropdown-toggle" data-toggle="dropdown">
                                                                <i class="material-icons">build</i>
                                                                <span class="caret"></span>
                                                            </button>
                                                            <ul class="dropdown-menu dropdown-menu-right" role="menu">
                                                                <li>
                                                                    <a href="#action">Action</a>
                                                                </li>
                                                                <li>
                                                                    <a href="#action">Another action</a>
                                                                </li>
                                                                <li>
                                                                    <a href="#here">Something else here</a>
                                                                </li>
                                                                <li class="divider"></li>
                                                                <li>
                                                                    <a href="#link">Separated link</a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="timeline-badge warning">
                                                    <i class="material-icons">flight_land</i>
                                                </div>
                                                <div class="timeline-panel">
                                                    <div class="timeline-heading">
                                                        <span class="label label-warning">Another One</span>
                                                    </div>
                                                    <div class="timeline-body">
                                                        <p>Tune into Big Boy's 92.3 I'm about to play the first single from Cruel Winter Tune into Big Boy's 92.3 I'm about to play the first single from Cruel Winter also to Kim�s hair and makeup Lorraine jewelry and the whole style squad at Balmain and the Yeezy team. Thank you Anna for the invite thank you to the whole Vogue team</p>
                                                    </div>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                    <div>
                                        <div class="row">
                                            <div class="col-md-10 col-lg-offset-1">
                                                <div class="form-group">
                                                    <label>Escribe un mensaje</label>
                                                    <div class="form-group label-floating is-empty">
                                                        <textarea class="form-control" rows="3" id="txtContenidoMensaje"></textarea>
                                                    <span class="material-input"></span></div>
                                                </div>
                                                <button class="btn btn-rose pull-right ingresarMensaje">Enviar</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>-->
                        
                        
                        
                        <!--<div class="card">
                            <div class="card-header card-header-icon" data-background-color="rose">
                                <i class="material-icons">equalizer</i>
                            </div>
                            <div class="card-content">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="card card-plain">
                                            <div class="card-content" id="mensajesContainer" style="height:200px;overflow-y:scroll;background-color: #e7e6e6;">
                                                <ul class="timeline" id="mensajes">
                                                    <li class="timeline-inverted">
                                                        <div class="timeline-badge">
                                                            <!--<i class="material-icons">card_travel</i>-->
                                                            <!--<img class="avatar" src="../../assets/img/faces/avatar.jpg" style="border-radius: 50%;">
                                                            
                                                        </div>
                                                        <div class="timeline-panel">
                                                            <div class="timeline-heading">
                                                                <span class="label label-danger">Alias</span>
                                                            </div>
                                                            <div class="timeline-body">
                                                                <p>Wifey made the best Father's Day meal ever. So thankful so happy so blessed. Thank you for making my family We just had fun with the �future� theme !!! It was a fun night all together ... The always rude Kanye Show at 2am Sold Out Famous viewing @ Figueroa and 12th in downtown.</p>
                                                            </div>
                                                            <h6>
                                                                <i class="ti-time"></i> 11 hours ago via FutPlay
                                                            </h6>
                                                        </div>
                                                    </li>
                                                    <li>
                                                        <div class="timeline-badge success">
                                                            <i class="material-icons">extension</i>
                                                        </div>
                                                        <div class="timeline-panel">
                                                            <div class="timeline-heading">
                                                                <span class="label label-success">Another One</span>
                                                            </div>
                                                            <div class="timeline-body">
                                                                <p>Thank God for the support of my wife and real friends. I also wanted to point out that it�s the first album to go number 1 off of streaming!!! I love you Ellen and also my number one design rule of anything I do from shoes to music to homes is that Kim has to like it....</p>
                                                            </div>
                                                        </div>
                                                    </li>
                                                    <li class="timeline-inverted">
                                                        <div class="timeline-badge info">
                                                            <i class="material-icons">fingerprint</i>
                                                        </div>
                                                        <div class="timeline-panel">
                                                            <div class="timeline-heading">
                                                                <span class="label label-info">Another Title</span>
                                                            </div>
                                                            <div class="timeline-body">
                                                                <p>Called I Miss the Old Kanye That�s all it was Kanye And I love you like Kanye loves Kanye Famous viewing @ Figueroa and 12th in downtown LA 11:10PM</p>
                                                                <p>What if Kanye made a song about Kanye Roy�re doesn't make a Polar bear bed but the Polar bear couch is my favorite piece of furniture we own It wasn�t any Kanyes Set on his goals Kanye</p>
                                                                <hr>
                                                                <div class="dropdown pull-left">
                                                                    <button type="button" class="btn btn-round btn-info dropdown-toggle" data-toggle="dropdown">
                                                                        <i class="material-icons">build</i>
                                                                        <span class="caret"></span>
                                                                    </button>
                                                                    <ul class="dropdown-menu dropdown-menu-right" role="menu">
                                                                        <li>
                                                                            <a href="#action">Action</a>
                                                                        </li>
                                                                        <li>
                                                                            <a href="#action">Another action</a>
                                                                        </li>
                                                                        <li>
                                                                            <a href="#here">Something else here</a>
                                                                        </li>
                                                                        <li class="divider"></li>
                                                                        <li>
                                                                            <a href="#link">Separated link</a>
                                                                        </li>
                                                                    </ul>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </li>
                                                    <li>
                                                        <div class="timeline-badge warning">
                                                            <i class="material-icons">flight_land</i>
                                                        </div>
                                                        <div class="timeline-panel">
                                                            <div class="timeline-heading">
                                                                <span class="label label-warning">Another One</span>
                                                            </div>
                                                            <div class="timeline-body">
                                                                <p>Tune into Big Boy's 92.3 I'm about to play the first single from Cruel Winter Tune into Big Boy's 92.3 I'm about to play the first single from Cruel Winter also to Kim�s hair and makeup Lorraine jewelry and the whole style squad at Balmain and the Yeezy team. Thank you Anna for the invite thank you to the whole Vogue team</p>
                                                            </div>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div>
                                <div class="row">
                                    <div class="col-md-10 col-lg-offset-1">
                                        <div class="form-group">
                                            <label>Escribe un mensaje</label>
                                            <div class="form-group label-floating is-empty">
                                                <textarea class="form-control" rows="3" id="txtContenidoMensaje"></textarea>
                                            <span class="material-input"></span></div>
                                        </div>
                                        <button class="btn btn-rose pull-right ingresarMensaje">Enviar</button>
                                    </div>
                                </div>
                            </div>
                        </div>-->
                    </div>
                                    <button class="btn btn-rose pull-right" id="btnEnviarMensaje">Enviar</button>
                </div>
            </div>
        </div>
        <%@include file="../includes/importsJS.jsp" %>
        <script>
            $("#charla").addClass('active');
            $("#nombrepagina").text("Charla tecnica");
            window.onload = function (){
                
                verMensajes();
                //CargarNotificaciones();
            };
            
            $("#btnEnviarMensaje").click(function (){

               alert("Ingresar mensaje con el id XDXDXDXDXDXDXDXDXDX"); 
            });
        </script>
    </body>
</html>

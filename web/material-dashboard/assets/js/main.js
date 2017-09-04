$(document).ready(function(){
    $('.btn-ExitSystem').on('click', function(e){
        e.preventDefault();
        swal({ 
            title: "Cerrar Sesion",   
            text: "¿Estas seguro que deseas cerrar sesion?",   
            type: "warning",   
            showCancelButton: true,   
            confirmButtonColor: "#DD6B55",   
            confirmButtonText: "Si",
            animation: "slide-from-top",   
            closeOnConfirm: false,
            cancelButtonText: "Cancelar"
        }).then(function(){
            $.post("/FutPlayFinal/inicio/cerrar",function (responseText){
                
                if (responseText == "1") {
                    
                    window.location='/FutPlayFinal/material-dashboard/pages/usuario/login.html';
                }
                
            });
            
        });
    }); 
    $('.btn- ').on('click', function(e){
        e.preventDefault();
        swal({   
            title: "What are you looking for?",   
            text: "Write what you want",   
            type: "input",   
            showCancelButton: true,   
            closeOnConfirm: false,   
            animation: "slide-from-top",   
            inputPlaceholder: "Write here",
            confirmButtonText: "Search",
            cancelButtonText: "Cancel" 
        }, function(inputValue){   
            if (inputValue === false) return false;      
            if (inputValue === "") {     swal.showInputError("You must write something");     
            return false   
            }      
            swal("Nice!", "You wrote: " + inputValue, "success"); 
        });    
    });
    //////////// SCRIPT PARA MOSTRAR Y OCULTAR LAS NOTIFICACIONES NOTIFICACION ////////////////////////
    $('.btn-Notification').on('click', function(){
        var NotificationArea=$('.NotificationAreaP');
        if(NotificationArea.hasClass('NotificationArea-showP')){
            NotificationArea.removeClass('NotificationArea-showP');
        }else{
            NotificationArea.addClass('NotificationArea-showP');
        }
    });
   
});
$("#btnRegistrar").click(function (e){
    e.preventDefault();
    swal("¡Bienvenido!", "Ahora haces parte del mundo FutPlay","success");
    
});
//////////////////////////////////////////// REGISTRO DE UNA PERSONA //////////////////////////////////////

//$("#cmbGeneroUsuario").on("change",function(){
//      alert($("#cmbGeneroUsuario").val());
//      alert($("#cmbGeneroUsuario").val());
//});
/*$(".registrarUsuario").click(function (e){
    
    e.preventDefault();
    swal({
        title: "Confirmar datos",
        text: "¿Estas seguro de que todos tus datos son correctos?",
        type: "info",
        showCancelButton: true,
        closeOnConfirm: false,
        showLoaderOnConfirm: true,
      },
      function(){
        setTimeout(function(){
            //alert($("#cmbGeneroUsuario").val());
            var nombre = $("#txtNombreUsuario").val();
            var apellido = $("#txtApellidoUsuario").val();
            var fechaNacimiento = $("#txtFechaNacimientoUsuario").val();
            var telefono = $("#txtTelefonoUsuario").val();
            var genero = $("#cmbGeneroUsuario").val();
            var correo = $("#txtCorreoUsuario").val();
            var usuario = $("#txtUsuario").val();
            var contrasenia = $("#txtContraseniaUsuario").val();
            
                    
            $.post("../../usuario/registrar",{UNombre:nombre,UApellido:apellido,UFechaNacimiento:fechaNacimiento,UTelefono:telefono,UGenero:genero,UCorreo:correo,UUsuario:usuario,UContrasenia:contrasenia},function (responseText){
                
                if(responseText == "1"){
                   
                    window.location = "/FutPlay/PAGES/Jugador/RegistrarJugador.jsp";
                    
                }else{
                    
                    swal("Ocurrio un error", "Lo sentimos tus datos no fueron registrados, por favor intentalo nuevamente.","error");
                     
                }
                
            });
        }, 2000);
    });
 
});
$(".registrarPropietario").on("click",function(e){
    e.preventDefault();
    swal({
        title: "Confirmar datos",
        text: "¿Estas seguro de que todos tus datos son correctos?",
        type: "info",
        showCancelButton: true,
        closeOnConfirm: false,
        showLoaderOnConfirm: true,
      },
      function(){
        setTimeout(function(){
            //alert($("#cmbGeneroUsuario").val());
            var nombre = $("#txtNombreUsuario").val();
            var apellido = $("#txtApellidoUsuario").val();
            var fechaNacimiento = $("#txtFechaNacimientoUsuario").val();
            var telefono = $("#txtTelefonoUsuario").val();
            var genero = $("#cmbGeneroUsuario").val();
            var correo = $("#txtCorreoUsuario").val();
            var usuario = $("#txtUsuario").val();
            var contrasenia = $("#txtContraseniaUsuario").val();
            
                    
            $.post("../../usuario/registrar",{UNombre:nombre,UApellido:apellido,UFechaNacimiento:fechaNacimiento,UTelefono:telefono,UGenero:genero,UCorreo:correo,UUsuario:usuario,UContrasenia:contrasenia},function (responseText){
                
                if(responseText == "1"){
                   
                    swal({
                        title: "¡Bienvenido! Ahora haces parte de la comunidad FutPlay",
                        text: "Inicia sesion y disfruta",
                        type: "success",
                        showCancelButton: false,
                        closeOnConfirm: false,
                        showLoaderOnConfirm: true

                    },function(){

                        window.location = "/FutPlay/GaiaTemplate/index.html";

                    });
                    
                }else{
                    
                    swal("Ocurrio un error", "Lo sentimos tus datos no fueron registrados, por favor intentalo nuevamente.","error");
                     
                }
                
            });
        }, 2000);
    }); 
});*/
////////////////////////////////////////////////////////// EDITAR PERSONA ///////////////////////////////////////////
$(".editarUsuario").click(function (e){
    e.preventDefault();
    swal({
        title: "Actualizar datos",
        text: "¿Estas seguro de que deseas actualizar tus datos?",
        type: "info",
        showCancelButton: true,
        closeOnConfirm: false,
        showLoaderOnConfirm: true,
      },
      function(){
        setTimeout(function(){
                    
            var nombre = $("#txtNombreEditarUsuario").val();
            var apellido = $("#txtApellidoEditarUsuario").val();
            var fechaNacimiento = $("#txtFechaNacimientoEditarUsuario").val();
            var telefono = $("#txtTelefonoEditarUsuario").val();
            var genero = $("#cmbGeneroEditarUsuario").val();
            var correo = $("#txtCorreoEditarUsuario").val();
            var usuario = $("#txtUsuarioEditarUsuario").val();
            var contrasenia = $("#txtContraseniaEditarUsuario").val();
            var avatar = $("#txtAvatarEditarUsuario").val();
            
                    
            $.post("../../usuario/editar",{UNombre:nombre,UApellido:apellido,UFechaNacimiento:fechaNacimiento,UTelefono:telefono,UGenero:genero,UCorreo:correo,UUsuario:usuario,UContrasenia:contrasenia,UAvatar:avatar},function (responseText){
                
                if(responseText == "1"){
                    
                   swal({
                        title: "¡Excelente!",
                        text: "La informacion de tu perfil fue actualizada",
                        type: "success",
                        showCancelButton: false,
                        closeOnConfirm: false,
                        showLoaderOnConfirm: true
                          
                    });
                    
                }else{
                    
                    swal("Ocurrio un error", "Lo sentimos tus datos no fueron registrados, por favor intentalo nuevamente.","error");
                     
                }
                
            });
        }, 2000);
    });
 
});
/////////////////////Funcion para animar los tabs de los formularios//////////////
    function refreshAnimation($wizard, index){
        total_steps = $wizard.find('li').length;
        move_distance = $wizard.width() / total_steps;
        step_width = move_distance;
        move_distance *= index;

        $current = index + 1;

        if($current == 1){
            move_distance -= 8;
        } else if($current == total_steps){
            move_distance += 8;
        }

        $wizard.find('.moving-tab').css('width', step_width);
        $('.moving-tab').css({
            'transform':'translate3d(' + move_distance + 'px, 0, 0)',
            'transition': 'all 0.5s cubic-bezier(0.29, 1.42, 0.79, 1)'

        });
    }
//////////////////////Validacion e inicializacion de formulario con tabs//////////////////
      	$('.wizard-card').bootstrapWizard({
            'tabClass': 'nav nav-pills',
            'nextSelector': '.btn-next',
            'previousSelector': '.btn-previous',

            onNext: function(tab, navigation, index) {
            	var $valid = $('.wizard-card form').valid();
            	if(!$valid) {
            		$validator.focusInvalid();
            		return false;
            	}
            },

            onInit : function(tab, navigation, index){

              //check number of tabs and fill the entire row
              var $total = navigation.find('li').length;
              $width = 100/$total;
              var $wizard = navigation.closest('.wizard-card');

              $display_width = $(document).width();

              if($display_width < 600 && $total > 3){
                  $width = 50;
              }

               navigation.find('li').css('width',$width + '%');
               $first_li = navigation.find('li:first-child a').html();
               $moving_div = $('<div class="moving-tab">' + $first_li + '</div>');
               $('.wizard-card .wizard-navigation').append($moving_div);
               refreshAnimation($wizard, index);
               $('.moving-tab').css('transition','transform 0s');
           },

            onTabClick : function(tab, navigation, index){
                var $valid = $('.wizard-card form').valid();

                if(!$valid){
                    return false;
                } else{
                    return true;
                }
            },

            onTabShow: function(tab, navigation, index) {
                var $total = navigation.find('li').length;
                var $current = index+1;

                var $wizard = navigation.closest('.wizard-card');

                // If it's the last tab then hide the last button and show the finish instead
                if($current >= $total) {
                    $($wizard).find('.btn-next').hide();
                    $($wizard).find('.btn-finish').show();
                } else {
                    $($wizard).find('.btn-next').show();
                    $($wizard).find('.btn-finish').hide();
                }

                button_text = navigation.find('li:nth-child(' + $current + ') a').html();

                setTimeout(function(){
                    $('.moving-tab').text(button_text);
                }, 150);

                var checkbox = $('.footer-checkbox');

                if( !index == 0 ){
                    $(checkbox).css({
                        'opacity':'0',
                        'visibility':'hidden',
                        'position':'absolute'
                    });
                } else {
                    $(checkbox).css({
                        'opacity':'1',
                        'visibility':'visible'
                    });
                }

                refreshAnimation($wizard, index);
            }
      	});
/////////////////////Funcion para recargar avatar, foto del campo y obtener datos////////////////////
    $("#avatarJugador").change(function(){
        readURL(this);
    });
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#wizardPicturePreview').attr('src', e.target.result).fadeIn('slow');
                $("#avatarJugadorNombre").val(input.files[0].name);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }
////////////////////Funciones para validar password email y telefono////////////////7
    $.validator.addMethod("pwcheck1", function(value) {
       return /^[A-Za-z0-9\d=!\-@._*]*$/.test(value) 
           && /[a-z]/.test(value) // evalua que tenga una minuscula como minimo
    });
    $.validator.addMethod("pwcheck2", function(value) {
       return /^[A-Za-z0-9\d=!\-@._*]*$/.test(value) 
           && /\d/.test(value) // evalua que tenga un digito como minimo
    });
    $.validator.addMethod("pwcheck3", function(value) {
       return /^[A-Za-z0-9\d=!\-@._*]*$/.test(value) 
           && /[A-Z]/.test(value) // evalua que tenga una mayuscula como minimo
    });
    $.validator.addMethod("validarEmail", function(value){
       var pattern = /^([a-z\d!#$%&'*+\-\/=?^_`{|}~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+(\.[a-z\d!#$%&'*+\-\/=?^_`{|}~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+)*|"((([ \t]*\r\n)?[ \t]+)?([\x01-\x08\x0b\x0c\x0e-\x1f\x7f\x21\x23-\x5b\x5d-\x7e\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|\\[\x01-\x09\x0b\x0c\x0d-\x7f\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))*(([ \t]*\r\n)?[ \t]+)?")@(([a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|[a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF][a-z\d\-._~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]*[a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])\.)+([a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|[a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF][a-z\d\-._~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]*[a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])\.?$/i;
       return pattern.test(value);
    });
    $.validator.addMethod("validarTelefono", function(value){
       var pattern = /^3[0,1,2,3,5][0-9]{8}$/;
       return pattern.test(value);
    });
////////////////////////////////////////////////////////////// REGISTRO DE UN JUGADOR////////////////////////////////
var $validator = $('#frmJugador').validate({
            rules: {
                nombresJugador:{
                  required:true,
                  minlength:3
                },
                apellidosJugador:{
                    required:true,
                    minlength:3
                },
                fechanacimientoJugador:{
                    required:true
                },
                telefonoJugador:{
                    required:true,
                    validarTelefono:true
                },
                generoJugador:{
                    required:true
                },
                emailJugador:{
                    required:true,
                    validarEmail:true
                },
                passwordJugador:{
                    required:true,
                    minlength:8,
                    maxlength:15,
                    pwcheck1:true,
                    pwcheck2:true,
                    pwcheck3:true
                },
                passwordJugadorConfirm:{
                    equalTo:"#passwordJugador"
                },
                txtAliasJugador:{
                    required:true,
                    minlength:5
                },
                cmbPosicionJugador:{
                    required:true
                },
                cmbPiernaJugador:{
                    required:true
                },
                txtDescripcionJugador:{
                    required:true
                },
                pregunta1:{
                    required:true
                },
                pregunta2:{
                    required:true
                },
                pregunta3:{
                    required:true
                }
        },
        messages:{
            nombresJugador:{
                required:"Ingresa tus nombres",
                minlength:"Ingresa 3 caracteres como minimo"
            },
            apellidosJugador:{
                required:"Ingresa tus apellidos",
                minlength:"Ingresa 3 caracteres como minimo"
            },
            fechanacimientoJugador:{
                required:"Selecciona tu fecha de nacimiento"
            },
            telefonoJugador:{
                required:"Ingresa tu numero telefonico",
                validarTelefono:"Ingresa un numero telefonico valido"
            },
            generoJugador:{
                required:"Selecciona tu genero"
            },
            emailJugador:{
                required:"Ingresa tu correo electronico",
                validarEmail:"Ingresa un correo electronico valido",
                email:"Ingresa un correo electronico valido"
            },
            passwordJugador:{
                required:"Ingresa una contraseña",
                minlength:"Ingresa 8 caracteres como minimo",
                maxlength:"Ingresa 15 caracteres como maximo",
                pwcheck1:"La contraseña debe contener una minuscula como minimo",
                pwcheck2:"La contraseña debe contener un digito como minimo",
                pwcheck3:"La contraseña debe contener una mayuscula como minimo"
            },
            passwordJugadorConfirm:{
                equalTo:"Ambas contraseñas deben coincidir"
            },
            txtAliasJugador:{
                required:"Ingresa tu alias",
                minlength:"Ingresa 5 caracteres como minimo"
            },
            cmbPosicionJugador:{
                required:"Selecciona tu posicion"
            },
            cmbPiernaJugador:{
                required:"Selecciona tu pierna habil"
            },
            txtDescripcionJugador:{
                required:"Danos una breve descripcion sobre ti"
            },
            pregunta1:{
                required:"Selecciona una opcion"
            },
            pregunta2:{
                required:"Selecciona una opcion"
            },
            pregunta3:{
                required:"Selecciona una opcion"
            }
        },
        errorElement : 'div',
        errorPlacement: function(error, element) {
          var placement = $(element).data('error');
          if (placement) {
            $(placement).append(error);
          } else {
            error.insertAfter(element);
          }
        },
        submitHandler: function(){
            var UNombre = $("#nombresJugador").val();
            var UApellido = $("#apellidosJugador").val();
            var UFechaNacimiento = $("#fechanacimientoJugador").val();
            var UTelefono = $("#telefonoJugador").val();
            var UGenero = $("#generoJugador").val();
            var UCorreo = $("#emailJugador").val();
            var UContrasenia = $("#passwordJugador").val();
            var UAvatar = $("#avatarJugadorNombre").val();
            $.ajax({
                    url:"/FutPlayFinal/usuario/verificarEmail",
                    method:"post",
                    dataType:"json",
                    data:{UCorreo:UCorreo}
                }).done(function(data){
                   if(data>"0"){
                       swal({
                           title:"Advertencia",
                           text:"¿Estas seguro de que todo tus datos son correctos?",
                           type:"warning",
                           showCancelButton:true,
                           closeOnConfirm:false,
                           showLoaderOnConfirm:true,
                           cancelButtonText:"Cancelar",
                           confirmButtonText:"Si",
                           preConfirm: function(){
                               setTimeout(function(){                                 
                                   $.ajax({
                                       url:"/FutPlayFinal/usuario/registrar",
                                       method:"post",
                                       data:{UNombre:UNombre,UApellido:UApellido,UFechaNacimiento:UFechaNacimiento,UTelefono:UTelefono,UGenero:UGenero,UCorreo:UCorreo,UContrasenia:UContrasenia,UAvatar:UAvatar},
                                       complete: function(){
                                           ////////Subir Avatar/////////
                                            var data = new FormData();
                                            $.each($('#avatarJugador')[0].files, function(i, file) {
                                                data.append('file-'+i, file);
                                            });
                                            $.ajax({
                                                url: '/FutPlayFinal/uploadAvatar',
                                                data: data,
                                                dataType: 'text',
                                                processData: false,
                                                contentType: false,
                                                type: 'POST'
                                            }); 
                                           /////////Registrar jugador////////
                                           var alias = $("#txtAliasJugador").val();
                                           var posicion = $("#cmbPosicionJugador").val();
                                           var pierna = $("#cmbPiernaJugador").val();
                                           var descripcion = $("#txtDescripcionJugador").val();
                                           var rankingSystem1 = $("#pregunta1").val();
                                           var rankingSystem2 = $("#pregunta2").val();
                                           var rankingSystem3 = $("#pregunta3").val();
                                           $.ajax({
                                              url:"/FutPlayFinal/jugador/registrar",
                                              method:"post",
                                              dataType:"json",
                                              data:{UCorreo:UCorreo,Alias:alias,Posicion:posicion,Pierna:pierna,Descripcion:descripcion,rankingSystem1:rankingSystem1,rankingSystem2:rankingSystem2,rankingSystem3:rankingSystem3}
                                           }).done(function(data){
                                               console.log(data);
                                               $.ajax({
                                                  url:"/FutPlayFinal/notificacion/notificacionregistro"
                                               });
                                           });
                                       }
                                   }).done(function(data){
                                       if(data>"0"){
                                           swal({
                                               title:"Bienvenido!",
                                               text:"Ahora haces parte de la comunidad futplay inicia sesion y disfruta",
                                               type:"success",
                                               preConfirm: function(){
                                                   window.location.href = "/FutPlayFinal/material-dashboard/pages/usuario/login.html";
                                               }
                                           });
                                       }
                                       else{
                                           swal("Error","Ocurrio un error al momento de procesar la solicitud","error");
                                       }
                                   });
                               },2000);
                           }
                       });
                   } 
                   else{
                       swal("Advertencia","El correo electronico que ingresaste ya esta en uso","warning");
                   }
               });
        }
    });
/////////////////////////////////////////////////////////// EDITAR JUGADOR ///////////////////////////////////////
$(".editarJugador").click(function (e){
    
    e.preventDefault();
    swal({
        title: "Actualizar Datos",
        text: "¿Estas seguro de que deseas actualizar tus datos?",
        type: "info",
        showCancelButton: true,
        closeOnConfirm: false,
        showLoaderOnConfirm: true
      }).then(function(){
        setTimeout(function(){
                    
            var alias = $("#txtAliasEditarJugador").val();
            var posicion = $("#cmbPosicionEditarJugador").val(); //$("#cmbPosicionJugador").find("option".val();
            var pierna = $("#cmbPiernaEditarJugador").val(); //$("#cmbPiernaJugador").val();
            var descripcion = $("#txtDescripcionEditarJugador").val();
            //var rankingSystem = "100"; //$("#cmbRankingJugador").val();
            
            $.post("/FutPlayFinal/jugador/editar",{Alias:alias,Posicion:posicion,Pierna:pierna,Descripcion:descripcion},function (responseText){
                
                if(responseText == "1"){
                    
                    swal({
                        title: "¡Excelente!",
                        text: "La informacion de tu perfil de jugador fue actualizada",
                        type: "success",
                        showCancelButton: false,
                        closeOnConfirm: false,
                        showLoaderOnConfirm: true
                          
                    }).then(function (){
                        
                        window.location = "/FutPlayFinal/material-dashboard/pages/jugador/verPerfilJugador.jsp";
                        
                    });
                    
                }else{
                    
                    swal("Ocurrio un error", "Lo sentimos tus datos no fueron registrados, por favor intentalo nuevamente.","error");
                     
                }
                
            });
        }, 2000);
    });
 
});
////////////////////////////////////////////// BUSCAR JUGADOR ////////////////////////////////////
$(".buscarJugador").keyup(function (){
    var valor = $("#txtBuscarJugador").val();
    $.post("/FutPlayFinal/jugador/buscarpersona",{Valor:valor},function (responseText){
        if(responseText == "0" || responseText == ""){
            
            $("#busquedaContainer").html("<p>No se encontraron coincidencias</p>");
            
        }else{

            //$("#btlBuscarJugador").find("tbody").html("");
            $("#busquedaContainer").html(responseText);
        }
        
    });
 
});
///////////////////////////////////////////// FICHAR A UN JUGADOR ////////////////////////////////////
function ficharJugador(url){
    //alert("FNCION FICHARJUGADOR");
    //alert(url);
    var datosJugador = url.split("/");
    //alert(datosJugador[0]);
    swal({
        title: "Fichar Jugador",
        text: "¿Estas seguro de que deseas fichar a "+datosJugador[2]+"?",
        type: "info",
        showCancelButton: true,
        closeOnConfirm: true,
        showLoaderOnConfirm: true,
        
      }).then(function () {
        
        $.post("/FutPlayFinal/jugador/ficharjugador",{recibe:datosJugador[1]},function (responseText) {
            
            if (responseText == "1") {

                $.notify({
                    icon: "perm_identity",
                    message: "No puedes fichar a "+datosJugador[2]+" porque hacen parte del mismo equipo."

                },{
                    type: 'danger',
                    timer: 3000,
                    placement: {
                        from: 'bottom',
                        align: 'right'
                    }
                });

            }else if (responseText == "2") {
                
                $.notify({
                    icon: "perm_identity",
                    message: "Ya le enviaste una notificacion  a "+datosJugador[2]+"."

                },{
                    type: 'danger',
                    timer: 3000,
                    placement: {
                        from: 'bottom',
                        align: 'right'
                    }
                });
                
            }else if (responseText == "3") {

                $.notify({
                    icon: "perm_identity",
                    message: "Se envió una solicitud a "+datosJugador[2]+" para que haga parte de tu equipo."

                },{
                    type: 'success',
                    timer: 2500,
                    placement: {
                        from: 'bottom',
                        align: 'right'
                    }
                });
            }
                
        });
        
    });
}
/////////////////////////////////////////////////////////// AGREGAR JUGADOR A UN EQUIPO ///////////////////////////////////////
function agregarJugador(url){
    
    var datos = url.id.split("/");
    
    
    swal({
        title: "Aceptar Solicitud",
        text: "Estas seguro de que deseas hacer parte del equipo de "+datos[0]+", si en este momento haces parte de un equipo saldras :(",
        type: "warning",
        showCancelButton: true,
        closeOnConfirm: false,
        showLoaderOnConfirm: true
      }).then(function (){
          
          //alert("Este el es then");
          setTimeout(function (){
                
                $.post("/FutPlayFinal/jugador/agregarequipo",{equipo:datos[1]},function (responseText) {
                
                    if (responseText == "1") {

                        $.notify({
                            icon: "speaker_notes_off",
                            message: "Ya haces parte del equipo de "+datos[0]+"."
                        },{
                            type: 'danger',
                            timer: 3000,
                            placement: {
                                from: 'bottom',
                                align: 'right'
                            }
                        });

                    }else if (responseText == "2") {

                        $.notify({
                            icon: "speaker_notes_off",
                            message: "Exelente, ahora haces parte del equipo de "+datos[0]+"."
                        },{
                            type: 'success',
                            timer: 3000,
                            placement: {
                                from: 'bottom',
                                align: 'right'
                            }
                        });
                        window.location = "/FutPlayFinal/material-dashboard/pages/equipo/verEquipo.jsp";
                    }
                
                });
                
            },2000);
      });
}
$(".agregarJugador").click(function (e){
    
    e.preventDefault();
    swal({
        title: "Agregar jugador",
        text: "¿Estas seguro de que deseas fichar a este jugador?",
        type: "info",
        showCancelButton: true,
        closeOnConfirm: false,
        showLoaderOnConfirm: true,
      },
      function(){
        setTimeout(function(){
                    
            var idJugador = $("#lblIdJugador").text();
                    alert(idJugador);
            $.post("../../jugador/agregarequipo",{idJugador:idJugador},function (responseText){
                
                if(responseText == "1"){
                    
                    swal({
                        title: "¡Excelente!",
                        text: "La informacion de tu perfil fue actualizada",
                        type: "success",
                        showCancelButton: false,
                        closeOnConfirm: false,
                        showLoaderOnConfirm: true
                        
//                    },function(){
//                        
//                        //window.location = "/FutPlay/PAGES/Usuario/Login.jsp";
//                        
                    });
                    
                }else{
                    
                    swal("Ocurrio un error", "Lo sentimos tus datos no fueron registrados, por favor intentalo nuevamente.","error");
                     
                }
                
            });
        }, 2000);
    });
 
});
///////////////////////////////////////////// ELIMINAR UN JUGADOR DE UN EQUIPO //////////////////////////////
$(".eliminarJugador").click(function (e){
    e.preventDefault();
    swal({
        title: "Eliminar jugador",
        text: "¿Estas seguro que deseas elmininar este jugador de tu equipo?",
        type: "info",
        showCancelButton: true,
        closeOnConfirm: false,
        showLoaderOnConfirm: true,
      },
      function(){
        setTimeout(function(){
            
            $.post("/FutPlay/jugador/eliminarjugador",{hola:1},function (responseText){
                
                if(responseText == "1"){
                    
                    swal({
                        title: "¡Excelente!",
                        text: "El jugador fue eliminado del quipo",
                        type: "success",
                        showCancelButton: false,
                        closeOnConfirm: false,
                        showLoaderOnConfirm: true
                        
                   },function(){
                        
                        window.location = "/FutPlay/PAGES/Equipo/CrearEquipo.jsp";
                        
                    });
                    
                }else{
                    
                    swal("Ocurrio un error", "Lo sentimos, el jugador no pudo ser eliminado","error");
                     
                }
                
            });
           
        }, 2000);
    });
 
});
/////////////////////////////////////////////// REGISTRAR EQUIPO//////////////////////////////
$(".crearEquipo").click(function (e){
    e.preventDefault();
    swal({
        title: "Crear Equipo",
        text: "¿Estas seguro de que deseas crear un equipo?",
        type: "info",
        showCancelButton: true,
        closeOnConfirm: false,
        showLoaderOnConfirm: true,
        preConfirm:function (){
            
            setTimeout(function(){
                    
            var nombre = $("#txtNombreEquipo").val();
            var ciudad = $("#txtCiudadEquipo").val();
            
            $.post("/FutPlayFinal/equipo/crear",{Nombre:nombre,Ciudad:ciudad},function (responseText){
                
                if(responseText == "1"){
                    
                    swal({
                        title: "¡Excelente!",
                        text: "Tu equipo fue creado, ahora solo falta agregar a tus jugadores",
                        type: "success",
                        showCancelButton: false,
                        closeOnConfirm: false,
                        showLoaderOnConfirm: true
                        
                    }).then(function (){
                        window.location = "/FutPlayFinal/material-dashboard/pages/jugador/verJugadores.jsp";
                    });
                    
                }else if(responseText == "2"){
                    
                    /*swal({
                        title: "Ya perteneces a un quipo",
                        text: "Solo puedes hacer parte de un equipo",
                        type: "error",
                        showCancelButton: false,
                        closeOnConfirm: false,
                        showLoaderOnConfirm: true
                        
                    },function (){
                        
                        window.location = "/FutPlay/PAGES/Equipo/CrearEquipo.jsp";
                        
                    });*/
                    $.notify({
                        icon: "perm_identity",
                        message: "Solo puedes hacer parte de un equipo."

                    },{
                        type: 'danger',
                        timer: 2500,
                        placement: {
                            from: 'bottom',
                            align: 'right'
                        }
                    });
                    
                }else{
                    
                    $.notify({
                        icon: "error",
                        message: "Ocurrió un error mientras estabamos creando tu equipo, por favor intentalo mas tarde."

                    },{
                        type: 'danger',
                        timer: 2500,
                        placement: {
                            from: 'bottom',
                            align: 'right'
                        }
                    });
                    //swal("Ocurrio un error", "Lo sentimos tus datos no fueron registrados, por favor intentalo nuevamente.","error");
                     
                }
                
            });
        }, 2000);
            
        }
        
      });
});
/////////////////////////////////////////////////////////////// EDITAR EQUIPO //////////////////////////////////////////////
$(".editarEquipo").click(function (e){
    e.preventDefault();
    swal({
        title: "Editar Equipo",
        text: "¿Estas seguro de que deseas editar los datos de tu equipo?",
        type: "info",
        showCancelButton: true,
        closeOnConfirm: false,
        showLoaderOnConfirm: true,
        preConfirm:function (){
            
            setTimeout(function(){
            
            var id = $("#lblIdEquipo").text();
            var nombre = $("#txtNombreEditarEquipo").val();
            var ciudad = $("#txtCiudadEditarEquipo").val();
            
            $.post("/FutPlayFinal/equipo/editar",{idEquipo:id,Nombre:nombre,Ciudad:ciudad},function (responseText){
                
                if(responseText == "1"){
                    
                    swal({
                        title: "¡Excelente!",
                        text: "Los datos de tu equipo fueron actualizados",
                        type: "success",
                        showCancelButton: false,
                        closeOnConfirm: false,
                        showLoaderOnConfirm: true
                        
                    }).then(function (){
                        
                        window.location = "/FutPlayFinal/material-dashboard/pages/equipo/verEquipo.jsp";
                        
                    });
                    
                }else{
                    
                    swal("Ocurrio un error", "Lo sentimos tus datos no fueron registrados, por favor intentalo nuevamente.","error");
                     
                }
                
            });
        }, 2000);
            
        }
      });
 
});
/////////////////////////////////////////////// VER MENSAJES ////////////////////////////////////////////
function verMensajes (){
    alert("Pta mierda");
    $.ajax({
        async: true,
        type: 'POST',
        url: "/FutPlayFinal/mensaje/vermensajes",
        cache: false
    }).done(function (responseText){
        if (responseText === "0") {
            
            $("#containercharla").html("<div class='col-md-8 col-md-offset-2'>"
                                            +"<div class='card card-profile'>"
                                                +"<div class='card-header card-header-icon' data-background-color='rose'>"
                                                    +"<i class='material-icons'>message</i>"
                                                +"</div>"
                                                +"<div class='card-content'>"
                                                    +"<div class='clearfix'></div>"
                                                    +"<h6 class='category text-gray'>¿No tienes mensajes?</h6>"
                                                    +"<h4 class='card-title'>FutPlay te informa</h4>"
                                                    +"<p class='description'>"
                                                        +"Hola, por el momento no haces parte de un equipo. Nos gustaria que crearass tu propio equipo con el que podras competir en los torneo, on en su defecto pidele a un amigo que te agregue su equipo :)."
                                                    +"</p>"
                                                    +"<a href='/FutPlayFinal/material-dashboard/pages/equipo/verEquipo.jsp' class='btn btn-rose btn-round'>Ir a crear equipo</a>"
                                                +"</div>"
                                            +"</div>"
                                        +"</div>");
            
            $.notify({
            icon: "speaker_notes_off",
            message: "No tienes mensajes, tus mensajes apareceran cuando hagas parte de un equipo."
            },{
                type: 'warning',
                timer: 2500,
                placement: {
                    from: 'bottom',
                    align: 'right'
                }
            });

        }else if (responseText === "1") {

            swal({
                title: "Ocurrio un error",
                text: "Los mensajes no cargaron, por favor revisa tu conexion e intentalo de nuevo",
                type: "error",
                showCancelButton: false,
                closeOnConfirm: false,
                showLoaderOnConfirm: true
            },function (){

                window.location = "/FutPlayFinal/jugador/indexJugador.jsp";
            });
        }else if(responseText == "2"){
            
            $.notify({
            icon: "speaker_notes_off",
            message: "Al parecer aun no tienes mensajes en tu bandeja de entrada."
            },{
                type: 'danger',
                timer: 2500,
                placement: {
                    from: 'bottom',
                    align: 'right'
                }
            });
            $("#containercharla").html("<div class='col-md-12'>"
                                            +"<div class='card'>"
                                                +"<div class='card-header card-header-icon' data-background-color='rose'>"
                                                    +"<i class='material-icons'>perm_identity</i>"
                                                +"</div>"
                                                +"<div class='card-content'>"
                                                    +"<h4 class='card-title'>Mensajes - <small class='category'>Mensajes enviados</small></h4>"
                                                    +"<div class='card-content' id='mensajesContainer' style='height:200px;overflow-y:scroll;background-color: #e7e6e6;'>"
                                                        +"<ul class='timeline' id='mensajes'>"
                                                        +"</ul>"
                                                    +"</div>"
                                                    +"<div class='row'>"
                                                        +"<div class='col-md-10 col-lg-offset-1'>"
                                                            +"<div class='form-group'>"
                                                                +"<label>Escribe un mensaje</label>"
                                                                +"<div class='form-group is-empty'>"
                                                                    +"<textarea class='form-control' rows='3' id='txtContenidoMensaje'></textarea>"
                                                                    +"<span class='material-input'></span>"
                                                                +"</div>"
                                                            +"</div>"
                                                            +"<button class='btn btn-rose pull-right ingresarMensaje' id='btnEnviarMensaje'>EnviarSinMensajes</button>"
                                                        +"</div>"
                                                    +"</div>"
                                                +"</div>"
                                            +"</div>"
                                       +"</div>");

            $("#mensajes").html("");
            $("#mensajes").append("No tienes mensajes :(");
            
        }else{

            $("#containercharla").html("<div class='col-md-12'>"
                                            +"<div class='card'>"
                                                +"<div class='card-header card-header-icon' data-background-color='rose'>"
                                                    +"<i class='material-icons'>perm_identity</i>"
                                                +"</div>"
                                                +"<div class='card-content'>"
                                                    +"<h4 class='card-title'>Mensajes - <small class='category'>Mensajes enviados</small></h4>"
                                                    +"<div class='card-content' id='mensajesContainer' style='height:200px;overflow-y:scroll;background-color: #e7e6e6;'>"
                                                        +"<ul class='timeline' id='mensajes'>"
                                                        +"</ul>"
                                                    +"</div>"
                                                    +"<div class='row'>"
                                                        +"<div class='col-md-10 col-lg-offset-1'>"
                                                            +"<div class='form-group'>"
                                                                +"<label>Escribe un mensaje</label>"
                                                                +"<div class='form-group is-empty'>"
                                                                    +"<textarea class='form-control' rows='3' id='txtContenidoMensaje'></textarea>"
                                                                    +"<span class='material-input'></span>"
                                                                +"</div>"
                                                            +"</div>"
                                                            +"<button class='btn btn-rose pull-right ingresarMensaje' id='btnEnviarMensaje'>EnviarConMSJ</button>"
                                                        +"</div>"
                                                    +"</div>"
                                                +"</div>"
                                            +"</div>"
                                       +"</div>");

            $("#mensajes").html("");
            $("#mensajes").append(responseText);
            
            var div_msg = document.getElementById('mensajesContainer');
            div_msg.scrollTop = div_msg.scrollHeight;
            //setTimeout('verMensajes()',5000);

        }

    });

};
/////////////////////////////////////////////////// INGRESAR MENSAJE ////////////////////////////////////////
$(".ingresarMensaje").click(function (){
    var contenido = $("#txtContenidoMensaje").val();
    //$("#txtContenidoMensaje").text("");
    alert("enviandoMensaje..." + contenido);
    $.post("/FutPlayFinal/mensaje/ingresarmesaje",{contenido:contenido},function (responseText){
        
        if (responseText == 0) {
            swal("No puedes enviar mensajes", "Para poder enviar mensajes primero deves hacer parte de un equipo","error");
        }else if (responseText == 2) {
            swal("Ocurrio un error", "Lo sentimos, tu mensaje no fue enviado por favor revisa tu conexion e intentalo de nuevo.","error");
        }
        
    });
    
});
////////////////////////////////////////////////// VER NOTIFICACIONES ////////////////////////////////////////////
$(".verNotificaciones").click(function (){
    $.post("/FutPlayFinal/notificacion/vernotificaciones",function (responseText){
   
        $("#notificacionesContenedor").html("");
        $("#notificacionesContenedor").append(responseText);
        
    });
    
});
//////////////////////////////////////// DEJAR EN VISTO LAS NOTIFICACIONES //////////////////////////////////
$(".actualizarNotificaciones").click(function (){
   
    $.post("/FutPlayFinal/notificacion/vistonotificacion",function (responseText){
        
        if(responseText === "1"){
            
            CargarNotificaciones();
            
        }
        
    });
    
});
///////////////////////////////////////// CARGAR NOTIFICACIONES ///////////////////////////////////
window.onload = function (){
    
    //CargarNotificaciones();
};
function CargarNotificaciones (){
    
    $.ajax({
        async: true,
        type: 'POST',
        url: "/FutPlayFinal/notificacion/cargarnotificaciones",
        cache:false
    }).done(function (responseText){
        
        $("#numeroNotificacionesContainer").html(responseText);
        //ESTAR PERDIENE DE VOLVER A DESCOMENTAR ESTE TIMEOUT -> setTimeout('CargarNotificaciones()',10000);
        
    });
};
////////////////////////////////////////// TABS //////////////////////////
$("#registrarUsuario").click(function (){
    
    var x = $("#lol2").css({class: "Active"});
    alert("click " + x.toString());
});
/////////////////////////////////Iniciar sesion//////////////////////
/////////////////////////////////Iniciar sesion//////////////////////
$(".btnIniciarSesion").on("click",function(){
    $("#frmLogin").validate({
        rules:{
            txtEmailLogin:{
                required:true,
                email:true
            },
            txtContraseniaLogin:{
                required:true
            }
        },
        messages:{
            txtEmailLogin:{
                required:"",
                email:""
            },
            txtContraseniaLogin:{
                required:""
            }
        },
        errorElement : 'div',
        errorPlacement: function(error, element) {
          var placement = $(element).data('error');
          if (placement) {
            $(placement).append(error);
          } else {
            error.insertAfter(element);
          }
        },
        submitHandler:function(){
            var email = $("#txtEmailLogin").val();
            var contrasenia = $("#txtContraseniaLogin").val();
            $.post("/FutPlayFinal/inicio/iniciar",{email:email,pass:contrasenia},function (responseText) {
                if(responseText=="indexJugador"){
                   
                    window.location.href = "/FutPlayFinal/material-dashboard/pages/jugador/indexJugador.jsp";
                }
                else if(responseText=="indexPropietario"){
                    window.location.href = "/FutPlayFinal/material-dashboard/pages/propietario/indexPropietario.jsp";
                }
                else{
                    swal("Error","Usuario o contraseña incorrectos","error");
                }
            });
        }
   });
});
//////////////////////////////////// VER Y VERIFICAR SI TIENE O NO EQUIPO /////////////////////////////////
function verEquipo(){
    $.getJSON("/FutPlayFinal/equipo/verequipo",function(responseText){
        $("#divEquipo").html("");
        $.each(responseText,function (i,item){
            if(item.Nombre == "FutPlay"){
                
               $.notify({
                        icon: "people",
                        message: "La informacion de tu equipo aparecerá cuando hagas parte de uno."
                    },{
                    type: 'warning',
                    timer: 2500,
                    placement: {
                        from: 'bottom',
                        align: 'right'
                    }
                });
                  $("#contenedorEquipo").html("<div class='col-md-8 col-md-offset-2'>"
                                                    +"<div class='card card-profile'>"
                                                        +"<div class='card-header card-header-icon' data-background-color='rose'>"
                                                            +"<i class='material-icons'>people</i>"
                                                        +"</div><div class='card-content'>"
                                                        +"<div class='clearfix'>"
                                                        +"</div>"
                                                        +"<h6 class='category text-gray'>¿No tienes equipo?</h6>"
                                                        +"<h4 class='card-title'>FutPlay te informa</h4>"
                                                        +"<p class='description'>Hola, por el momento no haces parte de un equipo. Nos gustaria que crearass tu propio equipo con el que podras competir en los torneo, on en su defecto pidele a un amigo que te agregue su equipo :).</p>"
                                                        +"<button class='btn btn-rose btn-round crearEquipo' data-toggle='modal' data-target='#noticeModal'>Crear equipo</button>"
                                                    +"</div>"
                                                +"</div>"
                                            +"</div>");
            }else{
                $("#nombreEquipo").text(item.Nombre);
                $.post("/FutPlayFinal/jugador/verjugadores",function (response){
                        
                    $("#contenedorEquipo").html("<div class='row'>"
                                                    +"<div class='col-md-12'>"
                                                        +"<div class='card card-product'>"
                                                            +"<div class='card-image' data-header-animation='true'>"
                                                                +"<img src='../../assets/img/jugadorimg/Manchester-City-stats1.png' class='responsive-img'>"
                                                                +"<span class='card-title'>"+item.Nombre+"</span>"
                                                                +"<div class='ripple-container'></div>"
                                                            +"</div>"
                                                            +"<div class='card-content'>"
                                                                +"<div class='card-actions'>"
                                                                    +"<a class='btn btn-danger btn-simple fix-broken-card' rel='tooltip' data-placement='bottom' data-original-title='Ver de nuevo'>"
                                                                        +"<i class='material-icons' style='font-size:30px;'>replay</i>"
                                                                    +"</a>"
                                                                    +"<a href='#editarEquipo' data-toggle='modal' class='btn btn-warning btn-simple' rel='tooltip' data-placement='bottom' title='' data-original-title='Editar equipo'>"
                                                                        +"<i class='material-icons' style='font-size:30px;'>mode_edit</i>"
                                                                        +"<div class='ripple-container'></div>"
                                                                    +"</a>"
                                                                +"</div>"
                                                                +"<div class='card-description' id='jugadoesEquipo'>"
                                                                +"</div>"
                                                            +"</div>"
                                                        +"</div>"
                                                    +"</div>"
                                                +"</div>");
                    $("#jugadoesEquipo").html(response);
                    $("#lblIdEquipo").text(item.idEquipo);
                    $("#txtNombreEditarEquipo").val(item.Nombre);
                    $("#txtCiudadEditarEquipo").val(item.Ciudad);

                });
            };

        });
    });
};
/////////////////////////////// VER JUGADORES DEL EQUIPO ///////////////////////////
function JugadoresVer(){
    
    $.post("/FutPlayFinal/jugador/verjugadores",function (responseText){
        
        if (responseText == "0") {
        
            $.notify({
                icon: "perm_identity",
                message: "Los jugadores y su informacion apareceran cuando hagas parte de un equipo."

            },{
                type: 'warning',
                timer: 2500,
                placement: {
                    from: 'bottom',
                    align: 'right'
                }
            });
            $("#contenedorJugadores").html("<div class='col-md-8 col-md-offset-2'>"
                                            +"<div class='card card-profile'>"
                                                +"<div class='card-header card-header-icon' data-background-color='rose'>"
                                                    +"<i class='material-icons'>perm_identity</i>"
                                                +"</div>"
                                                +"<div class='card-content'>"
                                                    +"<div class='clearfix'></div>"
                                                    +"<h6 class='category text-gray'>¿No hay jugadores?</h6>"
                                                    +"<h4 class='card-title'>FutPlay te informa</h4>"
                                                    +"<p class='description'>"
                                                        +"Hola, por el momento no haces parte de un equipo. Nos gustaria que crearass tu propio equipo con el que podras competir en los torneo, on en su defecto pidele a un amigo que te agregue su equipo :)."
                                                    +"</p>"
                                                    +"<a href='/FutPlayFinal/material-dashboard/pages/equipo/verEquipo.jsp' class='btn btn-rose btn-round'>Ir a crear equipo</a>"
                                                +"</div>"
                                            +"</div>"
                                        +"</div>");
            
        }else{
            
            $("#contenedorJugadores").html("<div class='row'>"  
                                                +"<div class='col-md-12'>"
                                                    +"<div class='card card-product'>"
                                                        +"<div class='card-image' data-header-animation='true'>"
                                                            +"<img src='../../assets/img/jugadorimg/messi.png' class='responsive-img'>"
                                                            +"<span class='card-title'>Jugadores</span>"
                                                            +"<div class='ripple-container'></div>"
                                                        +"</div>"
                                                        +"<div class='card-content'>"
                                                            +"<div class='card-actions'>"
                                                                +"<a class='btn btn-danger btn-simple fix-broken-card' rel='tooltip' data-placement='bottom' title='' data-original-title='Ver de nuevo'>"
                                                                    +"<i class='material-icons' style='font-size:30px;'>replay</i>"
                                                                    +"<div class='ripple-container'></div>"
                                                                +"</a>"
                                                                +"<a href='#' data-toggle='modal' data-target='#noticeModal' class='btn btn-info btn-simple' rel='tooltip' data-placement='bottom' title='' data-original-title='Agregar nuevo jugador'>"
                                                                    +"<i class='material-icons' style='font-size:30px;'>add_circle</i>"
                                                                    +"<div class='ripple-container'></div>"
                                                                +"</a>"
                                                            +"</div>"
                                                            +"<div class='card-description' id='JugadoresVer'>"
                                                            +"</div>"
                                                        +"</div>"
                                                    +"</div>"
                                                +"</div>"
                                            +"</div>");
            $("#JugadoresVer").html(responseText);  
        }
        
    });
    
}
//////////////////////////////////// DAR LIKE A UN JUGADOR ///////////////////////
$(".likeJugador").click(function (){
    $.post("/FutPlayFinal/jugador/likejugador",function (responseText){
        
        if (responseText == "1") {
            
            $.notify({
                icon: "perm_identity",
                message: "Solo puedes dar like una vez al jugador."

            },{
                type: 'danger',
                timer: 2500,
                placement: {
                    from: 'bottom',
                    align: 'right'
                }
            });
            
        }else if (responseText =="2") {
            
            $.notify({
                icon: "perm_identity",
                message: "La calificacion del jugador fue exitosa."

            },{
                type: 'success',
                timer: 2500,
                placement: {
                    from: 'bottom',
                    align: 'right'
                }
            });
        }
        
    });
    
});
////////////////////////////////// DAR DISLIKE A UN JUGADOR //////////////////////////
$(".dislikeJugador").click(function (){
    
    $.post("/FutPlayFinal/jugador/dislikejugador",function (responseText){
        
        if (responseText == "1") {
            $.notify({
                icon: "perm_identity",
                message: "Solo puedes dar like una vez al jugador."

            },{
                type: 'danger',
                timer: 2500,
                placement: {
                    from: 'bottom',
                    align: 'right'
                }
            });
        }else if (responseText == "2") {
            
            $.notify({
                icon: "perm_identity",
                message: "La calificacion del jugador fue exitosa."

            },{
                type: 'success',
                timer: 2500,
                placement: {
                    from: 'bottom',
                    align: 'right'
                }
            });
            
            //window.location='/FutPlayFinal/material-dashboard/pages/jugador/verJugador.jsp';
        }
        
    });
    
});
////////////////////// BUSCCAR EQUIPOS SEGUN EL TIPO DE ENCUENTRO /////////////////////////
$(".buscarEquipoEncuentro").click(function (){
    alert("click");
    var tipo = $("#tipoEncuentro").val();
    $.getJSON("/FutPlayFinal/equipo/buscarEquipoEncuentro",{tipo:tipo},function (responseText){
        
        alert(responseText);
        //var jsonData = JSON.parse(responseText.data);
        console.log(responseText);
    });
    
});
function carajo(e){
    alert(e);
}
function NoEquipo(from, align){
    
    type = ['','info','success','warning','danger','rose','primary'];
    color = Math.floor((Math.random() * 6) + 1);

    $.notify({
            icon: "notifications",
            message: "La informacion de tu equipo aparecerá cuando hagas parte de uno."

    },{
        type: 'warning',
        timer: 2500,
        placement: {
            from: from,
            align: align
        }
    });
}





////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////7Verificar si el equipo esta Disponible
    $(".btnEquipo").on('click',function (e){
    e.preventDefault();
    swal({
        title: "Enfrentrar Equipo",
        text: "Esta seguro de enfrentar este equipo",
        type: "info",
        showCancelButton: true,
        closeOnConfirm: true,
        showLoaderOnConfirm: true,
    }).then(function (){
        
        setTimeout(function(){
          var id = $("#idEquipo").val();
                       
            $.post("/FutPlay/equipo/listarEquipo",{id:id},function (responseText){
                
                if(responseText == "1"){
                    
                    $.notify({
                        icon: "perm_identity",
                        message: "La solicitud del encuentro ha sido enviada exitosamente."

                    },{
                        type: 'success',
                        timer: 2500,
                        placement: {
                            from: 'bottom',
                            align: 'right'
                        }
                    });
                    
                }else{
                    
                    $.notify({
                        icon: "perm_identity",
                        message: "Al parecer este equipo no esta disponible para el tipo de encuentro que elegiste :("

                    },{
                        type: 'danger',
                        timer: 3000,
                        placement: {
                            from: 'bottom',
                            align: 'right'
                        }
                    });
                    
                }
                
            });
        }, 2000);
        
    });
 
});
/////////////////////////////////////77 VERIFICAR EL EQUIPO PARA EL ENCUENTRO /////////////////
$('.btnCampo').on('click',function(e){
    
    var idCampo = $(this).attr("value");
    var tipo =$('#tipo').val();

    $.ajax({
       url:"/FutPlayFinal/canchas/listarCanchas",
       method:"post",
       data:{idCampo:idCampo,tipo:tipo}
    }).done(function(data){
       localStorage.setItem('JSONProd', JSON.stringify(data));
      // location.href = "/FutPlayFinal/material-dashboard/pages/encuentro/registrarEncuentros.jsp"; 
    });
 });
 
 //////////// FUNCIONES PARA DEFINIR LOS VALORES PRINCIPALES DEL ENCUENTRO ///////7
 
 //// ESTABLECEMOS LAS VARIABLES QUE VAMOS A USAR ////
 var tipoSelect = 0;
 var equipoSelect = 0;
 var campoSelect = 0;
 function tipoSeleccionado(e){
     
     tipoSelect = e;
 }
 function equipoSeleccionado(e){
     
     equipoSelect = e.value;
 }
 function campoSeleccionado(e){
     
     campoSelect = e.value;
     
 }
 ////////////////////////////// HACER EL REGISTRO DEL ENCUENTRO ///////////////////////////
 $(".ingresarEncuentro").click(function (){
     
     /// VEMOS LOS VALORES SELECCIONADOS //////
    if (tipoSelect == 0 || equipoSelect == 0 || campoSelect == 0) {
        
         $.notify({
            icon: "perm_identity",
            message: "Para ingresar el encuentro primero debes completar todos los datos."

        },{
            type: 'danger',
            timer: 3000,
            placement: {
                from: 'bottom',
                align: 'right'
            }
        });
    }else{
        
        $.post("/FutPlayFinal/encuentros/ingresarencuentro",{tipo:tipoSelect,equipo:equipoSelect,campo:campoSelect},function (responseText) {
       
            if (responseText == "1") {

                $.notify({
                    icon: "perm_identity",
                    message: "La solicitud del encuentro ha sido enviada exitosamente."

                },{
                    type: 'success',
                    timer: 2500,
                    placement: {
                        from: 'bottom',
                        align: 'right'
                    }
                });

            }else if (responseText == 2) {

                $.notify({
                    icon: "perm_identity",
                    message: "Al parecer este equipo que elegiste no esta disponible este tipo de encuentro."

                },{
                    type: 'danger',
                    timer: 3000,
                    placement: {
                        from: 'bottom',
                        align: 'right'
                    }
                });

            }else if (responseText == "3") {
                
                $.notify({
                    icon: "perm_identity",
                    message: "Al parecer tu equipo no esta disponible para el tipo de encuentro que elegiste."

                },{
                    type: 'danger',
                    timer: 3000,
                    placement: {
                        from: 'bottom',
                        align: 'right'
                    }
                });
                
            }
        });
        
    }
    
 });
 ////////////////////////// ACEPTAR LA SOLICITUD PARA UN ENCUENTRO //////////////////////////
 function aceptarEncuentro(e){
     
    var informacion = e.id.split("/");

    swal({
       title: "Aceptar Encuentro",
       text: "¿Estas seguro que deseas enfrentarte al equipo "+informacion[0]+"?",
       type: "warning",
       showCancelButton: true,
       closeOnConfirm: false,
       showLoaderOnConfirm: true
     }).then(function (){

        $.post("/FutPlayFinal/encuentros/aceptarencuentro",{equipo:informacion[1],campo:informacion[2],tipo:informacion[3]},function (responseText) {
           
            alert(responseText);
            
        });
         
     });
     
 }
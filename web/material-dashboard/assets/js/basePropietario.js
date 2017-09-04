$(document).ready(function(){
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
    $("#avatarPropietario").change(function(){
        readURL(this);
    });
    $("#avatarPropietarioUP").change(function(){
        readURL(this);
    });
    $("#fotocampoupload").change(function(){
        readURL(this); 
    });
    $("#fotocampouploadUP").change(function(){
        readURL(this); 
    });
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#wizardPicturePreview').attr('src', e.target.result).fadeIn('slow');
                $("#avatarFotoNombre").val(input.files[0].name);
                $("#campoFotoNombre").val(input.files[0].name);
                $("#campoFotoNombreUP").val(input.files[0].name);
                $("#avatarPropietarioNombreUP").val(input.files[0].name);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }
////////////////////////Registro de un propietario///////////////////
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
    var $validator = $('#frmPropietario').validate({
            rules: {
                nombresPropietario:{
                    required:true,
                    minlength:3
                },
                apellidosPropietario:{
                    required:true,
                    minlength:3
                },
                fechanacimientoPropietario:{
                    required:true
                },
                telefonoPropietario:{
                    required:true,
                    validarTelefono:true
                },
                generoPropietario:{
                    required:true
                },
                emailPropietario:{
                    required:true,
                    validarEmail:true
                },
                passwordPropietario:{
                    required:true,
                    minlength:8,
                    maxlength:15,
                    pwcheck1:true,
                    pwcheck2:true,
                    pwcheck3:true
                },
                passwordPropietarioConfirm:{
                    equalTo:"#passwordPropietario"
                }
        },
        messages:{
            nombresPropietario:{
                required:"Ingresa tus nombres",
                minlength:"Ingresa 3 caracteres como minimo"
            },
            apellidosPropietario:{
                required:"Ingresa tus apellidos",
                minlength:"Ingresa 3 caracteres como minimo"
            },
            fechanacimientoPropietario:{
                required:"Selecciona tu fecha de nacimiento"
            },
            telefonoPropietario:{
                required:"Ingresa tu numero telefonico",
                validarTelefono:"Ingresa un numero telefonico valido"
            },
            generoPropietario:{
                required:"Selecciona tu genero"
            },
            emailPropietario:{
                required:"Ingresa tu correo electronico",
                validarEmail:"Ingresa un correo electronico valido",
                email:"Ingresa un correo electronico valido"
            },
            passwordPropietario:{
                required:"Ingresa una contraseña",
                minlength:"Ingresa 8 caracteres como minimo",
                maxlength:"Ingresa 15 caracteres como maximo",
                pwcheck1:"La contraseña debe contener una minuscula como minimo",
                pwcheck2:"La contraseña debe contener un digito como minimo",
                pwcheck3:"La contraseña debe contener una mayuscula como minimo"
            },
            passwordPropietarioConfirm:{
                equalTo:"Ambas contraseñas deben coincidir"
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
            var UNombre = $("#nombresPropietario").val();
            var UApellido = $("#apellidosPropietario").val();
            var UFechaNacimiento = $("#fechanacimientoPropietario").val();
            var UTelefono = $("#telefonoPropietario").val();
            var UGenero = $("#generoPropietario").val();
            var UCorreo = $("#emailPropietario").val();
            var UContrasenia = $("#passwordPropietario").val();
            var UAvatar = $("#avatarFotoNombre").val();
            $.ajax({
                    url:"/FutPlayFinal/usuario/verificarEmail",
                    method:"post",
                    dataType:"json",
                    data:{UCorreo:UCorreo}
                }).done(function(data){
                   if(data>"0"){
                       swal({
                           title:"Advertencia",
                           text:"Estas seguro de que todo tus datos son correctos?",
                           type:"warning",
                           showCancelButton:true,
                           closeOnConfirm:false,
                           showLoaderOnConfirm:true,
                           cancelButtonText:"Cancelar",
                           confirmButtonText:"Sí",
                           preConfirm: function(){
                               setTimeout(function(){                                 
                                   $.ajax({
                                       url:"/FutPlayFinal/usuario/registrar",
                                       method:"post",
                                       data:{UNombre:UNombre,UApellido:UApellido,UFechaNacimiento:UFechaNacimiento,UTelefono:UTelefono,UGenero:UGenero,UCorreo:UCorreo,UContrasenia:UContrasenia,UAvatar:UAvatar},
                                       complete: function(){
                                           ////////Subir Avatar/////////
                                            var data = new FormData();
                                            $.each($('#avatarPropietario')[0].files, function(i, file) {
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
                                           /////////Registrar propietario////////
                                           $.ajax({
                                              url:"/FutPlayFinal/propietario/registrar",
                                              method:"post",
                                              dataType:"json",
                                              data:{UCorreo:UCorreo}
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
////////////Validacion y registro de un campo/////////////
    $("#frmRCampo").validate({
        rules:{
            nombrecampo:{
                required: true,
                minlength: 5
            },
            direccioncampo:{
                required:true,
                minlength:5
            },
            horarioatencionabre:{
                required:true
            },
            horarioatencioncierre:{
                required:true
            }
        },
        messages:{
            nombrecampo:{
                required: "Ingresa un nombre para tu campo",
                minlength: "Ingresa 5 caracteres como minimo"
            },
            direccioncampo:{
                required:"Ingresa una direccion para tu campo",
                minlength:"Ingresa 5 caracteres como minimo"
            },
            horarioatencionabre:{
                required:"Ingresa un horario de apertura"
            },
            horarioatencioncierre:{
                required:"Ingresa un horario de cierre"
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
            swal({
                title:"Confimar datos",
                text:"¿Estas seguro de que todos tus datos son correctos?",
                type:"info",
                confirmButtonText:"Sí",
                cancelButtonText:"Cancelar",
                showCancelButton:true,
                closeOnConfirm:false,
                showLoaderOnConfirm:true,
                preConfirm: function(){
                    setTimeout(function(){
                        var nombrecampo = $("#nombrecampo").val();
                        var direccioncampo = $("#direccioncampo").val();
                        var horarioapertura = $("#horarioatencionabre").val();
                        var horariocierre = $("#horarioatencioncierre").val();
                        var fotocampo = $("#campoFotoNombre").val();
                        function getUbicacion(ubicacionGmap){
                            var geocoder = new google.maps.Geocoder();
                            geocoder.geocode({ 'address': direccioncampo}, function (results, status) {
                                if (status === google.maps.GeocoderStatus.OK) {
                                    var ubicacionLatLng = results[0].geometry.location.lat()+"/"+results[0].geometry.location.lng();
                                    ubicacionGmap(ubicacionLatLng);
                                }
                                else {
                                    alert("Ubicacion no encontrada razon: " + status);
                                }
                            });
                        }
                        getUbicacion(function(ubi){                       
                            var data = new FormData();
                            $.each($('#fotocampoupload')[0].files, function(i, file) {
                                 data.append('file-'+i, file);
                            });
                            $.ajax({
                                url: '/FutPlayFinal/uploadfiles',
                                data: data,
                                dataType: 'text',
                                processData: false,
                                contentType: false,
                                type: 'POST'
                            });

                            $.ajax({
                                url:"/FutPlayFinal/campos/registrarcampo",
                                type:"post",
                                data:{nombrecampo:nombrecampo,direccioncampo:direccioncampo,ubicacion:ubi,horarioapertura:horarioapertura,horariocierre:horariocierre,fotocampo:fotocampo},
                                cache:false
                            }).done(function(rt){          
                                if(rt!=="0"){
                                    swal({
                                        title:"Exito",
                                        text:"Campo registrado exitosamente!",
                                        type:"success",
                                        closeOnConfirm:true,
                                        showCancelButton:true,
                                        preConfirm: function(){
                                           window.location="/FutPlayFinal/material-dashboard/pages/campo/administrarCampo.jsp";   
                                        }
                                    });
                                    $("#nombrecampo").val("");
                                    $("#direccioncampo").val("");
                                    $("#horarioatencionabre").val("");
                                    $("#horarioatencioncierre").val("");
                                }
                                else{
                                    swal("Error!","Ocurrio un error al momento de procesar la solicitud","error");
                                }
                            });
                        });
                    },2000);
                }
            });
        }                  
    });
/////////////Peticion de ajax para eliminar un campo////////////////////
    $('.eliminarCampo').on('click',function(e){
       e.preventDefault();
       var idcampo = $(this).attr("value");
       swal({ 
            title: "Advertencia",   
            text: "Si eliminas este campo las canchas que poseas en este serán eliminadas de la misma forma!",   
            type: "warning",   
            showCancelButton: true,   
            confirmButtonColor: "#DD6B55",   
            confirmButtonText: "Sí",
            animation: "slide-from-top",   
            closeOnConfirm: false,
            cancelButtonText: "Cancelar",
            showLoaderOnConfirm:true,
            preConfirm: function(){
                setTimeout(function(){
                    $.ajax({
                        url:"/FutPlayFinal/campos/eliminar",
                        method:"post",
                        data:{idcampo:idcampo}
                    }).done(function(rt){
                        if(rt!=="0"){
                            swal({
                                title:"Exito",
                                text:"Campo elimiado exitosamente",
                                type:"success",
                                preConfirm: function(){
                                    window.location.href="/FutPlayFinal/material-dashboard/pages/campo/administrarCampo.jsp";    
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
    });
////////////////////Mapa del campo///////////////////////
    $(".btnMapCampo").on("click", function(){
        var coordenadas = $(this).val().split("/");
        $(".btnMapCampo").each(function(){
            $("#mapModal").modal("show");
            $('#map-canvas').addClass('loading');    
              var latlng = new google.maps.LatLng(coordenadas[0] ,coordenadas[1]); 
              var settings = {
                  zoom: 16,
                  center: latlng,
                  mapTypeId: google.maps.MapTypeId.ROADMAP,
                  mapTypeControl: false,
                  scrollwheel: false,
                  draggable: true,
                  styles: [{"featureType":"landscape.natural","elementType":"geometry.fill","stylers":[{"visibility":"on"},{"color":"#e0efef"}]},{"featureType":"poi","elementType":"geometry.fill","stylers":[{"visibility":"on"},{"hue":"#1900ff"},{"color":"#c0e8e8"}]},{"featureType":"road","elementType":"geometry","stylers":[{"lightness":100},{"visibility":"simplified"}]},{"featureType":"road","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"transit.line","elementType":"geometry","stylers":[{"visibility":"on"},{"lightness":700}]},{"featureType":"water","elementType":"all","stylers":[{"color":"#7dcdcd"}]}],
                  mapTypeControlOptions: {style: google.maps.MapTypeControlStyle.DROPDOWN_MENU},
                  navigationControl: false,
                  navigationControlOptions: {style: google.maps.NavigationControlStyle.SMALL},           
              };
              var map = new google.maps.Map(document.getElementById("map-canvas"), settings);

              google.maps.event.addDomListener(window, "resize", function() {
                  var center = map.getCenter();
                  google.maps.event.trigger(map, "resize");
                  map.setCenter(center);
                  $('#map-canvas').removeClass('loading');
              });


              var campoImage = new google.maps.MarkerImage('/FutPlayFinal/material-dashboard/assets/img/map-marker.png',
                  new google.maps.Size(36,62),
                  new google.maps.Point(0,0),
                  new google.maps.Point(18,52)
              );

              var campoPos = new google.maps.LatLng(coordenadas[0],coordenadas[1]);

              var campoMarker = new google.maps.Marker({
                  position: campoPos,
                  map: map,
                  icon: campoImage,
                  title:"Shapeshift Interactive",
                  zIndex: 3
              });
        });
    });
///////////////////Peticion de ajax para cargar datos de un campo//////////////////////////
    $('.actualizarCampo').on('click',function(e){
       e.preventDefault();
       var idcampo = $(this).attr("value");
       $.ajax({
          url:"/FutPlayFinal/campos/getJSONCampo",
          method:"post",
          data:{idcampo:idcampo}
       }).done(function(data){
          localStorage.setItem('JSONCampo', JSON.stringify(data));
          window.location.href = "/FutPlayFinal/material-dashboard/pages/campo/actualizarCampo.jsp"; 
       });
    });
///////////////////Peticion de ajax para actualizar un campo////////////////////////////
    $("#frmRCampoUP").validate({
       rules:{
            nombrecampoUP:{
                required: true,
                minlength: 5
            },
            direccioncampoUP:{
                required:true,
                minlength:5
            },
            horarioatencionabreUP:{
                required:true
            },
            horarioatencioncierreUP:{
                required:true
            }
        },
        messages:{
            nombrecampoUP:{
                required: "Ingresa un nombre para tu campo",
                minlength: "Ingresa 5 caracteres como minimo"
            },
            direccioncampoUP:{
                required:"Ingresa una direccion para tu campo",
                minlength: "Ingresa 5 caracteres como minimo"
            },
            horarioatencionabreUP:{
                required: "Ingresa un horario de apertura"
            },
            horarioatencioncierreUP:{
                required: "Ingresa un horario de cierre"
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
            swal({
                title:"Confirmar datos",
                text:"¿Estas seguro de que todos tus datos son correctos?",
                showLoaderOnConfirm:true,
                confirmButtonText:"Aceptar",
                cancelButtonText:"Cancelar",
                type:"info",
                showCancelButton:true,
                closeOnConfirm:false,
                preConfirm: function(){
                   setTimeout(function(){
                    var nombrecampoUP = $("#nombrecampoUP").val();
                    var direccioncampoUP = $("#direccioncampoUP").val();
                    var horarioatencionabreUP = $("#horarioatencionabreUP").val();
                    var horarioatencioncierreUP = $("#horarioatencioncierreUP").val();
                    var fotocampoUP = $("#campoFotoNombreUP").val();
                    function getUbicacion(ubicacionGmap){
                        var geocoder = new google.maps.Geocoder();
                        geocoder.geocode({ 'address': direccioncampoUP}, function (results, status) {
                            if (status === google.maps.GeocoderStatus.OK) {
                                var ubicacionLatLng = results[0].geometry.location.lat()+"/"+results[0].geometry.location.lng();
                                ubicacionGmap(ubicacionLatLng);
                            }
                            else {
                                alert("Ubicacion no encontrada razon: " + status);
                            }
                        });
                    }
                    getUbicacion(function(ubi){
                        var data = new FormData();
                        $.each($('#fotocampouploadUP')[0].files, function(i, file) {
                             data.append('file-'+i, file);
                        });
                        $.ajax({
                            url: '/FutPlayFinal/uploadfiles',
                            data: data,
                            dataType: 'text',
                            processData: false,
                            contentType: false,
                            type: 'POST'
                        });
                        $.ajax({
                            url:"/FutPlayFinal/campos/actualizarcampo",
                            method:"post",
                            data:{nombrecampoUP:nombrecampoUP,direccioncampoUP:direccioncampoUP,ubicacionUP:ubi,horarioatencionabreUP:horarioatencionabreUP,horarioatencioncierreUP:horarioatencioncierreUP,fotocampoUP:fotocampoUP}
                        }).done(function(rt){
                             if(rt!=="0"){
                                 swal({
                                     title:"Exito",
                                     text:"Campo actualizado exitosamente",
                                     type:"success",
                                     preConfirm: function(){                                       
                                        window.location.href = "/FutPlayFinal/material-dashboard/pages/campo/administrarCampo.jsp";                  
                                     }
                                 });
                             }
                             else{
                                 swal("Error","Ocurrio un error al momento de procesar la solicitud","error");
                             }
                        });
                    });  
                 },2000); 
                }
            });
        }    
    });
/////////////////////////Funcion para agregar una cancha////////////////  
    var idCampo;
    
    $(".btnModalCancha").on("click",function(e){
        e.preventDefault();
        var idcampo = $(this).attr("value");
        setIdCampo(idcampo);
        $(this).each(function(){
            $("#añadirCancha").modal("show");           
        });
    });
    
    function setIdCampo(idcampo){
        idCampo = idcampo;
    }
    
    function getIdCampo(){
        return idCampo;
    }
    
    $(".btnAñadirCancha").on("click",function(e){
        e.preventDefault();               
        var campo = getIdCampo();
        var numcancha = 1;        
        var tipoCancha = $("#cmbTipoCancha").val();
        $.ajax({
           url:"/FutPlayFinal/canchas/registrarCancha",
           method:"post",
           dataType:"json",
           data:{campo:campo ,numcancha:numcancha, tipocancha:tipoCancha}
        }).done(function(data){
            if(data>"0"){
                $("#añadirCancha").modal("hide");
                $("#cmbTipoCancha").prop("selectedIndex",0);
            }
        });
    }); 
    
/////////////////////////////////Peticion de ajax para eliminar una cancha///////////////////////////////
    $(".btnEliminarCancha").on("click",function(e){
        e.preventDefault();
        var idcancha = $(this).attr("value");
        var btn = $(this);
        swal({
           title:"Advertencia",
           text:"¿Deseas eliminar la siguiente cancha?",
           type:"warning",
           showCancelButton:true,
           cancelButtonText:"Cancelar",
           confirmButtonText:"Sí",
           confirmButtonColor:"#DD6B55",
           showLoaderOnConfirm:true,
           closeOnConfirm:false,
           preConfirm: function(){
            setTimeout(function(){
                $.ajax({
                    url:"/FutPlayFinal/canchas/eliminarCancha",
                    method:"post",
                    data:{idcancha:idcancha}
                }).done(function(rt){
                    if(rt!=="0"){
                        swal("Exito","Cancha eliminada exitosamente","success");
                        btn.parent().parent().remove();
                    }
                    else{
                        swal("Error","Ocurrio un error al momento de procesar la solicitud","error");
                    }
                });
            },2000);
           }            
        });
    });
///////////////////////////////////Peticion de ajax para cargar datos de la cancha//////////////////////////
    $(".btnActualizarCancha").on("click",function(e){
        e.preventDefault();
        
    });
////////////////////////////////////Peticion de ajax para actualizar una cancha/////////////////////////////
    $("#frmCanchaUP").on("submit",function(e){
        e.preventDefault();
    });
//////////////////////////////////Chequeo de campos registrados fancy button////////////////////////////////
    $(".btnVerCampos").on("click",function(e){
       e.preventDefault();
       var idPropietario = $(this).val();
       $.ajax({
           url:"/FutPlayFinal/campos/checkCampos",
           method:"post",
           dataType:"json",
           data:{idPropietario:idPropietario}
       }).done(function(data){
           if(data>"0"){
               window.location.href = "/FutPlayFinal/material-dashboard/pages/campo/administrarCampo.jsp";
           }
           else{
               swal("Información","No tienes campos registrados, empieza por añadir alguno","info");
           }
       });
    });
//////////////////////////////////////Chequeo de canchas registradas fancy button/////////////////////////////
    $(".btnCheckCanchas").on("click",function(){
        var idcampo = $(this).attr("value");
        $.ajax({
            url:"/FutPlay/canchas/checkCanchas",
            type:"post",
            data:{idcampo:idcampo}
        }).done(function(rt){
            if(rt>"0"){ 
                
            }else{  
                swal("Informacion","No tienes canchas registradas en este campo","info");                             
            }           
        });
    });
///////////////////////////////////Funcion para cerrar sesion//////////////////////////////////
    $("#btnCerrarSesion").on("click",function(){
       swal({
           title:"Advertencia",
           text:"Deseas cerrar sesión?",
           type:"warning",
           showCancelButton:true,
           closeOnConfirm:false,
           showLoaderOnConfirm:true,
           cancelButtonText:"Cancelar",
           confirmButtonText:"Sí",
           confirmButtonColor:"#DD6B55",
           preConfirm:function(){
               return new Promise(function (resolve) {
                 $.ajax({
                    url:"/FutPlayFinal/inicio/cerrar"
                 }).done(function(data){
                     resolve();
                 });   
               });  
           }
       }).then(function(retorno){
           if(retorno>"0"){
               window.location.href="/FutPlayFinal/index.html";
           }
           else{
               swal("Error","Ocurrio un error al momento de procesar la solicitud","error");
           }
       }); 
    });
////////////////////////////Editar propietario//////////////////////////
    $("#frmEditarPropietario").validate({
       rules: {
                nombresPropietarioUP:{
                    required:true,
                    minlength:3
                },
                apellidosPropietarioUP:{
                    required:true,
                    minlength:3
                },
                fechanacimientoPropietarioUP:{
                    required:true
                },
                telefonoPropietarioUP:{
                    required:true
                },
                generoPropietarioUP:{
                    required:true
                }
        },
        messages:{
            nombresPropietarioUP:{
                required:"Ingresa tus nombres",
                minlength:"Ingresa 3 caracteres como minimo"
            },
            apellidosPropietarioUP:{
                required:"Ingresa tus apellidos",
                minlength:"Ingresa 3 caracteres como minimo"
            },
            fechanacimientoPropietarioUP:{
                required:"Selecciona tu fecha de nacimiento"
            },
            telefonoPropietarioUP:{
                required:"Ingresa tu numero telefonico"
            },
            generoPropietarioUP:{
                required:"Selecciona tu genero"
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
            swal({
                title:"Confimar datos",
                text:"¿Estas seguro de que todos tus datos son correctos?",
                type:"info",
                confirmButtonText:"Sí",
                cancelButtonText:"Cancelar",
                showCancelButton:true,
                closeOnConfirm:false,
                showLoaderOnConfirm:true,
                preConfirm: function(){
                    setTimeout(function(){
                        var UId = $("#idPropietarioUP").val();
                        var UNombre = $("#nombresPropietarioUP").val();
                        var UApellido = $("#apellidosPropietarioUP").val();
                        var UFechaNacimiento = $("#fechanacimientoPropietarioUP").val();
                        var UTelefono = $("#telefonoPropietarioUP").val();
                        var UGenero = $("#generoPropietarioUP").val();
                        var UCorreo = $("#emailPropietarioUP").val();
                        var UContrasenia = $("#passwordPropietarioUP").val();
                        var UAvatar = $("#avatarPropietarioNombreUP").val();  
                        $.ajax({
                            url:"/FutPlayFinal/propietario/actualizar",
                            method:"post",
                            dataType:"json",
                            data:{UId:UId,UNombre:UNombre,UApellido:UApellido,UFechaNacimiento:UFechaNacimiento,UTelefono:UTelefono,UGenero:UGenero,UCorreo:UCorreo,UContrasenia:UContrasenia,UAvatar:UAvatar},
                            complete: function(){
                            ////////Subir Avatar/////////
                                 var data = new FormData();
                                 $.each($('#avatarPropietarioUP')[0].files, function(i, file) {
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
                            }
                        }).done(function(data){
                            if(data>"0"){
                                swal({
                                    title:"Exito",
                                    text:"Perfil actualizado exitosamente",
                                    type:"success",
                                    preConfirm: function(){
                                        window.location.href = "/FutPlayFinal/material-dashboard/pages/propietario/verPerfilPropietario.jsp";
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
    });
    /////////////////////// NOTIFICACIONES ///////////////////////////
    
    ////////////////////////////////////////////////// VER NOTIFICACIONES ////////////////////////////////////////////
    $(".verNotificacionesPropietario").click(function (){
        
        $.post("/FutPlayFinal/notificacion/vernotificacionespropietario",function (responseText){

            $("#notificacionesContenedor").html("");
            $("#notificacionesContenedor").append(responseText);

        });
        
    });
    //////////////////////////////////////// DEJAR EN VISTO LAS NOTIFICACIONES //////////////////////////////////
    $(".actualizarNotificacionesPropietario").click(function (){
        
        $.post("/FutPlayFinal/notificacion/vistonotificacionpropietario",function (responseText){

            if(responseText === "1"){

                CargarNotificaciones();

            }

        });

    });
});
function CargarNotificacionesPropietario (){
    
    $.ajax({
        async: true,
        type: 'POST',
        url: "/FutPlayFinal/notificacion/cargarnotificacionespropietario",
        cache:false
    }).done(function (responseText){

        $("#numeroNotificacionesContainer").html(responseText);
        //ESTAR PERDIENE DE VOLVER A DESCOMENTAR ESTE TIMEOUT -> setTimeout('CargarNotificaciones()',10000);

    });
};
/////End of document ready//////
$(document).ready(function(){
/* inicializa el calendario */
    $('#calendar').fullCalendar({
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay'
        },
        defaultView: 'agendaWeek',
        titleFormat:"MMMM YYYY",
        columnFormat:"ddd D",
        slotLabelFormat:"h (:mm)a",
        editable:true,
        droppable:true,
        eventOverlap:false,
        eventDrop: function(event, delta, revertFunc) {
            var id = event._id;
            var title = event.title;
            var start = event.start.format();
            var end = event.end.format();
            var color = $(this).css("background-color");
            var campo = $("#cmbCampos").val();
            $.ajax({
                url:"/FutPlayFinal/canchas/guardarEncuentro",
                method:"post",
                data:{id:id,title:title,start:start,end:end,color:color,campo:campo}
            }).done(function(rt){
                if(rt>"0"){
                    swal("Excelente","Evento guardado exitosamente","success");   
                }
                else{
                    swal("Error","Ocurrio un error al momento de procesar la solicitud","error");
                }
            });
        },
        eventResize : function( event, jsEvent, ui, view ){
            var id =  event._id;
            var title = event.title;
            var start = event.start.format();
            var end = event.end.format();
            var color = $(this).css("background-color");
            var campo =$("#cmbCampos").val();
            $.ajax({
                url:"/FutPlayFinal/canchas/guardarEncuentro",
                method:"post",
                data:{id:id,title:title,start:start,end:end,color:color,campo:campo}
            }).done(function(rt){
                if(rt>"0"){
                    swal("Excelente","Evento guardado exitosamente","success");   
                }
                else{
                    swal("Error","Ocurrio un error al momento de procesar la solicitud","error");
                }
            });
        },
        eventClick: function(calEvent, jsEvent, view) {
           var idcampo = $("#cmbCampos").val();
           swal({
               title:"Advertencia",
               text:"Deseas eliminar el siguiente evento?",
               type:"warning",
               showCancelButton:true,
               showLoaderOnConfirm:true,
               closeOnConfirm:false,
               confirmButtonColor: "#DD6B55", 
               cancelButtonText:"Cancelar",
               confirmButtonText:"Sí",
               preConfirm: function(){
                   setTimeout(function(){
                       $.ajax({
                           url:"/FutPlayFinal/canchas/eliminarEvento",
                           type:"post",
                           data:{idevento:calEvent.id}
                       }).done(function(rt){
                          if(rt>"0"){
                              swal("Excelente","Evento eliminado exitosamente","success");
                              recargarEventos(idcampo);
                          } 
                          else{
                              swal("Error","Ocurrio un error al momento de procesar la solicitud!","error");
                          }
                       });
                   },2000);
               }              
           });
       }
    }); 

/* inicializa los eventos externos drag & drop */
    /*$('#external-events .fc-event').each(function() {
        
        $(this).data('event', {
            title: $.trim($(this).text()),
            stick: true, 
            color: "#F77168"
        });

        $(this).draggable({
            zIndex: 999,
            revert: true,      
            revertDuration: 0  
        });

    });*/
/* Funcion para recargar los eventos*/
    function recargarEventos(idCampo){
        var events = {
           url: "/FutPlayFinal/canchas/getJSONEncuentros/"+idCampo+"",
           type: 'POST'         
        };
        $("#calendar").fullCalendar('removeEvents');
        $('#calendar').fullCalendar( 'addEventSource', events);
    }
/* actualiza los eventos del calendario y carga las canchas de cada campo*/
    $("#cmbCampos").on("change",function(){
        var campo = $(this).val();
        recargarEventos(campo);        
        
        $("#cardEvents").children().remove();
        $.ajax({
           url:"/FutPlayFinal/canchas/getJSONCancha",
           method:"post",
           dataType:"json",
           data:{campo:campo}
        }).done(function(data){
            for (var i = 0; i < data.canchas.length; i++) {
                $("#cardEvents").append("<div class='fc-event btn btn-round btn-xs' style='background-color:#9C27B0;'>"+data.canchas[i]+"</div>");
                //asignarDroppable();
                $(".fc-event").draggable({
                zIndex: 999,
                revert: true,      
                revertDuration: 0  
            });
            $(".fc-event").data('event', {
                title: $(".fc-event").html(),
                stick: true,
                color: "#F44336"
            }); 
            }
        });
    });
/*funcion para asignar atributos a los fc-events despues de ser cargados en el DOM*/
    function asignarDroppable(){
        $.each(".fc-event",function(){
            $(this).draggable({
                zIndex: 999,
                revert: true,      
                revertDuration: 0  
            });
            $(this).data('event', {
                title: $(this).html(),
                stick: true,
                color: "#F44336"
            }); 
        });
    }
});


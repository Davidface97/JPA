$(document).ready(function () {
    
    $('#enviar').click(function () {

        var nombre = $('#nombre').val();
        var apellido = $('#apellido').val();
        var telefono = $('#tel').val();
        var correo = $('#correo').val();
        $.ajax({ 
            url: 'CrearTiendaServlet',
            type: 'POST',
            data: {nombre:nombre,apellido:apellido,telefono:telefono, correo:correo},
            dataType: 'json',
            success: function (data) {
                
                if (data.confirmacion === "ACK") {
                    console.log("DATOS CORRECTOS");
                    alert("Tienda creada exitosamente");
                    
                } else {
                    console.log("DATOS INCORRECTOS");
                    alert("Hubo un error al crear la tienda");
                }
            },

            error: function () {
            }
        });
    });
});


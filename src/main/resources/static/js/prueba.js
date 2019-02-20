function inicializar(){
    m = document.getElementById('M_input').value;
    n = document.getElementById('N_input').value;

    if(isBlank(m) || isBlank(n)){
        alert("Debe introducir M y N, enteros")
    } else {
        var datos = JSON.stringify({x: m, y: n});
        $.ajax({
            contentType: "application/json",
            type: "POST",
            url: "car/initialize",
            data: datos,
            mimeType: "application/json",
            success: function (respuesta) {
                document.getElementById('M_label').innerHTML = respuesta.position.x;
                document.getElementById('N_label').innerHTML = respuesta.position.y;
            },
            error: function(respuesta) {
                alert(JSON.stringify(respuesta));
            }
        });
    }
}

function obtener(){
    $.ajax({
        contentType: "application/json",
        type: "GET",
        url: "car/getPosition",
        mimeType: "application/json",
        success: function (respuesta) {
            document.getElementById('X_label').innerHTML = respuesta.position.x;
            document.getElementById('Y_label').innerHTML = respuesta.position.y;
        },
        error: function(respuesta) {
            alert(respuesta.responseJSON.error)
        }
    });
}

function mover(){
    comandos = document.getElementById('commands').value;
    if(isBlank(comandos)){
        alert("Debe introducir los comandos para mover el vehículo")
    } else {
        //var datos = JSON.stringify({commands: comandos});
        $.ajax({
            contentType: "application/json",
            type: "POST",
            url: "car/move",
            data: comandos,
            mimeType: "application/json",
            success: function (respuesta) {
            	document.getElementById('hist_label').innerHTML = respuesta.movements;
            },
            error: function(respuesta) {
                alert(respuesta.responseJSON.error)
            }
        });
    }
}

function isBlank(str){
    return str === null || str.match(/^ *$/) !== null;
}
$( document ).ready(function() {
    $( "#init" ).load( staticPath + "html/login.html" );
});

function login(){

        var usuario = $('#user').val();
        var contrasenya = $('#password').val();

        var json = { "usuario" : usuario, "contrasenya" : contrasenya };

        $.ajax({
            crossDomain: false,
            type: "POST",
            url: 'http://localhost:8080/fca/publico/autenticacion',
            data: JSON.stringify(json),
            beforeSend: function(xhr) {
                xhr.withCredentials = true;
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function(data){
                //$( "#init" ).load( "privado/panel.jsp" );
                window.location.replace("privado/panel.jsp?key=" + data.key);
            }
        });

        event.preventDefault();


}
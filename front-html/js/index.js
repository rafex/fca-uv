$('#login').click(function(event) {       
	var usuario = $('#user').val();
    var contrasenya = $('#password').val();
    
    var json = { "usuario" : usuario, "contrasenya" : contrasenya };
    alert("entre");
    $.ajax({
    	crossDomain: false,
        type: "POST",
        url: 'http://localhost:8080/front/publico/autenticacion',
        data: JSON.stringify(json),
        beforeSend: function(xhr) {
        	xhr.withCredentials = true;
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
        },
        success: function(data){ 
            alert(data);
        }
    });

    event.preventDefault();

});
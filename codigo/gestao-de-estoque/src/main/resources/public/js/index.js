window.addEventListener( "load", function (event) {
    let email = JSON.parse(localStorage.getItem('email'));

    loadDashboard( email );

    function loadDashboard ( email ) {
        let xhr = new XMLHttpRequest();
        
        xhr.addEventListener( 'load', function ( event ) {
            loadUser(event.target.responseText);
        } );

        // Define case error
        xhr.addEventListener( ' error', function ( event ) {
            alert ( 'Oops! ' );
        } );

        xhr.open( "GET", `/get/usuario/${email}`);

        xhr.send();
    }   

    function loadUser ( user ) {
        localStorage.setItem("user", user);
        let objUser = JSON.parse(user);

        console.log(objUser);

        document.getElementById("nomeUsuario").innerText = `Olá, ${objUser.nome} ${objUser.sobrenome}`;
    }
});
// Acess form elemento
const form = document.getElementById("formLogin");

function getUser() {
    let email = document.getElementById("email").value;
    let password = document.getElementById("senha").value;
    let actionSrc = `http://localhost:6789/get/usuario/${email}`;
    
    let xhr = new XMLHttpRequest();

    xhr.addEventListener( 'load', function ( event ) {
        verifyUser(event.target.responseText, password);
    } );

    // Define case error
    xhr.addEventListener( ' error', function ( event ) {
        alert ( 'Oops! ' );
    } );

    xhr.open( "GET", actionSrc);

    xhr.send();
}

function verifyUser( user, password) {
    let objUser = JSON.parse(user);
    // Verificação de senha
    if(objUser.senha == password) {
        window.location.replace("http://127.0.0.1:5500/index.html");
        localStorage.setItem('email', JSON.stringify(objUser.email));
    } else {
        alert("Senha incorreta!");
        window.location.replace("http://127.0.0.1:5500/login.html");
    }
}

window.addEventListener("load", function () { 
    form.addEventListener( "submit", function ( event ) {
        event.preventDefault();
        getUser();
    });
});
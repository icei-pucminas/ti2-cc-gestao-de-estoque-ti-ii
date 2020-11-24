window.addEventListener("load", function () { 

    function createSession() {
        let email = document.getElementById("email").value;

        localStorage.setItem('email', JSON.stringify(email));
    }

    // Acess form elemento
    const form = document.getElementById("formRegistro");

    form.addEventListener( "submit", function ( event ) {
        createSession();
    });
});
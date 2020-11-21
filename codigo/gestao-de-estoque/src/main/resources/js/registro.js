window.addEventListener("load", function () { 
    function sendData( data ) {
        console.log( 'Sending data... ' );

        const xhr = new XMLHttpRequest();

        // FormData object and the form element
        const fd = new FormData ( form ); 

        xhr.addEventListener( 'load', function ( event ) {
            alert ( event.target.responseText );
        } );

        // Define case error
        xhr.addEventListener( ' error', function ( event ) {
            alert ( 'Oops! ' );
        } );

        xhr.open( "POST", "http://localhost:6789/user");

        // The data sent is what user provided in the form
        xhr.send( fd ); 
    }    
        
    // Acess form elemento
    const form = document.getElementById("formRegistro");

    form.addEventListener( "submit", function ( event ) {
        event.preventDefault();
        sendData();
    });
});


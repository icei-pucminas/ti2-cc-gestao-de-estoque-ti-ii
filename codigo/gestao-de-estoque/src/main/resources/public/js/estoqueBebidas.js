// Variáveis globais
const buyButtons = document.querySelectorAll('.btnBuy');

// Main
$(window).on("load" , function () {
    // Carregar table de bebidas
    requestBebidas();

    // Capturar click no botão
    $(document).on("click", '.btnBuy', function () {
        redirectPedido(this.value);
    });
});

// Redirecionar para página de pedidos
function redirectPedido( codigo ){
    localStorage.setItem("idBebida", JSON.stringify(codigo));
    window.location.replace("http://127.0.0.1:5500/realizarPedido.html");
}

// Fazer requisição das bebidas no servidor
function requestBebidas() {
    // Variável de requisição
    let xhr = new XMLHttpRequest();
    let actionSrc = `http://localhost:6789/all/bebida`;
    let method = 'GET';

    xhr.addEventListener( 'load', function ( event ) {
        loadBebida(event.target.responseText);
    } );

    xhr.open(method, actionSrc);

    xhr.send();
}

// Carregar as bebidas na tabela
function loadBebida( bebidas ) {
    let objBebidas = JSON.parse(bebidas);
    
    // Tabela de bebidas
    var table = $('#dataTable').DataTable();
    objBebidas.forEach(bebida => {
        console.log(bebida);
        table.row.add( [
            `<td><button class="btn btn-primary btnBuy" value="${bebida.codigo}"><i class="fa fa-shopping-cart" aria-hidden="true"></i></button></td>`,
            bebida.codigo,
            bebida.nome,
            bebida.volume,
            bebida.quantidade,
            bebida.idFornecedor,
            bebida.preco
        ]).draw(false);
    });
}

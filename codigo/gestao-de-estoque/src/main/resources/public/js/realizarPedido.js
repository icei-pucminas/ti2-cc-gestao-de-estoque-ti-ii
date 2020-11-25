$(window).on("load", function () {
    
    requestBebida( idBebida );
});

// Abrir requisição de bebidas
function requestBebida( idBebida ) {
    let xhr = new XMLHttpRequest();

    let actionSrc = `http://localhost:6789/bebida/${idBebida}`;
    let method = 'GET';

    xhr.addEventListener( 'load', function ( event ) {
        // Carregar as bebidas no formulário
        loadBebida(event.target.responseText);
    } );

    xhr.open(method, actionSrc);

    xhr.send();
}

function loadBebida( bebida ) {
    // Criar obj de bebida
    const objBebida = JSON.parse(bebida);
    quantidadeEstoque = objBebida.quantidade;
    preco             = objBebida.preco;

    // Pegar as labels do formulário
    let labelNome       = document.getElementById("bebidaNome");
    let labelFornecedor = document.getElementById("bebidaFornecedor");
    let labelPreco      = document.getElementById("bebidaPreco");
    let labelDescricao  = document.getElementById("bebidaDescricao");
    let labelEstoque    = document.getElementById("bebidaQuantidade");
    let labelIdBebida   = document.getElementById("idBebida");
    let labelIdComprador  = document.getElementById("idComprador");

    let user = JSON.parse(localStorage.getItem("user"));

    // Setar valores das labels
    labelNome.value = objBebida.nome;
    labelFornecedor.value = objBebida.idFornecedor;
    labelPreco.value = objBebida.preco;
    labelDescricao.value = objBebida.descricao;
    labelEstoque.value = objBebida.quantidade;
    labelIdBebida.value = idBebida;
    labelIdComprador.value = user.id;
}
 
// Variáveis
let quantidadeDesejada = 0;
let quantidadeEstoque  = 0;
let preco = 0;
let precoTotal = 0;
const idBebida        = JSON.parse(localStorage.getItem("idBebida"));
const labelQuantidade = document.getElementById("pedidoQuantidade");
const labelPrecoTotal = document.getElementById("pedidoPreco");

// Preparar input
labelQuantidade.addEventListener("focus", function () {
    labelQuantidade.classList.remove("text-success");
    labelQuantidade.classList.remove("text-danger");
});

// Get Quantidade 
labelQuantidade.addEventListener("blur", function() {
    quantidadeDesejada = labelQuantidade.value;
    let quantidadeValida = parseInt(quantidadeDesejada) <= parseInt(quantidadeEstoque);

    if(!quantidadeValida) {
        labelQuantidade.classList.remove("text-success");
        labelQuantidade.classList.add("text-danger");
        quantidadeDesejada = 0;
    } else {
        labelQuantidade.classList.remove("text-danger");
        labelQuantidade.classList.add("text-success");
        quantidadeDesejada = labelQuantidade.value;
    }
});

// Set precoTotal 
labelQuantidade.addEventListener("blur", function() {
    precoTotal = preco*quantidadeDesejada;
    labelPrecoTotal.value = precoTotal;
    const displayPrecoTotal = document.getElementById("precoTotal");
    displayPrecoTotal.innerText = precoTotal;
});
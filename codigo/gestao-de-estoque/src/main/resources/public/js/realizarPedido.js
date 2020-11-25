const idBebida = JSON.parse(localStorage.getItem("idBebida"));

$(window).on("load", function () {
    
    requestBebida( idBebida );
});

function requestBebida( idBebida ) {
    let xhr = new XMLHttpRequest();

    let actionSrc = `http://localhost:6789/bebida/${idBebida}`;
    let method = 'GET';

    xhr.addEventListener( 'load', function ( event ) {
        loadBebida(event.target.responseText);
    } );

    xhr.open(method, actionSrc);

    xhr.send();
}

function loadBebida( bebida ) {
    objBebida = JSON.parse(bebida);
    
    console.log(objBebida);
    let labelNome = document.getElementById("bebidaNome");
    let labelFornecedor = document.getElementById("bebidaFornecedor");
    let labelPreco = document.getElementById("bebidaPreco");
    let labelDescricao = document.getElementById("bebidaDescricao");
    let labelEstoque = document.getElementById("bebidaQuantidade");

    labelNome.value = objBebida.nome;
    labelFornecedor.value = objBebida.idFornecedor;
    labelPreco.value = objBebida.preco;
    labelDescricao.value = objBebida.descricao;
    labelEstoque.value = objBebida.quantidade;
    console.log(labelNome);
}
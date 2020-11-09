window.onload = () => {
    let pedido = JSON.parse(localStorage.getItem("pedidos"));

    document.getElementById("bebidaCodigo").setAttribute("value",pedido.codigo);
    document.getElementById("bebidaNome").setAttribute("value",pedido.nome);
    document.getElementById("bebidaDescricao").value = pedido.descricao;
    document.getElementById("bebidaFornecedor").setAttribute("value",pedido.idFornecedor);
    document.getElementById("bebidaPreco").setAttribute("value",pedido.preco);
    document.getElementById("bebidaQuantidade").setAttribute("value",pedido.quantidade);

    document.getElementById("pedidoQuantidade").addEventListener("change", function () {
        atualizaValor(pedido);
    });
}

function atualizaValor(pedido){
    let qtd = document.getElementById("pedidoQuantidade").value;
    let total = pedido.preco * qtd;
    console.log(qtd);
    document.getElementById("pedidoPreco").innerHTML =  total;
}

       
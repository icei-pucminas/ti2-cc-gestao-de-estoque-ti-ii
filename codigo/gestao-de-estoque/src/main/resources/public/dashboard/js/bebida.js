let url = "http://localhost:6789/bebida";

window.onload = () => {
    getBebidasJSON(url);
}

function mostrarSalvos() {
    let tabela = document.querySelector("#corpoTabela");
    let dados = JSON.parse(this.responseText);
    let html = "";


    for(i = 0; i < dados.length; i++){

        let disponibilidade = dados[i].quantidade != 0 ? "<p style='color:green'>Disponível!</p>" : "<p style='color:red'>Não Disponível!</p>";

        html += `
            <tr id="${dados[i].codigo}-row">
                <td>
                    <a href="realizarPedido.html" id="${dados[i].codigo}-comprar">
                        <i id="${dados[i].codigo}-icon" class="fa fa-shopping-cart"></i>
                    </a>
                </td>
                <td id="${dados[i].codigo}-codigo">${dados[i].codigo}</td>
                <td id="${dados[i].codigo}-nome">${dados[i].nome}</td>
                <td id="${dados[i].codigo}-volume">${dados[i].volume}</td>
                <td id="${dados[i].codigo}-fornecedor">${dados[i].idFornecedor}</td>
                <td id="${dados[i].codigo}-disponibilidade">${disponibilidade}</td>
                <td id="${dados[i].codigo}-quantidade">${dados[i].quantidade}</td>
                <td id="${dados[i].codigo}-preco">${dados[i].preco}</td>
            </tr>
            `;
    }

    tabela.innerHTML = html;

    for(i = 0; i < dados.length; i++){
        let id = dados[i].codigo;
        let dado = dados[i];
        document.getElementById(`${id}-comprar`).addEventListener("click", function() {
            saveDadosPedido(dado);
        });
    }

}

function getBebidasJSON(url){
    var xhr = new XMLHttpRequest();

    xhr.onload = mostrarSalvos;

    xhr.open('GET', url, true);
    xhr.send();
}

function saveDadosPedido(dados){
    let dadosString = JSON.stringify(dados);

    localStorage.setItem("pedidos", dadosString);
}

// Função para compras
document.querySelector(".bebida").addEventListener("click", (e) => {
    let id = e.target.id;

    console.log(id);
    let bebidas = document.querySelectorAll(".bebida");

    for(let i = 0; i < bebidas.length; i++) {
        if(id == bebidas[i].value) {
            //console.log(id);
        }
    }

    event.preventDefault();
    let codigo = document.querySelector(".codigo").textContent;
    let nome = document.querySelector(".nome").textContent;
    let volume = document.querySelector(".volume").textContent;
    let fornecedor = document.querySelector(".fornecedor").textContent;
    let quantidade = document.querySelector(".quantidade").textContent;
    let preco = document.querySelector(".preco").textContent;
    
    let pedido = JSON.stringify({
        codigo : codigo,
        nome : nome,
        volume : volume, 
        fornecedor : fornecedor,
        quantidade : quantidade,
        preco : preco
    });

    //console.log(e.target.id);

    localStorage.setItem("pedido", pedido);
}); 

function reqListener () {
   let dado = JSON.parse(this.responseText);

   console.log(dado);
};


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
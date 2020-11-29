$(window).on("load" , function () {
    // Carregar table de bebidas
    requestPedidos();

    // Capturar delete
    $(document).on("click", '.btnDelete', function () {
        // Remover pedido pelo Id
        removerPedido(this.value);
    });
});

function requestPedidos() {
    let xhr = new XMLHttpRequest();

    // Pegar o usuário logado no momento
    let user = JSON.parse(localStorage.getItem("user"));

    // Fazer requisição dos pedidos do usuário
    let url = `/all/pedido/${user.id}`;
    let method = `GET`;

    xhr.open(method, url);

    xhr.addEventListener("load", function() {
        addTable(event.target.responseText);
    });

    xhr.addEventListener("error", function() {
        console.log("An error occurred during the transaction");
    });

    xhr.send();
}

function addTable( pedidos ) {
    let listPedidos = JSON.parse(pedidos);
    console.log(listPedidos);

    // Tabela de bebidas
    var table = $('#dataTable').DataTable();
    listPedidos.forEach(pedido => {
        table.row.add( [
            `<td><button class="btn btn-danger btnRemove" value="${pedido.codigo}" data-toggle="modal" data-target="#deletarPedido"><i class="fa fa-remove" aria-hidden="true"></i></button></td>
            <!-- Modal -->
            <div class="modal fade" id="deletarPedido" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Cancelar Pedido</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Deseja cancelar pedido?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-danger btnDelete" value="${pedido.codigo}">Sim</button>
                    </div>
                    </div>
                </div>
            </div>
            `,
            pedido.codigo,
            pedido.nomeBebida,
            pedido.precoTotal,
            pedido.quantidade,
            pedido.status,
        ]).draw(false);
    });
}

// Remover pedido
function removerPedido( id ){
    let xhr = new XMLHttpRequest();

    let url = `/delete/pedido/${id}`;
    let method = `GET`;

    xhr.open(method, url);

    xhr.addEventListener("load", function() {
        document.location.reload(true);
    });

    xhr.send();
}
window.onload = setIdFornecedor;

function setIdFornecedor() {
    let idFornecedor = document.querySelector("#bebidaIdFornecedor");
    let user = JSON.parse(localStorage.getItem("user"));
    idFornecedor.setAttribute("value", user.id);
}
function myFunction(){
    document.getElementById("demo").innerHTML="<h2>Registrar Bebida</h2>";
    document.getElementById("demo1").innerHTML="<h5>Preencha os campos abaixo:</h5>";
    document.getElementById("demo2").innerHTML=`
        <form class="needs-validation" novalidate>
            <div class="form-row">
                <div class="col-md-6 mb-3">
                    <label for="validationTooltip01">Código</label>
                    <input type="text" class="form-control" id="validationTooltip01" value="Mark" required>
                    <div class="valid-tooltip">
                        Looks good!
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="validationTooltip02">Nome</label>
                    <input type="text" class="form-control" id="validationTooltip02" value="Otto" required>
                    <div class="valid-tooltip">
                        Looks good!
                    </div>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12 mb-3">
                    <label for="exampleFormControlTextarea1">Descrição</label>
                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                </div>
            </div>
            <button class="btn btn-primary" type="submit">Submit form</button>
        </form> 
    `
}

function myExcluir() {
    document.getElementById("demo").innerHTML="<h2>Excluir Produto</h2>";
    document.getElementById("demo1").innerHTML="<h5>Selecione o produto para exclusão:</h5>";
    document.getElementById("demo2").innerHTML=`
    <form>
        <label for='excluir'>ID</label>
        <input type='text'name='id_produto' id='id_produto' value='X'>
        <br>
        <label for='excluir_qtd'>Excluir</label>
        <label for='excluir_qtd'>Tudo</label>
        <input type='radio' name='quantidade' id='unid' value='X'>
        <label for='excluir_unid'>Unidade</label>
        <input type='radio' name='quantidade' id='unid' value='X'>
        <br>
        <button type='submit'>Excluir</button>
    </form>
    `
}

function entradaProduto() {
    document.getElementById("demo").innerHTML="<h2>Entrada de nova carga/produto</h2>";
    document.getElementById("demo1").innerHTML="<h5>Preencha os campos e de a entrada no sistema:</h5>";
    document.getElementById("demo2").innerHTML=`
    <form>
        <label for='excluir'>Cod-Entrada</label>
        <input type='text'name='id_produto' id='id_produto' value='X'>
        <br>
        <label for='excluir_qtd'>Transporte-Cod</label>
        <input type='type' name='quantidade' id='unid' value='X'>
        <br>
        <label for='excluir_qtd'>Data-Pedido</label>
        <input type='type' name='quantidade' id='unid' value='X'>
        <br>
        <label for='excluir_unid'>Data-Saida</label>
        <input type='type' name='quantidade' id='unid' value='X'>
        <br>
        <label for='excluir_unid'>Preco total</label>
        <input type='type' name='quantidade' id='unid' value='X'>
        <br>
        <label for='excluir_unid'>Entrada-Frete</label>
        <input type='type' name='quantidade' id='unid' value='X'>
        <br>
        <label for='excluir_unid'>Fornecedor-Cod</label>
        <input type='type' name='quantidade' id='unid' value='X'>
        <br>
        <label for='excluir_unid'>Imposto</label>
        <input type='type' name='quantidade' id='unid' value='X'>
        <br>

        <button type='submit'>Registra entrada</button>
    </form>
    `
}

function saidaProduto() {
    document.getElementById("demo").innerHTML="<h2>Saida de mercadoria</h2>";
    document.getElementById("demo1").innerHTML="<h5>Registre as informacoes para onde o produto foi enviado:</h5>";
    document.getElementById("demo2").innerHTML=`
    <form>
        <label for='excluir'>Cod-Saida</label>
        <input type='text'name='id_produto' id='id_produto' value='X'>
        <br>
        <label for='excluir_qtd'>Loja-Cod</label>
        <input type='type' name='quantidade' id='unid' value='X'>
        <br>
        <label for='excluir_qtd'>Transporte-Cod</label>
        <input type='type' name='quantidade' id='unid' value='X'>
        <br>
        <label for='excluir_unid'>Preco Total</label>
        <input type='type' name='quantidade' id='unid' value='X'>
        <br>
        <label for='excluir_unid'>Frete</label>
        <input type='type' name='quantidade' id='unid' value='X'>
        <br>
        <label for='excluir_unid'>Imposto</label>
        <input type='type' name='quantidade' id='unid' value='X'>
        <br>
        <button type='submit'>Confirmar saida</button>
    </form>
    `
}

function fornecedorNew(){
    document.getElementById('demo2').innerHTML = 
    ` <div class='row lol'>
        <label for='identifica'>Cod-Fornecedor</label>
        <input type='text' name='id_produto' id='fornecedor_uf' value='3'>
    
        
            
            <label for='nome'>Cod_Cidade</label>
            <input type='text' name='nome_produto' id='fornecedor_uf' value='4'>
            
            <label for='UF'>Fornecedor</label>
            <input type='text' name='uf' id='fornecedor_uf'>
            <label for='UF'>Contato-Nome</label>
            <input type='text' name='uf' id='fornecedor_uf'>
            <br>
            <label for='UF'>Endereco</label>
            <input type='text' name='uf' id='fornecedor_uf'>
            <label for='UF'>Complemento</label>
            <input type='text' name='uf' id='fornecedor_uf'>
            <label for='UF'>Bairro</label>
            <input type='text' name='uf' id='fornecedor_uf'>
            <label for='UF'>CEP</label>
            <input type='text' name='uf' id='fornecedor_uf'>
            
            <label for='UF'>CNPJ</label>
            <input type='text' name='uf' id='fornecedor_uf'>
            <label for='UF'>Telefone</label>
            <input type='text' name='uf' id='fornecedor_uf'>
        
    </div>`
    var mudanca = document.getElementById('demo2');
    mudanca.style.padding = '2px';
    mudanca.style.justifyContent ='center';
}

function transporteNew(){
    document.getElementById('demo2').innerHTML = 
    ` <div class='row lol'>
        <label for='identifica'>Cod-Fornecedor</label>
        <input type='text' name='id_produto' id='fornecedor_uf' value='3'>    
            <label for='nome'>Cod_Transportadora</label>
            <input type='text' name='nome_produto' id='fornecedor_uf' value=''>
            <label for='UF'>Cidade_codCidade</label>
            <input type='text' name='uf' id='fornecedor_uf'>
            <label for='UF'>Contato-Nome</label>
            <input type='text' name='uf' id='fornecedor_uf'>
            <br>
            <label for='UF'>Transportadora</label>
            <input type='text' name='uf' id='fornecedor_uf'>
            <label for='UF'>Endereco</label>
            <input type='text' name='uf' id='fornecedor_uf'>
            <label for='UF'>Complemento</label>
            <input type='text' name='uf' id='fornecedor_uf'>
            <label for='UF'>Bairro</label>
            <input type='text' name='uf' id='fornecedor_uf'>
            
            <label for='UF'>CEP</label>
            <input type='text' name='uf' id='fornecedor_uf'>
            <label for='UF'>CNPJ</label>
            <input type='text' name='uf' id='fornecedor_uf'>
            <label for='UF'>Inscricao</label>
            <input type='text' name='uf' id='fornecedor_uf'>
            <label for='UF'>Contato-Nome</label>
            <input type='text' name='uf' id='fornecedor_uf'>
            <label for='UF'>Telefone</label>
            <input type='text' name='uf' id='fornecedor_uf'>
    </div>`
    var mudanca = document.getElementById('demo2');
    mudanca.style.padding = '2px';
    mudanca.style.justifyContent ='center';
}
function consultaNew(){
    document.getElementById("demo").innerHTML="<h2>Fornecedores registrados</h2>";
    document.getElementById("demo1").innerHTML="<h5>Banco de dados de fornecedores</h5>";
    document.getElementById('demo2').innerHTML = 
    ` <div class='row lol'>
        <label for='identifica'>Cod-Fornecedor</label>
        <input type='text' name='id_produto' id='fornecedor_uf' value='3'>    
            <label for='nome'>Cod_Transportadora</label>
            <input type='text' name='nome_produto' id='fornecedor_uf' value=''>
            <label for='UF'>Cidade_codCidade</label>
            <input type='text' name='uf' id='fornecedor_uf'>
            <label for='UF'>Contato-Nome</label>
            <input type='text' name='uf' id='fornecedor_uf'>
            <br>
            <label for='UF'>Transportadora</label>
            <input type='text' name='uf' id='fornecedor_uf'>
            <label for='UF'>Endereco</label>
            <input type='text' name='uf' id='fornecedor_uf'>
            <label for='UF'>Complemento</label>
            <input type='text' name='uf' id='fornecedor_uf'>
            <label for='UF'>Bairro</label>
            <input type='text' name='uf' id='fornecedor_uf'>
            
            <label for='UF'>CEP</label>
            <input type='text' name='uf' id='fornecedor_uf'>
            <label for='UF'>CNPJ</label>
            <input type='text' name='uf' id='fornecedor_uf'>
            <label for='UF'>Inscricao</label>
            <input type='text' name='uf' id='fornecedor_uf'>
            <label for='UF'>Contato-Nome</label>
            <input type='text' name='uf' id='fornecedor_uf'>
            <label for='UF'>Telefone</label>
            <input type='text' name='uf' id='fornecedor_uf'>
    </div>`
    var mudanca = document.getElementById('demo2');
    mudanca.style.padding = '2px';
    mudanca.style.justifyContent ='center';
}


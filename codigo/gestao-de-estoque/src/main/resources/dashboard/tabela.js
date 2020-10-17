function myFunction(){
    document.getElementById("demo").innerHTML="<h2>Registrar Bebida</h2>";
    document.getElementById("demo1").innerHTML="<h5>Preencha os campos abaixo:</h5>";
    document.getElementById("demo2").innerHTML=`
        <form class="needs-validation" novalidate>
            <div class="form-row">
                <div class="col-md-6 mb-3">
                    <label for="validationTooltip01">Código</label>
                    <input type="text" class="form-control" id="validationTooltip02" value="006" required>
                    <div class="valid-tooltip">
                        Fez a fila ali o/ !
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="validationTooltip02">Nome</label>
                    <input type="text" class="form-control" id="validationTooltip02" value="Ciroc" required>
                    <div class="valid-tooltip">
                        DJ Lindao
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="validationTooltip02">Volume</label>
                    <input type="text" class="form-control" id="validationTooltip02" value="L" required>
                    <div class="valid-tooltip">
                        Ta suave, pode vim
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="validationTooltip02">Alcoolico</label>
                    <input type="text" class="form-control" id="validationTooltip02" value="Sim" required>
                    <div class="valid-tooltip">
                        Safadeza e sacanagem, muita sucessagem
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="validationTooltip02">Fabricante</label>
                    <input type="text" class="form-control" id="validationTooltip02" value="Diageo" required>
                    <div class="valid-tooltip">
                    Méchanceté salope
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="validationTooltip02">Categoria</label>
                    <input type="text" class="form-control" id="validationTooltip02" value="Vodka" required>
                    <div class="valid-tooltip">
                    Rôti
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="validationTooltip02">Preço</label>
                    <input type="text" class="form-control" id="validationTooltip02" value="R$170,00" required>
                    <div class="valid-tooltip">                      
                    Billig
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="validationTooltip02">Cod_Fornecedor</label>
                    <input type="text" class="form-control" id="validationTooltip02" value="2945" required>
                    <div class="valid-tooltip">
                        formørkelse
                    </div>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12 mb-3">
                    <label for="exampleFormControlTextarea1">Descrição</label>
                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3">Et eksklusivt produkt til mestre</textarea>
                </div>
            </div>
            <button class="btn btn-primary" type="submit">Confirmar</button>
        </form> 
    `
}

function myExcluir() {
    document.getElementById("demo").innerHTML="<h2>Lista</h2>";
    document.getElementById("demo1").innerHTML="<h5>Selecione o tipo de lista</h5>";
    document.getElementById("demo2").innerHTML=`
    <form class="needs-validation" novalidate>
        <div class="form-row">
            <div class="col-md-12 mb-12" style="padding-top: 5px">
                <label for="validationTooltip02"><b>Mostrar tudo</b></label>
                <input type="checkbox" class="form-control" id="validationTooltip03" value="Whisky" required>
                <div class="valid-tooltip">
                    
                </div>
            </div>    
        </div>
        <div class="form-row">
            <div class="form-group col-md-12 mb-12">
                <label for="exampleFormControlTextarea1">Pesquisar produto</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="1" value="1"></textarea>
            </div>
            <button class="btn btn-primary col-12" type="submit">Pesquisa</button>
        </div>
        
    </div>    
    
    
    `
}

function entradaProduto() {
    document.getElementById("demo").innerHTML="<h2>Atualizar registro</h2>";
    document.getElementById("demo1").innerHTML="<h5>Digite o cod abaixo.</h5>";
    document.getElementById("demo2").innerHTML=`
    <form class="needs-validation" novalidate>
    <div class="form-row">
        <div class="col-md-12 mb-12">
            <label for="validationTooltip01">Código do produto</label>
            <input type="text" class="form-control" id="validationTooltip02" value="Digite aqui" required>
            <div class="valid-tooltip">
                Fez a fila ali o/ !
            </div>
        </div>
        <button class="btn btn-primary col-12" type="submit">Pronto</button>
    </div>
    </form>    
    `
}

function saidaProduto() {
    document.getElementById("demo").innerHTML="<h2>Excluir</h2>";
    document.getElementById("demo1").innerHTML="<h5>Digite o codigo abaixo</h5>";
    document.getElementById("demo2").innerHTML=`
    <form class="needs-validation" novalidate>
    <div class="form-row">
        <div class="col-md-12 mb-12 padding-top:20px">
            <label for="validationTooltip01">Código do produto</label>
            <input type="text" class="form-control" id="validationTooltip02" value="Digite aqui" required>
            <div class="valid-tooltip">
                Fez a fila ali o/ !
            </div>
        </div>
        <button class="btn btn-primary col-12" type="submit">Pronto</button>
    `
}

function fornecedorNew(){
    document.getElementById("demo").innerHTML="<h2>Pedido Novo</h2>";
    document.getElementById("demo1").innerHTML="<h5>Preencha os campos</h5>";
    document.getElementById('demo2').innerHTML = ` 
    <form class="needs-validation" novalidate>
        <div class="form-row">
        <div class="col-md-6 mb-3">
            <label for="validationTooltip01">Código</label>
            <input type="text" class="form-control" id="validationTooltip02" value="006" required>
            <div class="valid-tooltip">
                Fez a fila ali o/ !
            </div>
        </div>
        <div class="col-md-6 mb-3">
            <label for="validationTooltip02">Nome</label>
            <input type="text" class="form-control" id="validationTooltip02" value="Ciroc" required>
            <div class="valid-tooltip">
                DJ Lindao
            </div>
        </div>
        <div class="col-md-6 mb-3">
            <label for="validationTooltip02">Volume</label>
            <input type="text" class="form-control" id="validationTooltip02" value="L" required>
            <div class="valid-tooltip">
                Ta suave, pode vim
            </div>
        </div>
        <div class="col-md-6 mb-3">
            <label for="validationTooltip02">Alcoolico</label>
            <input type="text" class="form-control" id="validationTooltip02" value="Sim" required>
            <div class="valid-tooltip">
                Safadeza e sacanagem, muita sucessagem
            </div>
        </div>
        <div class="col-md-6 mb-3">
            <label for="validationTooltip02">Fabricante</label>
            <input type="text" class="form-control" id="validationTooltip02" value="Diageo" required>
            <div class="valid-tooltip">
            Méchanceté salope
            </div>
        </div>
        <div class="col-md-6 mb-3">
            <label for="validationTooltip02">Categoria</label>
            <input type="text" class="form-control" id="validationTooltip02" value="Vodka" required>
            <div class="valid-tooltip">
            Rôti
            </div>
        </div>
        <div class="col-md-6 mb-3">
            <label for="validationTooltip02">Preço</label>
            <input type="text" class="form-control" id="validationTooltip02" value="R$170,00" required>
            <div class="valid-tooltip">                      
            Billig
            </div>
        </div>
        <div class="col-md-6 mb-3">
            <label for="validationTooltip02">Cod_Fornecedor</label>
            <input type="text" class="form-control" id="validationTooltip02" value="2945" required>
            <div class="valid-tooltip">
                formørkelse
            </div>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-12 mb-3">
            <label for="exampleFormControlTextarea1">Descrição</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3">Et eksklusivt produkt til mestre</textarea>
        </div>
    </div>
    <button class="btn btn-primary" type="submit">Confirmar</button>
    </form> 
    `
    
}

function transporteNew(){
    document.getElementById("demo").innerHTML="<h2>Acompanhe seu pedido</h2>";
    document.getElementById("demo1").innerHTML="<h5>Informe o cod e confire o status.</h5>";
    document.getElementById('demo2').innerHTML = ` 
    <form class="needs-validation" novalidate>
    <div class="form-row">
        <div class="col-md-12 mb-12">
            <label for="validationTooltip01">Código do produto</label>
            <input type="text" class="form-control" id="validationTooltip02" value="Digite aqui" required>
            <div class="valid-tooltip">
                Fez a fila ali o/ !
            </div>
        </div>
        <button class="btn btn-primary col-12" type="submit">Pronto</button>
    </div>
    </form>    
    `   
    
    
}

function consultaNew(){
    document.getElementById("demo").innerHTML="<h2>Fornecedores registrados</h2>";
    document.getElementById("demo1").innerHTML="<h5>Banco de dados de fornecedores</h5>";
    document.getElementById('demo2').innerHTML = ` 
    <form class="needs-validation" novalidate>
    <div class="form-row">
        <div class="col-md-12 mb-12">
            <label for="validationTooltip01"><#.#></label>
            <input type="text" class="form-control" id="validationTooltip02" value="CONEXUX" required>
            <div class="valid-tooltip">
                Fez a fila ali o/ !
            </div>
        </div>
        <button class="btn btn-primary col-12" type="submit">SYSTEM</button>
    </div>
    </form>    
    `   
    
}
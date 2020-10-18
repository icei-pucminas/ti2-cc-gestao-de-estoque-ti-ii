function myFunction(){
    document.getElementById("demo").innerHTML="<h2>Registrar Bebida</h2>";
    document.getElementById("demo1").innerHTML="<h5>Preencha os campos abaixo:</h5>";
	document.getElementById("demo2").style.setProperty('height','auto');
    document.getElementById("demo2").innerHTML=` 
        <form class="needs-validation" method="post" action="http://localhost:3214/bebida">
            <div class="form-row">
                <div class="col-md-6 mb-3">
                    <label for="bebidaCodigo">C骴igo</label>
                    <input type="text" class="form-control" id="bebidaCodigo" name="bebidaCodigo" placeholder="Ex.: 1" value="1" required>
                    <div class="valid-tooltip">
                        
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="bebidaNome">Nome</label>
                    <input type="text" class="form-control" id="bebidaNome" name="bebidaNome" placeholder="Ex.: Ciroc" value="Agua" required>
                    <div class="valid-tooltip">

                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="bebidaVolume">Volume</label>
                    <input type="text" class="form-control" id="bebidaVolume" name="bebidaVolume" placeholder="Ex.: 2" value="2" required>
                    <div class="valid-tooltip">
                        
                    </div>
                </div>
                
                <div class="col-md-6 mb-3">
                    <label for="bebidaCategoria">Categoria</label>
                    <input type="text" class="form-control" id="bebidaCategoria" name="bebidaCategoria" placeholder="Ex.: Vodka" value="Essencial" required>
                    <div class="valid-tooltip">
                    
                    </div>
                </div>
				
				<div class="col-md-6 mb-3">
                    <label for="bebidaAlcoolico">Alcoolico</label>
                    <input type="checkbox" class="form-control" id="bebidaAlcoolico" name="bebidaAlcoolico" checked>
                    <div class="valid-tooltip">
                        
                    </div>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12 mb-3">
                    <label for="bebidaDescricao">Descri玢o</label>
                    <textarea class="form-control" id="bebidaDescricao" name="bebidaDescricao" placeholder="Ex.: Vodka de alta qualidade." value="Agua mineral" rows="3"></textarea>
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
            <label for="validationTooltip01">C贸digo do produto</label>
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
            <label for="validationTooltip01">C贸digo do produto</label>
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
            <label for="validationTooltip01">C贸digo</label>
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
            M茅chancet茅 salope
            </div>
        </div>
        <div class="col-md-6 mb-3">
            <label for="validationTooltip02">Categoria</label>
            <input type="text" class="form-control" id="validationTooltip02" value="Vodka" required>
            <div class="valid-tooltip">
            R么ti
            </div>
        </div>
        <div class="col-md-6 mb-3">
            <label for="validationTooltip02">Pre莽o</label>
            <input type="text" class="form-control" id="validationTooltip02" value="R$170,00" required>
            <div class="valid-tooltip">                      
            Billig
            </div>
        </div>
        <div class="col-md-6 mb-3">
            <label for="validationTooltip02">Cod_Fornecedor</label>
            <input type="text" class="form-control" id="validationTooltip02" value="2945" required>
            <div class="valid-tooltip">
                form酶rkelse
            </div>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-12 mb-3">
            <label for="exampleFormControlTextarea1">Descri莽茫o</label>
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
            <label for="validationTooltip01">C贸digo do produto</label>
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
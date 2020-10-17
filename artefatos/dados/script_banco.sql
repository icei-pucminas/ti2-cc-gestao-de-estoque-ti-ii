CREATE TABLE Cidade (
  id INT(4) NOT NULL,
  codigo INT(2)  NOT NULL, /* UNIQUE */
  cidade VARCHAR(45) NULL,
  uf CHAR(2) NULL,
  
  constraint pk_Cidade PRIMARY KEY (id)
);

CREATE TABLE Categoria (
  id INT(4) NOT NULL,
  codigo INT(2)  NOT NULL, /* UNIQUE */
  nome VARCHAR(25) NULL,
  
  constraint pk_Categoria PRIMARY KEY (id)
);

CREATE TABLE Bebida (
  id INT(4) NOT NULL,
  codigo INT(2)  NOT NULL, /* UNIQUE */
  nome VARCHAR(45) NOT NULL,
  descricao VARCHAR(45),
  volume float(10), 
  isAlcoolico TINYINT(1),
  idCategoria INT(4)  NOT NULL,
  idFornecedor INT(4)  NOT NULL,
  idFabricante INT(4) NOT NULL,
  
  constraint pK_Bebida PRIMARY KEY (id),
  constraint fK_BFornecedor FOREIGN KEY (idFornecedor) REFERENCES Fornecedor(id),
  constraint fK_BCategoria FOREIGN KEY(idCategoria) REFERENCES Categoria(id)
);

CREATE TABLE Loja (
  id INT(4) NOT NULL,
  codigo INT(2)  NOT NULL ,
  nome VARCHAR(45),
  cnpj CHAR(18) NULL,
  cep VARCHAR(8) NOT NULL, 
  idCidade INT(4)  NOT NULL,
  
  constraint pK_Loja PRIMARY KEY (id),
  constraint fK_LCidade FOREIGN KEY (idCidade) REFERENCES Cidade(id)
);

CREATE TABLE Pedido (
  id INT(4) NOT NULL,
  codigo INT(2)  NOT NULL ,
  data DATETIME,
  preco DECIMAL NULL,
  quantidade INT(5) NOT NULL,
  
  constraint pK_pedido PRIMARY KEY(id)
);

CREATE TABLE PedidoLoja (
  idLoja INT(4) NOT NULL,
  idPedido INT(4) NOT NULL,
  
  codigo INT(2) NOT NULL,
  
  constraint pK_pedidoLoja PRIMARY KEY (idLoja, idPedido),
  constraint fK_PLLoja FOREIGN KEY (idLoja) REFERENCES Loja(id),
  constraint fK_PLPedido FOREIGN KEY (idPedido) REFERENCES Pedido(id)
);

CREATE TABLE PedidoBebida (
  idPedido INT(4) NOT NULL,
  idBebida INT(4) NOT NULL,
  
  codigo INT(2),
  
  constraint pK_pedidoBebida PRIMARY KEY (idPedido, idBebida),
  constraint fK_PBPedido FOREIGN KEY (idPedido) REFERENCES Pedido(id),
  constraint fK_PBBedida FOREIGN KEY (idBebida) REFERENCES Bebida(id)
);

CREATE TABLE Fornecedor (
  id int(4) NOT NULL,
  codigo INT(2)  NOT NULL ,
  nome VARCHAR(45),

  idCidade INT(4)  NOT NULL,
  
  constraint pK_fornecedor PRIMARY KEY (id),
  constraint fK_FCidade FOREIGN KEY (idCidade) REFERENCES Cidade(id)
);

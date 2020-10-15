CREATE DATABASE estoqueti2;

CREATE TABLE Cidade (
  id INT PRIMARY KEY NOT NULL,
  codigo INT  UNIQUE, 
  cidade VARCHAR,
  uf CHAR(2)
);

CREATE TABLE Categoria (
  id INT PRIMARY KEY NOT NULL,
  codigo INT UNIQUE, 
  nome TEXT
);

CREATE TABLE Fornecedor (
  id INT PRIMARY KEY NOT NULL,
  codigo INT  NOT NULL UNIQUE ,
  nome TEXT,

  idCidade INT REFERENCES Cidade(id) NOT NULL
);

CREATE TABLE Bebida (
  id INT PRIMARY KEY NOT NULL,
  codigo INT  UNIQUE, /* UNIQUE */
  nome TEXT NOT NULL,
  descricao TEXT,
  volume REAL CHECK(VOLUME > 0), 
  isAlcoolico BOOLEAN,
  idCategoria INT REFERENCES Categoria(id) NOT NULL,
  idFornecedor INT REFERENCES Fornecedor(id) NOT NULL
);

CREATE TABLE Loja (
  id INT PRIMARY KEY NOT NULL,
  codigo INT UNIQUE,
  nome TEXT,
  cnpj CHAR(18),
  cep TEXT NOT NULL, 
  idCidade INT REFERENCES Cidade(id)  NOT NULL
);

CREATE TABLE Pedido (
  id INT PRIMARY KEY NOT NULL,
  codigo INT  UNIQUE,
  data DATE,
  preco REAL CHECK(preco >= 0),
  quantidade INT NOT NULL CHECK(quantidade >= 0)
);

CREATE TABLE PedidoLoja (
  id INT PRIMARY KEY NOT NULL,
  idLoja INT REFERENCES Loja(id) NOT NULL,
  idPedido INT REFERENCES Pedido(id) NOT NULL,
  
  codigo INT NOT NULL UNIQUE
);

CREATE TABLE PedidoBebida (
  id INT PRIMARY KEY NOT NULL,
  idPedido INT REFERENCES Pedido(id) NOT NULL,
  idBebida INT REFERENCES Bebida(id) NOT NULL,
  
  codigo INT UNIQUE
);




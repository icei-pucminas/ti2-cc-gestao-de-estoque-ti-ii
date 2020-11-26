CREATE DATABASE estoqueti2;

CREATE TABLE Usuario (
  id        INT PRIMARY KEY NOT NULL,
  nome      TEXT,
  sobrenome TEXT,
  cpf       TEXT,
  cnpj      TEXT,
  email     TEXT,
  senha     TEXT
);

CREATE TABLE Bebida (
  id         SERIAL INT PRIMARY KEY NOT NULL,
  nome       TEXT NOT NULL,
  descricao  TEXT,
  volume     REAL CHECK(volume > 0), 
  preco      REAL,
  quantidade INT,
  idFornecedor  INT REFERENCES Usuario(id) NOT NULL
);

CREATE TABLE Pedido (
  id              INT PRIMARY KEY NOT NULL,
  data            TIMESTAMP,
  precoTotal      REAL CHECK(precoTotal >= 0),
  quantidade      INT NOT NULL CHECK(quantidade >= 0),
  status          TEXT,
  idComprador     INT REFERENCES Usuario(id) NOT NULL,
  idBebida        INT REFERENCES Bebida(id) NOT NULL
);

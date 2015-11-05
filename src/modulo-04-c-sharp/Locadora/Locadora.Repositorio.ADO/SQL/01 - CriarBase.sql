CREATE TABLE dbo.Categoria
(    
    Id               INT             NOT NULL CONSTRAINT PK_IdCategoria PRIMARY KEY,
    Descricao        VARCHAR(250)    NOT NULL
)

CREATE TABLE dbo.Cliente
(    
    Id              INT             NOT NULL CONSTRAINT PK_IdCliente PRIMARY KEY,
    Nome            VARCHAR(250)    NOT NULL
)

CREATE TABLE dbo.Jogo
(    
    Id               INT IDENTITY (1,1)		NOT NULL CONSTRAINT PK_IdJogo PRIMARY KEY,
    Nome             VARCHAR(250)			NOT NULL,
    Preco            DECIMAL(19,2)			NOT NULL,
    IdCategoria      INT					NOT NULL CONSTRAINT FK_IdCategoria FOREIGN KEY REFERENCES Categoria(Id),
    IdClienteLocacao INT					NULL CONSTRAINT FK_IdClienteLocacao FOREIGN KEY REFERENCES Cliente(Id)    
)

ALTER TABLE Jogo ADD Descricao VARCHAR(MAX) NOT NULL DEFAULT 'Sem descrição';

CREATE TABLE Selo
(
	IDSelo int not null CONSTRAINT IDSelo PRIMARY KEY, 
	Nome VARCHAR(30)
);

ALTER TABLE Jogo ADD IDSelo INT NOT NULL DEFAULT 3 CONSTRAINT FK_IDSelo FOREIGN KEY REFERENCES Selo(IDSelo);

UPDATE Jogo SET IDSelo = 2 WHERE Preco BETWEEN 35 AND 55;
UPDATE Jogo SET IDSelo = 1 WHERE Preco > 55;
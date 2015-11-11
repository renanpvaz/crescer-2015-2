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


CREATE TABLE [dbo].[Permissao] (
    [Id] [int] NOT NULL IDENTITY,
    [Nome] [nvarchar](250) NOT NULL,
    CONSTRAINT [PK_dbo.Permissao] PRIMARY KEY ([Id])
)
CREATE TABLE [dbo].[Usuario] (
    [Id] [int] NOT NULL IDENTITY,
    [Nome] [nvarchar](250) NOT NULL,
    [Senha] [nvarchar](30) NOT NULL,
    [Email] [nvarchar](50) NOT NULL,
    CONSTRAINT [PK_dbo.Usuario] PRIMARY KEY ([Id])
)
CREATE TABLE [dbo].[Usuario_Permissao] (
    [IdUsuario] [int] NOT NULL,
    [IdPermissao] [int] NOT NULL,
    CONSTRAINT [PK_dbo.Usuario_Permissao] PRIMARY KEY ([IdUsuario], [IdPermissao])
)
CREATE INDEX [IX_IdUsuario] ON [dbo].[Usuario_Permissao]([IdUsuario])
CREATE INDEX [IX_IdPermissao] ON [dbo].[Usuario_Permissao]([IdPermissao])
ALTER TABLE [dbo].[Usuario_Permissao] ADD CONSTRAINT [FK_dbo.Usuario_Permissao_dbo.Usuario_IdUsuario] FOREIGN KEY ([IdUsuario]) REFERENCES [dbo].[Usuario] ([Id]) ON DELETE CASCADE
ALTER TABLE [dbo].[Usuario_Permissao] ADD CONSTRAINT [FK_dbo.Usuario_Permissao_dbo.Permissao_IdPermissao] FOREIGN KEY ([IdPermissao]) REFERENCES [dbo].[Permissao] ([Id]) ON DELETE CASCADE


ALTER TABLE usuario
ALTER COLUMN Senha varchar(250);

insert into usuario (Nome, Senha, Email) values ('Master', '501C3E9279882FFB776A1D1E506D0410', 'master@admin.com');

insert into usuario (Nome, Senha, Email) values ('Fabricio', '68ACE0CACCCF2CAF2C604BB54FDF450C', 'fabricio@operador.com');

insert into permissao (Nome) values ('ADMIN');

insert into permissao (Nome) values ('OPERADOR');

insert into usuario_permissao (idusuario, idpermissao) values (3, 1);

insert into usuario_permissao (idusuario, idpermissao) values (4, 2);

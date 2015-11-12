INSERT INTO dbo.Categoria VALUES (1, 'RPG')
INSERT INTO dbo.Categoria VALUES (2, 'Corrida')
INSERT INTO dbo.Categoria VALUES (3, 'Aventura')
INSERT INTO dbo.Categoria VALUES (4, 'Luta')
INSERT INTO dbo.Categoria VALUES (5, 'Esporte')

INSERT INTO dbo.Jogo VALUES ('Chrono Trigger',60,1, null)
INSERT INTO dbo.Jogo VALUES ('Top Gear',20,2, null)
INSERT INTO dbo.Jogo VALUES ('Megaman X',40,3, null)
INSERT INTO dbo.Jogo VALUES ('Super Metroid',35,3, null)
INSERT INTO dbo.Jogo VALUES ('Donkey Kong Country',25,3, null)
INSERT INTO dbo.Jogo VALUES ('Super Mario Kart',40,2, null)
INSERT INTO dbo.Jogo VALUES ('Super Street Fighter',25,4, null)
INSERT INTO dbo.Jogo VALUES ('Mortal Kombat 2',37,4, null)
INSERT INTO dbo.Jogo VALUES ('Killer Instinct',18,4, null)
INSERT INTO dbo.Jogo VALUES ('Final Fight',12,3, null)
INSERT INTO dbo.Jogo VALUES ('Super Mario 1',70,1, null)
INSERT INTO dbo.Jogo VALUES ('Aladdin',16,3, null)
INSERT INTO dbo.Jogo VALUES ('Rock ''n Roll Racing',22,2, null)
INSERT INTO dbo.Jogo VALUES ('Zelda: A link to the past',110,3, null)
INSERT INTO dbo.Jogo VALUES ('Final Fantasy VI',30.5,1, null)
INSERT INTO dbo.Jogo VALUES ('International Super Star Soccer Deluxe',45,5, null)
INSERT INTO dbo.Jogo VALUES ('Contra III',28,3, null)
INSERT INTO dbo.Jogo VALUES ('Sunset Riders',37.9,3, null)
INSERT INTO dbo.Jogo VALUES ('Goof Troop',41.9,3, null)
INSERT INTO dbo.Jogo VALUES ('Mickey to Donald: Magical Adventure 3',32.9,3, null)

insert into Selo (IDSelo, Nome) values (1, 'Ouro');
insert into Selo (IDSelo, Nome) values (2, 'Prata');
insert into Selo (IDSelo, Nome) values (3, 'Bronze');

update jogo set imagem = '/Content/Images/chrono_trigger_capa.png' where id = 1

--update jogo set imagem = '/Content/Images/ken.png' where id = 7;

--update jogo set imagem = '/Content/Images/megaman.png' where id = 3;

--update jogo set imagem = '/Content/Images/metroid.png' where id = 4;

--update jogo set descricao = 'Chrono Trigger traz a jogabilidade de RPGs cl�ssicos com diversas inova��es. O jogador controla o protagonista e seus companheiros pelo mundo fict�cio do jogo, composto por diversas florestas, cidades e cavernas. A navega��o ocorre atrav�s de um mapa a�reo de vis�o do mundo.' where id = 1

--update jogo set descricao = 'Apesar da storyline e dos personagens diferentes, o modo de jogo � bem similar � s�rie original de Mega Man, com diversas exce��es - mais notavelmente: X pode aderir-se �s paredes e, do segundo jogo em diante, Zero � armado com o Z-Saber (uma esp�cie de Sabre de luz, similar ao da s�rie Star Wars) al�m do mais que tradicional canh�o de plasma.' where id = 3

--update jogo set descricao = 'O jogo � do estilo plataforma, com elementos de a��o e aventura. Nele, voc� controla a hero�na Samus Aran, que vai at� um planeta recuperar um Metroid roubado pelos Piratas do Espa�o. Durante sua aventura, Samus encontrar� aperfei�oamentos para sua armadura ao mesmo tempo em que procura os chefes e seu objetivo final, o Metroid.' where id = 4

--update jogo set descricao = 'Assim como Street Fighter IV, Super Street Fighter IV traz cen�rios 3D e personagens control�veis em plano 2D. Os "Focus Attacks" e barras diferentes para "Super" e "Ultra" combos retornam. A barra de "Ultra Combo" n�o sofreu altera��es em rela��o a Street Fighter IV, mas os jogadores podem escolher entre dois Ultra Combos para cada personagem.' where id = 7

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

--update jogo set descricao = 'Chrono Trigger traz a jogabilidade de RPGs clássicos com diversas inovações. O jogador controla o protagonista e seus companheiros pelo mundo fictício do jogo, composto por diversas florestas, cidades e cavernas. A navegação ocorre através de um mapa aéreo de visão do mundo.' where id = 1

--update jogo set descricao = 'Apesar da storyline e dos personagens diferentes, o modo de jogo é bem similar à série original de Mega Man, com diversas exceções - mais notavelmente: X pode aderir-se às paredes e, do segundo jogo em diante, Zero é armado com o Z-Saber (uma espécie de Sabre de luz, similar ao da série Star Wars) além do mais que tradicional canhão de plasma.' where id = 3

--update jogo set descricao = 'O jogo é do estilo plataforma, com elementos de ação e aventura. Nele, você controla a heroína Samus Aran, que vai até um planeta recuperar um Metroid roubado pelos Piratas do Espaço. Durante sua aventura, Samus encontrará aperfeiçoamentos para sua armadura ao mesmo tempo em que procura os chefes e seu objetivo final, o Metroid.' where id = 4

--update jogo set descricao = 'Assim como Street Fighter IV, Super Street Fighter IV traz cenários 3D e personagens controláveis em plano 2D. Os "Focus Attacks" e barras diferentes para "Super" e "Ultra" combos retornam. A barra de "Ultra Combo" não sofreu alterações em relação a Street Fighter IV, mas os jogadores podem escolher entre dois Ultra Combos para cada personagem.' where id = 7

--cd S:\xampp\mysql\bin
--Connexion avec mysql -u root -p

--Création de la BBDD
CREATE DATABASE IF NOT EXISTS proxybanquev2_avofle;
use proxybanquev2_avofle;
CREATE TABLE IF NOT EXISTS conseilles (id int NOT NULL AUTO_INCREMENT, prenom varchar(30) NOT NULL, nom varchar(30) NOT NULL, login varchar(30)  NOT NULL, password varchar(30) NOT NULL, PRIMARY KEY(id));
CREATE TABLE IF NOT EXISTS clients (id int NOT NULL AUTO_INCREMENT, prenom varchar(30) NOT NULL, nom varchar(30) NOT NULL, mail varchar(30) NOT NULL, adresse varchar(100) NOT NULL, id_conseille int NOT NULL, PRIMARY KEY(id));
CREATE TABLE IF NOT EXISTS comptescourants (id int NOT NULL AUTO_INCREMENT, solde decimal(7.2) NOT NULL, date_creation date NOT NULL, decouvert decimal(7.2) NOT NULL, id_client int NOT NULL, PRIMARY KEY(id));
CREATE TABLE IF NOT EXISTS comptesepargnes (id int NOT NULL AUTO_INCREMENT, solde decimal(7.2) NOT NULL, date_creation date NOT NULL, taux decimal(3.2) NOT NULL, id_client int NOT NULL, PRIMARY KEY(id));
-- Création des enregistrements
INSERT INTO conseilles (prenom, nom, login, password) VALUES ("admin_prenom", "admin_nom", "admin", "admin");
INSERT INTO clients (prenom,nom,mail,adresse,id_conseille) VALUES ("Mickael", "Kael", "mickael.kael@orange.fr", "25 rue des poiriers 75015 Paris",1);
INSERT INTO clients (prenom,nom,mail,adresse,id_conseille) VALUES ("Edgar", "Grospiron", "edgar.grospiron", "13 av des pommier 74000 Annecy",1);
INSERT INTO clients (prenom,nom,mail,adresse,id_conseille) VALUES ("Julie", "Gayet", "julie.gayet@gmail.com", "8 boulevard de l'Elysee 75001 Paris",1);
INSERT INTO comptescourants(solde, date_creation, decouvert,id_client) VALUES (5000, "2017-05-12", 500,1);
INSERT INTO comptescourants(solde, date_creation, decouvert,id_client) VALUES (2500, "2012-06-08", 250,2);
INSERT INTO comptescourants(solde, date_creation, decouvert,id_client) VALUES (-50, "2016-11-05", 100,3);
INSERT INTO comptesepargnes(solde, date_creation, taux,id_client) VALUES (5000, "2017-05-12", 3.5,1);
INSERT INTO comptesepargnes(solde, date_creation, taux,id_client) VALUES (1325, "2017-12-06", 1.5,3);


--Ajout des clés étrangères 

ALTER TABLE  clients ADD FOREIGN KEY(id_conseille) REFERENCES conseilles(id);
ALTER TABLE  comptescourants ADD FOREIGN KEY(id_client) REFERENCES clients(id);
ALTER TABLE  comptesepargnes ADD FOREIGN KEY(id_client) REFERENCES clients(id);

--DROP DATABASE proxybanquev2_avofle;
--Connexion avec mysql -u root -p

--Création de la BBDD
CREATE DATABASE IF NOT EXISTS proxybanquev2_avofle;
use proxybanquev2_avofle;
CREATE TABLE IF NOT EXISTS conseilles (id int NOT NULL AUTO_INCREMENT, prenom varchar(30) NOT NULL, nom varchar(30) NOT NULL, login varchar(30)  NOT NULL, password varchar(30) NOT NULL, PRIMARY KEY(id));
CREATE TABLE IF NOT EXISTS conseilles_clients (id int NOT NULL AUTO_INCREMENT, id_conseille int NOT NULL, id_client int NOT NULL, PRIMARY KEY(id));
CREATE TABLE IF NOT EXISTS clients (id int NOT NULL AUTO_INCREMENT, prenom varchar(30) NOT NULL, nom varchar(30) NOT NULL, tel int(10) NOT NULL, adresse varchar(100) NOT NULL, code_postal int(5) NOT NULL, ville varchar(30) NOT NULL, PRIMARY KEY(id));
CREATE TABLE IF NOT EXISTS clients_comptescourants (id int NOT NULL AUTO_INCREMENT, id_client int NOT NULL, id_comptecourant int NOT NULL, PRIMARY KEY(id));
CREATE TABLE IF NOT EXISTS comptescourants (id int NOT NULL AUTO_INCREMENT, solde decimal(7.2) NOT NULL, date_creation date NOT NULL, decouvert decimal(7.2) NOT NULL, PRIMARY KEY(id));
CREATE TABLE IF NOT EXISTS clients_comptesepargnes (id int  NOT NULL AUTO_INCREMENT, id_client int NOT NULL, id_compteepargne int NOT NULL, PRIMARY KEY(id));
CREATE TABLE IF NOT EXISTS comptesepargnes (id int NOT NULL AUTO_INCREMENT, solde decimal(7.2) NOT NULL, date_creation date NOT NULL, taux decimal(3.2) NOT NULL, PRIMARY KEY(id));
-- Création des enregistrements
INSERT INTO conseilles (prenom, nom, login, password) VALUES ("admin_prenom", "admin_nom", "admin", "admin");
INSERT INTO clients (prenom,nom,tel,adresse,code_postal,ville) VALUES ("Mickael", "Kael", 0656874123, "25 rue des poiriers",75015, "Paris");
INSERT INTO clients (prenom,nom,tel,adresse,code_postal,ville) VALUES ("Edgar", "Grospiron", 0450697825, "13 av des pommier",74000, "Annecy");
INSERT INTO clients (prenom,nom,tel,adresse,code_postal,ville) VALUES ("Julie", "Gayet", 0688152647, "8 boulevard de l'Elysee",75001, "Paris");
INSERT INTO conseilles_clients(id_conseille, id_client) VALUES (1,1);
INSERT INTO conseilles_clients(id_conseille, id_client) VALUES (1,2);
INSERT INTO conseilles_clients(id_conseille, id_client) VALUES (1,3);
INSERT INTO comptescourants(solde, date_creation, decouvert) VALUES (5000, "2017-05-12", 500);
INSERT INTO comptescourants(solde, date_creation, decouvert) VALUES (2500, "2012-06-08", 250);
INSERT INTO comptescourants(solde, date_creation, decouvert) VALUES (-50, "2016-11-05", 100);
INSERT INTO clients_comptescourants(id_client, id_comptecourant) VALUES (1,1);
INSERT INTO clients_comptescourants(id_client, id_comptecourant) VALUES (2,2);
INSERT INTO clients_comptescourants(id_client, id_comptecourant) VALUES (3,3);
INSERT INTO comptesepargnes(solde, date_creation, taux) VALUES (5000, "2017-05-12", 3.5);
INSERT INTO comptesepargnes(solde, date_creation, taux) VALUES (1325, "2017-12-06", 1.5);
INSERT INTO clients_comptesepargnes(id_client, id_compteepargne) VALUES (1,1);
INSERT INTO clients_comptesepargnes(id_client, id_compteepargne) VALUES (3,2);

--Ajout des clés étrangères 

ALTER TABLE  conseilles_clients ADD FOREIGN KEY(id_conseille) REFERENCES conseilles(id);
ALTER TABLE  conseilles_clients ADD FOREIGN KEY (id_client) REFERENCES clients(id);
ALTER TABLE  clients_comptescourants ADD FOREIGN KEY(id_client) REFERENCES clients(id);
ALTER TABLE  clients_comptescourants ADD FOREIGN KEY(id_comptecourant) REFERENCES comptescourants(id);
ALTER TABLE  clients_comptesepargnes ADD FOREIGN KEY(id_client) REFERENCES clients(id);
ALTER TABLE  clients_comptesepargnes ADD FOREIGN KEY(id_compteepargne) REFERENCES comptesepargnes(id);

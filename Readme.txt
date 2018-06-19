# ProxiBanqueSI Version 2                                             19/06/2018
Antoine Volatron et Fabien Lenoir
--------------------------------------------------------------------------------

## I_Introduction

La Banque ProxiBanque, la banque proche de ses client.
L'application ProxiBanqueSI permets aux conseillers de client�les de se connecter 
et d'effectuer des actions sur les clients ainsi que leurs comptes associ�s.

## II_Fonctionnalit�s

Le Conseiller de client�le peut : 
- Cr�er un client
- Modifier les informations du client (Nom, Pr�nom, Mail et Adresse)
- Lire les informations de ses clients
- Supprimer un client
- Afficher les comptes d'un client sp�cifi�
- Cr�er des comptes pour un client sp�cifi�
- Effectuer des virements compte � compte pour un client sp�cifi�

## III_Installation

Pour utiliser ProxiBanqueSI v2.0 : 
------ Installer l'application ------
1) Copier le projet ProxiBanqueV2.jar dans le workspace d'Eclipse.
2) Ouvrez Eclipse
3) Importez le projet (File -> Import -> General -> ArchiveFile).
4) S�lectionner le fichier ProxiBanqueV2.jar
5) S�lectionner le dossier o� importer le fichier
6) Cliquer sur Finish.

------ Cr�er la base de donn�e MySQL ------
1) Ouvrir Xampp
2) Lancer Apache
3) Lancer MySQL
4) Lancer le controle Admin de MySQL sur Xampp
5) Cliquer sur l'onglet "console" de Xampp
6) taper : "mysql -u root -p" puis tapez [entr�e]
7) Dans le dossier PB_V2_AVOFLE, ouvrir le dossier Util et ouvrez dans un �diteur texte le fichier "CreationDBProxBanque_V2.sql"
8) Copier l'enti�ret� du fichier
9) Dans la console, coller le texte copi�.
10) La base de donn�e a �t� cr�e dans MySQL.

------ Lancer l'application ------
1) Lancer TomCat "tomcat-8.5.31"
2) Ouvrez un navigateur internet
3) Tapez dans l'url : http://localhost:8080/proxibanque/

## IV_Utilisation

Au d�marrage l'application ProxiBanqueV2 affiche une page de connexion.
Seuls les conseillers de client�les peuvent se connecter. 

Un login et un mot de passe est demand�.
Par d�faut 2 conseillers de client�le ont �t� d�finis avec 
	- conseiller 1:
		# login :"admin"			
		# password "admin"
	- conseiller 2:
		# login :"tim"			
		# password "tim1"

Si vous vous trompez, une page vous demandant de vous connecter avec de bons param�tres d'itentifications apparait. 
		
A chaque conseiller a �t� attribu� 3 client.
A chaque client a �t� cr�� un nombre de Comptes Epargnes et de Compte Courant al�atoire ainsi que des montant eux aussi al�atoire.
    
=== Une fois identifi� ===

Une page "Liste des clients" vous liste les clients qui vons sont associ�s.
Votre nom et pr�nom est affich� en haut � droit de l'�cran ainsi que le statut "Connect�"

Plusieurs choix s'offrent � vous :
	- En renseignant le formulaire qui est apparut sous le tableau de clients, vous pouvez cr�er un nouveau client.
		# Une fois le bouton [Cr�er] cliqu�, la page ets mise � jour et le nouveau client apparait dans le tableau.
		
    - [Edition] : �diter un client
		#  Une fois cliqu� une nouvelle page apparait vous affichant les caract�ristiques du client. 
		# Il vous est alors possible de modifier ses caract�ristiques � partir du formulaire puis de cliquer sur le bouton [Modifier]
		Vous retournez au menu principal "Liste des Clients"
		
    - [Liste des comptes] : de lister les comptes d'un client
		# Une fois cliqu� une nouvelle page vous affiche la liste des comptes du clients tri� par Commpte Courant et Compte Epargne.
		# Avec le formulaire il vous est possible de cr�er un nouveau Compte Courant ou Compte Epargne.
		# Pour revenir � la liste des clients cliquez sur l'onglet "Liste des Clients" au centre de la page.
		
	- [Virements] : d'effectuer un virement compte � compte d'un client
		# Une fois cliqu� une nouvelle page vous affiche les diff�rents comptes du client s�l�ctionn�
		# Vous pouvez effectuer des virements comptes � comptes avec le formulaire : 
			- s�lectionner le compte � d�biter
			- s�lectionner le compte � cr�diter
			- s�lectionner le montant
			- cliquer sur [effectuer le virement]
			- La page est alors mise � jour.
		# Pour revenir � la liste des clients cliquez sur l'onglet "Liste des Clients" au centre de la page.
		
	- [Suppression]	: de supprimer un client
		- Une fois cliqu�, le client est supprimer de la Banque de Donn�e.

A chaque �tape de votre navigation, le bouton [Logout] bleu vous permettra de vous deconnecter et de revenir au menu d'authentification.

## V_EVOLUTIONS
    - Dans de futures versions, l'application pourra proposer � ses acteurs 
      les fonctionnalit�s qui ne sont pas pr�sentes � l'heure actuelle.
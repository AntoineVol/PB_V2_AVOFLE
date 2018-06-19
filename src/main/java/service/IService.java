package service;

import java.util.List;

import domaine.Client;
import domaine.CompteCourant;
import domaine.CompteEpargne;
import domaine.Conseille;

/**
 * Interface de la couche service
* @author KHEZNADJI et VOLATRON
 * @version 1.0
 */
public interface IService {
	

	/**
	 * Methode utilisée pour la création en base de donnée d'un client attaché au conseillé identifié
	 * @param clt Client à créer
	 * @param csl Conseillé du client
	 */
	public void createClient(Client clt, Conseille csl);
	/**
	 * Methode utilisée pour la modification en base de donnée d'un client
	 * @param clt Client à modifier
	 */
	public void upClient(Client clt);
	/**
	 * Methode utilisée pour la suppression en base de donnée d'un client à partir de son id
	 * @param id id du client à supprimer
	 */
	public void deleteClient(int id);
	/**
	 * Methode retournant un client à partir de son id
	 * @param id id du client à retourner 
	 * @return Client de l'id renseigné
	 */
	public Client getClientByID(int id);
	/**
	 * Methode retournant tous les clients d'un conseillé enregistrés en base de donnée
	 * @param idConseille Conseillé dont les clients sont recherchés
	 * @return Liste de client du conseille
	 */
	public List<Client> allClient(int idConseille);
	
	/**
	 * Mehode permettant de créer un nouveau compte courant pour un client 
	 * @param cpt Compte à créer
	 * @param clt Client attribué au compte
	 */
	public void createCompteCourant(CompteCourant cpt, Client clt);
	/**
	 * Mehode permettant de créer un nouveau compte epargne pour un client 
	 * @param cep Compte à créer
	 * @param clt Client attribué au compte
	 */
	public void createCompteEpargne(CompteEpargne cep, Client clt);

	public void deleteCompteCourant(int id);
	public void deleteCompteEpargne(int id);
	public CompteCourant getCompteCourantByID(int id);
	public List<CompteCourant> allCompteCourant();

	
	public List<CompteCourant> allCompteCourantByIdClient(int id);
	public List<CompteEpargne> allCompteEpargneByIdClient(int id);
	
	public boolean identifyConseille(String login, String password);
	public Conseille getConseillerByLogin(String login);
	public Conseille getConseilleByID(int id);
	
	public void moneyWithdrawCompteCourant(int idCompte, double montant);
	public void moneyWithdrawCompteEpargne(int idCompte, double montant);
	public void moneyPayCompteCourant(int idCompte, double montant);
	public void moneyPayCompteEpargne(int idCompte, double montant);
	
	
	

}


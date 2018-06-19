package dao;

import java.util.List;

import domaine.Client;
import domaine.CompteCourant;
import domaine.CompteEpargne;
import domaine.Conseille;

/**
 * Interface de la couche DAO regissant les méthodes réalisant les requètes SQL
 * @author VOLATRON & LENOIR
 *
 */
public interface IDao {

	

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
	public List<Client> allClient(int id_csl);
	
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

	/**
	 * Methode permettant de supprimer en base de donnée un compte courant à partir de son id
	 * @param id id du compte à supprimer
	 */
	public void deleteCompteCourant(int id);
	/**
	 *  Methode permettant de recupérer un compte courant à partir de son id
	 * @param id id du compte à récuperer
	 * @return Compte courant à récuperer
	 */
	public CompteCourant getCompteCourantByID(int id);
	/**
	 * Methode permettant de recupérer tous les comptes courant d'un client à partir de son id
	 * @param id id du client dont les comptes courants sont récupérés
	 * @return Une liste des comptes courant du client
	 */
	public List<CompteCourant> allCompteCourantByClientId(int id);
	
	
	/**
	 *  Methode permettant de supprimer en base de donnée un compte epargne à partir de son id
	 * @param id id du compte à supprimer
	 */
	public void deleteCompteEpargne(int id);
	/**
	 *  Methode permettant de recupérer un compte epargne à partir de son id
	 * @param idCompte id du compte à récuperer
	 * @return Compte epargne à récuperer
	 */
	public CompteEpargne getCompteEpargneByID(int idCompte);
	/**
	 * Methode permettant de recupérer tous les comptes epargnes d'un client à partir de son id
	 * @param id id du client dont les comptes epargnes sont récupérés
	 * @return Une liste des comptes epargnes du client
	 */
	public List<CompteEpargne> allCompteEpargneByClientId(int id);
	
	/**
	 * Methode permettant le versement d'argent un compte courant identifié par son id
	 * @param idCompte id identifiant le compte
	 * @param montant Montant à verser sur le compte
	 */
	public void moneyWithdrawCompteCourant(int idCompte, double montant);
	/**
	 * Methode permettant le versement d'argent un compte epargne identifié par son id
	 * @param idCompte id identifiant le compte
	 * @param montant Montant à verser sur le compte
	 */
	public void moneyWithdrawCompteEpargne(int idCompte, double montant);
	/**
	 * Methode permettant le retrait d'argent un compte courant identifié par son id
	 * @param idCompte id identifiant le compte
	 * @param montant Montant à verser sur le compte
	 */
	public void moneyPayCompteCourant(int idCompte, double montant);
	/**
	 * Methode permettant le retrait d'argent un compte epargne identifié par son id
	 * @param idCompte id identifiant le compte
	 * @param montant Montant à verser sur le compte
	 */
	public void moneyPayCompteEpargne(int idCompte, double montant);
	
	/**
	 * Methode retournant true si le couple login password est dans la base de donnée des conseillés
	 * @param login Login du conseillé
	 * @param password Mot de passe du conseillé
	 * @return true si le login est valide ou false si le login est invalide
	 */
	public boolean checkConseilleId(String login, String password);
	/**
	 * Methode retournant un conseillé identifié à partir de son id
	 * @param id id du conseillé
	 * @return Conseillé identifié par l'id
	 */
	public Conseille getConseilleByID(int id);
	/**
	 * Methode retournant un conseillé identifié à partir de son login
	 * @param login Login du conseillé
	 * @return Conseille identifié par ce login
	 */
	public Conseille getConseilleByLogin(String login);

	
	

}


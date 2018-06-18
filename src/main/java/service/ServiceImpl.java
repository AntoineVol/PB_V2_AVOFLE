package service;

import java.util.ArrayList;
import java.util.List;

import dao.DaoImpl;
import dao.IDao;
import domaine.Client;
import domaine.Compte;
import domaine.CompteCourant;
import domaine.CompteEpargne;
import domaine.Conseille;

/**
 * @author Adminl Classe d'implémentation de l'interface IService
 */
public class ServiceImpl implements IService {	
	
	// Début implémentation Design Pattern Singleton -> Classe n'ayant qu'une
	// seule et unique instance.

	private static ServiceImpl INSTANCE;

	public static ServiceImpl getSingleton() {
		return ServiceImpl.INSTANCE;
	}

	public static void prepareSingleton(int idCount)
			throws UnsupportedOperationException {
		if (ServiceImpl.INSTANCE == null) {
			ServiceImpl.INSTANCE = new ServiceImpl();
		} else {
			throw new UnsupportedOperationException();
		}
	}

	// Fin implémentation Singleton.
	
	IDao dao = new DaoImpl();

	// FIXME instancier le conseiller au moment du login

	public void createClient(Client c, Conseille csl) {
		dao.createClient(c);

	}

	public void upClient(Client c) {
		dao.upClient(c);
	}

	public void deleteClient(int id) {
		dao.deleteClient(id);

	}

	public Client getClientByID(int id) {
		return dao.getClientByID(id);
	}

	public List<Client> allClient(int idConseille) {
		List<Client> listClient = new ArrayList<Client>(dao.allClient(idConseille));
		return listClient;
	}

	public void createCompteCourant(CompteCourant cpt, Client clt) {
		// TODO Recupérer un client avec les infos du front
		// TODO Créer un compte à partir du front
		dao.createCompteCourant(cpt);

	}

	public void upCompteCourant(CompteCourant c) {
		dao.upCompteCourant(c);

	}

	public void deleteCompteCourant(int id) {

		dao.deleteCompteCourant(id);

	}

	public CompteCourant getCompteCourantByID(int id) {
		return dao.getCompteCourantByID(id);
	}

	public List<CompteCourant> allCompteCourant() {
		return dao.allCompteCourant();
	}

	public boolean identifyConseille(String login, String password) {
		boolean idConseille;
		idConseille = dao.checkConseilleId(login, password);
		if (idConseille == true) {
			return true;
		} else {
			return false;
		}
	}

	public boolean transfer(int idComptePreleve, int idCompteCredite, double montant) {
		if (dao.getCompteCourantByID(idComptePreleve).getSolde() >= montant) {
			dao.moneyTransfer(idComptePreleve, idCompteCredite, montant);
			return true;
		}else {
			return false;
		}
	}
	
	public List<CompteCourant> allCompteCourantByIdClient(int id){
		List<CompteCourant> listCompte = new ArrayList<CompteCourant>(dao.allCompteCourantByClientId(id));
		return listCompte;
	}
	
	public List<CompteEpargne> allCompteEpargneByIdClient(int id){
		List<CompteEpargne> listCompte = new ArrayList<CompteEpargne>(dao.allCompteEpargneByClientId(id));
		return listCompte;
	}

	@Override
	public Conseille getConseillerByLogin(String login) {
		Conseille csl = dao.getConseilleByLogin(login);
		return csl;
	}

}


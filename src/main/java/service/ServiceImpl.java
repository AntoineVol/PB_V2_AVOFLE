package service;

import java.util.ArrayList;
import java.util.List;

import dao.DaoImpl;
import dao.IDao;
import domaine.Client;
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
		dao.createClient(c,csl);
	}

	public void deleteClient(int id) {
		List<CompteCourant> listCompteCourant =new ArrayList<CompteCourant>(dao.allCompteCourantByClientId(id));
		for(CompteCourant cpt :listCompteCourant) {
			dao.deleteCompteCourant(cpt.getId());
		}
		List<CompteEpargne> listCompteEpargne =new ArrayList<CompteEpargne>(dao.allCompteEpargneByClientId(id));
		for(CompteEpargne cpt :listCompteEpargne) {
			dao.deleteCompteEpargne(cpt.getId());
		}
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

		dao.createCompteCourant(cpt, clt);

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
	
	public Conseille getConseilleByID(int id) {
		return dao.getConseilleByID(id);
	}

	@Override
	public void createCompteEpargne(CompteEpargne cep, Client clt) {
		dao.createCompteEpargne(cep, clt);		
	}
	
	public void moneyWithdrawCompteCourant(int idCompte, double montant) {
		dao.moneyWithdrawCompteCourant(idCompte, montant);
	}
	public void moneyWithdrawCompteEpargne(int idCompte, double montant) {
		dao.moneyWithdrawCompteEpargne(idCompte, montant);
	}
	public void moneyPayCompteCourant(int idCompte, double montant) {
		dao.moneyPayCompteCourant(idCompte, montant);
	}
	public void moneyPayCompteEpargne(int idCompte, double montant) {
		dao.moneyPayCompteEpargne(idCompte, montant);
	}


	@Override
	public void upClient(Client clt) {
		dao.upClient(clt);
	}

}


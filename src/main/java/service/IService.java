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
	

	public void createClient(Client c, Conseille csl);
	public void upClient(Client c);
	public void deleteClient(int id);
	public Client getClientByID(int id);
	public List<Client> allClient(int idConseille);
	
	public void createCompteCourant(CompteCourant cpt, Client clt);
	public void upCompteCourant(CompteCourant cpt);
	public void deleteCompteCourant(int id);
	public CompteCourant getCompteCourantByID(int id);
	public List<CompteCourant> allCompteCourant();
	public boolean transfer (int idComptePreleve, int idCompteCredite, double montant);
	
	public List<CompteCourant> allCompteCourantByIdClient(int id);
	public List<CompteEpargne> allCompteEpargneByIdClient(int id);
	
	public boolean identifyConseille(String login, String password);
	
	
	
	
	

}


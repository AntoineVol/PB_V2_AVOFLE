package dao;

import java.util.List;

import domaine.Client;
import domaine.CompteCourant;
import domaine.CompteEpargne;
import domaine.Conseille;

public interface IDao {

	

	public void createClient(Client clt);
	public void upClient(Client c);
	public void deleteClient(int id);
	public Client getClientByID(int id);
	public List<Client> allClient(int id_csl);
	
	public void createCompteCourant(CompteCourant cpt);
	public void upCompteCourant(CompteCourant c);
	public void deleteCompteCourant(int id);
	public CompteCourant getCompteCourantByID(int id);
	public List<CompteCourant> allCompteCourant();
	public List<CompteCourant> allCompteCourantByClientId(int id);
	
	public List<CompteEpargne> allCompteEpargneByClientId(int id);
	
	public boolean moneyTransfer(int idComptePreleve, int idCompteCredite, double montant);
	public boolean moneyWithdraw(int idCompte, double montant);
	public boolean moneyPay(int idCompte, double montant); 
	
	public boolean checkConseilleId(String login, String password);
	public Conseille getConseilleByID(int id);
	public Conseille getConseilleByLogin(String login);

	
	

}


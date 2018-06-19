package dao;

import java.util.List;

import domaine.Client;
import domaine.CompteCourant;
import domaine.CompteEpargne;
import domaine.Conseille;

public interface IDao {

	

	public void createClient(Client clt, Conseille csl);
	public void upClient(Client clt);
	public void deleteClient(int id);
	public Client getClientByID(int id);
	public List<Client> allClient(int id_csl);
	
	public void createCompteCourant(CompteCourant cpt, Client clt);
	public void createCompteEpargne(CompteEpargne cep, Client clt);

	public void deleteCompteCourant(int id);
	public CompteCourant getCompteCourantByID(int id);
	public List<CompteCourant> allCompteCourant();
	public List<CompteCourant> allCompteCourantByClientId(int id);
	
	
	public void deleteCompteEpargne(int id);
	public CompteEpargne getCompteEpargneByID(int idCompte);
	public List<CompteEpargne> allCompteEpargneByClientId(int id);
	
	public void moneyWithdrawCompteCourant(int idCompte, double montant);
	public void moneyWithdrawCompteEpargne(int idCompte, double montant);
	public void moneyPayCompteCourant(int idCompte, double montant);
	public void moneyPayCompteEpargne(int idCompte, double montant);
	
	public boolean checkConseilleId(String login, String password);
	public Conseille getConseilleByID(int id);
	public Conseille getConseilleByLogin(String login);

	
	

}


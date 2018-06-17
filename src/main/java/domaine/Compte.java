package domaine;
/**
 * Compte est la classe repr�sentant les comptes des clients BroxiBanque.
 * @author KHEZNADJI et VOLATRON
 * @version 1.0
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class Compte {
	/**
	 * Le nombre de comptes bancaires de client.
	 */
	private static int nbCompte=0;
	/**
	 * L'ID du compte bancaire.
	 */
	private int id;
	/**
	 * Le solde du compte bancaires
	 */
	private double solde;
	/**
	 * La date de cr�ation de compte bancaire.
	 */
	private String date;
	/**
	 * Le type de compte bancaire.
	 */
	private String typeCompte;
	/**
	 * Instanciation de la carte bancaire par null.
	 */
	private CB cb=null;
	
	/**
	 * Le client de la banque.
	 */
	
	private Client client;
	
	public Compte() {}
	
	/**
	 * Le constructeur d'un objet Compte avec plusieurs param�tres.
	 * @param solde du compte bancaire.
	 * @param date du compte bancaire.
	 * @param typeCompte du compte bancaire.
	 * @param cb du client 
	 * @param client de la banque. 
	 */
	public Compte(double solde, String date, String typeCompte, CB cb, Client client) {
		super();
		this.id = nbCompte;
		this.solde = solde;
		this.date = date;
		this.typeCompte = typeCompte;
		this.cb = cb;
		this.client = client;
		nbCompte++;
	}


	/**
	 * Le constructeur avec les attributs id solde, date, typeCompte et date.
	 * @param solde Solde initiale du comtpe
	 */
	public Compte(double solde) {
		super();
		this.id = nbCompte;
		this.solde = solde;
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yy");
		Date Auj = new Date();
		this.date = formater.format(Auj);
		nbCompte++;
	}

	/**
	 * Retourne l'ID du compte.
	 * @return l'ID.
	 */
	public int getId() {
		return id;
	}
	/**
	 * Met � jour l'ID du compte bancaire.
	 * @param id du compte.
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Retourne le solde du compte bancaire.
	 * @return le solde.
	 */
	public double getSolde() {
		return solde;
	}
	/**
	 * Met � jour le solde.
	 * @param solde Solde du compte
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}
	/**
	 * Retourne la date de cr�ation du compte bancaire.
	 * @return la date de cr�ation cu compte.
	 */
	public String getDate() {
		return date;
	}
	/**
	 * Met � jour la date de cr�ation du compte bancaire
	 * @param date de cr�ation du compte.
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * Retourne le type du compte bancaire.
	 * @return le type du compte bancaire.
	 */
	public String getTypeCompte() {
		return typeCompte;
	}
	/**
	 * Met � jour le type du compte bancaire.
	 * @param typeCompte Type de compte bancaire
	 */
	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}
	/**
	 * Retourne la carte bancaire.
	 * @return Retourne la carte bancaire.
	 */
	public CB getCb() {
		return cb;
	}
	/**
	 * Met � jour la carte bancaire
	 * @param cb Carte Bancaire du compte
	 */
	public void setCb(CB cb) {
		this.cb = cb;
	}
	/**
	 * Retourne le client de la banque.
	 * @return le client 
	 */
	public Client getClient() {
		return client;
	}
	/**
	 * Met � jour le Client de la Banque 
	 * @param client de la banque.
	 */
	public void setClient(Client client) {
		this.client = client;
	}

}

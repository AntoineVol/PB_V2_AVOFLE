package domaine;

/**
 * Classe des comptes bancaires génériques
 * @author LENOIR & ANTOINE
 *
 */
public class Compte {
	private int id;
	private double solde;
	private String date;
	private boolean typeCompteCourant;
	
	/**
	 * Constructeur par default
	 * Par default, les comptes sont identifié comme "différent de compte courant" par l'attribut "typrCompteCourant=false"
	 * Cet attribut sera setter à true dans le cas des comptes courants lors de leurs recupération en base de donnée
	 */ 
	public Compte() {
		this.typeCompteCourant =false;
	}
	
	/**
	 * Constructeur élaboré
	 * @param solde Solde à initlialiser lors de la création du compte
	 */
	public Compte(double solde) {
		this.typeCompteCourant =false;
		this.solde = solde;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isTypeCompteCourant() {
		return typeCompteCourant;
	}

	public void setTypeCompteCourant(boolean typeCompteCourant) {
		this.typeCompteCourant = typeCompteCourant;
	}


}

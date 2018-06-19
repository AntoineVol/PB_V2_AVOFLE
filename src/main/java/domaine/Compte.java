package domaine;

public class Compte {
	private int id;
	private double solde;
	private String date;
	private boolean typeCompteCourant;
	
	public Compte() {
		this.typeCompteCourant =false;
	}
	
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

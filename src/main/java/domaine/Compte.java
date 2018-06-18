package domaine;

public class Compte {
	private int id;
	private double solde;
	private String date;
	
	public Compte() {}
	
	public Compte(double solde) {
		super();
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


}

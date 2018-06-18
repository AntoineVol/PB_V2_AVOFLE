package domaine;

public class CompteEpargne extends Compte {

	private double taux;

	public CompteEpargne() {
		super();
	}
	public CompteEpargne(double solde, double tx) {
		super(solde);
		this.taux = tx;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double tx) {
		this.taux = tx;
	}
}

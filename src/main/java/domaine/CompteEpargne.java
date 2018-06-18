package domaine;

 
public class CompteEpargne extends  Compte {

	private double taux;

	/**
	 * Le constructeur d'un objet compteEpargne
	 * @param solde du compteEpargne
	 * @param tx de r�mun�ration du compteEpargne
	 */
	public CompteEpargne(double solde,double tx) {
		super(solde);
		this.taux = tx;
	}

	public double getTx() {
		return taux;
	}
 void setTaux(double tx) {
		this.taux = tx;
	}
}

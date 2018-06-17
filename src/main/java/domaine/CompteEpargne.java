package domaine;
/**
 * CompteEpargne est la classe représentant un compte créée par  la banque BroxiBanque
 * @author KHEZNADJI et VOLATRON
 * @version 1.0
 */
 
public class CompteEpargne extends  Compte {
	/**
	 * Le taux de rémunération du compte épargne.
	 */
	private double tx;

	/**
	 * Le constructeur d'un objet compteEpargne
	 * @param solde du compteEpargne
	 * @param tx de rémunération du compteEpargne
	 */
	public CompteEpargne(double solde,double tx) {
		super(solde);
		this.tx = tx;
	}

	/**
	 * Retourne un taux de rémunération du compteEpargne
	 * @return Taux de rémunération du compteEpargne
	 */
	public double getTx() {
		return tx;
	}
	/**
	 * Met à jour le taux de rémunération du compteEpargne
	 * @param tx Taux de rémunération du compteEpargne
	 */
	public void setTx(double tx) {
		this.tx = tx;
	}
	/**
	 * Décrit l'instanciation d'un compteEpargne.
	 */
	public String toString() {
		return "Compte Epargne : " + this.getId() + " | solde :" + this.getSolde() + " | Taux : "+ this.tx +" | créee le :" +this.getDate(); 
	}
}

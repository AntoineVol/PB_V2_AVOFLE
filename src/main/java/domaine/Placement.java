package domaine;

/**
 * Placement est la classe représentant un placement d'un patrimoine géré par
 * l'agence de la banque BroxiBanque.
 * 
 * @author KHEZNADJI et VOLATRON
 * @version 1.0
 */
public class Placement {
	/**
	 * Le client qui va placer son patrimoine dans une bourse.
	 */
	private Client client;
	/**
	 * Le compte du client de la banque.
	 */
	private Compte compte;
	/**
	 * La bourse où va être placé le patrimoine .
	 */
	private Bourse bourse;
	/**
	 * Le montant de placement 
	 */
	private double mt;

	/**
	 * Le constructeur d'un objet placement 
	 * @param client de la banque 
	 * @param compte du client 
	 * @param bourse de Paris, New york ou Tokyo.
	 * @param mt Montant du placement
	 */

	public Placement(Client client, Compte compte, Bourse bourse, double mt) {
		super();
		this.client = client;
		this.compte = compte;
		this.bourse = bourse;
		this.mt = mt;
	}

	/**
	 * Retourne le client de la banque.
	 * @return le client.
	 */
	public Client getClient() {
		return client;
	}
	/**
	 * Met à jour le client d la banque .
	 * @param client de la banque.
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	/**
	 * Retourne le compte client de la banque.
	 * @return le compte client.
	 */
	public Compte getCompte() {
		return compte;
	}
	/**
	 * Met à jour le compte client de la banque.
	 * @param compte client.
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	/**
	 * Retourne la bourse .
	 * @return la bourse .
	 */
	public Bourse getBourse() {
		return bourse;
	}
	/**
	 * Met à jour la bourse.
	 * @param bourse Bourse (Tokyo, NY,...)
	 */
	public void setBourse(Bourse bourse) {
		this.bourse = bourse;
	}
	/**
	 * Retourne le montant de placement.
	 * @return le montant 
	 */
	public double getMt() {
		return mt;
	}
	/**
	 * Met à jour le montant du placement .
	 * @param mt du placement 
	 */
	public void setMt(double mt) {
		this.mt = mt;
	}

}

package domaine;
/**
 * CompteCourant  est la classe repr�sentant le compte courant d'un client de la banque BroxiBanque
 * @author KHEZNADJI et VOLATRON
 * @version 1.0
 */
public class CompteCourant extends Compte {
	/**
	 * Le d�couvert autoris� par la banque 
	 */
	private double dec;

	/**
	 * Le constructeur d'un objet compteCourant d'un client.
	 * @param solde du compteCourant
	 * @param dec du compteCourant
	 */
	public CompteCourant() {
		super();
	}
	
	public CompteCourant(double solde, double dec) {
		super(solde);
		this.dec = dec;
	}

	



	/**
	 * Retourne le d�couvert autoris� pour le client
	 * @return le d�couvert
	 */
	public double getDec() {
		return dec;
	}
	/**
	 * Met � jour le d�couvert autoris� par la banque.
	 * @param dec autoris�
	 */
	public void setDec(double dec) {
		this.dec = dec;
	}
	/**
	 * D�crit l'instanciation d'un compteCourant
	 */
	public String toString() {
		return "Compte Courant : " + this.getId() + " | solde :" + this.getSolde() + " | decouvert authoris�e : "+ this.dec +" | cr�ee le :" +this.getDate(); 
	}
}

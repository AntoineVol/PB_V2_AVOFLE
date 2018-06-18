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
	private double decouvert;

	public CompteCourant() {
		super();
	}
	
	public CompteCourant(double solde, double dec) {
		super(solde);
		this.decouvert = dec;
	}

	public double getDec() {
		return decouvert;
	}

	public void setDec(double dec) {
		this.decouvert = dec;
	}

}

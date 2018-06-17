package exceptions;

/**
 * @author KHEZNADJI et VOLATRON
 * @version 1.0
 * Classe Exception veillant à ce que le montant retiré soit inferieur au montant disponible (Decouvert authorisé pris en compte)
 */
public class MontantSuperieurSoldeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message Message alertant dans le cas où le solde n'est pas suffisant
	 */
	public MontantSuperieurSoldeException(String message) {
		super(message);
	}
	
}

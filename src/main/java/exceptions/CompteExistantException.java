package exceptions;

/**
 * @author KHEZNADJI et VOLATRON
 * @version 1.0
 *	Classe Exception permettant de vérifier l'existance d'un compte
 */
public class CompteExistantException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message Message indiquant l'inexistance d'un compte
	 */
	public CompteExistantException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}

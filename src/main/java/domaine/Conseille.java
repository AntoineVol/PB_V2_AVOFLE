package domaine;

/**
 * Classe des conseillés. 
 * @author LENOIR et VOLATRON
 */
public class Conseille extends Personne {
	private int id;
	private String login;
	private String Password;
	
	/**
	 * Constructeur par defaut
	 */
	public Conseille() {
		super();
	}

	/**
	 * Constructeur élaboré
	 * @param nom Nom du conseillé
	 * @param prenom Prenom du conseillé
	 * @param login Login du conseillé
	 * @param password Mot de passe du conseillé
	 */
	public Conseille(String nom, String prenom, String login, String password) {
		super( nom,prenom);
		this.login = login;
		this.Password=password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
}

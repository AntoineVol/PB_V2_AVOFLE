package domaine;

public class Conseille extends Personne {
	private int id;
	private String login;
	private String Password;
	
	public Conseille() {
		super();
	}

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

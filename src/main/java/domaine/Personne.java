package domaine;

public abstract class Personne {

	private String nom;

	private String prenom;

	private String mail;

	private String adresse;

	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Personne(String nom, String prenom, String mail, String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.adresse = adresse;

	}

	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;

	}

	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


}

package domaine;
/**
 * Personne est la classe représentant les clients, les conseillés et les gérants.
 * @author KHEZNADJI et VOLATRON
 * @version 1.0
 *
 */
public abstract class Personne {
	/**
	 * Le nom de la personne.
	 */
	private String nom;
	/**
	 * Le prénom de la personne.
	 */
	private String prenom;
	/**
	 * le téléphone de la personne.
	 */
	private String tel;
	/**
	 * L'adresse de la personne.
	 */
	private String adresse;
	/**
	 * Le code postal de la ville où habite cette personne.
	 */
	private int codePostal;
	/**
	 * La ville où habite cette personne.
	 */
	private String ville;

	/**
	 * Le constructeur par défaut
	 */
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Le Constructeur d'un objet personne avec plusieurs paramètres.
	 * @param nom de la personne.
	 * @param prenom de la personne.
	 * @param tel de la personne.
	 * @param adresse de la personne.
	 * @param codePostal de la personne.
	 * @param ville de la personne.
	 */
	public Personne(String nom, String prenom, String tel, String adresse, int codePostal, String ville) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.adresse = adresse;
		this.codePostal=codePostal;
		this.ville=ville;
	}
	/**
	 * Le constructeur d'un objet personne avec les paramètres nom et prénom uniquement.
	 * @param nom de la personne.
	 * @param prenom de la personne.
	 */
	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;

	}

	/**
	 * Retourne le nom de la personne.
	 * @return le nom.
	 */
	
	public String getNom() {
		return nom;
	}
	/**
 	* Retourne le code postal de la ville où habite la personne.
 	* @return le code postal.
 	*/
	public int getCodePostal() {
		return codePostal;
	}
	/**
 	* Met à jour le code postal.
 	* @param codePostal de la ville 
 	*/
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	/**
 	* Retourne la ville où habite la personne.
 	* @return la ville 
 	*/
	public String getVille() {
		return ville;
	}
	/**
	 * Met à jour la ville où habite la personne.
	 * @param ville Ville de l'adresse
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	/**
	* Met à jour le nom de la personne.
	* @param nom de la personne.
	*/
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * Retourne le prénom de la personne.
	 * @return le prénom.
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * Met à jour la prénom de la personne.
	 * @param prenom de la personne.
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * Reourne le numéro de téléphone de la personne.
 	* @return le numéro de téléphone.
 	*/
	public String getTel() {
		return tel;
	}
	/**
	 * Met à jour le numéro de téléphone.
	 * @param tel de la personne.
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * Retourne l'adresse de la personne.
	 * @return l'adresse.
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * Met à jour L'adresse de la personne.
	 * @param adresse de la personne.
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	/**
	 * Redéfinition de Tostring pour Personne.
	 */
	public String toString() {
		return this.prenom + " " + this.nom;
	}

}

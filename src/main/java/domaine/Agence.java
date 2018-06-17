package domaine;

/**
 * 
 * Agence est la classe représentant une agence de la banque BroxiBanque
 * @author KHEZNADJI et VOLATRON
 * @version 1.0
 */
public class Agence {
	/**
	 * L'ID de l'Agence. Il contient 5 caractères alphanumérique.
	 */
	private String id;
	/**
	 * La date de création de l'Agence.
	 */
	private String date;
	/**
	 * La Banque à laquelle fait partie l'Agence
	 */
	private Banque banque;
	/**
	 * Le Gérant qui dirige l'Agence.
	 */
	private Gerant gerant;

	/**
	 * Le constructeur sans paramètres
	 */
	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Le contructeur d'un objet Agence.
	 * @param id l'identifiant de l'agence.
	 * @param date date de création de l'Agence.
	 */

	public Agence(String id, String date) {
		super();
		this.id = id;
		this.date = date;
	}

	/**
	 * Retourne L'ID de l'Agence.
	 * @return  L'ID de l'Agence.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Met à jour l'ID de l'Agence
	 * 
	 * @param id
	 *            le nouveau id de l'Agence
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Retourne la date de création de l'Agence
	 * 
	 * @return la date de création de l'Agence
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Met à jour la nouvelle date de création.
	 * 
	 * @param date de création de l'Agence
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Retourne la classe Banque.
	 * @return la classe Banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/**
	 * Met à jour la classe Banque.
	 * 
	 * @param banque BroxiBanque
	 */
	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	/**
	 * Retourne la classe Gérant.
	 * 
	 * @return la classe Gérant.
	 */
	public Gerant getGerant() {
		return gerant;
	}

	/**
	 * Met à jour la classe Gérant.
	 * @param gerant Gérant de l'Agence.
	 */
	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

}

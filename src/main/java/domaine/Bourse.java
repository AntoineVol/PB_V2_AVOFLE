package domaine;

/**
 * Bourse est la classe représentant l'une des trois bourses de Paris, New-York
 * et Tokyo.
 * @author KHEZNADJI et VOLATRON
 * @version 1.0
 *
 */
public class Bourse {
	/**
	 * Le nom de la bourse
	 */
	private String nom;

	/**
	 * Le constructeur par défaut.
	 */
	public Bourse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Le Constructeur d'un objet Bourse.
	 * @param nom de la bourse.
	 */
	public Bourse(String nom) {
		super();
		this.nom = nom;
	}

	/**
	 * Retourne le nom de la bourse.
	 * @return le nom de la bourse.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Met à jour le nom de la bourse.
	 * @param nom de la bourse.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

}

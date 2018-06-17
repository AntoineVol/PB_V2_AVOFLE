package domaine;
/**
 * Banque est la classe représentant la banque BroxiBanque.
 * @author KHEZNADJI et VOLATRON
 * @version 1.0
 */
import java.util.Hashtable;
import java.util.Map;

public class Banque {
	/**
	 * La liste des agences de la Banque BroxiBanque.
	 */
	private Map<Integer, Agence> liAgence = new Hashtable<Integer, Agence>();
	/**
	 * Le nom de l'agence.
	 */
	private String nom;

	/**
	 *  Constructeur par défaut
	 */
	public Banque() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Le constructeur d'un objet Banque .
	 * @param nom de la banque.
	 */
	public Banque(String nom) {
		super();
		this.nom = nom;
	}

	/**
	 * Retourne la liste des agences BroxiBanque.
	 * @return la liste des agences.
	 */
	public Map<Integer, Agence> getLiAgence() {
		return liAgence;
	}
	/**
	 * Met à jour la liste des agences BroxiBanque.
	 * @param liAgence Liste des agences BroxiBanque.
	 */
	public void setLiAgence(Map<Integer, Agence> liAgence) {
		this.liAgence = liAgence;
	}
	/**
	 * Retourne de nom de l'agence.
	 * @return nom de l'agence.
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * Met à jour le nom de l'agence BroxiBnaque.
	 * @param nom de l'agence.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

}

package domaine;
/**
 * Gérant est la classe représentant un gérant d'une agence BroxiBanque.
 * @author KHEZNADJI et VOLATRON.
 * @version 1.0.
 */
import java.util.Hashtable;
import java.util.Map;

public class Gerant extends Personne {
	/**
	 * La création de la liste des conseillés appartenant à l'agence.
	 */
	private Map<Integer, Conseille> liConseille = new Hashtable<Integer, Conseille>();
	private Agence agence;

	/**
	 * constructeur d'un objet Gérant.
	 * @param nom nom de gérant. 
	 * @param prenom de gérant .
	 */
	public Gerant(String nom, String prenom) {
		super( nom,prenom);
	}
	/**
	 * Retourne la liste des conseillés de l'agence.
	 * @return la liste des conseillés
	 */
	public Map<Integer, Conseille> getLiConseille() {
		return liConseille;
	}
	/**
 	* Met à jour la liste des conseillés de l'agence.
 	* @param liConseille liste des consillés.
 	*/
	public void setLiConseille(Map<Integer, Conseille> liConseille) {
		this.liConseille = liConseille;
	}
	/**
	 * Retourne la classe Agence.
	 * @return la classe Agence.
	 */
	public Agence getAgence() {
		return agence;
	}
	/**
	 * Met à jour la classe Agence
	 * @param agence de la banque BroxiBanque.
	 */
	public void setAgence(Agence agence) {
		this.agence = agence;
	}

}

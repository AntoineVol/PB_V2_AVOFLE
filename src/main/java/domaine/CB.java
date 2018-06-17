package domaine;
/**
 * CB est la classe représentant les cartes bancaires attribuées par la Banque à ses clients.
 * @author KHEZNADJI et VOLATRON
 * @version 1.0
 */
public abstract class CB {
	/**
	 * le compte du client
	 */
	private Compte compte;
	/**
	 * l'ID de la carte bancaire
	 */
	private int id;
	/**
	 * Le status déterminant la validité de la carte bancaire.
	 */
	private String status;

	/**
	 * Le constructeur par défaut 
	 */
	public CB() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Le constructeur de l'objet carte bancaire.
	 * @param compte du client
	 * @param id de la carte bancaire.
	 */
	public CB(Compte compte, int id) {
		super();
		this.compte = compte;
		this.id = id;
		this.status="ActivÃ©e";
	}

	/**
	 * Le constructeur avec id
	 * @param id de la carte bancaire.
	 */
	public CB(int id) {
		super();
		this.id = id;
	}

	/**
	 * Retourne le Compte client.
	 * @return le compte.
	 */
	
	public Compte getCompte() {
		return compte;
	}
	/**
	 * Retourne le statut de la carte bancaire.
	 * @return le statut de la carte bancaire.
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * Met à jour le Statut de la carte bancaire.
	 * @param status de la carte .
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * Met à jour du compte client.
	 * @param compte client.
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	/**
	 * Retourne l'ID de la carte bancaire.
	 * @return l'ID.
	 */
	public int getId() {
		return id;
	}
	/**
	 * Met à jour l'ID de la carte bancaire.
	 * @param id de la carte.
	 */
	public void setId(int id) {
		this.id = id;
	}

}

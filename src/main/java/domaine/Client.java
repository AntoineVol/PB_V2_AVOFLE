package domaine;

/**
 * Classe d'un client 
 * @author LENOIR et VOLATRON
 * 
 */

public class Client extends Personne {

	// Attributs
	private int id; 
	private Conseille conseille;
	private CompteCourant compteCourant;
	private CompteEpargne compteEpargne;



//Constructeur avec id et typeClientS
	/** 
	 * Constructeur par defaut de la classe client
	 */
	public Client() {
		super();
	}
	/**
	 * Construteur avancée du client
	 * @param nom Nom du client
	 * @param prenom Prenom du client
	 * @param mail Email du client
	 * @param adresse Adresse entière du client (numero, rue, code postal ville)
	 */
	public Client(String nom, String prenom, String mail, String adresse) {
		super(nom,prenom,mail, adresse);
	}

	// Getters et setters

	public Conseille getConseille() {
		return conseille;
	}

	public void setConseille(Conseille conseille) {
		this.conseille = conseille;
	}

	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}
}

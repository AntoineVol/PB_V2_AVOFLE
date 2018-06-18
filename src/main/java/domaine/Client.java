package domaine;

/**
 * Classe repr�sentant une fiche client
 * @author KHEZNADJI et VOLATRON
 * @version 1.0
 */
public class Client extends Personne {

	// Attributs
	private int id; 
	private Conseille conseille;
	private CompteCourant compteCourant;
	private CompteEpargne compteEpargne;



//Constructeur avec id et typeClientS
	public Client() {
		super();
	}
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

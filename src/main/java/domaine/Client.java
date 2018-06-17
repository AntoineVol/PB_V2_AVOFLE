package domaine;

/**
 * Classe repr�sentant une fiche client
 * @author KHEZNADJI et VOLATRON
 * @version 1.0
 */
public class Client extends Personne {

	// Attributs
	private static int nbClient=0;
	private int id; 
	private String typeClient;
	private Conseille conseille;
	private CompteCourant compteCourant;
	private CompteEpargne compteEpargne;



//Constructeur avec id et typeClientS
	public Client() {
		super();
	}
	public Client(String typeClient,String nom, String prenom, String telephone, String adresse, int codePostal, String ville) {
		super(nom,prenom,telephone, adresse, codePostal, ville);
		this.id = nbClient;
		this.typeClient = typeClient;
		nbClient++;
	}

	// Getters et setters
	public String getTypeClient() {
		return typeClient;
	}

	public void setTypeClient(String typeClient) {
		this.typeClient = typeClient;
	}

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

	public String toString() {
		return "ID = "+this.getId()+" | "+ super.toString()  +" | "+this.typeClient +" | "+ this.getTel() +" | "+ this.getAdresse() +" | "+ this.getCodePostal()+" | "+this.getVille();
	}
}

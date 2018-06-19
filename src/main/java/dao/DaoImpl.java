package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domaine.Client;
import domaine.Compte;
import domaine.CompteCourant;
import domaine.CompteEpargne;
import domaine.Conseille;

/**
 * Classe implémentant l'interface de la couche DAO
 * @author VOLATRON & LENOIR
 *
 */
public class DaoImpl implements IDao {

	public void createClient(Client clt, Conseille csl) {
		PreparedStatement pstat = null;
		Connection con = null;

		try {
			con = DbUtil.seConnecter();
			String sql_clt = "INSERT INTO clients (prenom,nom,mail,adresse,id_conseille) VALUES (?,?,?,?,?)";
			pstat = con.prepareStatement(sql_clt);
			pstat.setString(1, clt.getPrenom());
			pstat.setString(2, clt.getNom());
			pstat.setString(3, clt.getMail());
			pstat.setString(4, clt.getAdresse());
			pstat.setInt(5, csl.getId());

			pstat.executeUpdate();
			con.commit();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DbUtil.seDeconnecter(pstat, null, con);
		}

	}

	public void deleteClient(int id_clt) {
		PreparedStatement pstat = null;
		Connection con = null;

		try {
			con = DbUtil.seConnecter();
			String sql = "DELETE FROM clients WHERE id=?";
			pstat = con.prepareStatement(sql);
			pstat.setInt(1, id_clt);
			pstat.executeUpdate();

			con.commit();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DbUtil.seDeconnecter(pstat, null, con);
		}

	}


	public Client getClientByID(int id) {
		PreparedStatement pstat = null;
		Connection con = null;
		ResultSet res = null;
		Client clt = null;

		try {
			con = DbUtil.seConnecter();
			String sql = "SELECT * FROM clients WHERE id=?";
			pstat = con.prepareStatement(sql);
			pstat.setInt(1, id);
			res = pstat.executeQuery();
			con.commit();
			clt = new Client();
			while (res.next()) {
				clt.setId(res.getInt(1));
				clt.setPrenom(res.getString(2));
				clt.setNom(res.getString(3));
				clt.setMail(res.getString(4));
				clt.setAdresse(res.getString(5));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {

			DbUtil.seDeconnecter(pstat, res, con);
		}
		return clt;
	}

	public List<Client> allClient(int id_csl) {
		PreparedStatement pstat = null;
		Connection con = null;
		ResultSet res = null;
		List<Client> listClt = new ArrayList<Client>();

		try {
			con = DbUtil.seConnecter();
			String sql = "SELECT * FROM clients WHERE id_conseille =?";
			pstat = con.prepareStatement(sql);
			pstat.setInt(1, id_csl);
			res = pstat.executeQuery();
			con.commit();

			while (res.next()) {
				Client clt = new Client();
				clt.setId(res.getInt(1));
				clt.setPrenom(res.getString(2));
				clt.setNom(res.getString(3));
				clt.setMail(res.getString(4));
				clt.setAdresse(res.getString(5));

				listClt.add(clt);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {

			DbUtil.seDeconnecter(pstat, res, con);
		}
		return listClt;
	}

	public void createCompteCourant(CompteCourant cpt, Client clt) {
		PreparedStatement pstat = null;
		Connection con = null;

		try {
			con = DbUtil.seConnecter();
			String sql = "INSERT INTO comptescourants (solde,decouvert,id_client) VALUES (?,?,?)";
			pstat = con.prepareStatement(sql);
			pstat.setDouble(1, cpt.getSolde());
			pstat.setDouble(2, cpt.getDecouvert());
			pstat.setInt(3, clt.getId());
			pstat.executeUpdate();
			con.commit();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DbUtil.seDeconnecter(pstat, null, con);
		}

	}




	public void deleteCompteCourant(int id) {
		PreparedStatement pstat = null;
		Connection con = null;
		try {
			con = DbUtil.seConnecter();
			String sql = "DELETE FROM comptescourants WHERE id=?";
			pstat = con.prepareStatement(sql);
			pstat.setInt(1, id);
			pstat.executeUpdate();
			con.commit();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DbUtil.seDeconnecter(pstat, null, con);
		}

	}


	public CompteCourant getCompteCourantByID(int id) {
		PreparedStatement pstat = null;
		Connection con = null;
		ResultSet res = null;
		CompteCourant cpt = null;

		try {
			con = DbUtil.seConnecter();
			String sql = "SELECT * FROM comptescourants WHERE id=?";
			pstat = con.prepareStatement(sql);
			pstat.setInt(1, id);
			res = pstat.executeQuery();
			con.commit();
			cpt = new CompteCourant();
			while (res.next()) {
				cpt.setId(res.getInt(1));
				cpt.setSolde(res.getDouble(2));
				cpt.setDecouvert(res.getDouble(3));
				cpt.setTypeCompteCourant(true);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {

			DbUtil.seDeconnecter(pstat, res, con);
		}
		return cpt;
	}
	
	public List<CompteCourant> allCompteCourantByClientId(int id) {
		PreparedStatement pstat = null;
		Connection con = null;
		ResultSet res = null;
		List<CompteCourant> listCpt = new ArrayList<CompteCourant>();

		try {
			con = DbUtil.seConnecter();
			String sql = "SELECT * FROM comptescourants WHERE id_client =?";
			pstat = con.prepareStatement(sql);
			pstat.setInt(1, id);
			res = pstat.executeQuery();
			con.commit();

			while (res.next()) {
				CompteCourant cpt = new CompteCourant();
				cpt.setId(res.getInt(1));
				cpt.setSolde(res.getDouble(2));
				cpt.setDecouvert(res.getDouble(3));
				cpt.setTypeCompteCourant(true);
				listCpt.add(cpt);
				
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			
		} finally {
			DbUtil.seDeconnecter(pstat, res, con);
		}
		return listCpt;

	}

	public List<CompteCourant> allCompteCourant() {
		Statement stat = null;
		Connection con = null;
		ResultSet res = null;
		List<CompteCourant> listCpt = new ArrayList<CompteCourant>();

		try {
			con = DbUtil.seConnecter();
			String sql = "SELECT * FROM comptescourants";
			stat = con.createStatement();
			res = stat.executeQuery(sql);
			con.commit();

			while (res.next()) {
				CompteCourant cpt = new CompteCourant();
				cpt.setId(res.getInt(1));
				cpt.setSolde(res.getDouble(2));
				cpt.setDecouvert(res.getDouble(3));
				cpt.setTypeCompteCourant(true);
				;
				listCpt.add(cpt);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {

			DbUtil.seDeconnecter(stat, res, con);
		}
		return listCpt;
	}
	
	public void deleteCompteEpargne(int id) {
		PreparedStatement pstat = null;
		Connection con = null;
		try {
			con = DbUtil.seConnecter();
			String sql = "DELETE FROM comptesepargnes WHERE id=?";
			pstat = con.prepareStatement(sql);
			pstat.setInt(1, id);
			pstat.executeUpdate();
			con.commit();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DbUtil.seDeconnecter(pstat, null, con);
		}
	}
	public CompteEpargne getCompteEpargneByID(int idCompte) {
		PreparedStatement pstat = null;
		Connection con = null;
		ResultSet res = null;
		CompteEpargne cpt = null;

		try {
			con = DbUtil.seConnecter();
			String sql = "SELECT * FROM comptesepargnes WHERE id=?";
			pstat = con.prepareStatement(sql);
			pstat.setInt(1, idCompte);
			res = pstat.executeQuery();
			con.commit();
			cpt = new CompteEpargne();
			while (res.next()) {
				cpt.setId(res.getInt(1));
				cpt.setSolde(res.getDouble(2));
				cpt.setDate(res.getString(3));
				cpt.setTaux(res.getDouble(4));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {

			DbUtil.seDeconnecter(pstat, res, con);
		}
		return cpt;
	}
	
	public List<CompteEpargne> allCompteEpargneByClientId(int id){
		PreparedStatement pstat = null;
		Connection con = null;
		ResultSet res = null;
		List<CompteEpargne> listCpt = new ArrayList<CompteEpargne>();

		try {
			con = DbUtil.seConnecter();
			String sql = "SELECT * FROM comptesepargnes WHERE id_client =?";
			pstat = con.prepareStatement(sql);
			pstat.setInt(1, id);
			res = pstat.executeQuery();
			con.commit();

			while (res.next()) {
				CompteEpargne cpt = new CompteEpargne();
				cpt.setId(res.getInt(1));
				cpt.setSolde(res.getDouble(2));
				cpt.setTaux(res.getDouble(3));
				listCpt.add(cpt);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DbUtil.seDeconnecter(pstat, res, con);
		}
		return listCpt;

	}
	
	
	public boolean checkConseilleId(String login, String password) {
		PreparedStatement pstat = null;
		Connection con = null;
		ResultSet res = null;

		try {
			con = DbUtil.seConnecter();
			String sql = "SELECT id FROM conseilles WHERE login=? AND password =?";
			pstat = con.prepareStatement(sql);
			pstat.setString(1, login);
			pstat.setString(2, password);
			res = pstat.executeQuery();
			con.commit();
			if (res.next()) {
				return true;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DbUtil.seDeconnecter(pstat, res, con);
		}
		return false;
	}

	public Conseille getConseilleByID(int id) {
		PreparedStatement pstat = null;
		Connection con = null;
		ResultSet res = null;
		Conseille csl = new Conseille();

		try {
			con = DbUtil.seConnecter();
			String sql = "SELECT prenom, nom FROM conseilles WHERE id=?";
			pstat = con.prepareStatement(sql);
			pstat.setInt(1, id);
			res = pstat.executeQuery();
			con.commit();
			if (res.next()) {
				csl.setId(id);
				csl.setPrenom(res.getString(1));
				csl.setNom(res.getString(2));
				return csl;
			}
			;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DbUtil.seDeconnecter(pstat, res, con);
		}
		return csl;
	}
	
	public Conseille getConseilleByLogin(String login) {
		PreparedStatement pstat = null;
		Connection con = null;
		ResultSet res = null;
		Conseille csl = new Conseille();

		try {
			con = DbUtil.seConnecter();
			String sql = "SELECT id, prenom, nom FROM conseilles WHERE login=?";
			pstat = con.prepareStatement(sql);
			pstat.setString(1, login);
			res = pstat.executeQuery();
			con.commit();
			if (res.next()) {
				csl.setId(res.getInt(1));
				csl.setPrenom(res.getString(2));
				csl.setNom(res.getString(3));
			}
			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DbUtil.seDeconnecter(pstat, res, con);
		}
		return csl;
		
	}



	@Override
	public void createCompteEpargne(CompteEpargne cep, Client clt) {
		PreparedStatement pstat = null;
		Connection con = null;

		try {
			con = DbUtil.seConnecter();
			String sql = "INSERT INTO comptesepargnes (solde,taux,id_client) VALUES (?,?,?)";
			pstat = con.prepareStatement(sql);
			pstat.setDouble(1, cep.getSolde());
			pstat.setDouble(2, cep.getTaux());
			pstat.setInt(3, clt.getId());
			pstat.executeUpdate();
			con.commit();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DbUtil.seDeconnecter(pstat, null, con);
		}
		
	}

	@Override
	public void upClient(Client clt) {
		PreparedStatement pstat = null;
		Connection con = null;

		try {
			con = DbUtil.seConnecter();
			String sql_clt = "UPDATE clients SET prenom=?,nom=?,mail=?,adresse=? WHERE id=?";
			pstat = con.prepareStatement(sql_clt);
			pstat.setString(1, clt.getPrenom());
			pstat.setString(2, clt.getNom());
			pstat.setString(3, clt.getMail());
			pstat.setString(4, clt.getAdresse());
			pstat.setInt(5, clt.getId());
			pstat.executeUpdate();
			con.commit();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DbUtil.seDeconnecter(pstat, null, con);
		}
}


	@Override
	public void moneyWithdrawCompteCourant(int idCompte, double montant) {
		PreparedStatement pstat = null;
		Connection con = null;
		Compte cpt;
		cpt = getCompteCourantByID(idCompte);

		try {
			con = DbUtil.seConnecter();
			String sql = "UPDATE comptescourants SET solde=? WHERE id=?";
			pstat = con.prepareStatement(sql);
			pstat.setDouble(1, cpt.getSolde()+montant);
			pstat.setDouble(2, idCompte);
			pstat.executeUpdate();
			con.commit();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DbUtil.seDeconnecter(pstat, null, con);
		}
		
	}

	@Override
	public void moneyWithdrawCompteEpargne(int idCompte, double montant) {
		PreparedStatement pstat = null;
		Connection con = null;
		Compte cpt;
		cpt = getCompteEpargneByID(idCompte);

		try {
			con = DbUtil.seConnecter();
			String sql = "UPDATE comptesepargnes SET solde=? WHERE id=?";
			pstat = con.prepareStatement(sql);
			pstat.setDouble(1, cpt.getSolde()+montant);
			pstat.setInt(2, idCompte);
			pstat.executeUpdate();
			con.commit();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DbUtil.seDeconnecter(pstat, null, con);
		}
		
	}



	@Override
	public void moneyPayCompteCourant(int idCompte, double montant) {
		PreparedStatement pstat = null;
		Connection con = null;
		Compte cpt;
		cpt = getCompteCourantByID(idCompte);

		try {
			con = DbUtil.seConnecter();
			String sql = "UPDATE comptescourants SET solde=? WHERE id=?";
			pstat = con.prepareStatement(sql);
			pstat.setDouble(1, cpt.getSolde()-montant);
			pstat.setDouble(2, idCompte);
			pstat.executeUpdate();
			con.commit();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DbUtil.seDeconnecter(pstat, null, con);
		}
		
	}



	@Override
	public void moneyPayCompteEpargne(int idCompte, double montant) {
		PreparedStatement pstat = null;
		Connection con = null;
		Compte cpt;
		cpt = getCompteEpargneByID(idCompte);

		try {
			con = DbUtil.seConnecter();
			String sql = "UPDATE comptesepargnes SET solde=? WHERE id=?";
			pstat = con.prepareStatement(sql);
			pstat.setDouble(1, cpt.getSolde()-montant);
			pstat.setDouble(2, idCompte);
			pstat.executeUpdate();
			con.commit();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DbUtil.seDeconnecter(pstat, null, con);
		}
		
	}
	

}


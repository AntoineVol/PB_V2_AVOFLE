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

public class DaoImpl implements IDao {

	public void createClient(Client clt) {
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
			pstat.setInt(5, 1);

			pstat.executeUpdate();
			con.commit();
			// TODO mututaliser les deux erreurs
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

	

	public void upClient(Client c) {
		PreparedStatement pstat = null;
		Connection con = null;

		try {
			con = DbUtil.seConnecter();
			String sql = "UPDATE clients SET prenom=?,nom=?,mail=?,adresse=? WHERE id=?";
			pstat = con.prepareStatement(sql);
			pstat.setString(1, c.getPrenom());
			pstat.setString(2, c.getNom());
			pstat.setString(3, c.getMail());
			pstat.setString(4, c.getAdresse());
			pstat.executeUpdate();
			con.commit();
			// TODO mututaliser les deux erreurs
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
			// TODO mututaliser les deux erreurs
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
			// TODO mututaliser les deux erreurs
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
			String sql = "SELECT * FROM clients WHERE id_conseille =1";
			pstat = con.prepareStatement(sql);
			//pstat.setInt(1, id_csl);
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
			// TODO mututaliser les deux erreurs
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

	public void createCompteCourant(CompteCourant cpt) {
		PreparedStatement pstat = null;
		Connection con = null;

		try {
			con = DbUtil.seConnecter();
			String sql = "INSERT INTO comptescourants (solde,decouvert,id_client) VALUES (?,?,?)";
			pstat = con.prepareStatement(sql);
			pstat.setDouble(1, cpt.getSolde());
			pstat.setDouble(2, cpt.getDecouvert());
			pstat.setInt(2, 1); //FIXME changer le numéro client en dur
			pstat.executeUpdate();
			con.commit();
			// TODO mututaliser les deux erreurs
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


	public void upCompteCourant(CompteCourant c) {
		PreparedStatement pstat = null;
		Connection con = null;

		try {
			con = DbUtil.seConnecter();
			String sql = "UPDATE comptescourants SET solde=?,decouvert=? WHERE id=?";
			pstat = con.prepareStatement(sql);
			pstat.setDouble(1, c.getSolde());
			pstat.setDouble(2, c.getDecouvert());
			pstat.setInt(3, c.getId());

			pstat.executeUpdate();
			con.commit();
			// TODO mututaliser les deux erreurs
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
			// TODO mututaliser les deux erreurs
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
				cpt.setDate(res.getString(3));
				cpt.setDecouvert(res.getDouble(4));
			}
			// TODO mututaliser les deux erreurs
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
				listCpt.add(cpt);
				return listCpt;
			}
			// TODO mututaliser les deux erreurs
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return listCpt;
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return listCpt;
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
				cpt.setDate(res.getString(3));
				cpt.setDecouvert(res.getDouble(4));
				;
				listCpt.add(cpt);
			}
			// TODO mututaliser les deux erreurs
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
			// TODO mututaliser les deux erreurs
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
				;
				listCpt.add(cpt);
				return listCpt;
			}
			// TODO mututaliser les deux erreurs
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return listCpt;
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return listCpt;
		} finally {
			DbUtil.seDeconnecter(pstat, res, con);
		}
		return listCpt;

	}
	
	public boolean moneyTransfer(int idComptePreleve, int idCompteCredite, double montant) {
		if(moneyPay(idComptePreleve, montant) && moneyWithdraw(idCompteCredite, montant)) {
			return true;
		}else {
			return false;
		}		
	}
	public boolean moneyWithdraw(int idCompte, double montant) {
		PreparedStatement pstat = null;
		Connection con = null;
		Compte cpt;
		cpt = getCompteCourantByID(idCompte);

		try {
			con = DbUtil.seConnecter();
			String sql = "UPDATE comptescourants SET solde=? WHERE id=?";
			pstat = con.prepareStatement(sql);
			pstat.setDouble(1, cpt.getSolde());
			pstat.setDouble(2, cpt.getSolde()+montant);
			pstat.executeUpdate();
			con.commit();
			return true;
			// TODO mututaliser les deux erreurs
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			try {
				con.rollback();
				return false;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		} finally {
			DbUtil.seDeconnecter(pstat, null, con);
		}
	}
	
	public boolean moneyPay(int idCompte, double montant) {
		PreparedStatement pstat = null;
		Connection con = null;
		Compte cpt;
		cpt = getCompteCourantByID(idCompte);

		try {
			con = DbUtil.seConnecter();
			String sql = "UPDATE comptescourants SET solde=? WHERE id=?";
			pstat = con.prepareStatement(sql);
			pstat.setDouble(1, cpt.getSolde());
			pstat.setDouble(2, cpt.getSolde()-montant);
			pstat.executeUpdate();
			con.commit();
			return true;
			// TODO mututaliser les deux erreurs
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			try {
				con.rollback();
				return false;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		} finally {
			DbUtil.seDeconnecter(pstat, null, con);
		}
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
			// TODO mututaliser les deux erreurs
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
				csl.setPrenom(res.getString(1));
				csl.setNom(res.getString(2));
				return csl;
			}
			;
			// TODO mututaliser les deux erreurs
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
			
			// TODO mututaliser les deux erreurs
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
	

}


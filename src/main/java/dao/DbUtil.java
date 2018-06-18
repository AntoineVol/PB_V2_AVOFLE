package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public  abstract class DbUtil {
	public static Connection seConnecter() throws ClassNotFoundException, SQLException {
		// TODO Créer la BDD est adapter le chemin dans l'adresse ci-dessous
		String url = "jdbc:mysql://localhost/proxybanquev2_avofle";
		String login = "root";
		String password = "";
		Connection con = null;

		// TODO Importer le driver mysql connector\J dans le projet
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, login, password);
		con.setAutoCommit(false);
		return con;
	}

	public static void seDeconnecter(Statement stat, ResultSet res, Connection con) {
		try {
			if (stat != null) {
				stat.close();
			}
			if (res != null) {
				res.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

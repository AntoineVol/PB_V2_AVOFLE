package presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ServiceImpl;

/**
 * Classe de servlet permettant de renvoyer m'utilisateur sur une page de
 * connection implémentée d'un message d'erreur Le servlet contient un doGet
 * pour le diriger vers la jsp "AuthFailed.jsp" Le servlet contient un doPost
 * pour le diriger vers la jsp "listeClients.jsp" si le login/mdp est connu de
 * la base de donnée. Sinon l'utilisateur est redirigé vers la même jsp pour
 * s'identifier à nouveau
 * 
 * @author VOLATRON & LENOIR
 */
public class AuthFailed extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/views/AuthFailed.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServiceImpl service = new ServiceImpl();
		// Récupérer les paramètres 'login' et 'password de la page d'authentification.
		String login = req.getParameter("login");
		String password = req.getParameter("password");

		if (service.identifyConseille(login, password)) {
			resp.sendRedirect(this.getServletContext().getContextPath() + "/listeClients");
			req.getSession().setAttribute(AuthFilter.SESSION_AUTH, login);
		} else {
			resp.sendRedirect(this.getServletContext().getContextPath() + "/AuthFailed");
			req.getSession().setAttribute(AuthFilter.SESSION_AUTH, null);
		}

	}
}

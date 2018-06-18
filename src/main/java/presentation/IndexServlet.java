package presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domaine.Conseille;
import service.ServiceImpl;

public class IndexServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext()
		.getRequestDispatcher("/WEB-INF/views/index.jsp")
		.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServiceImpl service = new ServiceImpl();
		// Récupérer les paramètres 'login' et 'password de la page d'authentification.
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		Conseille csl = service.getConseillerByLogin(login);
		String nom = csl.getNom();
		String prenom = csl.getPrenom();

		if (service.identifyConseille(login, password)) {
			req.getSession().setAttribute(AuthFilter.SESSION_AUTH, login);
			req.getSession().setAttribute("login", prenom+" "+nom);
			req.getSession().setAttribute("idCsl", csl.getId());
			resp.sendRedirect(this.getServletContext().getContextPath() + "/listeClients?idConseille="+csl.getId());

		} else {resp.sendRedirect(this.getServletContext().getContextPath() + "/AuthFailed");
				req.getSession().setAttribute(AuthFilter.SESSION_AUTH, null);}
	}
}

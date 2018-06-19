package presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domaine.Client;
import domaine.Conseille;
import service.ServiceImpl;

/**
 * Classe de servlet pour l'edition d'un client. 
 * Le servlet contient un doGet pour le diriger vers
 * la jsp "clientEdition.jsp" Le servlet contient un doPost pour le diriger vers la
 * jsp "listeClients.jsp" après avoir mis à jour la base de donnée
 * 
 * @author VOLATRON & LENOIR
 * 
 *
 */
public class EditionClientServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession maSession = request.getSession(true);
		ServiceImpl service = new ServiceImpl();
		
		String idClient = request.getParameter("idClient");
		String idCsl = request.getParameter("idCsl");
		
		Client client = service.getClientByID(Integer.parseInt(idClient));
		
		maSession.setAttribute("idCsl", idCsl);
		maSession.setAttribute("client", client);
		
		this.getServletContext()
		.getRequestDispatcher("/WEB-INF/views/clientEdition.jsp").forward(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ServiceImpl service = new ServiceImpl();
		Client clt = new Client();
		clt.setPrenom(req.getParameter("prenomModifClient"));
		clt.setNom(req.getParameter("nomModifClient"));
		clt.setMail(req.getParameter("mailModifClient"));
		clt.setAdresse(req.getParameter("adresseModifClient"));
		clt.setId(Integer.parseInt(req.getParameter("idClt")));
		
		Conseille csl ;
		int idCsl = Integer.parseInt(req.getParameter("idCsl"));
		csl=service.getConseilleByID(idCsl);

		service.upClient(clt);
		
		resp.sendRedirect(this.getServletContext().getContextPath() + "/listeClients?idConseille="+ idCsl);

	}
	
}

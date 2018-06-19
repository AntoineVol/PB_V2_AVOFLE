package presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domaine.Client;
import domaine.Conseille;
import service.ServiceImpl;

public class listeClientsServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession maSession = request.getSession();
		
		ServiceImpl service = new ServiceImpl();
		List<Client> listClient = new ArrayList<Client>();
		String action = "Default";
		String idConseille = request.getParameter("idConseille");
		if (request.getParameter("action")!=null) {action=request.getParameter("action");}
		
		switch(action) {
		case "suppressionClient" :
			String idDeleted = request.getParameter("idDeleted");
			service.deleteClient(Integer.parseInt(idDeleted));
			listClient.addAll(service.allClient(Integer.parseInt(idConseille)));
			break;
			
		default:
			listClient.addAll(service.allClient(Integer.parseInt(idConseille)));
			
		}
		maSession.setAttribute("idCsl", idConseille);
		maSession.setAttribute("listClient", listClient);
		this.getServletContext()
		.getRequestDispatcher("/WEB-INF/views/listeClients.jsp")
		.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServiceImpl service = new ServiceImpl();
		Client clt = new Client();
		clt.setPrenom(req.getParameter("prenomNouveauClient"));
		clt.setNom(req.getParameter("nomNouveauClient"));
		clt.setMail(req.getParameter("mailNouveauClient"));
		clt.setAdresse(req.getParameter("adresseNouveauClient"));
		
		Conseille csl ;
		int idCsl = Integer.parseInt(req.getParameter("idCsl"));
		csl=service.getConseilleByID(idCsl);

		service.createClient(clt, csl);
		
		resp.sendRedirect(this.getServletContext().getContextPath() + "/listeClients?idConseille="+ idCsl);

	}
}

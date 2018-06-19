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
import domaine.Compte;
import domaine.Conseille;
import service.ServiceImpl;

public class virementsServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession maSession = request.getSession(true);
		ServiceImpl service = new ServiceImpl();
		String idClient = request.getParameter("idClient");
		
		List<Compte> listCompte = new ArrayList<Compte>();
		listCompte.addAll(service.allCompteCourantByIdClient(Integer.parseInt(idClient)));
		listCompte.addAll(service.allCompteEpargneByIdClient(Integer.parseInt(idClient)));
		
		maSession.setAttribute("listCompte", listCompte);
		
		this.getServletContext()
		.getRequestDispatcher("/WEB-INF/views/virements.jsp")
		.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		ServiceImpl service = new ServiceImpl();
//		Compte cptDebiter = new Compte();
//		Compte cptCrediter = new Compte();
////		cpt.Debiter = req.getParameter("Debiter")
////		clt.setPrenom(req.getParameter("prenomNouveauClient"));
////		clt.setNom(req.getParameter("nomNouveauClient"));
////		clt.setMail(req.getParameter("mailNouveauClient"));
////		clt.setAdresse(req.getParameter("adresseNouveauClient"));
//		
//		Conseille csl ;
//		int idCsl = Integer.parseInt(req.getParameter("idCsl"));
//		csl=service.getConseilleByID(idCsl);
//
////		service.createClient(clt, csl);
//		
//		resp.sendRedirect(this.getServletContext().getContextPath() + "/listeClients?idConseille="+ idCsl);

	}
}

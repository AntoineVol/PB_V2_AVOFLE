package presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domaine.Compte;
import domaine.CompteCourant;
import domaine.CompteEpargne;
import service.ServiceImpl;

public class virementsServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession maSession = request.getSession(true);
		ServiceImpl service = new ServiceImpl();
		String idClient = request.getParameter("idClient");
		String idCsl = request.getParameter("idCsl");
		
		List<CompteCourant> listCompteCourant = new ArrayList<CompteCourant>(
				service.allCompteCourantByIdClient(Integer.parseInt(idClient)));
		List<CompteEpargne> listCompteEpargne = new ArrayList<CompteEpargne>(
				service.allCompteEpargneByIdClient(Integer.parseInt(idClient)));

		maSession.setAttribute("listCompteCourant", listCompteCourant);
		maSession.setAttribute("listCompteEpargne", listCompteEpargne);
		
		List<Compte> listCompte = new ArrayList<Compte>();
		listCompte.addAll(service.allCompteCourantByIdClient(Integer.parseInt(idClient)));
		listCompte.addAll(service.allCompteEpargneByIdClient(Integer.parseInt(idClient)));
		
		maSession.setAttribute("listCompte", listCompte);
		maSession.setAttribute("idClient", idClient);
		maSession.setAttribute("idCsl", idCsl);
		this.getServletContext()
		.getRequestDispatcher("/WEB-INF/views/virements.jsp")
		.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServiceImpl service = new ServiceImpl();
		String[] debiter= req.getParameter("debiter").split("##");
		String[] crediter= req.getParameter("crediter").split("##");
		String montant= req.getParameter("montant");
		if(debiter[1].equals("true")) {
			service.moneyPayCompteCourant(Integer.parseInt(debiter[0]), Double.parseDouble(montant));
		}else {
			service.moneyPayCompteEpargne(Integer.parseInt(debiter[0]), Double.parseDouble(montant));
		}
		if(crediter[1].equals("true")) {
			service.moneyWithdrawCompteCourant(Integer.parseInt(crediter[0]), Double.parseDouble(montant));
		}else {
			service.moneyWithdrawCompteEpargne(Integer.parseInt(crediter[0]), Double.parseDouble(montant));
		}
		
		resp.sendRedirect(this.getServletContext().getContextPath() + "/virements?idClient="+req.getParameter("idClient")+"&idCsl="+req.getParameter("idCsl"));

	}
}

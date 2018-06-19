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
import domaine.CompteCourant;
import domaine.CompteEpargne;
import service.ServiceImpl;

/**
 * Classe de servlet . Le servlet contient un doGet pour l'affichage de
 * l'ensemble des comptes d'un client choisi à partir de la liste des clients.
 * Le servlet contient un doPost pour l'ajout d'un nouveau compte courant ou
 * epargne
 * 
 * @author VOLATRON & LENOIR
 * 
 *
 */
public class listeComptesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession maSession = request.getSession(true);
		ServiceImpl service = new ServiceImpl();
		String idClient = request.getParameter("idClient");
		String idCsl = request.getParameter("idCsl");

		// Supression d'un compte
		String action = "Default";
		if (request.getParameter("action") != null) {
			action = request.getParameter("action");
		}

		switch (action) {
		case "supressionCompteCourant":
			String idDeleted = request.getParameter("idDeleted");
			service.deleteCompteCourant(Integer.parseInt(idDeleted));
			break;
		case "supressionCompteEpargne":
			String idDeleted2 = request.getParameter("idDeleted");
			service.deleteCompteEpargne(Integer.parseInt(idDeleted2));
			break;
		default:
		}

		List<CompteCourant> listCompteCourant = new ArrayList<CompteCourant>(
				service.allCompteCourantByIdClient(Integer.parseInt(idClient)));
		List<CompteEpargne> listCompteEpargne = new ArrayList<CompteEpargne>(
				service.allCompteEpargneByIdClient(Integer.parseInt(idClient)));

		maSession.setAttribute("listCompteCourant", listCompteCourant);
		maSession.setAttribute("listCompteEpargne", listCompteEpargne);
		maSession.setAttribute("idCsl", idCsl);
		maSession.setAttribute("idClient", idClient);

		this.getServletContext().getRequestDispatcher("/WEB-INF/views/listeComptes.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServiceImpl service = new ServiceImpl();

		HttpSession maSession = req.getSession();

		String decouvert = null;

		String solde = req.getParameter("solde");
		decouvert = req.getParameter("decouvert");
		String idClient = req.getParameter("idClient");
		String taux = req.getParameter("taux");
		String idCsl = req.getParameter("idCsl");

		Client clt = service.getClientByID(Integer.parseInt(idClient));

		if (decouvert != null) {
			// Création nouveau compte courant
			CompteCourant cpt = new CompteCourant();
			// set des valeurs rentrées
			cpt.setSolde(Double.parseDouble(solde));
			cpt.setDecouvert(Double.parseDouble(decouvert));
			// Service création Compte Courant
			service.createCompteCourant(cpt, clt);
		} else {
			// Création compte Epargne
			CompteEpargne cep = new CompteEpargne();
			// set des valeurs rentrées
			cep.setSolde(Double.parseDouble(solde));
			cep.setTaux(Double.parseDouble(taux));
			service.createCompteEpargne(cep, clt);
		}

		maSession.setAttribute("idCsl", idCsl);
		// maSession.setAttribute("listCompteCourant", listCompteCourant);
		// maSession.setAttribute("listCompteEpargne", listCompteEpargne);

		resp.sendRedirect(
				this.getServletContext().getContextPath() + "/listeComptes?idClient=" + idClient + "&idCsl=" + idCsl);
	}
}

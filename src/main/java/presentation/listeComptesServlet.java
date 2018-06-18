package presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domaine.CompteCourant;
import domaine.CompteEpargne;
import service.ServiceImpl;

public class listeComptesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession maSession = request.getSession(true);
		ServiceImpl service = new ServiceImpl();
		String idClient = request.getParameter("idClient");
		List<CompteCourant> listCompteCourant = new ArrayList<CompteCourant>(service.allCompteCourantByIdClient(Integer.parseInt(idClient)));
		List<CompteEpargne> listCompteEpargne = new ArrayList<CompteEpargne>(service.allCompteEpargneByIdClient(Integer.parseInt(idClient)));
		
		maSession.setAttribute("listCompteCourant", listCompteCourant);
		maSession.setAttribute("listCompteEpargne", listCompteEpargne);
		
		this.getServletContext()
		.getRequestDispatcher("/WEB-INF/views/listeComptes.jsp")
		.forward(request, response);
	}
}

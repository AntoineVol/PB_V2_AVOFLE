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
import service.ServiceImpl;

public class listeClientsServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession maSession = request.getSession(true);
		
		ServiceImpl service = new ServiceImpl();
		//List<Client> listClient = new ArrayList<Client>(service.allClient(1));
		List<Client> listClient = new ArrayList<Client>();
		Client c1 = new Client("Tom","Pouce","tom.pouce@gmail.com","52 rue du chemin 74589 Croisy");
		listClient.add(c1);
		Client monClient = new Client();

		maSession.setAttribute("listClient", listClient);
		maSession.setAttribute("id", monClient.getId());
		maSession.setAttribute("nom", monClient.getNom());
		maSession.setAttribute("prenom", monClient.getPrenom());
		maSession.setAttribute("tel", monClient.getMail());
		maSession.setAttribute("adresse", monClient.getAdresse());


		
		this.getServletContext()
		.getRequestDispatcher("/WEB-INF/views/listeClients.jsp")
		.forward(request, response);
	}
}

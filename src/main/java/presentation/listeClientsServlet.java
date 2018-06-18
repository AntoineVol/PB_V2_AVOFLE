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
		List<Client> listClient = new ArrayList<Client>();
		String action = "Default";
		if (request.getParameter("action")!=null) {action=request.getParameter("action");}
		
		switch(action) {
		case "suppressionClient" :
			String idDeleted = request.getParameter("idDeleted");
			service.deleteClient(Integer.parseInt(idDeleted));
			listClient.addAll(service.allClient(1));
			break;
			
		default:
			listClient.addAll(service.allClient(1));
			
		}
		
		maSession.setAttribute("listClient", listClient);
		this.getServletContext()
		.getRequestDispatcher("/WEB-INF/views/listeClients.jsp")
		.forward(request, response);
	}
}

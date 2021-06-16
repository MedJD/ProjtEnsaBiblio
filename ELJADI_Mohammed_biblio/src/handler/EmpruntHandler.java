
package handler;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Emprunt;
import dao.EmpruntDao;

public class EmpruntHandler extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String EmpruntList = "/emprunt/listEmprunt.jsp";
	private EmpruntDao dao;

	public EmpruntHandler() {
		super();
		dao = new EmpruntDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String redirect="";
		String action = request.getParameter("action");
		// System.out.println("action: " + action);
		try {
			if(action.equalsIgnoreCase("insert"))
			{
				Emprunt emp = new Emprunt();
				// emp.setNumero(Integer.parseInt(request.getParameter("numero")));
				emp.setNumero_livre(Integer.parseInt(request.getParameter("numero_livre")));
				emp.setCin_etudiant(request.getParameter("cin_etudiant"));
				System.out.println(request.getParameter("date"));		
				emp.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date")));
						
				// emp.setRemis_le(new Date(request.getParameter("remis_le")));
				dao.ajouter(emp);
				request.setAttribute("emprunts", dao.Lister());
				System.out.println("Emprunt Added Successfully");
				redirect = EmpruntList;
			}
			else if(action.equalsIgnoreCase("remis"))
			{
				String numeroStr = request.getParameter("numero");
				Emprunt emp = dao.getEmpruntById(Integer.parseInt(numeroStr));
				if (request.getParameter("remis_le") != null) {
					// convert date from jsp format to java format
					emp.setRemis_le(new SimpleDateFormat("yyyy-MM-dd")
									.parse(request.getParameter("remis_le")));
					dao.modifier(emp);
					dao.emprunter(Integer.parseInt(numeroStr));
				}
				redirect = EmpruntList;
			}
			else if (action.equalsIgnoreCase("extraire"))
			{
				if (request.getParameter("extraire") != null) {
					System.out.println("le path: " + request.getParameter("extraire"));
					dao.extraire(request.getParameter("extraire"));
				}
				redirect = EmpruntList;
				
			}
			else
			{
				redirect = EmpruntList;
			}
		} catch (Exception e)
		{
//			HttpSession session = request.getSession();
//			if (e.getMessage().equals("Stock insuffisant"))
//			{
//				session.setAttribute("error", "Stock insuffisant");
//				redirect = EmpruntList;
//			}
//			request.getSession(false).removeAttribute("error");
			
			System.err.println(e.getMessage());
		}
		RequestDispatcher rd = request.getRequestDispatcher(redirect);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

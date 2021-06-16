package handler;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Livre;
import dao.LivreDao;

public class LivreHandler extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String LivreList = "/livre/listLivre.jsp";
	private LivreDao dao;

	public LivreHandler() {
		super();
		dao = new LivreDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String redirect="";
		String action = request.getParameter("action");
		try
		{
			if(action.equalsIgnoreCase("insert"))
			{
				Livre livre = new Livre();
				livre.setTitre(request.getParameter("titre"));
				livre.setNumero_edition(request.getParameter("numero_edition"));
				livre.setDate_apparition(new SimpleDateFormat("yyyy-MM-dd")
						.parse(request.getParameter("date_apparition")));
				System.out.println(request.getParameter("date_apparition"));
				livre.setStock(Integer.parseInt(request.getParameter("stock")));
				dao.ajouter(livre);
				redirect = LivreList;
			}
			else if (action.equalsIgnoreCase("delete"))
			{
				String numero = request.getParameter("numero");
				dao.supprimer(Integer.parseInt(numero));
				redirect = LivreList;
			}
			else if (action.equalsIgnoreCase("extraire"))
			{
				if (request.getParameter("extraire") != null)
				{
					System.out.println("le path: " + request.getParameter("extraire"));
					dao.extraire(request.getParameter("extraire"));
				}
				redirect = LivreList;
				
			}
			else if (action.equalsIgnoreCase("edit"))
			{
				
				String numeroStr = request.getParameter("numero");
				Livre livre = new Livre();
				livre.setNumero(Integer.parseInt(numeroStr));
				livre.setTitre(request.getParameter("titre"));
				livre.setNumero_edition(request.getParameter("numero_edition"));
				livre.setDate_apparition(new SimpleDateFormat("yyyy-MM-dd")
						.parse(request.getParameter("date_apparition")));
				livre.setStock(Integer.parseInt(request.getParameter("stock")));
				dao.modifier(livre);
				redirect = LivreList;
				
			}
			else
			{
				redirect = LivreList;
			}
		}
		catch (Exception e)
		{
			System.err.print(e);
		}
		RequestDispatcher rd = request.getRequestDispatcher(redirect);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

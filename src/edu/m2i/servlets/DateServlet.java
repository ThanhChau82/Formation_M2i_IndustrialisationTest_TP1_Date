package edu.m2i.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.m2i.entites.Date;
import edu.m2i.validators.ValidateDate;

/**
 * Servlet implementation class DateServlet
 */
@WebServlet("/DateServlet")
public class DateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ValidateDate validateDate;

	/**
	 * Default constructor. 
	 */
	public DateServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupérer les params.
		String paramAnnee = request.getParameter("annee");
		String paramMois = request.getParameter("mois");
		String paramJour = request.getParameter("jour");

		String message = "";
		if (paramAnnee != null && !paramAnnee.isBlank()
				&& paramMois != null && !paramMois.isBlank()
				&& paramJour != null && !paramJour.isBlank()){
			try {
				int annee = Integer.parseInt(paramAnnee);
				int mois = Integer.parseInt(paramMois);
				int jour = Integer.parseInt(paramJour);

				// Construire l'objet Date
				Date date = new Date(jour, mois, annee);
				validateDate = new ValidateDate();
				if (validateDate.verifierDate(date)) {
					message = "Date (aaaa-MM-jj) " + annee + "-" + mois + "-" + jour + " valide";	
					request.setAttribute("confimation", message);
				} else {
					message = "Date (aaaa-MM-jj) " + annee + "-" + mois + "-" + jour + " non valide";
					request.setAttribute("erreurDate", message);					
				}
			} catch (NumberFormatException e) {
				message = "Données non parsables";
				request.setAttribute("erreurDate", message);				
			}
		} else {
			message = "Paramètres des données incorrects";
			request.setAttribute("erreurDate", message);			
		}
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

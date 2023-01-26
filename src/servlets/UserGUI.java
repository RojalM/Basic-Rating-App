package servlets;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import MD_Adapter.Movie;
import MRA_application.application;


/**
 * Class responsible for the GUI of the User *
 */
public class UserGUI extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		// Generate and show results of a search
		if (request.getParameter("action").equals("request Movie List")) {
			request.setAttribute("pagetitle", "Movie List results");
			List<Movie> MovieList = null;

			// Call application to request the results
			try {
				ArrayList<Movie> MovieList1 = application.getInstance().getMovieList();
				// Dispatch results to template engine
				request.setAttribute("MovieList", MovieList1);
				request.getRequestDispatcher("/templates/MovieListRepresentation.ftl").forward(request, response);
			} catch (Exception e1) {
				try {
					request.setAttribute("errormessage", "Database error: please contact the administator");
					request.getRequestDispatcher("/templates/error.ftl").forward(request, response);
				} catch (Exception e) {
					request.setAttribute("errormessage", "System error: please contact the administrator");
					e.printStackTrace();
				}
				e1.printStackTrace();
			}
	}
}

}

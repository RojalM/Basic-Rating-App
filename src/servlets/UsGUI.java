package servlets;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.MRApplication;
import dbadapter.Movie;


/**
 * Contains GUI for UUser
 *
 */
public class UsGUI extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * doGet contains the register form
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		// set pagetitle und navtype
		request.setAttribute("navtype", "users");
		request.setAttribute("pagetitle", "Movie List");
		// Dispatch request to template engine
		try {
			request.getRequestDispatcher("/templates/defaultWebpageUs.ftl").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Contains handling of insertOffer call
	 * @throws IOException 
	 * @throws ServletException 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("navtype", "users");

		// Check wether the call is register or not
		if (request.getParameter("action").equals("Movies")) {
			List<Movie> Movielist = null;
			try {
				request.setAttribute("pagetitle", "Movie List");
				Movielist = MRApplication.getInstance().getMovieList();
				System.out.println(Movielist);
				request.setAttribute("Movies", Movielist);
				request.getRequestDispatcher("/templates/MoviesRepresentation.ftl").forward(request, response);
			} catch (ServletException | IOException e) {
				request.setAttribute("errormessage", "System error: please contact the administrator");
				e.printStackTrace();
			}
		} else
			doGet(request, response);

	}}

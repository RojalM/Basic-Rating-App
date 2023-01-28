package servlets;


import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.MRApplication;


/**
 * Contains GUI for LIUUser
 *
 */
public class LIUGUI extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * doGet contains the addMovie form
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		// set pagetitle und navtype
		request.setAttribute("navtype", "loggedInUser");
		request.setAttribute("pagetitle", "addMovie");
		// Dispatch request to template engine
		try {
			request.getRequestDispatcher("/templates/defaultWebpageAM.ftl").forward(request, response);
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

		request.setAttribute("navtype", "loggedInUser");

		// Check wether the call is addMovie or not
		if (request.getParameter("action").equals("addingMovie")) {
			// Append parameter of request
			String title = (String) request.getParameter("title");
			String director = (String) request.getParameter("director");
			String release = (String) request.getParameter("release");
			String actor = (String) request.getParameter("actor");
			try {DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = dateFormat.parse(release);
			long time = date.getTime();
			Timestamp TimeSQL = new Timestamp(time);}
			catch(Exception e) {
				request.setAttribute("pagetitle", "addingMovie");
				request.setAttribute("message", "Movie Addition failed! Enter a correct Date.");
				request.getRequestDispatcher("/templates/failInfoRepresentation.ftl").forward(request, response);
				e.printStackTrace();
			}
			if(MRApplication.getInstance().checkingTitle(title) == false ) {
			
			try {
				// Call application to addMovie
				MRApplication.getInstance().addingMovie(title, director, release, actor);
				// Dispatch message to template engine
				request.setAttribute("pagetitle", "addMovie");
				request.setAttribute("message", "Movie added!");
				request.getRequestDispatcher("/templates/okRepresentation.ftl").forward(request, response);
			} catch (ServletException | IOException e) {
				request.setAttribute("errormessage", "System error: please contact the administrator");
				e.printStackTrace();
			}
			}else {
				if(MRApplication.getInstance().checkingTitle(title) == true ) {
				try {	
				request.setAttribute("pagetitle", "addingMovie");
				request.setAttribute("message", "Movie Addition failed! Movie already exists.");
				request.getRequestDispatcher("/templates/failInfoRepresentation.ftl").forward(request, response);
				} catch (ServletException | IOException e) {
					request.setAttribute("errormessage", "System error: please contact the administrator");
					e.printStackTrace();
				}		
				
				}
			}
			// Call doGet if request is not equal to addMovie
		} else
			doGet(request, response);

	}
}
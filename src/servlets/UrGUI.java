package servlets;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.MRApplication;


/**
 * Contains GUI for UUser
 *
 */
public class UrGUI extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * doGet contains the register form
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		// set pagetitle und navtype
		request.setAttribute("navtype", "userr");
		request.setAttribute("pagetitle", "Rating");
		// Dispatch request to template engine
		try {
			request.getRequestDispatcher("/templates/defaultWebpageUr.ftl").forward(request, response);
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

		request.setAttribute("navtype", "userr");

		// Check wether the call is register or not
		if (request.getParameter("action").equals("Rating")) {
			// Append parameter of request
			String Username = (String) request.getParameter("username");
			String Movie = (String) request.getParameter("movie");
			String Rating = (String) request.getParameter("rating");
			String Comment = (String) request.getParameter("comment");
			int RatingSQL = 0;
			try {RatingSQL = Integer.parseInt(Rating);}
			catch(Exception e) {
				request.setAttribute("pagetitle", "Register");
				request.setAttribute("message", "Rateing fail. The Rating has to be between 1 and 10!");
				request.getRequestDispatcher("/templates/failInfoRepresentation.ftl").forward(request, response);
				e.printStackTrace();
			}
			if(MRApplication.getInstance().checkingUser(Username, null) == true && RatingSQL < 11 && 
					RatingSQL > 0 && MRApplication.getInstance().checkingMovie(Movie) == true && 
					MRApplication.getInstance().checkingRating(Movie, Username) == false) {
			
			try {
				// Call application to register
				MRApplication.getInstance().rate(Username, Movie, Rating, Comment);
				// Dispatch message to template engine
				request.setAttribute("pagetitle", "Rating");
				request.setAttribute("message", "Rating successful!");
				request.getRequestDispatcher("/templates/showConfirmMake.ftl").forward(request, response);
			} catch (ServletException | IOException e) {
				request.setAttribute("errormessage", "System error: please contact the administrator");
				e.printStackTrace();
			}
			}else {
				if(RatingSQL < 1 || RatingSQL > 10 ) {
				try {	
				request.setAttribute("pagetitle", "Rating");
				request.setAttribute("message", "Rating fail! Your Rating hast to be between 1 and 10!.");
				request.getRequestDispatcher("/templates/failInfoRepresentation.ftl").forward(request, response);
				} catch (ServletException | IOException e) {
					request.setAttribute("errormessage", "System error: please contact the administrator");
					e.printStackTrace();
				}		
				
				}else if (MRApplication.getInstance().checkingMovie(Movie) == false) {
					try {
					request.setAttribute("pagetitle", "Rating");
					request.setAttribute("message", "Rating fail! This Movie doesent exists in the Database.");
					request.getRequestDispatcher("/templates/failInfoRegistration.ftl").forward(request, response);
					} catch (ServletException | IOException e) {
						request.setAttribute("errormessage", "System error: please contact the administrator");
						e.printStackTrace();
					}
					
				}
				else if (MRApplication.getInstance().checkingRating(Movie, Username) == true) {
					try {
					request.setAttribute("pagetitle", "Rating");
					request.setAttribute("message", "Rating fail! You already rated this Movie.");
					request.getRequestDispatcher("/templates/failInfoRegistration.ftl").forward(request, response);
					} catch (ServletException | IOException e) {
						request.setAttribute("errormessage", "System error: please contact the administrator");
						e.printStackTrace();
					}
					
				}
				else {
					try {
					request.setAttribute("pagetitle", "Rating");
					request.setAttribute("message", "Rating fail! This User isnt registert.");
					request.getRequestDispatcher("/templates/failInfoRegistration.ftl").forward(request, response);
					} catch (ServletException | IOException e) {
						request.setAttribute("errormessage", "System error: please contact the administrator");
						e.printStackTrace();
					}
			    }
			}
			// Call doGet if request is not equal to Register
		} else
			doGet(request, response);

	}}

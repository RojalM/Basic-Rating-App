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
public class UGUI extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * doGet contains the register form
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		// set pagetitle und navtype
		request.setAttribute("navtype", "user");
		request.setAttribute("pagetitle", "raten");
		// Dispatch request to template engine
		try {
			request.getRequestDispatcher("/templates/defaultWebpageU.ftl").forward(request, response);
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

		request.setAttribute("navtype", "unregistrierterUser");

		// Check wether the call is register or not
		if (request.getParameter("action").equals("Register")) {
			// Append parameter of request
			String Username = (String) request.getParameter("username");
			String Email = (String) request.getParameter("email");
			String age = (String) request.getParameter("age");
			int ageSQL = 0;
			try {ageSQL = Integer.parseInt(age);}
			catch(Exception e) {
				request.setAttribute("pagetitle", "Register");
				request.setAttribute("message", "Registration fail! Give correct Age.");
				request.getRequestDispatcher("/templates/failInfoRegistration.ftl").forward(request, response);
				e.printStackTrace();
			}
			if(MRApplication.getInstance().checkingUser(Username, Email) == false && ageSQL > 17) {
			
			try {
				// Call application to register
				MRApplication.getInstance().register(Username, Email, age);
				// Dispatch message to template engine
				request.setAttribute("pagetitle", "Register");
				request.setAttribute("message", "Registration successful!");
				request.getRequestDispatcher("/templates/showConfirmRegister.ftl").forward(request, response);
			} catch (ServletException | IOException e) {
				request.setAttribute("errormessage", "System error: please contact the administrator");
				e.printStackTrace();
			}
			}else {
				if(ageSQL < 18) {
				try {	
				request.setAttribute("pagetitle", "Register");
				request.setAttribute("message", "Registration fail! You have to be at least 18 years old.");
				request.getRequestDispatcher("/templates/failInfoRegistration.ftl").forward(request, response);
				} catch (ServletException | IOException e) {
					request.setAttribute("errormessage", "System error: please contact the administrator");
					e.printStackTrace();
				}		
				
				}else {
					try {
					request.setAttribute("pagetitle", "Register");
					request.setAttribute("message", "Registration fail! Username or Email already in use.");
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

	}
}
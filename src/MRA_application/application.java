package MRA_application;

import java.util.ArrayList;

import MD_Adapter.DBFacade;
import MD_Adapter.Movie;
import interfaces.UCmds;


public class application implements UCmds {

	private static application instance;

	/**
	 * Implementation of the Singleton pattern.
	 * 
	 * @return
	 */
	public static application getInstance() {
		if (instance == null) {
			instance = new application();
		}
		return instance;
		}
	public Object addingMovie;

	public boolean checkingUser(String username, String email) {

		// Parse inputs to correct datatypes
		try {
			return DBFacade2.getInstance().checkUser(username, email);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void register(String username, String email, String age) {
		try {
			int ageSQL = Integer.parseInt(age);
			DBFacade2.getInstance().register(username, email, ageSQL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean checkingMovie(String Movie) {

		// Parse inputs to correct datatypes
		try {
			return DBFacade2.getInstance().checkMovie(Movie);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}



	public ArrayList<Movie> getMovieList() {
			ArrayList<Movie> result = null;
		
			try {
			
				result = DBFacade.getInstance().get_Movielist();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			return result;
}
}

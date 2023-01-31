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
	public void rate(String username, String Movie, String Rating, String comment) {
		try {
			int RatingSQL = Integer.parseInt(Rating);
			DBFacade2.getInstance().rate(username, Movie, RatingSQL, comment);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean checkingRating(String Movie, String Username) {

		// Parse inputs to correct datatypes
		try {
			return DBFacade2.getInstance().checkRating(Movie, Username);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean checkingTitle(String title) {

		// Parse inputs to correct datatypes
		try {
			return DBFacade2.getInstance().checkTitle(title);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void addingMovie(String title, String director, String release, String actor) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = dateFormat.parse(release);
			long time = date.getTime();
			Timestamp TimeSQL = new Timestamp(time);
			DBFacade2.getInstance().addingMovie1(title, director, TimeSQL, actor);
		} catch (Exception e) {
			e.printStackTrace();
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

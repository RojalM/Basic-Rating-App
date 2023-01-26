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

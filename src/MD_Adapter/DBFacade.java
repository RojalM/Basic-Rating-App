package MD_Adapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Class which acts as the connector between application and database. Creates
 * Java objects from SQL returns. Exceptions thrown in this class will be
 * catched with a 500 error page.
 *
 */

/*implements DBinterfaces*/

public class DBFacade  {
	private static DBFacade instance;

	/**
	 * Constructor which loads the corresponding driver for the chosen database type
	 */
	private DBFacade() {
		try {
			Class.forName("com." + Configuration.getType() + ".jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Implementation of the Singleton pattern.
	 * 
	 * @return
	 */
	public static DBFacade getInstance() {
		if (instance == null) {
			instance = new DBFacade();
		}

		return instance;
	}

	public static void setInstance(DBFacade dbfacade) {
		instance = dbfacade;
	}

	/**
	 * Function that returns all appropriate offers from the database.
	 * 
	 * @param arrivalTime   compared with existing bookings and start time.
	 * @param departureTime compared with existing bookings and start time.
	 * @param persons       compared with capacity.
	 * @return Arraylist of all offer objects.
	 */
	public ArrayList<Movie> get_Movielist() {
		ArrayList<Movie> result = new ArrayList<Movie>();

		// Declare the necessary SQL queries.
		String queryMovieList = "Select * from MovieDataBase";
		

		// Query all offers that fits to the given criteria.
		try (Connection connection = DriverManager
				.getConnection(
						"jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
								+ Configuration.getPort() + "/" + Configuration.getDatabase(),
						Configuration.getUser(), Configuration.getPassword())) {

			try (PreparedStatement ps = connection.prepareStatement(queryMovieList);) {
				try (ResultSet rs = ps.executeQuery()) {
					//ArrayList<Movie> movieList = new ArrayList<Movie>();
					while (rs.next()) {
						result.add( new Movie(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4)));
					}
						
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} catch (Exception e) {
			e.printStackTrace();
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}

	return result;	
	}
}



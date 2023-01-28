package interfaces;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
/**
 * Interface for DBFacade to provide all necessary database function.
 * 
 *
 *
 */
public interface IUrser {

	public boolean checkRating(String Movie, String Username);
	public boolean checkMovie(String Movie);

}

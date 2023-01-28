package interfaces;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Interface for DBFacade to provide all necessary database function.
 * 

 *
 */
public interface IUUser {

	public boolean checkUser(String username, String email);
	

}

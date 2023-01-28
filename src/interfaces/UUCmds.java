package interfaces;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;


/**
 * Interface for DBFacade to provide all necessary database function.
 * 
*
 */
public interface UUCmds {

	public void register (String username, String email, String age) throws SQLException;

}

package dbadapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;


import interfaces.IUUser;
import interfaces.IUrser;

/**
 * Class which acts as the connector between application and database. Creates
 * Java objects from SQL returns. Exceptions thrown in this class will be
 * catched with a 500 error page.
 *
 *
 *
 */
public class DBFacade2 implements IUUser, IUrser {
    private static DBFacade2 instance;

    /**
     * Constructor which loads the corresponding driver for the chosen database type
     */
    private DBFacade2() {
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
    public static DBFacade2 getInstance() {
        if (instance == null) {
            instance = new DBFacade2();
        }

        return instance;
    }
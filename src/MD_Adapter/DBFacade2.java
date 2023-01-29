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

    /**
     * checks if a user already exists
     *
     *
     */

    public boolean checkUser(String username, String email) {
        String QueryUser = "select * from Userdatabase where username = ? or email = ?";

        try (Connection connection = DriverManager
                .getConnection(
                        "jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
                                + Configuration.getPort() + "/" + Configuration.getDatabase(),
                        Configuration.getUser(), Configuration.getPassword())) {
            try (PreparedStatement psSelect = connection.prepareStatement(QueryUser)) {
                psSelect.setString(1, username);
                psSelect.setString(2, email);
                try (ResultSet rs = psSelect.executeQuery()) {
                    return rs.next();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * inserting User into the Database
     *
     *
     */
    public void register (String username, String email, int age) throws SQLException {

        // Declare SQL query to insert User.
        String sqlInsert = "INSERT INTO userdatabase (username, email, age) VALUES (?,?,?)";

        // Insert User into database.
        try (Connection connection = DriverManager
                .getConnection(
                        "jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
                                + Configuration.getPort() + "/" + Configuration.getDatabase(),
                        Configuration.getUser(), Configuration.getPassword())) {

            try (PreparedStatement ps = connection.prepareStatement(sqlInsert)){
                ps.setString(1, username);
                ps.setString(2, email);
                ps.setInt(3, age);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();

            } catch (Exception e) {
                e.printStackTrace();


            }
        }
    }
    public boolean checkMovie(String Movie) {
        String QueryUser = "select * from moviedatabase where Titel = ?";

        try (Connection connection = DriverManager
                .getConnection(
                        "jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
                                + Configuration.getPort() + "/" + Configuration.getDatabase(),
                        Configuration.getUser(), Configuration.getPassword())) {
            try (PreparedStatement psSelect = connection.prepareStatement(QueryUser)) {
                psSelect.setString(1, Movie);
                try (ResultSet rs = psSelect.executeQuery()) {
                    return rs.next();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void rate(String username, String Movie, int rating, String comment) throws SQLException {

        // Declare SQL query to insert User.
        String sqlInsert = "INSERT INTO ratings (username, movie, rating, comment) VALUES (?,?,?,?)";

        // Insert User into database.
        try (Connection connection = DriverManager
                .getConnection(
                        "jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
                                + Configuration.getPort() + "/" + Configuration.getDatabase(),
                        Configuration.getUser(), Configuration.getPassword())) {

            try (PreparedStatement ps = connection.prepareStatement(sqlInsert)){
                ps.setString(1, username);
                ps.setString(2, Movie);
                ps.setInt(3, rating);
                ps.setString(4, comment);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();

            } catch (Exception e) {
                e.printStackTrace();


            }
        }
    }
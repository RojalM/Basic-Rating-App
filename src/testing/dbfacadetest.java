package testing;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import dbadapter.Configuration;

import dbadapter.DBFacade2;


import junit.framework.TestCase;
public class dbfacadetest extends TestCase{


    @Before
    public void setUp() throws SQLException {



        //Sql statement
        String sqlclean="DROP TABLE IF EXISTS moviedatabase";
        String sqlcreatetable="CREATE TABLE moviedatabase (titel, Ver�ffentlichungsdatum, Direktor,  Hauptdarsteller)";
        //perform data base update
        try(Connection connection = DriverManager
                .getConnection(
                        "jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
                                + Configuration.getPort() + "/" + Configuration.getDatabase(),
                        Configuration.getUser(), Configuration.getPassword())){
            try (PreparedStatement psClean = connection.prepareStatement(sqlclean)) {
                psClean.executeUpdate();
            }catch (SQLException e) {
                e.printStackTrace();}
            try (PreparedStatement pscreate = connection.prepareStatement(sqlcreatetable)) {
                pscreate.executeUpdate();
            }catch (SQLException e) {
                e.printStackTrace();
            }}}

    //we insert new movie and check if the movie is added Hauptdarsteller
    public void testAddingMovie() throws SQLException {
        Timestamp tm = new Timestamp(0);
        Movie mtest=new Movie("testmovie","peter","tom",tm,"3","nice");
        String sqlcheck="SELECT * FROM  moviedatabase";
        String a = null,c = null,d = null;
        Timestamp b = null;

        DBFacade2.getInstance().addingMovie1( mtest.getTitel(),  mtest.getDirekor(), mtest.getReleaseData(), mtest.getHauptdarsteller());

        try(Connection connection =DriverManager.getConnection("jdbc:"+Configuration.getType()+"://"+Configuration.getServer()+":"+
                Configuration.getPort()+"/"+Configuration.getDatabase(),Configuration.getUser(),Configuration.getPassword())){
            try (PreparedStatement PSCHECK = connection.prepareStatement(sqlcheck)) {
                PSCHECK.executeUpdate();try (PreparedStatement ps = connection.prepareStatement(sqlcheck);) {
                    try (ResultSet rs = ps.executeQuery()) {
                        //we should recieve the same movie that we have entered

                        while (rs.next()) {
                            a=rs.getString("Titel");
                            b=rs.getTimestamp("Veröffentlichungsdatum");
                            c=rs.getString("Direktor");
                            d=rs.getString("Hauptdarsteller");
                        }}catch (SQLException e) {
                        e.printStackTrace();}
                }
            }
        }

        //verify return value
        assertTrue(a==mtest.getTitel());
        assertTrue(b==mtest.getReleaseData());
        assertTrue(c==mtest.getDirekor());
        assertTrue(d==mtest.getHauptdarsteller());
    }
    //check the checkmovie method
    public void testcheckmovie() {
        Timestamp tm = new Timestamp(0);
        Movie mtest=new Movie("testmovie","peter","tom",tm,"3","nice");
        boolean t=DBFacade2.getInstance().checkMovie(mtest.getTitel());
        assertTrue(t==true);
        boolean t1=DBFacade2.getInstance().checkMovie("corona");
        assertTrue(t1==false);


    }
    // rest data base

    @After
    public void tearDown() {
        String sqlclean="DROP TABLE IF EXISTS moviedatavase";
        // Perform database updates
        try (Connection connection = DriverManager
                .getConnection(
                        "jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
                                + Configuration.getPort() + "/" + Configuration.getDatabase(),
                        Configuration.getUser(), Configuration.getPassword())) {

            try (PreparedStatement psClean = connection.prepareStatement(sqlclean)) {
                psClean.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}


package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import org.junit.Before;
import org.junit.Test;
import application.MRApplication;
import net.sourceforge.jwebunit.junit.WebTester;

/**
 * This class performs a system test on the LIUGUI using JWebUnit.
 *
 * @author swe.uni-due.de
 *
 */
public class addingMovieWebTestCase {

    private WebTester tester;

    /**
     * Create a new WebTester object that performs the test.
     */
    @Before
    public void prepare() {
        tester = new WebTester();
        tester.setBaseUrl("http://localhost:8080/team 3/");
    }

    @Test
    public void testaddingmovie() {
        // Start testing for guestgui
        tester.beginAt("liugui");

        // Check all components of the search form
        tester.assertTitleEquals("addingMovie");
        tester.assertFormPresent();
        tester.assertTextPresent("Required Information");
        tester.assertTextPresent("Titel");
        tester.assertFormElementPresent("title");
        tester.assertTextPresent("Director");
        tester.assertFormElementPresent("director");
        tester.assertTextPresent("Release");
        tester.assertFormElementPresent("release");
        tester.assertTextPresent("Actor");
        tester.assertFormElementPresent("actor");
        tester.assertButtonPresent("Add");

        // Submit the form with given parameters
        tester.setTextField("title", "pablo");

        tester.setTextField("director", "escobar");
        tester.setTextField("release", "02.02.2021");
        tester.setTextField("actor","soli");


        tester.clickButton("Add");
        // check if the success or fail messsage are appropriately represented
        String titel="pablo";
        if(MRApplication.getInstance().checkingTitle(titel) == false )
        {
            tester.assertTitleEquals("addMovie");
            tester.assertTextPresent("Movie added!");

        }
        else {if(MRApplication.getInstance().checkingTitle(titel) == true) {
            tester.assertTitleEquals("addingMovie");
            tester.assertTextPresent("Movie Addition failed! Movie already exists.");
        }}

    }

}


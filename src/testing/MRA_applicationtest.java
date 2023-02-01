package testing;



import org.junit.Test;

import application.MRApplication;
import dbadapter.DBFacade2;
import junit.framework.TestCase;

public class MRA_applicationtest extends TestCase {

    public void MRA_applicationTest() {

    }

    @Test
    public void addingMovietest() {
        DBFacade2 stub = mock(DBFacade2.class);
        DBFacade2.setInstance(stub);


        //irgend was
        MRApplication.getInstance().addingMovie(getName(), getName(), getName(), getName());

        verify(stub, times(1)).addingMovie1();
    }



}


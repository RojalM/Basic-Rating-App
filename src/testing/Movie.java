package testing;

import java.security.Timestamp;

public class Movie {

    private  String Titel;
    private String Direkor;
    private String Hauptdarsteller;
    private java.sql.Timestamp ReleaseData;
    private String rating;
    private String comment;

    public Movie (String Titel,String Direktor,String Hauptdarsteller,java.sql.Timestamp ReleaseData, String rating, String comment) {
        this.Titel=Titel;
        this.Direkor=Direktor;
        this.Hauptdarsteller=Hauptdarsteller;
        this.ReleaseData=ReleaseData;
        this.rating = rating;
        this.comment = comment;
    }

    public java.sql.Timestamp getReleaseData() {
        return ReleaseData;
    }

    public void setReleaseData(java.sql.Timestamp releaseData) {
        ReleaseData = releaseData;
    }

    public String getHauptdarsteller() {
        return Hauptdarsteller;
    }
    public void setHauptdarsteller(String hauptdarsteller) {
        Hauptdarsteller = hauptdarsteller;
    }
    public String getDirekor() {
        return Direkor;
    }
    public void setDirekor(String direkor) {
        Direkor = direkor;
    }
    public String getTitel() {
        return Titel;
    }
    public void setTitel(String titel) {
        Titel = titel;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}




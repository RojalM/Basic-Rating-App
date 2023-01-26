package MD_Adapter;


public class Movie {
	private  String Titel;
	private String Direkor;
	private String Hauptdarsteller;
	private String ReleaseData;
	
	public Movie (String Titel,String Direktor,String Hauptdarsteller,String ReleaseData) {
		this.Titel=Titel;
		this.Direkor=Direktor;
		this.Hauptdarsteller=Hauptdarsteller;
		this.ReleaseData=ReleaseData;
	}

	public String getReleaseData() {
		return ReleaseData;
	}

	public void setReleaseData(String releaseData) {
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
}

package datatypes;

public class NameData {
	
	private String Firstname;
	private String Middlename;
	private String Lastname;
	public NameData(String Firstname,String Middlename,String Lastname) {
		this.Firstname=Firstname;
		this.Middlename=Middlename;
		this.Lastname=Lastname;
	}
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getMiddlename() {
		return Middlename;
	}
	public void setMiddlename(String middlename) {
		Middlename = middlename;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}

}

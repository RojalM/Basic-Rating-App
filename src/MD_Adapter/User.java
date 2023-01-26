package MD_Adapter;

import datatypes.NameData;

public class User {
	private NameData username; 
	private String email;
	private Integer age;

	public User(NameData username,String email,Integer age) {
		this.username=username;
		this.email=email;
		this.age=age;
	}

	public NameData getUsername() {
		return username;
	}

	public void setUsername(NameData username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}


package curs.client;

public class ForeignClient extends Client{
	private String nationality;
	
	public ForeignClient(long id, String name, String email,
			String phonenumber, boolean active, String dateOfBirth,
			String nationality) {
		super(id, name, email, phonenumber, active, dateOfBirth);
		this.nationality = nationality;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	@Override
	public String getContactInfo() {
		return super.getContactInfo() + " " + nationality;
	}
	
}

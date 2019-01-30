package curs.client;

import java.util.Objects;

public class Client 
//implements Comparable
implements Executive
{
	
	public final static String label = "CEL MAI BUN CLIENT!";
	
	private long id;
	private String name;
	private String email;
	private String phonenumber;
	private boolean active;
	private String dateOfBirth;
	
	public Client() {}
	
	public Client(long id, String name, String email,
			String phonenumber, boolean active, String dateOfBirth) {
		this.id = id; 
		this.name = name; 
		this.phonenumber = phonenumber; 
		this.active = active; 
		this.dateOfBirth = dateOfBirth; 
		this.email = email;
	}
	
	public String getContactInfo() {
		return this.name + " " + this.email + " " + this.phonenumber;
	}
	
	@Override
	public String toString() {
		return this.id + " " + this.name;
	}
	
//	@Override
//	public int compareTo(Object o) {
//		Client otherClient = (Client) o;
//		if(this.id < otherClient.id) {
//			return -1;
//		} else if(this.id > otherClient.id) {
//			return 1;
//		} else {
//			return 0;
//		}
//	}
	
	@Override
	public boolean equals(Object obj) {
		Client otherClient = (Client) obj;
		return this.id == otherClient.id
				&& this.email.equals(otherClient.email);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.email);
	}
	
	
	public long getId() {
		return this.id;
	}
	
	public void setId(Long newId) {
		this.id = newId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public static class Address {
		private String city;
		private String streetName;
		private String streetNumber;
		
		public Address(String city, String streetName, String streetNumber) {
			this.city = city;
			this.streetName = streetName;
			this.streetNumber = streetNumber;
			
		}
		
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getStreetName() {
			return streetName;
		}
		public void setStreetName(String streetName) {
			this.streetName = streetName;
		}
		public String getStreetNumber() {
			return streetNumber;
		}
		public void setStreetNumber(String streetNumber) {
			this.streetNumber = streetNumber;
		}
	}

	@Override
	public void hire(String jobTitle) {
		System.out.println("Congratulations! You are a" + jobTitle + "!");
	}

	@Override
	public void fire(String employee) {
		// TODO Auto-generated method stub
	}
}

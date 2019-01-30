package curs;

import java.util.Arrays;

import curs.client.Client;
import curs.client.Employable;
import curs.client.Executive;
import curs.client.ForeignClient;

public class Main {

	public static void main(String[] args) {
//		example1();
//		example2();
		
		Client.Address address = new Client.Address("Bucuresti", "Iuliu Mani", "244");
		
		ForeignClient foreignClient = new ForeignClient(5, "FAbio", "fabio@gmail.com", 
				"+5023232", false, "1990-01-01", "Spanish");
		
		foreignClient.hire("programmer");
		
		Executive executive = foreignClient;
		Employable employable = foreignClient;
		
		Employable employee = new Employable() {
			@Override
			public void hire(String jobTitle) {
				System.out.println("Surprise");
			}
		};
		
		employee.hire("");
		
	}

	private static void example2() {
		Client client1 = new Client();
		client1.setId(2L);
		client1.setName("Popa");
		client1.setEmail("gica@gmail.com");
		client1.setPhonenumber("00");
		
		Client client2 = new Client();
		client2.setId(1L);
		client2.setName("Popescu");
		client2.setEmail("gica@gmail.com");
		client2.setPhonenumber("01");
		
		System.out.println(client1.getContactInfo());
		
		ForeignClient foreignClient = new ForeignClient(5, "FAbio", "fabio@gmail.com", 
				"+5023232", false, "1990-01-01", "Spanish");
		
		System.out.println(foreignClient.getContactInfo());
		System.out.println(foreignClient);
	}

	private static void example1() {
		Client newClient = new Client();
		newClient.setName("Bogdan");
//		System.out.println(newClient.getEmail());
		
		Client client = new Client(1, "Ionut", "ionut@gmail.com",
				"073343434", true, "2019-01-02");
		
//		System.out.println(client.getEmail());
//		System.out.println(Client.label);
		
//		System.out.println(newClient == newClient);
		
		calculate(newClient);
		System.out.println(newClient.getName());
	}
	
	public static void calculate(Client client) {
		client.setName("New name");
	}

}

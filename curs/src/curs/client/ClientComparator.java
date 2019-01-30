package curs.client;

import java.util.Comparator;

public class ClientComparator implements Comparator<Client>{

	public int compare(Client client1, Client client2) {
		if(client1.getId() < client2.getId()) {
			return -1;
		} else if(client1.getId() > client2.getId()) {
			return 1;
		} else {
			return 0;
		}
	}
	
}

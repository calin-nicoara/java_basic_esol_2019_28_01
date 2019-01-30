package com.example.bankservice;

import java.util.List;
import java.util.Optional;

import com.example.bankservice.business_object.Client;

public interface ClientRepository {
	Optional<Client> getClient(Long id);
	void deleteClient(Long id);
	void addClient(Client client);
	List<Client> getAllClients();
	void updateClient(Client newClient);
}

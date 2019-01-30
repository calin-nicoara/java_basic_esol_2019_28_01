package com.example.bankservice;

import org.springframework.stereotype.Component;

import com.example.bankservice.business_object.Client;

@Component
public class ClientService {
	private ClientRepository clientRepository;

	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	public void deleteClient(Long id) {
		clientRepository.getClient(id).ifPresent(client -> {
			if(!client.getActive()) {
				clientRepository.deleteClient(id);
			}
		});
	}
	
	public Client getClient(Long id) {
		return clientRepository.getClient(id)
			.orElseThrow(() -> new ClientNotFoundException(id));
	}
}

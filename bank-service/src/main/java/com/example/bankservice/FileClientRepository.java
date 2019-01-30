package com.example.bankservice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.bankservice.business_object.Client;

@Component
public class FileClientRepository implements ClientRepository{
	private static final String databaseFile = "client.csv";

	public List<Client> getAllClients() {
		try {
			return Files.lines(Paths.get(databaseFile)).map(this::getClient).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList();
		}
	}

	private Client getClient(String line) {
		String[] fields = line.split(",");
		Client client = new Client();
		client.setId(Long.parseLong(fields[0]));
		client.setName(fields[1]);
		client.setEmail(fields[2]);
		client.setPhoneNumber(fields[3]);

		String[] dateFields = fields[4].split("-");
		LocalDate dateOfBirth = LocalDate.of(Integer.parseInt(dateFields[2]), Integer.parseInt(dateFields[1]),
				Integer.parseInt(dateFields[0]));
		client.setDateOfBirth(dateOfBirth);

		client.setActive(Boolean.parseBoolean(fields[5]));

		return client;
	}

	public Optional<Client> getClient(Long id) {
		return getAllClients().stream().filter(s -> s.getId() == id).findFirst();
	}
	
	public void addClient(Client client) {
		List<Client> allClients = new ArrayList<>(getAllClients());
		client.setId(allClients.size() + 1L);
		allClients.add(client);
		
		writeClientsFile(allClients);
	}
	
	public void deleteClient(Long id) {
		List<Client> clients= getAllClients().stream()
		.filter(s -> s.getId() != id)
		.collect(Collectors.toList());
		
		writeClientsFile(clients);
	}
	
	public void updateClient(Client newClient) {
		List<Client> allClients = getAllClients();
		
		Optional<Client> clientOptional = allClients.stream()
		.filter(s -> s.getId() == newClient.getId())
		.findFirst();
		
		if(clientOptional.isPresent()) {
//			allClient.indexOf(clientOptional.get())
			Client oldClient = clientOptional.get();
			oldClient.setName(newClient.getName());
			oldClient.setEmail(newClient.getEmail());
			oldClient.setPhoneNumber(newClient.getPhoneNumber());
			oldClient.setDateOfBirth(newClient.getDateOfBirth());
			oldClient.setActive(newClient.getActive());
			
			writeClientsFile(allClients);
		} else {
			throw new ClientNotFoundException(newClient.getId());
		}
	}

	// A method that receives a Collection of clients
	// and overwrites the csv file
	private void writeClientsFile(Collection<Client> clients) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");

		String clientsString = clients.stream()
				.map(client -> {
					return client.getId() + "," + client.getName() 
					+ "," + client.getEmail() + ","
							+ client.getPhoneNumber() + "," + formatter.format(client.getDateOfBirth()) + ","
							+ client.getActive();
				}).collect(Collectors.joining("\n"));
		
		try {
			Files.deleteIfExists(Paths.get(databaseFile));
			
			Files.write(
					Paths.get(databaseFile), 
					clientsString.getBytes(), 
					StandardOpenOption.CREATE_NEW
			);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

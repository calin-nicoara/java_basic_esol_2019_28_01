package com.example.bankservice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.bankservice.business_object.Client;

@SpringBootApplication
public class BankServiceApplication
{
	
	public static void main(String[] args) {
		SpringApplication.run(BankServiceApplication.class, args);
//		testing();
	}

	private static void testing() {
		//		
				ClientRepository clientRepository = new FileClientRepository();
		//		System.out.println(clientRepository.getAllClients());
		//		System.out.println(clientRepository.getClient(1L));
		//		System.out.println(clientRepository.getClient(2L));
				
				Client client = new Client(1L, "Calin", "raius@gmail.com", 
						"0723499999",
						LocalDate.parse("1991-05-06"), false);
				
		//		clientRepository.updateClient(client);
		//		clientRepository.addClient(client);
				
		//		clientRepository.deleteClient(3L);
				
				ClientService clientService = new ClientService(clientRepository);
				
		//		clientService.deleteClient(1L);
				
				
				System.out.println(clientRepository.getAllClients());
	}


}


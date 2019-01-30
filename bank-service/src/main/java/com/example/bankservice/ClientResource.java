package com.example.bankservice;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankservice.business_object.Client;

@RestController
@RequestMapping("/clients")
public class ClientResource {
	private ClientService clientService;
	private ClientRepository clientRepository;

	public ClientResource(ClientService clientService,
			ClientRepository clientRepository) {
		this.clientService = clientService;
		this.clientRepository = clientRepository;
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<Client> getClient(@PathVariable("id")Long id) {
		return ResponseEntity.ok(clientService.getClient(id));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Client>> getClients(
			@RequestParam	("filter1") String filter1,
			@RequestParam("filter2") Long filter2,
			@RequestParam(value = "filter3", 
			required= false, defaultValue="0") Long filter3) {
		System.out.println(filter1);
		System.out.println(filter2);
		System.out.println(filter3);
		
		return ResponseEntity.ok(clientRepository.getAllClients());
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteClient(@PathVariable("id")Long id) {
		clientRepository.deleteClient(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createClient(@RequestBody Client client) {
		clientRepository.addClient(client);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateClient(
			@PathVariable("id") Long id,
			@RequestBody Client client) {
		client.setId(id);
		clientRepository.updateClient(client);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}

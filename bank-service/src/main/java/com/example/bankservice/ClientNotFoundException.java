package com.example.bankservice;

public class ClientNotFoundException extends RuntimeException {

	public ClientNotFoundException(Long id) {
		super("Client " + id + " was not found!");
	}

}

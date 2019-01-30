package curs.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;

import curs.client.Client;

public class Main {
	
	public static void main(String[] args) throws IOException {
//		testFiles();
		Client client = new Client(5L, "Ionut", "bogdan@gmail", 
				"0733232", false, "2019-01-01");
		writeClientToFile(client);
	}

	private static void testFiles() throws IOException {
		Path path = Paths.get("test_1.txt");
		byte[] bytesOfString = "A normal string\n".getBytes();
		Files.write(path, bytesOfString, getOptionForWritting(path));
		
		List<String> list = Files.readAllLines(path);
		
		System.out.println(list);
		
		Files.copy(path, Paths.get("test_copy.txt"),
				StandardCopyOption.REPLACE_EXISTING);
		
		Files.deleteIfExists(Paths.get("test_copy.txt"));
	}
	
	private static OpenOption getOptionForWritting(Path path) {
		return Files.exists(path) ? 
				StandardOpenOption.APPEND : 
				StandardOpenOption.CREATE_NEW;
	}
	
	private static void writeClientToFile(Client client) throws IOException {
		String line = client.getId() + "," + client.getName() + ","
				+ client.getEmail() + "," + client.getPhonenumber() + "\n";
		
		Path clientPath = Paths.get("clients.csv");
		Files.write(clientPath, line.getBytes(), getOptionForWritting(clientPath));
	}
}

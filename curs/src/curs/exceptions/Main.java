package curs.exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {

	public static void main(String[] args) {
		try {
//			throwsSometimes();
			
			throw new ClientIsBrokeException();
		} catch(NumberFormatException ex) {
			System.out.println("IO Exception thrown!");
		} catch(Exception ex) {
			System.out.println("Exception thrown!");
		} finally {
			System.out.println("Always runs!");
		}
	}
	
	public static void throwsSometimes() throws IOException{
		long time = System.currentTimeMillis();
		
		if(time % 2 == 0) {
			System.out.println("All good!");
		} else {
			throw new IOException();
		}
	}
}

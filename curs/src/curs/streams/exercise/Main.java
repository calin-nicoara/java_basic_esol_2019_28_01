package curs.streams.exercise;

import java.io.ObjectInputStream.GetField;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Author author1 = new Author("Mihai", "Eminescu", 25, "roman");
		Author author2 = new Author("Ion", "Creanga", 40, "roman");
		Author author3 = new Author("Isaac", "Asimov", 70, "american");
		
		Book book1 = new Book("Amintiri..", LocalDate.of(1967, 3, 3), 
				"Biografie", BigDecimal.valueOf(34.89), author2);
		Book book2 = new Book("Harap Alb...", LocalDate.of(1999, 3, 3), 
				"Fictiune", BigDecimal.valueOf(20.89), author2);
		Book book3 = new Book("Scrisoarea a III-a", LocalDate.of(1980, 3, 3), 
				"Poezie", BigDecimal.valueOf(34.89), author1);
		Book book4 = new Book("Foundation", LocalDate.of(1995, 6, 7), 
				"Fictiune", BigDecimal.valueOf(50), author3);
		Book book5 = new Book("Robots", LocalDate.of(1985, 8, 20), 
				"Fictiune", BigDecimal.valueOf(34.89), author3);
		Book book6 = new Book("Empire", LocalDate.of(1990, 11, 18), 
				"Biografie", BigDecimal.valueOf(13), author3);
		
		
		List<Book> books = Arrays.asList(book1, book2, book3, book4,
				book5, book6);
		
		System.out.println(getExpensiveAuthors(books));
		
		System.out.println(anyAuthorIsOlderThan50(books));
		System.out.println(getSumOfRomanianBooks(books));
	}
	
	/*
	 * Exercise 1:
	 * 
	 * Make a method that receives a list of books and
	 * returns the authors that have a book more expensive
	 * than 25
	 */
	private static Set<Author> getExpensiveAuthors(Collection<Book> books) {
		return books
				.stream()
				.filter(s -> s.getPrice()
						.compareTo(BigDecimal.valueOf(35)) > 0)
				.map(s -> s.getAuthor())
				.collect(Collectors.toSet());
	}
	
	
	/*
	 * Exercise 2:
	 * 
	 * .....
	 * I want to know if there are authors older than 50
	 */
	private static boolean anyAuthorIsOlderThan50(
			Collection<Book> books) {
		return books.stream()
		.map(s -> s.getAuthor())
		.anyMatch(a -> a.getAge() > 50);
	}
	
	
	/*
	 * Exercise 3:
	 * 
	 * .....
	 * I want the sum of all the book prices
	 * of the romanian authors
	 */
	private static BigDecimal getSumOfRomanianBooks(
			Collection<Book> books) {
		return books
		.stream()
		.filter(s -> s.getAuthor()
				.getNationality()
				.equalsIgnoreCase("roman"))
		.map(s -> s.getPrice())
		.reduce(BigDecimal.ZERO, (sum, current) -> sum.add(current));
	}
	
//	goo.gl/vvpMUb

}

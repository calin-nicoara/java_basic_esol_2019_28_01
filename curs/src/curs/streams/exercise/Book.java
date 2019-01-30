package curs.streams.exercise;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Book {
	private String title;
	private LocalDate dateOfPublication;
	private String genre;
	private BigDecimal price;
	private Author author;
	
	public Book(String title, LocalDate dateOfPublication, String genre, 
			BigDecimal price, Author author) {
		super();
		this.title = title;
		this.dateOfPublication = dateOfPublication;
		this.genre = genre;
		this.price = price;
		this.setAuthor(author);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getDateOfPublication() {
		return dateOfPublication;
	}
	public void setDateOfPublication(LocalDate dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", dateOfPublication=" + dateOfPublication + ", genre=" + genre + ", price="
				+ price + "]";
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
}

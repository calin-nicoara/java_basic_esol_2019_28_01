package curs;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateExample {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		
		LocalDate localDate1 = LocalDate.of(2000, 4, 23);
		LocalDate localDate2 = LocalDate.of(1999, 4, 23);
		
		System.out.println(localDate1.isAfter(localDate2));
		System.out.println(localDate1.isBefore(localDate2));
		
		System.out.println(localDate1.plusDays(10));
		
		DateTimeFormatter dateTimeFormatter = 
				DateTimeFormatter.ofPattern("dd/MM/YYYY");
		
		System.out.println(localDate1.format(dateTimeFormatter));
		
		LocalTime localTime = LocalTime.of(18, 0);
		
		LocalDateTime localDateTime = LocalDateTime.of(2000, 1, 1, 16, 0);
	}

}

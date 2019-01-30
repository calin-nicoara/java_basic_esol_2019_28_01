package curs.enums;

public class Main {

	public static void main(String[] args) {
		Day dayOfWeek = Day.SATURDAY;
		
		System.out.println(dayOfWeek.getNumberOfDay());
	
		
		switch(dayOfWeek) {
			case FRIDAY:
				System.out.println("The weekend!!!!");
				break;
			default:
				System.out.println("Anything else...");
		}
		
	}

}

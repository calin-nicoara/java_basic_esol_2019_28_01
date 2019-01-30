package curs;

import java.util.Arrays;

public class StringExample {

	public static void main(String[] args) {
		String guineePig = "A great example!";
		
		String string1 = guineePig + " concatenated";
		
		System.out.println(string1);
		
		String emptyString = "";
		System.out.println(emptyString.isEmpty());
		
		System.out.println(string1.contains("ample"));
		System.out.println(string1.contains("good"));
		
		System.out.println(string1.length());
		
		System.out.println(string1.replaceAll("great", "good"));
		System.out.println(string1.indexOf("ple"));
		
		String stringToSplit = "apples, pears, melons";
		String[] values = stringToSplit.split(",");
		
		System.out.println(Arrays.toString(values));
		
		System.out.println(" asdasd    ".trim());
		
		System.out.println("A greate brown fox".substring(5, 10));
		
		String formatted = String.format(
				"The value of your order is %s and it will arrive %s",
				"200", "tomorrow");
		
		System.out.println(formatted);
	}

}

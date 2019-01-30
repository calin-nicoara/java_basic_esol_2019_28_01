package curs.collection;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import curs.client.Client;

public class Main {

	public static void main(String[] args) {
//		iterator();
//		list();
//		generics();
//		map();
		
//		System.out.println(getLengthMap(Arrays.asList("ONE", "TWO", "THREE")));
		
		Set<Integer> setOfIntegers = new HashSet<>();
		
		setOfIntegers.add(4);
		setOfIntegers.add(2);
		setOfIntegers.add(3);
		setOfIntegers.add(3);
		
		System.out.println(setOfIntegers);
		
		BigDecimal n1 = BigDecimal.valueOf(20.34);
		BigDecimal n2 = BigDecimal.valueOf(14.03);
		BigDecimal multiply = n1.multiply(n2);
		System.out.println(n1.add(n2));
		System.out.println(n1.divide(n2, RoundingMode.FLOOR));
		System.out.println(multiply);
	}

	private static void map() {
		Map<String, Integer> map = new HashMap<>();
		
		map.put("ONE", 1);
		map.put("TWO", 1);
		map.put("THREE", 1);
		map.put("THREE", 4);
		
		System.out.println(map.get("ONE"));
		
		map.put(null, 10);
		System.out.println(map.get(null));
		
		map.remove("TWO");
		map.remove("THREE", 2);
		
		System.out.println(map);
		
		System.out.println(map.containsKey("THREE"));
		System.out.println(map.containsValue(1));
	}
	
	// Create a method which has a list of strings as a parameter
	// and then returns a map where the key is the string and 
	// the value is the length of the string
	private static Map<String, Integer> getLengthMap(List<String> strings) {
		Map<String, Integer> map = new HashMap<>();
		for(String s: strings) {
			map.put(s, s.length());
		}
		return map;
	}

	private static void generics() {
		Box<Object> stringBox = new Box<>();
		stringBox.setValue("Hello there!");
		
		System.out.println(stringBox.getValue());
		
		List<Integer> integerList = new ArrayList<>();
		
		Number number = Integer.valueOf(20);
		
		List<? extends Number> numbersList = new ArrayList<Long>();
	}

	private static void list() {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		
		System.out.println(numbers.get(2));
		System.out.println(numbers.contains(5));
		System.out.println(numbers.indexOf(4));
		
		numbers.remove(4);
		System.out.println(numbers);
		
		System.out.println(numbers.isEmpty());
		System.out.println(numbers.size());
		
		int sum = 0;
		for(int index = 0; index < numbers.size(); index++) {
			sum += (int)numbers.get(index);
		}
		System.out.println(sum);
	}

	private static void iterator() {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		
		Iterator iterator = numbers.iterator();
		while(iterator.hasNext()) {
			int number = (int) iterator.next();
			System.out.println(number);
			
			if(number == 4) {
				iterator.remove();
			}
		}
		
//		System.out.println(numbers);
		
		for(int i: numbers) {
			System.out.println(i);
		}
	}

}

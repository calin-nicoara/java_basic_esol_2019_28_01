package curs.lambdas;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
//		lambdas();
		
		Optional<Integer> integerOptional = Optional.of(200);
		
		if(integerOptional.isPresent()) {
			System.out.println(integerOptional.get());
		} else {
			System.out.println(0);
		}
		
		Optional<Integer> empty = Optional.empty();
		System.out.println(empty.orElse(0));
		System.out.println(empty.orElseGet(() -> {
			return 0;
		}));
	}

	private static void lambdas() {
		Function doubleFunction = number -> number;
		NumberFunction2 sameFunction = (number, number2) -> number * 2 + "";
		System.out.println(sameFunction.compute2(2, 2));
		
		NumberFunctionMultiple sumFunction = (n1, n2) -> {
			System.out.println(n1);
			System.out.println(n2);
			return n1+n2;
		};
		
		String testString = "HELLO!";
		testString = "Bye";
		BulkFunction bulkFunction = (numbers) -> {
//			System.out.println(testString);
			for(int i = 0; i < numbers.length; i++) {
				if(numbers[i] % 2 == 0) {
					return numbers[i];
				}
			}
			return 0;
		};
		
		System.out.println(bulkFunction.compute(1, 7, 9, 2, 3, 4, 5));
		
		
		Consumer<String> stringConsumer = n -> System.out.println(n.toUpperCase());
		stringConsumer.accept("small text");
		
		Supplier<String> stringSupplier = () -> {
			return "SHOW ME THE MONEY!";
		};
		System.out.println(stringSupplier.get());
		
		Function<Integer, String> stringFunction = 
				number -> number.toString();
				
		String numberAsString = stringFunction.apply(200);
		System.out.println(numberAsString);
		
		Predicate<String> predicate = s -> s.length() > 4;
		
		System.out.println(predicate.test("THREE"));
		
		testThis((Integer s) -> s % 2 == 0);
	}
	
	private static void testThis(Predicate<?> predicate) {
		
	}
	
	// Create a functional interface that has a method compute that
	// has int... as a parameter and return an int
	// Then create a lambda which returns the first number divisible by 2
	
	@FunctionalInterface
	interface BulkFunction {
		int compute(int... numbers);
	}
	
	interface NumberFunction {
		int compute(int number);
	}
	
	interface NumberFunction2 {
		String compute2(int number, int second);
	}
	
	interface NumberFunctionMultiple {
		int compute(int n1, int n2);
	}

}

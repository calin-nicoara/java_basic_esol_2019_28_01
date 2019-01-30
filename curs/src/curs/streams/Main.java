package curs.streams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Collection<String> stringCollection = 
				Arrays.asList("Ionut", "Ioan", "Bogdan",
						"Mihaela", "Elena", "Ana", "Elena",
						"Alexandra", "Ana");
		
		BigDecimal price = BigDecimal.valueOf(27);
		
//		Price greater than 25
//		price.compareTo(BigDecimal.valueOf(25)) > 0;
		
//		filterMap(stringCollection);
//		distinct(stringCollection);
//		peek(stringCollection);
//		flatMap();
		
		Supplier<Stream<String>> streamSupplier = () -> {
			return stringCollection
					.stream()
//					.filter(s -> s.charAt(0) == 'A')
					.distinct()
					.map(s -> s.toLowerCase());
		};
		
//		aLotOfStream(stringCollection, streamSupplier);
		
		IntSummaryStatistics stat = IntStream
		.range(1, 10)
		.summaryStatistics();
		
		int reduced = IntStream.range(1, 10)
//		.filter(i -> i % 2 == 0)
//		.map(s -> s * 2)
		.reduce(1, (resultUntilNow, currentValue) ->
		resultUntilNow * currentValue);
		
//		System.out.println(reduced);
		
		Stream
		.of("1", "2", "3", "4")
		.skip(1)
		.limit(2)
		.forEach(s -> System.out.println(s));
	}

	private static void aLotOfStream(Collection<String> stringCollection, Supplier<Stream<String>> streamSupplier) {
		List<String> strings = streamSupplier.get()
				.collect(Collectors.toList());
//		System.out.println(strings);
		
		Set<String> stringSet = streamSupplier.get().collect(Collectors.toSet());
//		System.out.println(stringSet);
		
		Map<String, Integer> map = streamSupplier.get()
		.collect(Collectors.toMap(s -> s, s -> s.length()));
//		System.out.println(map);
		
		Map<Character, Set<String>> map2 =  streamSupplier.get()
		.collect(Collectors
				.groupingBy((String s) -> {
					return s.charAt(0);
				}, Collectors.toSet()));
		
//		System.out.println(map2);
		
		Map<Boolean, List<String>> map3 = streamSupplier
				.get()
				.collect(Collectors.partitioningBy
						(s -> s.length() % 2 == 0));
		
//		System.out.println(map3);
		
		String joined = streamSupplier.get()
				.collect(Collectors.joining(", ", "Names: ", "."));
		
		System.out.println(joined);
		
		long count = stringCollection
		.stream()
		.filter(s -> s.length() % 2 == 0)
		.count();
		System.out.println(count);
		
		boolean anyMatch = stringCollection
		.stream()
		.anyMatch(s -> s.length() % 2 == 0);
		
		System.out.println(anyMatch);
		
		stringCollection.stream()
		.allMatch(s -> s.length() % 2 == 0);
		
		stringCollection.stream()
		.noneMatch(s -> s.length() % 2 == 0);
		

		String max = stringCollection.stream()
		.max(Comparator.comparing(s -> s.length()))
		.get();
		
		System.out.println(max);
	}

	private static void flatMap() {
		List<List<Integer>> listOfLists = new ArrayList<>();
		listOfLists.add(Arrays.asList(1, 2, 5));
		listOfLists.add(Arrays.asList(4, 3, 7));
		
		listOfLists.stream()
		.flatMap(m -> m.stream())
		.peek(s -> System.out.println(s))
		.forEach(s -> System.out.println(s));
	}

	private static void peek(Collection<String> stringCollection) {
		stringCollection
		.stream()
		.filter(s -> s.charAt(0) == 'A')
		.peek(s -> System.out.println(s))
		.map(s -> s.toLowerCase())
		.sorted()
		
		.forEach(s -> System.out.println(s));
	}

	private static void filterMap(Collection<String> stringCollection) {
		stringCollection
		.stream()
		.filter(s -> s.length() > 4)
		.map(s -> s.toUpperCase())
		.forEach(finalValue -> System.out.println(finalValue));
		
		for(String value: stringCollection) {
			if(value.length() > 5) {
				System.out.println(value.toUpperCase());
			}
		}
	}

	private static void distinct(Collection<String> stringCollection) {
		System.out.println();
		stringCollection
		.stream()
		.distinct()
		.forEach(s -> System.out.println(s));
		
		Set<String> stringSet = new HashSet<>(stringCollection);
	}

}

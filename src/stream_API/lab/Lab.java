package stream_API.lab;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static jdk.nashorn.internal.runtime.JSType.isNumber;

public class Lab {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

//        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" "))
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//
//        takeTwo(numbers);

//        upperString(sc);
//        firstName(sc);
//        averageOfDoubles(sc);
//        minEvenNumber(sc);
//        findAndSumIntegers(sc);
        boundedNumbers(sc);

    }

//    Take Two – Functional

    private static void takeTwo(List<Integer> numbers) {

        numbers.stream()
                .filter(n -> 10 <= n && n <= 20)
                .distinct()
                .limit(2)
                .forEach(n -> System.out.print(n + " "));
    }

    private static void hashMapSyntax(){

        HashMap<String, String> map = new HashMap<>();

        Stream<Map.Entry<String, String>> entries =	map.entrySet().stream();
        Stream<String> keys = map.keySet().stream();
        Stream<String> values = map.values().stream();

    }

//    UPPER STRINGS
    private static void upperString(Scanner sc){
        Arrays.stream(sc.nextLine().split(" "))
                .map(String::toUpperCase)
                .forEach(s -> System.out.print(s + " "));
    }

//    Optional<T>

    public static void optionalSyntax() {

        List<String> elements = new ArrayList<>();

        Optional<String> first = elements.stream()
                .sorted()
                .findFirst();

        if (first.isPresent()) {
            System.out.println(first.get());
        } else {
            System.out.println("No matches.");
        }
    }

//    First Name

    private static void firstName(Scanner sc) {

        List<String> names = Arrays.asList(sc.nextLine().split(" "));

        Set<Character> letters = new HashSet<>();

        Stream.of(sc.nextLine().split(" "))
                .map(s -> s.toLowerCase().charAt(0))
                .forEach(letters::add);

       Optional<String> first = names.stream()
               .filter(s -> letters.contains(s.toLowerCase().charAt(0)))
               .sorted()
               .findFirst();

       if(first.isPresent()){
           System.out.println(first.get());
       }else{
           System.out.println("No match");
       }

    }

//    Primitive Streams
    public static void primitiveSyntax() {

        int[] ints = { 1, 2, 3, 4 };
        IntStream intStream = IntStream.of(ints);

        List<Integer> list = new ArrayList<>();
        IntStream mappedIntStream = list.stream()
                .mapToInt(Integer::valueOf);

    }

//    Average of Doubles
    private static void averageOfDoubles(Scanner sc) {

        List<String> elements = Arrays.asList(sc.nextLine().split(" "));

        OptionalDouble average = elements.stream()
                .filter(s -> !s.isEmpty())
                .mapToDouble(Double::valueOf)
                .average();

        if(average.isPresent()){
            System.out.printf("%.2f",average.getAsDouble());
        }else{
            System.out.println("No match");
        }

    }

//    Min Even Number
    private static void minEvenNumber(Scanner sc) {

        OptionalDouble min = Arrays.stream(sc.nextLine().split("\\s+"))
                .filter(s -> !s.isEmpty())
                .mapToDouble(Double::valueOf)
                .filter(n -> n % 2 == 0)
                .min();

        if(min.isPresent()){
            System.out.printf("%.2f", min.getAsDouble());
        }else{
            System.out.println("No match");
        }
    }

//    Find and Sum Integers
    private static void findAndSumIntegers(Scanner sc) {

        OptionalInt sum = Arrays.stream(sc.nextLine().split("\\s+"))
                .filter(s -> !s.isEmpty())
                .filter(s -> isNumber(s))
                .mapToInt(Integer::valueOf)
                .reduce((a, b) -> a + b);

        if(sum.isPresent()){
            System.out.println(sum.getAsInt());
        }else{
            System.out.println("No match");
        }
    }

    private static boolean isNumber(String s){
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }

//    Bounded Numbers
    public static void boundedNumbers(Scanner sc) {

        List<Integer> bounds = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::valueOf)
                .filter(n -> Collections.min(bounds) <= n && n <= Collections.max(bounds))
                .forEach(n -> System.out.printf("%d ", n));



    }

}

package functional_programming.lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Map<String, Integer> persons = new LinkedHashMap<>();

        for(int i = 0; i < n; i++){
            String[] input = sc.nextLine().split(", ");

            String name = input[0];
            int age = Integer.parseInt(input[1]);
            persons.put(name, age);
        }

        String condition = sc.nextLine();
        int age = Integer.parseInt(sc.nextLine());
        String format = sc.nextLine();

        printFilteredStudent(persons, createTester(condition, age), createPrinter(format));

    }

    private static Consumer<Map.Entry<String,Integer>> createPrinter(String format) {

        switch (format){
            case "name age":
                return person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());

            case "age name":
                return person -> System.out.printf("%d - %s%n", person.getValue(), person.getKey());

            case "age":
                return person -> System.out.println(person.getValue());

            case "name":
                return person -> System.out.println(person.getKey());


            default:
                return person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());
        }

    }

    private static Predicate<Integer> createTester(String condition, Integer age) {

        switch (condition){
            case "younger":
                return x -> x < age;
            case "older":
                return x -> x >= age;
        }
        return null;

    }

    private static void printFilteredStudent(
            Map<String, Integer> people,
            Predicate<Integer> tester,
            Consumer<Map.Entry<String, Integer>> printer) {

        for (Map.Entry<String, Integer> person :
                people.entrySet()) {
            if (tester.test(people.get(person.getKey()))) {
                printer.accept(person);
            }
        }
    }




}

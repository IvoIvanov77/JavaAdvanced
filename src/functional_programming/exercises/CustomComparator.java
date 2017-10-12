package functional_programming.exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class CustomComparator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");

        Integer[] numbers = Arrays.stream(input)
                .map(Integer::valueOf)
                .toArray(Integer[]::new);

       // BiFunction<Integer, Integer, Comparator<Integer>> customComparator =

        Arrays.sort(numbers, (n1, n2) -> Math.abs(n1 % 2) == Math.abs(n2 % 2)
                ? n1 - n2
                : Math.abs(n1 % 2) - Math.abs(n2 % 2));

        System.out.println(Arrays.toString(numbers).replaceAll("[\\[\\],]", ""));
    }
}

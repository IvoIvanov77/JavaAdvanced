package functional_programming.lab;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        numbers.removeIf(n -> n % 2 != 0);

        System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));

        numbers.sort(Comparator.naturalOrder());

        System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));

    }
}

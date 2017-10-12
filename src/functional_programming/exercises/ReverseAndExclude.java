package functional_programming.exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");

        List<Integer> numbers = Arrays.stream(input)
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        int divisor = Integer.parseInt(sc.nextLine());

        numbers.removeIf(isDivisible(divisor));
        Collections.reverse(numbers);

        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));

    }

    private static Predicate<Integer> isDivisible(Integer divisor){
        return n -> n % divisor == 0;
    }
}

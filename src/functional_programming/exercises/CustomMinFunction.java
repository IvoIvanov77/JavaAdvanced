package functional_programming.exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");

        Integer[] numbers = Arrays.stream(input)
                .map(Integer::valueOf)
                .toArray(Integer[]::new);

        Function<Integer[], Integer> min = array -> Collections.min(Arrays.asList(array));

        System.out.println(min.apply(numbers));
    }
}

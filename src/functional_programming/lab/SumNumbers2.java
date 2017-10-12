package functional_programming.lab;

import java.util.Scanner;
import java.util.function.BiFunction;

public class SumNumbers2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s*,\\s*");

        BiFunction<String, String, Integer> parser =
                (x, y) -> Integer.parseInt(x) + Integer.parseInt(y);

        int sum = 0;
        for (int i = 0; i < input.length - 1; i += 2) {
            sum += parser.apply(input[i], input[i + 1]);
        }
        if(input.length % 2 != 0){
            sum += Integer.parseInt(input[input.length - 1]);
        }
        System.out.println("Count = " + input.length);
        System.out.println("Sum = " + sum);

    }

}

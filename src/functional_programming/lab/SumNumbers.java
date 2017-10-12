package functional_programming.lab;

import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(", ");

        Function<String, Integer> parser = Integer::parseInt;

        int sum = 0;

        for (String s : input){
            sum += parser.apply(s);
        }

        System.out.println("Count = " + input.length);
        System.out.println("Sum = " + sum);

    }
}

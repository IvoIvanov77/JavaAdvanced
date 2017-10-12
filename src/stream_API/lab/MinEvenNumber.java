package stream_API.lab;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Scanner;

public class MinEvenNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

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
}

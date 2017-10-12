package functional_programming.exercises;

import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");

        Consumer<String> printer = s -> System.out.printf("Sir %s%n", s);

        for(String name : input){
            printer.accept(name);
        }
    }
}

package functional_programming.exercises;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");

        Consumer<String> printer = System.out::println;

        for(String name : input){
            printer.accept(name);
        }
    }
}

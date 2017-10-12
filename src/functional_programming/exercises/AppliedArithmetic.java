package functional_programming.exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AppliedArithmetic {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");

        Integer[] numbers = Arrays.stream(input)
                .map(Integer::valueOf)
                .toArray(Integer[]::new);

        String command = sc.nextLine();

        while(!command.equals("end")){
            if(command.equals("print")){
                printArray(numbers);
            }else{
                for(int i = 0; i < numbers.length; i ++){
                    UnaryOperator<Integer> fun = operations(command);
                    numbers[i] = fun.apply(numbers[i]);
                }
            }

            command = sc.nextLine();
        }

    }

    private static void printArray(Integer[] numbers) {
        for(Integer n : numbers){
            System.out.print(n + " ");
        }
        System.out.println();
    }

    private static UnaryOperator<Integer> operations(String operator){

        switch (operator){
            case "add" : return n -> n + 1;
            case "multiply" : return n -> n * 2;
            case "subtract" : return n -> n - 1;
            default: return n -> n;
        }
    }

}

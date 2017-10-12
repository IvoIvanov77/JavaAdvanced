package objects_classes_and_collections.exercises;

import java.util.ArrayDeque;
import java.util.Scanner;


public class ReverseNumbersWithStack {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayDeque<String> numbers = new ArrayDeque<>();

        String[] input = sc.nextLine().split("\\s+");

        for(String number : input){
            numbers.push(number);
        }

        while(!numbers.isEmpty()){
            System.out.print(numbers.pop() + " ");
        }
    }
}

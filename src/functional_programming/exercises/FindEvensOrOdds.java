package functional_programming.exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensOrOdds {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");

        Integer[] numbers = Arrays.stream(input)
                .map(Integer::valueOf)
                .toArray(Integer[]::new);

        Integer start = numbers[0];
        Integer end = numbers[1];
        String condition = sc.nextLine();

        printFilteredNumbers(oddTester(condition), start,end);
    }

    private static Predicate<Integer> oddTester(String condition){

        if(condition.equals("odd")){
            return n -> n % 2 != 0;
        }else{
            return n -> n % 2 == 0;
        }
    }


    private static void printFilteredNumbers(Predicate<Integer> oddTester, Integer start, Integer end){

        for(int i = start; i <= end; i ++){
            if(oddTester.test(i) ){
                System.out.print(i + " ");
            }
        }
    }

}

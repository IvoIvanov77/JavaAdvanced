package functional_programming.exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class ListOfPredicates {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Integer[] array = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);

        for(int i = 1; i <= n ; i ++){
            if(allDivisors(array, i)){
                System.out.printf("%d ", i);
            }

        }

    }

    private static Predicate<Integer> isDivisible(Integer divisor){
        return n -> n % divisor == 0;
    }

    private static boolean allDivisors(Integer[] array, int n){

        for (Integer divisor: array) {

            if(!isDivisible(divisor).test(n)){
                return false;
            }
        }

        return true;
    }
}

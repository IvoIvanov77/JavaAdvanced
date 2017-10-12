package stream_API.lab;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class FindAndSumIntegers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        OptionalInt sum = Arrays.stream(sc.nextLine().split("\\s+"))
                .filter(s -> !s.isEmpty())
                .filter(s -> isNumber(s))
                .mapToInt(Integer::valueOf)
                .reduce((a, b) -> a + b);

        if(sum.isPresent()){
            System.out.println(sum.getAsInt());
        }else{
            System.out.println("No match");
        }
    }

    private static boolean isNumber(String s){
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }
}

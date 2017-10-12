package functional_programming.exercises;

import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int len = Integer.parseInt(sc.nextLine());

        String[] names = sc.nextLine().split(" ");

        Predicate<String> tester = s -> s.length() <= len;

        for(String name : names){
            if(tester.test(name)){
                System.out.println(name);
            }
        }
    }
}

package functional_programming.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWords {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");

        Predicate<String> upperCaseChecker = s -> s.charAt(0) == s.toUpperCase().charAt(0);

        List<String> result = new ArrayList<>();

        for(String s : input){
            if(upperCaseChecker.test(s)){
                result.add(s);
            }
        }

        System.out.println(result.size());

        for(String s : result){
            System.out.println(s);
        }
    }
}

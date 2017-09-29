package string_processing.exercises;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Palindromes {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(palindromes(s));

    }

    private static String palindromes(String line){
        String[] words = line.trim().split("[\\s,.!?]");
        Set<String> palindromes = new TreeSet<>();
        for (String string : words) {
            if(string.equals(reverseString(string)) && !string.isEmpty()){
                palindromes.add(string);
            }
        }

        return palindromes.toString();

    }

    private static String reverseString(String string){
        StringBuilder b = new StringBuilder(string);
        return b.reverse().toString();
    }
}

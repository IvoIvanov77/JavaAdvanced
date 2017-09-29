package string_processing.exercises;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MatchFullName {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String regex = "^[A-Z][a-z]+ [A-Z][a-z]+$";

        String line = sc.nextLine();

        while (!line.equals("end")){
            if(Pattern.matches(regex, line)){
                System.out.println(line);
            }
            line = sc.nextLine();
        }

    }
}

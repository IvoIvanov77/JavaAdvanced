package string_processing.exercises;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MatchPhoneNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String regex = "^\\+359([ |-])2\\1\\d{3}\\1\\d{4}$";

        String line = sc.nextLine();

        while (!line.equals("end")){
            if(Pattern.matches(regex, line)){
                System.out.println(line);
            }
            line = sc.nextLine();
        }

    }
}

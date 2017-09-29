package string_processing.exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceExtractor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String key = " " + sc.nextLine() + " ";

        String text = sc.nextLine();

        Pattern regex = Pattern.compile("[^.!?]*[.!?]");
        Matcher matcher = regex.matcher(text);

        while (matcher.find()){
            if(matcher.group(0).contains(key)){
                System.out.println(matcher.group(0).trim());
            }

        }


    }
}

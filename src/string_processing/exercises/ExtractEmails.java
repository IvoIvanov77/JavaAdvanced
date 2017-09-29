package string_processing.exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        String regex = "(?<=^|\\s)([A-Za-z0-9]+[-._]*)+@([\\w]+[-.])+[\\w]+";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(line);

        while(m.find()){
            System.out.println(m.group());
        }
        sc.close();

    }
}

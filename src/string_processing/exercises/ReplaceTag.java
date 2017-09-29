package string_processing.exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceTag {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StringBuilder b = new StringBuilder();

        String line = sc.nextLine();

        while(!line.equals("END")){
            b.append(line);
            b.append("\n");
            line = sc.nextLine();
        }

        Pattern regex = Pattern.compile("(<a)(\\s*href=)(\".*\")(>)(.*)(</a>)", Pattern.DOTALL);
        Matcher matcher = regex.matcher(b);

        while(matcher.find()){
//            System.out.println(matcher.group(1));
//            System.out.println(matcher.group(2));
//            System.out.println(matcher.group(3));
//            System.out.println(matcher.group(4));
//            System.out.println(matcher.group(5));
//            System.out.println(matcher.group(6));
            String replacement = "[URL" +  matcher.group(2) + matcher.group(3) + "]" + matcher.group(5) + "[/URL]";
//            System.out.println(replacement);
            b.replace(matcher.start(), matcher.end(), replacement);
        }

        System.out.println(b);

    }
}

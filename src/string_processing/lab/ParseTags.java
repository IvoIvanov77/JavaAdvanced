package string_processing.lab;

import java.util.Scanner;

public class ParseTags {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        String upcaseStart = "<upcase>";
        String upcaseEnd = "</upcase>";

        while(text.contains(upcaseStart)){
            int startIndex = text.indexOf(upcaseStart);
            int endIndex = text.indexOf(upcaseEnd);
            String remainder = text.substring(startIndex + 8, endIndex);
            String upRemainder = remainder.toUpperCase();
            text = text.replaceFirst(remainder, upRemainder);
           // System.out.println(text);
            text = text.replaceFirst(upcaseStart, "");
            text = text.replaceFirst(upcaseEnd, "");
        }

        System.out.println(text);

    }
}

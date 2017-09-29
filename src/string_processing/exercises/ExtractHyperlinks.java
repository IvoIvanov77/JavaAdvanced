package string_processing.exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractHyperlinks {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StringBuilder text = new StringBuilder();

        String line = sc.nextLine();

        while (!line.equalsIgnoreCase("end")){
            text.append(line);
            line = sc.nextLine();
        }

        Matcher matcher = extractATag(text.toString());

        while(matcher.find()){
            String tag = matcher.group(0);
            String link = extractLinks(tag);

            if(link != null){
                System.out.println(link);
            }
        }



    }


    private static Matcher extractATag(String text){

        Pattern regex = Pattern.compile("<a.*?>");

        return regex.matcher(text);
    }

    private static String extractLinks(String tag){
        Pattern regex = Pattern.compile("(?<=href)\\s*=\\s*(['\"]*)(.*?)\\1(?=[\\s>])");

        Matcher matcher = regex.matcher(tag);

        if(matcher.find()){
            return matcher.group(2);
        }

        return null;
    }

}

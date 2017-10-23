package EXAM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExtensions {



    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();
        String line = reader.readLine();



        while (!line.equals("Print")){

//            line = Pattern.quote(line);
            line = line.replaceAll("\\.", "\\\\.");
            line = line.replaceAll("%", "[\\\\S]*");


//            System.out.println(line);

            Pattern pattern = Pattern.compile(line);

            Matcher matcher = pattern.matcher(text);
            while(matcher.find()){
//                System.out.println(matcher.group(0));

                text = text.replaceAll(matcher.group(0), reverse(matcher.group(0)));
//                System.out.println("text: "  + text);
            }
            line = reader.readLine();
        }


        System.out.println(text);

    }

    private static String reverse(String input){
        return new StringBuilder(input).reverse().toString();
    }

    private static String escapeString(String s){
        Pattern regex = Pattern.compile("[., ]");
        return null;

    }




}

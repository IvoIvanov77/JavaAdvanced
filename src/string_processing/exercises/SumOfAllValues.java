package string_processing.exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumOfAllValues {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String key = sc.nextLine();

        String text = sc.nextLine();

        String startKey = extractString(key, "^[a-zA-Z_]+(?=\\d)");
        String endKey = extractString(key, "(?<=\\d)[a-zA-Z_]+$");

        if(startKey == null || endKey == null){
            System.out.println("<p>A key is missing</p>");
            return;
        }

        String regex = "(?<=" + startKey + ").*?" + "(?="  + endKey + ")";

//        System.out.println(regex);

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        double sum = 0;

        while (matcher.find()){
            try {
                double number = Double.parseDouble(matcher.group(0));
                sum += number;
            }catch (Exception e){

            }

        }

        if(sum == 0){
            System.out.println("<p>The total value is: <em>nothing</em></p>");
        }else {
            if (sum == (int)sum) {
                System.out.printf("<p>The total value is: <em>%d</em></p>", (int)sum);
            } else
                System.out.printf("<p>The total value is: <em>%.2f</em></p>", sum);
        }




//        System.out.println(startKey);
//        System.out.println(endKey);
    }

    private static String extractString(String str, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        if(matcher.find()){
            return matcher.group(0);
        }

        return null;
    }
}

package exam_preparation;

import java.nio.channels.Channels;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ascent {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        Pattern regex = Pattern.compile("[,_][a-zA-Z]+\\d");

        List<String> matches = new ArrayList<>();

        while(!line.equals("Ascend")){

            for(String s : matches){
                line = line.replaceAll(s, decrypt(s));
            }
            StringBuilder b = new StringBuilder(line);
            Matcher matcher = regex.matcher(b);

            int n = 0;
            while(true){
                if(matcher.find(n)){
                    String match = matcher.group(0);
                    String replacement = decrypt(match);
                    int start = matcher.start();
                    int end = matcher.end();
                    if(!matches.contains(match)){
                        matches.add(match);
                    }
                    b.replace(start, end, replacement);
                    n = end -(match.length() - replacement.length());
                }else{
                    break;
                }
            }
            System.out.println(b);
            line = sc.nextLine();
        }

    }

    private static String decrypt(String word){
        char symbol = word.charAt(0);
        int number = Character.getNumericValue(word.charAt(word.length() - 1));
        StringBuilder b = new StringBuilder();

        switch (symbol){
            case ',' : {
                for (int i = 1; i < word.length() - 1; i++) {
                    b.append((char)(word.charAt(i) + number));
                }
                break;
            }
            case '_' : {
                for (int i = 1; i < word.length() - 1; i++) {
                    b.append((char)(word.charAt(i) - (char)number));
                }
                break;
            }
        }

        return b.toString();
    }

}



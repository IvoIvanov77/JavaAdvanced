package exam_preparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LetterExpression {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        Pattern regex = Pattern.compile("\\d+");
        Matcher matcher = regex.matcher(line);
        double sum = 0;
        int end = 0;
        if(matcher.find()){
            sum += Double.parseDouble(matcher.group(0));
            end = matcher.end();
        }

        while(matcher.find()){
            double number = Double.parseDouble(matcher.group(0));
            int start = matcher.start();
            int countOfSymbolsBetweenTwoNumbers = start - end;
            if(countOfSymbolsBetweenTwoNumbers % 2 == 0){
                sum += number;
            }else {
                sum -= number;
            }
            end = matcher.end();
        }

        System.out.println(new DecimalFormat("0.#######").format(sum));

    }
}

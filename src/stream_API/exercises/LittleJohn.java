package stream_API.exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LittleJohn {

    public static void main(String[] args) {

        String regex = ">{1,3}-{5}>{1,2}";

        Pattern pattern = Pattern.compile(regex);

        String smallArrow = ">----->";
        String mediumArrow = ">>----->";
        String largeArrow = ">>>----->>";

        Map<String, Integer> arrows = new LinkedHashMap<>();
        arrows.put(smallArrow, 0);
        arrows.put(mediumArrow, 0);
        arrows.put(largeArrow, 0);

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            String line = sc.nextLine();
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                if(matcher.group(0).contains(largeArrow)){
                   arrows.computeIfPresent(largeArrow, (k, v) -> v + 1);
                   continue;
                }

                if(matcher.group(0).contains(mediumArrow)){
                    arrows.computeIfPresent(mediumArrow, (k, v) -> v + 1);
                    continue;
                }

                if(matcher.group(0).contains(smallArrow)){
                    arrows.computeIfPresent(smallArrow, (k, v) -> v + 1);
                }
            }
        }

        StringBuilder number = new StringBuilder();

        for (Integer n : arrows.values()) {
            number.append(n);
        }

        int n = Integer.parseInt(number.toString());

        String toBinary = Integer.toBinaryString(n);
        StringBuilder binaryResult = new StringBuilder(toBinary);
        binaryResult.append(new StringBuilder(binaryResult).reverse());
        int decimalValue = Integer.parseInt(binaryResult.toString(), 2);
        System.out.println(decimalValue);
    }
}

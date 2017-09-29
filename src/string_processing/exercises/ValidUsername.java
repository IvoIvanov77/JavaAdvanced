package string_processing.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ValidUsername {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] username = line.split("[\\s/\\\\()]+");

        String regex = "(?<=^|\\s)[a-zA-Z]{1}[\\w]{2,24}";

        List<String> validNames = Arrays.stream(username)
                .filter(name -> isValid(name, regex))
                .collect(Collectors.toList());

        int bestLength = 0;
        int bestIndex = 0;

        for (int i = 1; i < validNames.size(); i++) {
            int currentLength = validNames.get(i).length() + validNames.get(i - 1).length();
            if(currentLength > bestLength){
                bestLength = currentLength;
                bestIndex = i;
            }
        }

        System.out.printf("%s%n%s", validNames.get(bestIndex -1), validNames.get(bestIndex));

        sc.close();
    }

    private static boolean isValid(String name, String regex){
        return name.matches(regex);
    }


}

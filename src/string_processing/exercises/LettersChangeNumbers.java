package string_processing.exercises;


import java.util.Scanner;

public class LettersChangeNumbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+");

        double result = 0;

        for(String item : input){
            result += calculate(item);
        }

        System.out.printf("%.2f", result);

    }

    private static int getAlphabetPosition(char letter) {
        return Character.toLowerCase(letter) - 'a' + 1;
    }

    private static double calculate(String str) {

        char leftLetter = str.charAt(0);
        char rightLetter = str.charAt(str.length() - 1);
        double number = Double.parseDouble(str.substring(1, str.length() - 1));
        double result = 0;

        if (Character.isUpperCase(leftLetter)) {
            result += number / getAlphabetPosition(leftLetter);

        } else {
            result += number * getAlphabetPosition(leftLetter);
        }

        if (Character.isUpperCase(rightLetter)) {
            result -= getAlphabetPosition(rightLetter);
        } else {
            result += getAlphabetPosition(rightLetter);

        }

        return result;
    }


}

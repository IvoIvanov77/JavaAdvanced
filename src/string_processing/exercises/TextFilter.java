package string_processing.exercises;

import java.util.Scanner;

public class TextFilter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String banList = sc.nextLine();
        String text = sc.nextLine();

        String result = textFilter(banList, text, '*');
        System.out.println(result);

    }

    private static String textFilter(String bannedWords, String text, char ch){
        String[] bannedWordsArray = bannedWords.split(", ");
        String result = text;
        for (String string : bannedWordsArray) {
            result = result.replaceAll(string, createString(string.length(), ch));
        }

        return result;
    }

    private static String createString(int len, char ch){
        char[] arr = new char[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ch;
        }
        return new String(arr);
    }
}

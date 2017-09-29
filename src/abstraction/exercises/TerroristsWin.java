package abstraction.exercises;

import java.util.Scanner;

public class TerroristsWin {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        StringBuilder builder = new StringBuilder(text);

        int startIndex = 0;
        int endIndex = 0;
        while(text.indexOf('|', startIndex) != -1){
            startIndex = text.indexOf('|', startIndex);
            endIndex = text.indexOf('|', startIndex + 1) + 1;

            String bomb = text.substring(startIndex, endIndex);
            int bombPower = bombPower(bomb);
            int replaceFromIndex = startIndex - bombPower >= 0 ? startIndex - bombPower : 0;
            int replaceToIndex = endIndex + bombPower < text.length() ? endIndex + bombPower : text.length();
            builder.replace(replaceFromIndex, replaceToIndex, replacement(replaceFromIndex, replaceToIndex));

            startIndex = endIndex;
        }

        System.out.println(builder);

    }

    private static int bombPower(String bomb){
        int sum = 0;
        for (int i = 1; i < bomb.length() - 1 ; i++) {
            sum += bomb.charAt(i);
        }

        return sum % 10;
    }

    private static String replacement(int start, int end){
        StringBuilder b = new StringBuilder();
        for (int i = start; i < end; i++) {
            b.append('.');
        }

        return b.toString();
    }

}

package data_representation_and_manipulation.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiplyBigNumber {


    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int n = Integer.parseInt(reader.readLine());

        String result = multiplyNumber(line, n);

        System.out.println(result);

    }



//    923847238931983192462832102
//            4


    private static String multiplyNumber(String line, int n){

        StringBuilder b = new StringBuilder();
        int reminder = 0;

        for (int i = line.length() - 1; i >= 0 ; i--) {
            int number = Character.getNumericValue(line.charAt(i));
            int result = number * n + reminder;
            int digit = result % 10;
            b.append(digit);
            reminder = result / 10;
        }

        b.append(reminder);

        removeZeroes(b);

        return b.reverse().toString();
    }

    private static void removeZeroes(StringBuilder b){

        while (b.charAt(b.length() - 1) == '0' && b.length() > 1){
            b.deleteCharAt(b.length() - 1);
        }

    }

}

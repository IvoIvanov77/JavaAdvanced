package abstraction.lab;

import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        String[] array = new String[n];

        for (int i = 0; i < array.length ; i++) {
            array[i] = sc.nextLine();
        }

        int[] encryptArray = Arrays.stream(array)
                .mapToInt(s -> encryptString(s))
                .toArray();

        Arrays.sort(encryptArray);

        printArray(encryptArray);

    }

    private static int encryptString(String s){
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if(isVowel(s.charAt(i))){
                result += s.charAt(i) * s.length();
            }else{
                result += s.charAt(i) / s.length();
            }
        }

        return result;
    }

    private static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    private  static void printArray(int[] arr){
        for (int i : arr) {
            System.out.println(i);
        }
    }
}

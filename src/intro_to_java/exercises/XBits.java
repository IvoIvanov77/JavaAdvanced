package intro_to_java.exercises;

import java.util.Scanner;

public class XBits {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] numbers = new int[8];

        for (int i = 0; i < 8 ; i++) {
            numbers[i] = Integer.parseInt(sc.nextLine());
        }

        int count = 0;

        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j < 29; j++) {
                if(
                        extractBit(numbers[i], j) == 1
                        && extractBit(numbers[i], j + 1) == 0
                        && extractBit(numbers[i], j + 2) == 1
                        && extractBit(numbers[i + 1], j) == 0
                        && extractBit(numbers[i + 1], j + 1) == 1
                        && extractBit(numbers[i + 1], j + 2) == 0
                        && extractBit(numbers[i + 2], j) == 1
                        && extractBit(numbers[i + 2], j + 1) == 0
                        && extractBit(numbers[i + 2], j + 2) == 1

                        ){
                    count ++;
                }
            }
        }

        System.out.println(count);
    }

    public static int extractBit(int number, int index){

        int mask = number >> index;

        return mask & 1;
    }
}

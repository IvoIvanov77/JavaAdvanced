package intro_to_java.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class ByteParty {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(sc.nextLine());
        }

        String line = sc.nextLine();

        while(!line.equals("party over")){
            int[] input = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            int command = input[0];
            int index = input[1];

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = manipulateNumber(numbers[i], index, command);
            }
            line = sc.nextLine();
        }

        for(int i : numbers){
            System.out.println(i);
        }

    }

    public static int flipBit(int number, int index){
        int mask = 1 << index;

        return number ^ mask;
    }

    public static int turnBitToZero(int number, int index){
        int mask = ~(1 << index);

        return number & mask;
    }

    public static int turnBitToOne(int number, int index){
        int mask = 1 << index;

        return number | mask;
    }

    static int manipulateNumber(int number, int index, int command){
        switch (command){
            case -1: return flipBit(number, index);
            case 0: return turnBitToZero(number, index);
            case 1 : return turnBitToOne(number,index);
            default: return number;
        }

    }
}

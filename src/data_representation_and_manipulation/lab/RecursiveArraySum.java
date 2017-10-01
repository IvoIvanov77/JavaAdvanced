package data_representation_and_manipulation.lab;

import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] array = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::valueOf)
                .toArray();

        System.out.println(sum(array, 0));
    }

    public static int sum(int[]array, int index){

        if(index == array.length - 1){
            return array[index];
        }

        return array[index] + sum(array, index + 1);
    }
}

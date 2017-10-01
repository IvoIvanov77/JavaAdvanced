package data_representation_and_manipulation.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArrayRec {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::valueOf)
                .toArray();

        reverse(array, 0, array.length -1);

        System.out.println(Arrays.toString(array).replaceAll("[\\[\\],]", ""));
    }

    private static void reverse(int[] array, int start, int end){
        if(start > end){
            return;
        }
        int tmp = array[start];
        array[start] = array[end];
        array[end] = tmp;

        reverse(array, start + 1, end -1);

    }
}

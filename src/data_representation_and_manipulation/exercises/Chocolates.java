package data_representation_and_manipulation.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Chocolates {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int items = Integer.parseInt(reader.readLine());
        int[]array = Arrays.stream(reader.readLine().split(", "))
                .mapToInt(Integer::valueOf)
                .sorted()
                .toArray();
        int students = Integer.parseInt(reader.readLine());

        int minDifference = getMinDifference(array, students - 1);
        System.out.printf("Min Difference is %d.", minDifference);
    }


    private static int getMinDifference(int[] array, int count){
        int minDiff = Integer.MAX_VALUE;

        for (int i = count; i < array.length; i++) {
            if(array[i] - array[i - count] < minDiff){
                minDiff = array[i] - array[i - count];
            }
        }
        return minDiff;
    }
}

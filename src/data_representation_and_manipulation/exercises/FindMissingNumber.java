package data_representation_and_manipulation.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindMissingNumber {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[] array = Arrays.stream(reader.readLine().split(",\\s*"))
                .mapToInt(Integer::valueOf)
                .sorted()
                .toArray();

        for (int i = 1; i < array.length ; i++) {
            if(array[i - 1] != i){
                System.out.println(i);
                return;
            }
        }
        System.out.println(n);
    }
}

package data_representation_and_manipulation.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OverlappingIntervals {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[][] matrix = new int[n][2];

        for (int i = 0; i < n ; i++) {

            int[] array = Arrays.stream(reader.readLine().split(",\\s*"))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            matrix[i] = array;
        }

        List<int[]> list = Arrays.stream(matrix).sorted(Comparator.comparingInt(arr -> arr[0]))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size() - 1; i++) {
            if(list.get(i)[1] >= list.get(i + 1)[0]){
                System.out.println("true");
                return;
            }
        }

        System.out.println("false");

    }
}

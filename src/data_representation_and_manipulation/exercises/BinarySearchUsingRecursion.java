package data_representation_and_manipulation.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinarySearchUsingRecursion {


    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::valueOf)
                .toArray();
        int item = Integer.parseInt(reader.readLine());


        int index = binarySearch(array, item, 0, array.length - 1);

        System.out.println(index);

    }



    private static int binarySearch(int[] array, int item, int startIndex, int endIndex){
        int middleIndex = (endIndex + startIndex) / 2;

        if(array[middleIndex] == item){
            return middleIndex;
        }

        if(startIndex > endIndex){
            return -1;
        }

        if(array[middleIndex] > item){
            return binarySearch(array, item, startIndex, middleIndex - 1);
        }else {
            return binarySearch(array, item, middleIndex + 1, endIndex);
        }

    }
}

package data_representation_and_manipulation.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Searching {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::valueOf)
                .toArray();
        int item = Integer.parseInt(reader.readLine());

//        Arrays.sort(array);
        System.out.println(binarySearch(array, item));
//        System.out.println(linearSearch(array, item));
//        int index = binarySearchIteration(array, item);
//        System.out.println(index);
//        System.out.println(binarySearchIteration(array, item));

    }

    public static int linearSearch(int[] array, int item){
        for (int i = 0; i < array.length ; i++) {
            if(array[i] == item){
                return  i;
            }
        }
        return -1;
    }

    private static int binarySearchHelper(int[] array, int item, int startIndex, int endIndex){
        int middleIndex = (endIndex + startIndex) / 2;

        if(array[middleIndex] == item){
            return middleIndex;
        }

        if(startIndex > endIndex){
            return -1;
        }

        if(array[middleIndex] > item){
            return binarySearchHelper(array, item, startIndex, middleIndex - 1);
        }else {
            return binarySearchHelper(array, item, middleIndex + 1, endIndex);
        }

    }

    public static int binarySearch(int[] array, int item){
        return binarySearchHelper(array,item, 0, array.length - 1);
    }

    public static int binarySearchIteration(int[] array, int item){
        int hi = array.length - 1;
        int low = 0;

        while(hi >= low){
            int middle = low + (hi - low)/2;
            if(array[middle] == item){
                return middle;
            }else if (array[middle] > item){
                hi = middle - 1;
            }else {
                low = middle + 1;
            }
        }
        return -1;
    }
}

package data_representation_and_manipulation.lab;

import java.util.Arrays;
import java.util.Scanner;

public class Sorting {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Integer[] array = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);

//        selectionSort(array);
//        bubbleSort(array);
        Arrays.sort(array);
        System.out.println(Arrays.toString(array).replaceAll("[\\[\\],]", ""));

    }

    public static void selectionSort(int[] array){

        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    public static void bubbleSort(int[] array){
        boolean swapped = true;
        while(swapped){
            swapped = false;
            for (int i = 0; i < array.length - 1 ; i++) {
                if(array[i] > array[i + 1]){
                    swap(array, i, i + 1);
                    swapped = true;
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {

        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}

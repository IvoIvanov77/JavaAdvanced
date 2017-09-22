package abstraction.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(", ");

        int n = Integer.parseInt(input[0]);
        String method = input[1];

        int[][] matrix = new int[n][n];

        switch (method){
            case "A" : methodA(matrix);
            break;
            case "B" : methodB(matrix);
            break;
        }
        printMatrix(matrix);
    }


    private static void methodA(int[][] arr){
        int fill = 1;

        for (int col = 0; col < arr.length; col++) {
            for (int row = 0; row < arr.length; row++) {
                arr[row][col] = fill;
                fill ++;
            }
        }
    }

    private static void methodB(int[][] arr){
        int fill = 1;

        for (int col = 0; col < arr.length; col++) {
            if(col % 2 == 0){
                for (int row = 0; row < arr.length; row++) {
                    arr[row][col] = fill;
                    fill ++;
                }
            }else {
                for (int row = arr.length - 1; row >= 0; row--) {
                    arr[row][col] = fill;
                    fill++;
                }
            }

        }
    }

    private  static void printMatrix(int[][] matrix){
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\],]", ""));
        }
    }
}

package abstraction.lab;

import java.util.Scanner;

public class SumMatrixElements {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(", ");

        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);


        int[][] matrix = new int[rows][columns];

        int sum = 0;

        for (int row = 0; row < matrix.length ; row++) {
            String[] remainder = sc.nextLine().split(", ");
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = Integer.parseInt(remainder[col]);
            }
        }

        for(int[] arr : matrix){
            for(int i : arr){
                sum += i;
            }
        }

        System.out.println(rows);
        System.out.println(columns);
        System.out.println(sum);
    }
}



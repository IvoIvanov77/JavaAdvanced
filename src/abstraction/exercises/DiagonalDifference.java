package abstraction.exercises;

import java.util.Scanner;

public class DiagonalDifference {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int n = Integer.parseInt(sc.nextLine());



        int[][] matrix = new int[n][n];

        for (int row = 0; row < matrix.length ; row++) {
            String[] remainder = sc.nextLine().split(" ");
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = Integer.parseInt(remainder[col]);
            }
        }

        System.out.printf("%d", Math.abs(sumLeftDiagonal(matrix) - sumRightDiagonal(matrix)));
    }

    private static int sumLeftDiagonal(int[][] matrix){
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }

        return sum;
    }

    private static int sumRightDiagonal(int[][] matrix){
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][matrix.length - 1 - i];
        }

        return sum;
    }



}

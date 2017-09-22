package abstraction.lab;

import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(", ");

        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);


        int[][] matrix = new int[rows][columns];



        for (int row = 0; row < matrix.length ; row++) {
            String[] remainder = sc.nextLine().split(", ");
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = Integer.parseInt(remainder[col]);
            }
        }

        int rowIndex = 0;
        int colIndex = 0;

        int bestSum = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                int sum = matrix[i][j] + matrix[i][j + 1] +
                        matrix[i + 1][j] + matrix[i + 1][j + 1];
                if(sum > bestSum){
                    bestSum = sum;
                    rowIndex = i;
                    colIndex = j;
                }
            }
        }

        System.out.printf("%d %d%n", matrix[rowIndex][colIndex], matrix[rowIndex][colIndex + 1]);
        System.out.printf("%d %d%n", matrix[rowIndex + 1][colIndex], matrix[rowIndex + 1][colIndex + 1]);
        System.out.println(bestSum);


    }
}

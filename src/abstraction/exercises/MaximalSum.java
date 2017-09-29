package abstraction.exercises;

import java.util.Scanner;

public class MaximalSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");

        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);


        int[][] matrix = new int[rows][columns];



        for (int row = 0; row < matrix.length ; row++) {
            String[] remainder = sc.nextLine().split(" ");
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = Integer.parseInt(remainder[col]);
            }
        }

        int rowIndex = 0;
        int colIndex = 0;

        int bestSum = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[0].length - 2; j++) {
                int sum = 0;
                int endRowIndex = i + 3;
                int endColIndex = j + 3;
                for (int k = i; k < endRowIndex ; k++) {
                    for (int l = j; l < endColIndex ; l++) {
                        sum += matrix[k][l];
                    }
                }
                if(sum > bestSum){
                    bestSum = sum;
                    rowIndex = i;
                    colIndex = j;
                }
            }
        }


        System.out.printf("Sum = %d%n", bestSum);

        int endRowIndex = rowIndex + 3;
        int endColIndex = colIndex + 3;
        for (int row = rowIndex; row < endRowIndex; row++) {
            for (int col = colIndex; col < endColIndex; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }
}

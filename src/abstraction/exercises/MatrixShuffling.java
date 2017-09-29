package abstraction.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");

        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);


        String[][] matrix = new String[rows][columns];

        for (int row = 0; row < matrix.length ; row++) {
            String[] remainder = sc.nextLine().split(" ");
            matrix[row] = remainder;
        }

        String line = sc.nextLine();

        while (!line.equals("END")){
            String[] command = line.split(" ");
            if(!isValidInput(command)){
                System.out.println("Invalid input!");
            }else{
                int row1 = Integer.parseInt(command[1]);
                int col1 = Integer.parseInt(command[2]);
                int row2 = Integer.parseInt(command[3]);
                int col2 = Integer.parseInt(command[4]);
                try {
                    swap(matrix, row1, col1, row2, col2);
                    printMatrix(matrix);
                }catch (IndexOutOfBoundsException e){
                    System.out.println("Invalid input!");
                }
            }


            line = sc.nextLine();
        }
    }

    private static boolean isValidInput(String[]input){
        return input[0].equals("swap") && input.length == 5;
    }

    private static void swap(String[][] matrix, int row1, int col1, int row2, int col2)
            throws IndexOutOfBoundsException{
        String tmp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = tmp;

    }

    private  static void printMatrix(String[][] matrix){
        for (String[] row : matrix) {
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\],]", ""));
        }
    }

}

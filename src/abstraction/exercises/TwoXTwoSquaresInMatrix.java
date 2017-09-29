package abstraction.exercises;

import java.util.Scanner;

public class TwoXTwoSquaresInMatrix {

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

        int count = 0;

        for (int i = 0; i < matrix.length - 1 ; i++) {
            for (int j = 0; j < matrix[0].length - 1 ; j++) {

                if(matrix[i][j].equals(matrix[i][j + 1])
                        && matrix[i][j].equals(matrix[i + 1][j + 1])
                        && matrix[i][j].equals(matrix[i + 1][j])){
                            count ++;
                }
            }
        }

        System.out.println(count);
    }
}

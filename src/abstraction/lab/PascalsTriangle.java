package abstraction.lab;

import java.util.Arrays;
import java.util.Scanner;

public class PascalsTriangle {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        long[][] triangle = new long[n][];

        triangle[0] = new long[1];
        triangle[0][0] = 1;

        for (int row = 1; row < n ; row++) {
            long[] column = new long[row + 1];
            column[0] = 1;
            column[row] = 1;
            triangle[row] = column;
            for (int col = 1; col < row ; col++) {
                triangle[row][col] = triangle[row-1][col -1] + triangle[row-1][col];
            }
        }

        printArray(triangle);
    }

    private  static void printArray(long[][] triangle){
        for (long[] row : triangle) {
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\],]", ""));
        }
    }
}

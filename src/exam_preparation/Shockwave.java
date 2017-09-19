package exam_preparation;

import java.util.Arrays;
import java.util.Scanner;

public class Shockwave {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int columns = sc.nextInt();
        sc.nextLine();

        int[][] arr = new int[rows][columns];

        String line = sc.nextLine();

        while(!line.equals("Here We Go")){
            String[] input = line.split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);

            for (int i = x1; i <= x2 ; i++) {
                for (int j = y1; j <= y2 ; j++) {
                    arr[i][j] += 1;
                }
            }
            line = sc.nextLine();
        }

        printMatrix(arr);

    }

    static void printMatrix(int[][] matrix){
        for(int[] arr : matrix){
            System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", ""));
        }
    }
}

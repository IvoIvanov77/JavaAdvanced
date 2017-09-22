package abstraction.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");

        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);

        Palindrome[][] matrix = new Palindrome[rows][columns];

        for (int r = 0; r < matrix.length ; r++) {
            for (int c = 0; c < matrix[0].length ; c++) {
                matrix[r][c] = new Palindrome(r, c);
            }
        }
        printMatrix(matrix);
    }

    private  static void printMatrix(Palindrome[][] matrix){
        for (Palindrome[] row : matrix) {
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\],]", ""));
        }
    }

}

class Palindrome {

    private char a;
    private char b;
    private char c;

    Palindrome(int r, int c) {
        this.a = (char)('a' + r);
        this.c = (char)('a' + r);
        this.b = (char)('a' + r + c);
    }

    @Override
    public String toString() {
        return a + "" + b + "" + c;
    }
}

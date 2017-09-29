package abstraction.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SequenceInMatrix {

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

        List<String> result = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length ; j++) {
                List<String> horizontalSequence = horizontalSequence(matrix, i, j);
                List<String> verticalSequence = verticalSequence(matrix, i, j);
                List<String> leftDiagonalSequence = leftDiagonalSequence(matrix, i, j);
                List<String> rightDiagonalSequence = rightDiagonalSequence(matrix, i, j);

//                System.out.println(rightDiagonalSequence);
//                if(horizontalSequence.size() >= result.size()){
//                    result = horizontalSequence;
//                }
                if(verticalSequence.size() >= result.size()){
                    result = verticalSequence;
                }
                if(leftDiagonalSequence.size() >= result.size()){
                    result = leftDiagonalSequence;
                }

//                if(rightDiagonalSequence.size() >= result.size()){
//                    result = rightDiagonalSequence;
//                }
            }
        }

        System.out.println(result.toString().replaceAll("[\\[\\]]", ""));
    }

    private static List<String> horizontalSequence(String[][] matrix, int row, int col){

        List<String> sequence = new ArrayList<>();
        String item = matrix[row][col];
        sequence.add(item);

        int next = col + 1;

        while(next < matrix[row].length && item.equals(matrix[row][next])){
            sequence.add(matrix[row][next]);
            next ++;
        }

        return sequence;
    }

    private static List<String> verticalSequence(String[][] matrix, int row, int col){

        List<String> sequence = new ArrayList<>();
        String item = matrix[row][col];
        sequence.add(item);

        int next = row + 1;

        while(next < matrix.length && item.equals(matrix[next][col])){
            sequence.add(matrix[next][col]);
            next ++;
        }

        return sequence;
    }

    private static List<String> leftDiagonalSequence(String[][] matrix, int row, int col){

        List<String> sequence = new ArrayList<>();
        String item = matrix[row][col];
        sequence.add(item);

        int nextRow = row + 1;
        int nextCol = col + 1;

        while(nextRow < matrix.length
                && nextCol < matrix[nextRow].length
                && item.equals(matrix[nextRow][nextCol])){
            sequence.add(matrix[nextRow][nextCol]);
            nextRow ++;
            nextCol ++;
        }

        return sequence;
    }

    private static List<String> rightDiagonalSequence(String[][] matrix, int row, int col){

        List<String> sequence = new ArrayList<>();
        String item = matrix[row][col];
        sequence.add(item);

        int nextRow = row + 1;
        int nextCol = col - 1;

        while(nextRow < matrix.length
                && nextCol >= 0
                && item.equals(matrix[nextRow][nextCol])){
            sequence.add(matrix[nextRow][nextCol]);
            nextRow ++;
            nextCol --;
        }

        return sequence;
    }
}

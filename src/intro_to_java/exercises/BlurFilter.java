package intro_to_java.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class BlurFilter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long blurAmount = Long.parseLong(sc.nextLine());

        String[] rowsAndColumns = sc.nextLine().split("\\s+");

        Matrix matrix = new Matrix(rowsAndColumns);

        matrix.populate(sc);

        matrix.blur(blurAmount, sc.nextLine());

        System.out.println(matrix);

    }

    static class Matrix{
        int row;

        int column;

        long[][] matrix;

        Matrix(String[] input) {
            this.row = Integer.parseInt(input[0]);
            this.column = Integer.parseInt(input[1]);
            this.matrix = new long[row][column];
        }

        void populate(Scanner sc) {

            for(int i = 0; i < row; i ++){
                String[] input = sc.nextLine().split("\\s+");
                long[] row = Arrays.stream(input)
                        .mapToLong(Long::parseLong)
                        .toArray();
                this.matrix[i] = row;
            }

        }

        void blur(long amount, String target){

            int[] coors = Arrays.stream(target.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int row = coors[0];
            int column =coors[1];
            this.matrix[row][column] += amount;

            if(isValid(row - 1, column - 1)){
                this.matrix[row - 1][column - 1] += amount;
            }
            if(isValid(row - 1, column)){
                this.matrix[row - 1][column] += amount;
            }
            if(isValid(row - 1, column + 1)){
                this.matrix[row - 1][column + 1] += amount;
            }
            if(isValid(row, column - 1)){
                this.matrix[row ][column - 1] += amount;
            }
            if(isValid(row, column + 1)){
                this.matrix[row][column + 1] += amount;
            }
            if(isValid(row + 1, column - 1)){
                this.matrix[row + 1][column - 1] += amount;
            }
            if(isValid(row + 1, column)){
                this.matrix[row + 1][column] += amount;
            }
            if(isValid(row + 1, column + 1)){
                this.matrix[row + 1][column + 1] += amount;
            }

        }

        private boolean isValid(int rowIndex, int columnIndex){
            return(rowIndex >= 0 && rowIndex < this.row
                    && columnIndex >= 0 && columnIndex < this.column);
        }

        @Override
        public String toString() {
            StringBuilder b = new StringBuilder();
            for (long[] aMatrix : this.matrix) {
                b.append(Arrays.toString(aMatrix).replaceAll("[\\[\\],]", ""));
                b.append("\n");
            }
            return b.toString();
        }
    }
}

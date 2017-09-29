package abstraction.exercises;

import java.util.Scanner;

public class CollectTheCoins {

    private static char[][] matrix = new char[4][];
    private static int coins = 0;
    private static int wall = 0;
    private static int row = 0;
    private static int col = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);



        for (int i = 0; i < 4; i++) {
            matrix[i] = sc.nextLine().toCharArray();
        }

        String movement = sc.nextLine();
        for (int i = 0; i < movement.length() ; i++) {
            char direction = movement.charAt(i);

            switch (direction){
                case 'V' : moveDown();
                break;
                case '^': moveUp();
                break;
                case '>': moveRight();
                break;
                case '<': moveLeft();
            }
        }

        System.out.printf("Coins = %d%n", coins);
        System.out.printf("Walls = %d%n", wall);

    }

    private static void moveDown(){

        try {
            char ch = matrix[++row][col];
            if(ch == '$'){
                coins ++;
            }
        }catch (IndexOutOfBoundsException e){
            wall ++;
            row --;
        }
    }

    private static void moveUp(){

        try {
            char ch = matrix[--row][col];
            if(ch == '$'){
                coins ++;
            }
        }catch (IndexOutOfBoundsException e){
            wall ++;
            row ++;
        }
    }

    private static void moveRight(){

        try {
            char ch = matrix[row][++col];
            if(ch == '$'){
                coins ++;
            }
        }catch (IndexOutOfBoundsException e){
            wall ++;
            col --;
        }
    }

    private static void moveLeft(){

        try {
            char ch = matrix[row][--col];
            if(ch == '$'){
                coins ++;
            }
        }catch (IndexOutOfBoundsException e){
            wall ++;
            col ++;
        }
    }


}

package data_representation_and_manipulation.lab;

import java.util.Collections;
import java.util.Scanner;

public class RecursiveDrawing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        drawFigure(n);
    }

    private static void drawFigure(int n) {

        if(n == 0){
            return;
        }

        System.out.println(String.join("", Collections.nCopies(n, "*")));
        drawFigure(n - 1);
        System.out.println(String.join("", Collections.nCopies(n, "#")));
    }
}

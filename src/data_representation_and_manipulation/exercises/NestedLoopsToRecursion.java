package data_representation_and_manipulation.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class NestedLoopsToRecursion {

    private static int[] loops;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        loops = new int[n];

        doAction(n, 0);

    }

    private static void doAction(int n, int start){
        if(start == n){
            printLoops();
            return;
        }

        for (int i = 1; i <= n; i++) {
            loops[start] = i;
            doAction(n, start + 1);

        }

    }

    private static void printLoops(){
        System.out.println(Arrays.toString(loops).replaceAll("[\\[\\],]", ""));
    }


}

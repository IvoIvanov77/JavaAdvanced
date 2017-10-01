package data_representation_and_manipulation.lab;

import java.util.Arrays;
import java.util.Scanner;

public class RecursiveFactorial {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        System.out.println(fact(n));

    }

    private static int fact(int n) {

        if(n == 0){
            return  1;
        }

        return n * fact(n - 1);
    }


}

package intro_to_java.lab;

import java.util.Scanner;

public class AverageOfThreeNumbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double first = sc.nextDouble();
        double second = sc.nextDouble();
        double third = sc.nextDouble();

        System.out.printf("%.2f", (first + second + third) / 3);
    }
}

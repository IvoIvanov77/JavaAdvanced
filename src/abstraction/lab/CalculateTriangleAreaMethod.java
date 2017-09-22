package abstraction.lab;

import java.util.Scanner;

public class CalculateTriangleAreaMethod {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double base = sc.nextDouble();
        double height = sc.nextDouble();

        System.out.printf("Area = %.2f", calculateArea(base, height));

    }

    private static double calculateArea(double base, double height){
        return  base * height / 2;
    }
}

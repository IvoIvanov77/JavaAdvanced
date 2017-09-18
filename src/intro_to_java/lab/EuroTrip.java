package intro_to_java.lab;

import java.math.BigDecimal;
import java.util.Scanner;

public class EuroTrip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BigDecimal priceInBGN = new BigDecimal(sc.nextDouble() * 1.2);

        BigDecimal marks = priceInBGN.multiply(new BigDecimal("4210500000000"));

        System.out.printf("%.2f marks", marks);
    }
}

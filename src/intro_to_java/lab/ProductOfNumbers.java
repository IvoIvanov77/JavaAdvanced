package intro_to_java.lab;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class ProductOfNumbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int tmp = n;
        BigInteger product = BigInteger.ONE;

        do {
            BigInteger number = new BigInteger("" + tmp);
            product = product.multiply(number);
            tmp++;
        } while (tmp <= m);

        System.out.printf("product[%d..%d] = %d\n", n, m, product);

    }
}

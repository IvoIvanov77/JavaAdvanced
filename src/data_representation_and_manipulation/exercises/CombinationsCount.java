package data_representation_and_manipulation.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class CombinationsCount {

    public static void main(String[] args) throws IOException {

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        long n = Long.parseLong(reader.readLine());
//        long k = Long.parseLong(reader.readLine());
//
//        double combination = calculateCombinations(n, k);
//        System.out.printf("%.0f", combination);
        BigInteger n = new BigInteger("5");
        BigInteger f = factorial(n);
        System.out.println(f);

    }

    private static double factorial(long n){

        if(n == 0){
            return 1;
        }

        return n * factorial(n - 1);
    }

    private static double calculateCombinations(long n, long k){

        return factorial(n) / factorial(n - k) / factorial(k);
    }

    private static BigInteger factorial(BigInteger n){

        if(n.intValue() == 0){
            return new BigInteger("1");
        }

        return n.multiply(factorial(n.subtract(new BigInteger("1"))));
    }

}

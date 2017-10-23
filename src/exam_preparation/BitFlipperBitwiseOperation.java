package exam_preparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BitFlipperBitwiseOperation {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BigInteger number = new BigInteger(reader.readLine());
        BigInteger seven = new BigInteger("7");
        BigInteger zero = new BigInteger("0");


        for (int i = 0; i <= 61 ; i++) {

            BigInteger threeDigit = number.shiftRight(61 - i).and(seven);
            if(threeDigit.equals(seven) || threeDigit.equals(zero)){
                number = number.xor(seven.shiftLeft(61 - i));
                i += 2;
            }
        }

        System.out.println(number);
    }
}

package exam_preparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ShuffleBits {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BigInteger firstNumber = new BigInteger(reader.readLine());
        BigInteger secondNumber = new BigInteger(reader.readLine());
        BigInteger result = new BigInteger("0");

        BigInteger one = new BigInteger("1");
        BigInteger tree = new BigInteger("3");

        if (firstNumber.compareTo(secondNumber) >= 0)
        {
            for (int i = 31; i >= 0; i--)
            {
                result = (result.shiftLeft(1)).or(firstNumber.shiftRight(i).and(one));
                result = (result.shiftLeft(1)).or(secondNumber.shiftRight(i).and(one));

            }
        }
        else
        {
            for (int i = 31; i >= 0; i -= 2)
            {
                BigInteger twoDigitOfFirstNumber = firstNumber.shiftRight(i - 1).and(tree);
                BigInteger twoDigitOfSecondNumber = secondNumber.shiftRight(i - 1).and(tree);
                result = result.shiftLeft(2).or(twoDigitOfFirstNumber);
                result = result.shiftLeft(2).or(twoDigitOfSecondNumber);

            }
        }

        System.out.println(result);
    }
}

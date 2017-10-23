package exam_preparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class WaveBits {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BigInteger number = new BigInteger(reader.readLine());

        BigInteger five = new BigInteger("5");

        BigInteger seven = new BigInteger("7");


        int bestSequenceLength = 0;
        int bestSequenceStartIndex = 0;
        int currentSequenceLength = 1;

        for (int i = 0; i <= 61 ; i++) {
            BigInteger treeDigit = number.shiftRight(i).and(seven);

            if(treeDigit.equals(five)){
                currentSequenceLength += 2;

                if(currentSequenceLength > bestSequenceLength){
                    bestSequenceLength = currentSequenceLength;
                    bestSequenceStartIndex = i + 2;
                    i ++;
                }
            }else {
                currentSequenceLength = 1;
            }

        }
    }
}

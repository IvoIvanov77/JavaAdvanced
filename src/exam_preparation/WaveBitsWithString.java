package exam_preparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class WaveBitsWithString {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BigInteger number = new BigInteger(reader.readLine());
        String binaryNumber = number.toString(2);
//        System.out.println(binaryNumber);
        StringBuilder b = new StringBuilder(binaryNumber).reverse();

        int maxCount = 1;
        int bestIndex = 0;

        for (int i = 0; i < b.length() - 3; i++) {

            int subCount = 1;
            while(i < b.length() - 2){
                String treeDigit = b.substring(i, i+3);
                if(treeDigit.equals("101")){
                    i += 2;
                    subCount += 2;
                }else{
                    break;
                }
            }
            if(subCount > maxCount){
                maxCount = subCount;
                bestIndex = i - subCount + 1;
            }

        }

        if(maxCount <= 1){
            System.out.println("No waves found!");
            return;
        }

        b.delete(bestIndex, bestIndex + maxCount).reverse();
        if(b.length() == 0){
            System.out.println(0);
        }else{
            System.out.println(new BigInteger(b.toString(), 2));
        }


//
//        System.out.println(maxCount);
//        System.out.println(bestIndex);

    }
}

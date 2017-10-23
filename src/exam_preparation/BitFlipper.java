package exam_preparation;

import java.math.BigInteger;
import java.util.Scanner;

public class BitFlipper {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger number = new BigInteger(sc.nextLine());

        String binaryNumber = number.toString(2);

        StringBuilder b = new StringBuilder(binaryNumber);
        while(b.length() < 64){
            b.insert(0, '0');
        }

//        System.out.println(binaryNumber);
//        System.out.println(b);

        for (int i = 0; i < b.length() - 3 ; i++) {
            String subNumber = b.substring(i, i + 3);
            if(subNumber.equals("111")){
                b.replace(i, i + 3, "000");
                i += 2;
            }

            if(subNumber.equals("000")){
                b.replace(i, i + 3, "111");
                i += 2;
            }
        }

        BigInteger bi = new BigInteger(b.toString(), 2);
        System.out.println(bi);

    }
}

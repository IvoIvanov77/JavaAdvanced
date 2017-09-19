package intro_to_java.lab;

import java.util.Scanner;

public class ExtractBitFromInteger {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int p = sc.nextInt();

        int mask = n >> p;
//        System.out.println(Integer.toBinaryString(n));//100100011
//        System.out.println(Integer.toBinaryString(mask));//1001;
        int bit = mask & 1;

        System.out.println(bit);
    }
}

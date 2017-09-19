package intro_to_java.lab;

public class BitwiseOperation {

    public static void main(String[] args) {
        //print binary number
        System.out.println(Integer.toBinaryString(291));
        System.out.println(Integer.toBinaryString(100 >> 2));

        int n = 520;                    // 00000010 00001000
        int maskRight = n >> 2;         // 00000000 10000010
        int bitLeft = n << 3;            // 00010000 01000000

        System.out.println(maskRight);        // 82
        System.out.println(bitLeft);        // 4160

    }
}

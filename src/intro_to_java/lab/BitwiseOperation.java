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

        int a = 60;	/* 60 = 0011 1100 */
        int b = 13;	/* 13 = 0000 1101 */
        int c = 0;

        c = a & b;        /* 12 = 0000 1100 */
        System.out.println("a & b = " + c );

        c = a | b;        /* 61 = 0011 1101 */
        System.out.println("a | b = " + c );

        c = a ^ b;        /* 49 = 0011 0001 */
        System.out.println("a ^ b = " + c );

        c = ~a;           /*-61 = 1100 0011 */
        System.out.println("~a = " + c );

        c = a << 2;       /* 240 = 1111 0000 */
        System.out.println("a << 2 = " + c );

        c = a >> 2;       /* 15 = 1111 */
        System.out.println("a >> 2  = " + c );

        c = a >>> 2;      /* 15 = 0000 1111 */
        System.out.println("a >>> 2 = " + c );

    }
}

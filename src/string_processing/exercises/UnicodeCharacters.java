package string_processing.exercises;

import java.util.Scanner;

public class UnicodeCharacters {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {
//			String str = String.format ("\\u%04x", (int)s.charAt(i));
//			System.out.print(str);
            System.out.print( "\\u" + Integer.toHexString(s.charAt(i) | 0x10000).substring(1) );
        }
//        System.out.println();
//        System.out.println("________________________");
//
//        StringBuilder b = new StringBuilder(s);
//
//        for (int i = 0; i < b.length() ; i++) {
//            System.out.print("\\u00" + Integer.toHexString(b.codePointAt(i)));
//        }
        sc.close();
    }
}

package intro_to_java.lab;

import java.util.Scanner;

public class ModifyABit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int p = sc.nextInt();
        int bit = sc.nextInt();
        int result;
        int mask;
        if(bit == 0){
            mask = ~(1 << p);
            result = n & mask;
        }else{
            mask = 1 << p;
            result = n | mask;
        }
        System.out.println(result);
    }
}

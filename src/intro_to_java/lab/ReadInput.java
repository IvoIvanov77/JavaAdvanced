package intro_to_java.lab;

import java.util.Scanner;

public class ReadInput {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String firstWord = sc.next("\\w++");
        String secondWord = sc.next("\\w++");
        int firstInt = sc.nextInt();
        int secondInt = sc.nextInt();
        int thirdInt = sc.nextInt();
        sc.nextLine();

        String thirdWord = sc.nextLine();

        int sum = firstInt + secondInt + thirdInt;

        System.out.println(firstWord + " " + secondWord + " " + thirdWord + " " + sum);
    }
}

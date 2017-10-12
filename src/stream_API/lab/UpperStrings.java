package stream_API.lab;

import java.util.Arrays;
import java.util.Scanner;

public class UpperStrings {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Arrays.stream(sc.nextLine().split(" "))
                .map(String::toUpperCase)
                .forEach(s -> System.out.print(s + " "));

    }
}

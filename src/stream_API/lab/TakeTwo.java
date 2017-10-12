package stream_API.lab;

import java.util.Arrays;
import java.util.Scanner;

public class TakeTwo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .filter(n -> 10 <= n && n <= 20)
                .distinct()
                .limit(2)
                .forEach(n -> System.out.print(n + " "));

    }
}

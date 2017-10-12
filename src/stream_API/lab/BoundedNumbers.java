package stream_API.lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BoundedNumbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> bounds = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::valueOf)
                .filter(n -> Collections.min(bounds) <= n && n <= Collections.max(bounds))
                .forEach(n -> System.out.printf("%d ", n));

    }
}

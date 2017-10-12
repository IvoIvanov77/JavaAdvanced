package objects_classes_and_collections.lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MathPotato {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] children = sc.nextLine().split("\\s+");
        int n = Integer.parseInt(sc.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>(Arrays.asList(children));

        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++){
                queue.offer(queue.poll());
            }
//            System.out.println(cycle);
//            System.out.println(isPrime(cycle));
            if (isPrime(cycle)){
                System.out.println("Prime " + queue.peek());
            }else{
                System.out.println("Removed " + queue.poll());
            }

            cycle++;
        }
        System.out.println("Last is " + queue.poll());


    }

//    private static boolean isPrime(int num) {
//        if (num == 1) return false;
//        if (num == 2) return true;
//        if (num % 2 == 0) return false;
//        for (int i = 3; i * i < num; i += 2)
//            if (num % i == 0) return false;
//        return true;
//    }

    private static boolean isPrime(int number) {
        return number > 1 &&
                IntStream.rangeClosed(2, (int) Math.sqrt(number))
                        .noneMatch(i -> number % i == 0);
    }
}

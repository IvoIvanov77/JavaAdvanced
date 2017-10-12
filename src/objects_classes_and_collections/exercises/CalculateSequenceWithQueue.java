package objects_classes_and_collections.exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by Ivaylo on 9/10/2017.
 */
public class CalculateSequenceWithQueue {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long n = Long.parseLong(sc.nextLine());

        Deque<Long> queue = new ArrayDeque<>();
        queue.offer(n);
        int count = 0;
        while(count < 50){

            Long s1 = queue.peek();

            queue.offer(s1 + 1);
            queue.offer(2 * s1 + 1);
            queue.offer(s1 + 2);

            System.out.printf("%d ", queue.pop());
            count ++;
        }


    }
}

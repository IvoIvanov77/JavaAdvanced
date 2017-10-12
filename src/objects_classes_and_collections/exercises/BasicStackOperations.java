package objects_classes_and_collections.exercises;

import java.util.*;

public class BasicStackOperations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = input[0], s = input[1], x = input[2];

        Deque<Integer> stack = new ArrayDeque<>(n);

        int[] items = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for(int i = 0; i < n - s; i ++){
            stack.push(items[i]);
        }

        if(stack.isEmpty()){
            System.out.println(0);
            return;
        }

        if(stack.contains(x)){
            System.out.println("true");
        }else {
            System.out.println(Collections.min(stack));
        }

    }
}

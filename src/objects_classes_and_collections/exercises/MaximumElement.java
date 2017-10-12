package objects_classes_and_collections.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


public class MaximumElement {

    public static void main(String[] args) throws IOException {

//        Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Deque<Long> stack = new ArrayDeque<>(n);

        Deque<Long> maxElements = new ArrayDeque<>();

        long max = Long.MIN_VALUE;

        for(int i = 0; i < n; i ++){
            String command = reader.readLine();

            if(command.startsWith("1")){
                long item = Long.parseLong(command.substring(2));
                stack.push(item);
                if(item > max){
                    maxElements.push(item);
                    max = item;
                }
            }else if(command.startsWith("2")){
                if(stack.pop() == maxElements.peek()){
                    maxElements.pop();
                    max = maxElements.isEmpty() ? Long.MIN_VALUE : maxElements.peek();
                }
            }else{
                System.out.println(maxElements.peek());
            }
        }

    }
}

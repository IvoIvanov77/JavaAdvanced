package objects_classes_and_collections.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class TheStockSpanProblem {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(reader.readLine());
        }
        calculateSpan(prices);
    }

    private static void calculateSpan(int prices[])
    {
        StringBuilder b = new StringBuilder();
        // Create a stack and push index of first element to it
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        // Span value of first element is always 1
        b.append(1).append("\n");


        // Calculate span values for rest of the elements
        for (int i = 1; i < prices.length; i++)
        {
            // Pop elements from stack while stack is not empty and top of
            // stack is smaller than price[i]
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i])
                stack.pop();

            // If stack becomes empty, then price[i] is greater than all elements
            // on left of it, i.e., price[0], price[1],..price[i-1]. Else price[i]
            // is greater than elements after top of stack
            int spam = (stack.isEmpty())? (i + 1) : (i - stack.peek());
            b.append(spam).append("\n");

            // Push this element to stack
            stack.push(i);
        }

        System.out.println(b);
    }
}

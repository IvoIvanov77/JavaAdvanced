package objects_classes_and_collections.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BalancedParentheses {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] array = reader.readLine().toCharArray();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char parentheses : array) {
            if (isParenthesesOpen(parentheses)) {
                stack.push(parentheses);
            } else {
                if (stack.isEmpty() || getClosedParentheses(stack.poll()) != parentheses) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");

    }

    private static char getClosedParentheses(char openParentheses){
        switch (openParentheses){
            case '(' : return ')';
            case '{' : return '}';
            case '[' : return ']';
        }
        return '\0';
    }

    private static boolean isParenthesesOpen(char parentheses){
        return parentheses == '('
                || parentheses =='{'
                || parentheses == '[';

    }
}

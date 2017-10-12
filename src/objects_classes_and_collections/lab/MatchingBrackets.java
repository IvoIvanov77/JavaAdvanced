package objects_classes_and_collections.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == '('){
                stack.push(i);
            }
            if(line.charAt(i) == ')'){
                int index = stack.pop();
                System.out.println(line.substring(index, i + 1));
            }

        }
    }
}

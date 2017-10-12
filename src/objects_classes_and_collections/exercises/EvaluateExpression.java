package objects_classes_and_collections.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class EvaluateExpression {


    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = InfixToPostfix(reader.readLine());

        String[] tokens = input.split(" ");

        ArrayDeque<Double> stack = new ArrayDeque<>();


        for (String token : tokens) {
            if(isOperand(token)){
                double number = Double.parseDouble(token);
                stack.push(number);
            }else {
                double right = stack.pop();
                double left = stack.pop();
                stack.push(evaluate(left, right, token));
            }
        }

        System.out.printf("%.2f", stack.pop());
    }

    private static Double evaluate(double left, double right, String operator) {
        switch (operator){
            case "+" : return left + right;
            case "-" : return left - right;
            case "*" : return left * right;
            case "/" : return left / right;
        }
        return null;
    }

    private static String InfixToPostfix(String line)  {

        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder postfixExpression = new StringBuilder();

        String[] tokensArray = line.split(" ");

        for(String token : tokensArray){
            if(isOperand(token)){
                postfixExpression.append(token).append(" ");
            }else if(isOperator(token)){
                while (!stack.isEmpty() && (compareOperands(stack.peek(), token) > 0)){
                    postfixExpression.append(stack.pop()).append(" ");
                }
                stack.push(token);

            }else if(isParentheses(token)){
                if ("(".equals(token)){
                    stack.push(token);
                }else {
                    while(!stack.isEmpty() && !stack.peek().equals("(")){
                        postfixExpression.append(stack.pop()).append(" ");
                    }
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()){
            postfixExpression.append(stack.pop()).append(" ");
        }

        return  postfixExpression.toString();
    }

    private static boolean isOperand(String token){
        String operatorRegex = "[0-9a-z]+";
        return token.matches(operatorRegex);
    }

    private static boolean isOperator(String token){
        String operandRegex = "[+/*-]";
        return token.matches(operandRegex);
    }

    private static boolean isParentheses(String token){
        String parenthesesRegex = "[()]";
        return token.matches(parenthesesRegex);
    }

    private static int compareOperands(String o1, String o2){

        if(o1.matches("[*/]") && o2.matches("[-+]")) {
            return 1;
        }
        if(o1.matches("[-+]") && o2.matches("[-+]")) {
            return 1;
        }
        if(o1.matches("[*/]") && o2.matches("[*/]")) {
            return 1;
        }
        return 0;
    }
}

package objects_classes_and_collections.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class SimpleTextEditor {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        StringBuilder text = new StringBuilder();

        ArrayDeque<String[]> undoStack = new ArrayDeque<>();

        boolean addToUndo = true;

        for (int i = 0; i < n; i++) {
            String[] token = reader.readLine().split("\\s+");
            if(token.length < 2){
                token = undoStack.pop();
                addToUndo = false;
            }
//            System.out.println(Arrays.toString(token));
            String command = token[0];
            String argument = token[1];

            switch (command){
                case "1" :{
                    text.append(argument);
                    String[] array = {"2", "" + argument.length()};
                    if(addToUndo){
                        undoStack.push(array);
                    }
                    addToUndo = true;
                    break;
                }
                case "2" : {
                    int index = Integer.parseInt(argument);
                    String[] array = {"1", text.substring(text.length() - index)};
                    text.delete(text.length() - index, text.length());
                    if(addToUndo){
                        undoStack.push(array);
                    }
                    addToUndo = true;
                    break;
                }
                case "3" : {
                    int index = Integer.parseInt(argument);
                    System.out.println(text.charAt(index - 1));
                    break;
                }
//                case "4" : break;
            }
//            System.out.println(Arrays.deepToString(undoStack.toArray()));

        }
    }
}

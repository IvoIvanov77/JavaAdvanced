package abstraction.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlusRemove {

    static List<List<CustomChar>> text = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);



        String line = sc.nextLine();

        while(!line.equals("END")){
            List<CustomChar> row = new ArrayList<>();

            for (int i = 0; i < line.length() ; i++) {

                row.add(new CustomChar(line.charAt(i)));
            }
            text.add(row);
            line = sc.nextLine();
        }

        for (int i = 0; i < text.size() - 2 ; i++) {
            for (int j = 1; j < text.get(i).size(); j++) {
                if(isPlusShape(i, j)){
                    text.get(i).get(j).isPartOfShapes = true;
                    text.get(i + 1).get(j).isPartOfShapes = true;
                    text.get(i + 1).get(j - 1).isPartOfShapes = true;
                    text.get(i + 1).get(j + 1).isPartOfShapes = true;
                    text.get(i + 2).get(j).isPartOfShapes = true;
                }
            }
        }

        deleteShape();
        printText();

    }

    private static boolean isPlusShape(int row, int col){

        try {
            return Character.toLowerCase(text.get(row).get(col).name) ==
                        Character.toLowerCase(text.get(row + 1).get(col).name) &&
                    Character.toLowerCase(text.get(row).get(col).name) ==
                            Character.toLowerCase(text.get(row + 1).get(col - 1).name) &&
                    Character.toLowerCase(text.get(row).get(col).name) ==
                            Character.toLowerCase(text.get(row + 1).get(col + 1).name) &&
                    Character.toLowerCase(text.get(row).get(col).name) ==
                            Character.toLowerCase(text.get(row + 2).get(col).name);

        }catch(IndexOutOfBoundsException e){
            return false;
        }

    }

    private static void deleteShape(){
        for (List<CustomChar> aText : text) {
            for (int j = 0; j < aText.size(); j++) {
                if (aText.get(j).isPartOfShapes) {
                    aText.remove(j --);
                }
            }
        }
    }

    private static void printText(){
        for (List<CustomChar> aText : text) {
            System.out.println(aText.toString().replaceAll("[\\[\\],\\s]", ""));
        }
    }
}

class CustomChar{
    char name;
    boolean isPartOfShapes;

    CustomChar(char name) {
        this.name = name;
        this.isPartOfShapes = false;
    }

    @Override
    public String toString() {
        return "" + name;
    }
}

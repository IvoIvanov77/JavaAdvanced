package abstraction.exercises;

import java.util.*;

public class StringMatrixRotation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String rotate = sc.nextLine();

        String[] input = rotate.split("[()]");
        int degree = Integer.parseInt(input[1]);

        degree = degree % 360;

        String line = sc.nextLine();

        int maxLen = 0;

        List<StringBuilder> strings = new ArrayList<>();

        while (!line.equals("END")){
            strings.add(new StringBuilder(line));
            if(line.length() > maxLen){
                maxLen = line.length();
            }
            line = sc.nextLine();
        }

        for(StringBuilder b : strings){
            while(b.length() < maxLen){
                b.append(" ");
            }
        }

        switch (degree){
            case 90 :
                printMatrix(rotate90(strings, maxLen));
                break;
            case 180 :
                printMatrix(rotate180(strings));
                break;
            case 270 :
                printMatrix(rotate270(strings, maxLen));
                break;
            default:
                printMatrix(strings);
                break;
        }

    }

    private static List<StringBuilder> rotate90(List<StringBuilder> list, int length){
        List<StringBuilder> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            StringBuilder line = new StringBuilder();
            for(StringBuilder b : list ) {
                line.append(b.charAt(i));
            }
            result.add(line.reverse());
        }
        return result;
    }

    private static List<StringBuilder> rotate180(List<StringBuilder> list){
        List<StringBuilder> result = new ArrayList<>();
        for (StringBuilder b : list) {
            StringBuilder line = b.reverse();
            result.add(line);
        }
        Collections.reverse(result);
        return result;
    }

    private static List<StringBuilder> rotate270(List<StringBuilder> list, int length){
        List<StringBuilder> result = new ArrayList<>();
        for (int i = length - 1; i >= 0; i--) {
            StringBuilder line = new StringBuilder();
            for(StringBuilder b : list ) {
                line.append(b.charAt(i));
            }
            result.add(line);
        }
        return result;
    }

    private static void printMatrix(List<StringBuilder> list){
        for(StringBuilder b : list){
            System.out.println(b);
        }
    }

}

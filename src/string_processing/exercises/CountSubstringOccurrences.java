package string_processing.exercises;

import java.util.Scanner;

public class CountSubstringOccurrences {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine().toLowerCase();
        String target = sc.nextLine().toLowerCase();

        int count = 0;

        int index = 0;

        while(true){
            index = text.indexOf(target, index);
            if(index == -1){
                break;
            }
            count ++;
            index ++;
        }

        System.out.println(count);
    }
}

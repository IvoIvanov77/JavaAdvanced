package objects_classes_and_collections.exercises;

import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        HashMap<String, String> phones = new HashMap<>();

        while (!line.equalsIgnoreCase("search")){
            String[] token = line.split("-");
            String name = token[0];
            String number = token[1];

            phones.put(name, number);

            line = sc.nextLine();
        }

        line = sc.nextLine();
        while (!line.equalsIgnoreCase("stop")){

            if(!phones.containsKey(line)){
                System.out.printf("Contact %s does not exist.%n", line);
            }else {
                System.out.printf("%s -> %s%n", line, phones.get(line));
            }
            line = sc.nextLine();
        }

    }



}

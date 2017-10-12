package functional_programming.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<String> people = Arrays.stream(sc.nextLine().split(" "))
                .collect(Collectors.toList());

        String line = sc.nextLine();

        while (!line.equalsIgnoreCase("Party!")){
            String[] token = line.split(" ");
            String command = token[0];
            String criteria = token[1];
            String argument = token[2];
            manipulateList(people, command, criteria, argument);
            line = sc.nextLine();
        }

        if(people.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else{
            System.out.printf("%s are going to the party!%n",
                    people.toString().replaceAll("[\\[\\]]", ""));
        }

    }

    private static void manipulateList(List<String> list, String command, String criteria,
                                       String argument){
        switch (criteria){
            case "StartsWith" :
                if(command.equals("Double")){
                    doubleItem(list, startsWith(argument));
                }else{
                    removeItem(list, startsWith(argument));
                }
                break;
            case "EndsWith" : {
                if(command.equals("Double")){
                    doubleItem(list, endsWith(argument));
                }else{
                    removeItem(list, endsWith(argument));
                }
                break;
            }
            case "Length" : {
                if(command.equals("Double")){
                    doubleItem(list, lengthEquals(argument));
                }else{
                    removeItem(list, lengthEquals(argument));
                }
                break;
            }

        }
    }

    private static void doubleItem(List<String> list, Predicate<String> predicate ){
        for (int i = 0; i < list.size(); i++) {
            String item = list.get(i);
            if(predicate.test(item)){
                list.add(i ++, item);
            }
        }
    }

    private static void removeItem(List<String> list, Predicate<String> predicate ){
        for (int i = 0; i < list.size(); i++) {
            String item = list.get(i);
            if(predicate.test(item)){
                list.remove(i --);
            }
        }
    }

    private static Predicate<String> startsWith(String argument){
        return s -> s.startsWith(argument);
    }

    private static Predicate<String> endsWith(String argument){
        return s -> s.endsWith(argument);
    }

    private static Predicate<String> lengthEquals(String argument){
        return s -> s.length() == Integer.parseInt(argument);
    }
}

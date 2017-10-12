package functional_programming.exercises;

import java.util.*;
import java.util.stream.Collectors;

public class TPRF {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<String> people = Arrays.stream(sc.nextLine().split(" "))
                .collect(Collectors.toList());

        String line = sc.nextLine();

        List<String[]> predicates = new LinkedList<>();

        while (!line.equalsIgnoreCase("Print")){
            String[] token = line.split(";");
            String command = token[0];
            String filterType = token[1];
            String filterParameter = token[2];
            if(command.startsWith("Add")){
                String[] typeAndParameter = {filterType, filterParameter};
                predicates.add(typeAndParameter);
            }else {
                predicates.removeIf(arr -> arr[0].equals(filterType) && arr[1].equals(filterParameter));
            }
            line = sc.nextLine();
        }

        for(String[] predicate : predicates){
            String filter = predicate[0];
            String parameter = predicate[1];
            switch (filter){
                case "Starts with" :{
                    people.removeIf(s -> s.startsWith(parameter));
                }
                break;
                case "Ends with" :{
                    people.removeIf(s -> s.endsWith(parameter));
                }
                break;
                case "Contains" :{
                    people.removeIf(s -> s.contains(parameter));
                }
                break;
                case "Length" :{
                    people.removeIf(s -> s.length() == Integer.parseInt(parameter));
                }
                break;

            }
        }

        System.out.println(people.toString().replaceAll("[\\[\\],]", ""));


    }

//    Pesho Misho Jica
//    Add filter;Starts with;P
//    Add filter;Starts with;M
//    Remove filter;Starts with;M
//            Print

}

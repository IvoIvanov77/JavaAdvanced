package stream_API.lab;

import java.util.*;
import java.util.stream.Stream;

public class FirstName {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<String> names = Arrays.asList(sc.nextLine().split(" "));

        Set<Character> letters = new HashSet<>();

        Stream.of(sc.nextLine().split(" "))
                .map(s -> s.toLowerCase().charAt(0))
                .forEach(letters::add);

        Optional<String> first = names.stream()
                .filter(s -> letters.contains(s.toLowerCase().charAt(0)))
                .sorted()
                .findFirst();

        if(first.isPresent()){
            System.out.println(first.get());
        }else{
            System.out.println("No match");
        }

    }
}

package stream_API.exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class StudentsByEnrollmentYear {

    public static void main(String[] args) throws IOException {

        List<String[]> lines = Files.readAllLines(Paths.get("StudentData.txt"))
                .stream()
                .skip(1)
                .map(s -> s.split("\\s+"))
                .collect(Collectors.toList());

        Map<Integer, Set<String>> students = new TreeMap<>();

        for(String[] arr : lines){
            Integer year = Integer.parseInt(arr[0].substring(arr[0].length() - 2));
            String name = arr[1] + " " + arr[2];
            if(!students.containsKey(year)){
                students.put(year, new TreeSet<>());
            }
            students.get(year).add(name);
        }

        students.forEach((k, v) -> {
            System.out.println("20" + k + ":");
            v.forEach(s -> System.out.println("-- " + s));
        });
    }
}

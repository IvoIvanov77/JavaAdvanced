package stream_API.exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentsByFirstAndLastName {

    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("StudentData.txt"))
                .stream()
                .skip(1)
                .collect(Collectors.toList());

        Map<String, Integer> studentsByGroup = new LinkedHashMap<>();

        for(String line : lines){
            String[] token = line.split("\\s+");
            String firstName = token[1];
            String lastName = token[2];
            if(firstName.compareTo(lastName) < 0){
                String name = String.format("%s %s", token[1], token[2]);
                studentsByGroup.put(name, null);
            }

        }

        studentsByGroup.forEach((key, value) -> System.out.println(key));

    }
}

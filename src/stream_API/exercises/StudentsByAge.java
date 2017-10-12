package stream_API.exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentsByAge {

    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("StudentData.txt"))
                .stream()
                .skip(1)
                .collect(Collectors.toList());


        Map<String, Integer> studentsByGroup = new LinkedHashMap<>();

        for(String line : lines){
            String[] token = line.split("\\s+");
            String name = String.format("%s %s", token[1], token[2]);
            int age = Integer.parseInt(token[4]);
            studentsByGroup.put(name, age);
        }

        studentsByGroup.entrySet()
                .stream()
                .filter(es -> es.getValue() >= 18 && es.getValue() <= 24)
                .forEach((es -> System.out.printf("%s %s%n", es.getKey(), es.getValue())));

    }


}

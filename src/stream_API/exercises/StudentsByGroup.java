package stream_API.exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StudentsByGroup  {

    public static void main(String[] args) throws IOException {


        List<String> lines = Files.readAllLines(Paths.get("StudentData.txt"))
                .stream()
                .skip(1)
                .collect(Collectors.toList());

        Map<String, Integer> studentsByGroup = new TreeMap<>();

        for(String line : lines){
            String[] token = line.split("\\s+");
            String name = String.format("%s %s", token[1], token[2]);
            int group = Integer.parseInt(token[5]);
            studentsByGroup.put(name, group);

        }

        studentsByGroup.entrySet().stream()
                .filter(es -> es.getValue() == 2)
                .forEach(es -> System.out.println(es.getKey()));

    }
}

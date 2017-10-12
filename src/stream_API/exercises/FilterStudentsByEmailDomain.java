package stream_API.exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class FilterStudentsByEmailDomain {

    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("StudentData.txt"))
                .stream()
                .skip(1)
                .collect(Collectors.toList());

        lines.stream()
                .filter(s -> s.contains("@gmail.com"))
                .map(s -> s.split("\\s+"))
                .forEach(arr -> System.out.printf("%s %s %s%n", arr[1], arr[2], arr[3]));
    }

}

package stream_API.exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FilterStudentsPhone {

    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("StudentData.txt"))
                .stream()
                .skip(1)
                .collect(Collectors.toList());

        lines.stream()
                .map(s -> s.split("\\s+"))
                .filter(arr -> arr[10].startsWith("02") || arr[10].startsWith("+3592"))
                .forEach(arr -> System.out.printf("%s %s %s%n", arr[1], arr[2], arr[10]));
    }

}

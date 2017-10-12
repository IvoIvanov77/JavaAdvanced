package stream_API.exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class WeakStudents {

    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("StudentData.txt"))
                .stream()
                .skip(1)
                .collect(Collectors.toList());

        Map<String,List<Integer>> students = lines.stream()
                .map(s -> s.split("\\s+"))
                .collect(Collectors.toMap(arr -> arr[1] + " " + arr[2],arr ->  Arrays.stream(arr)
                        .skip(6)
                        .limit(4)
                        .map(Integer::valueOf)
                        .collect(Collectors.toList()),(v1, v2) -> { throw new IllegalStateException(); },
        LinkedHashMap::new));

//        System.out.println(students);

        students.entrySet().stream()
                .filter(es -> es.getValue().stream().filter((n -> n <= 3)).count() >= 2)
                .sorted(Comparator.comparing(es -> es.getValue()
                        .stream()
                        .mapToInt(Integer::valueOf)
                        .average().getAsDouble()))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        es -> es.getValue()
                                .stream().sorted()
                        .collect(Collectors.toList()),(v1, v2) -> { throw new IllegalStateException(); },
                        LinkedHashMap::new))
        .forEach((k, v) -> System.out.printf("%s %s%n", k, v.toString().replaceAll("[\\[\\],]", "")));

//        lines.stream()
//                .map(s -> s.split("\\s+"))
//                .filter(arr ->
//                        Arrays.stream(arr)
//                                .skip(6)
//                                .limit(4)
//                                .map(Integer::valueOf)
//                                .filter(n -> n <= 3)
//                                .collect(Collectors.toList())
//                                .size() >= 2
//                ).sorted(Comparator.comparing(arr -> Arrays.stream(arr)
//                .skip(6)
//                .limit(4)
//                .mapToInt(Integer::valueOf)
//                .average().getAsDouble()))
//
//                .forEach(arr -> System.out.printf("%s %s %s %s %s %s%n", arr[1], arr[2], arr[6], arr[7], arr[8], arr[9]));
    }
}

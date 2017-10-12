package stream_API.exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortStudents {

    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("StudentData.txt"))
                .stream()
                .skip(1)
                .collect(Collectors.toList());

        List<Student> students = new ArrayList<>();

        for(String line : lines){
            String[] names = line.split("\\s+");
            students.add(new Student(names[1], names[2]));

        }

        Comparator<Student> comparator = Comparator.comparing(Student::getLastName)
                .thenComparing((s1, s2) -> s2.firstName.compareTo(s1.firstName));

        students.stream()
                .sorted(comparator)
                .forEach(System.out::println);

    }
}

class Student{
    String firstName;
    String lastName;

    Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}


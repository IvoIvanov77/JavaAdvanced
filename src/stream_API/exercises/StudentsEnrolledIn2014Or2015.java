package stream_API.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentsEnrolledIn2014Or2015 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        List<String> students = new ArrayList<>();

        while(!line.equalsIgnoreCase("end")){
            students.add(line);
            line = sc.nextLine();
        }

        students.stream()
                .map(s -> s.split("\\s+", 2))
                .filter(arr -> arr[0].endsWith("14") || arr[0].endsWith("15"))
                .forEach(arr -> System.out.printf("%s%n", arr[1]));
    }
}

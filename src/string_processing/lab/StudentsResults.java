package string_processing.lab;

import java.util.Arrays;
import java.util.Scanner;

public class StudentsResults {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        String[] input = line.split(" - ");
        String name = input[0];
        double[] grades = Arrays.stream(input[1].split(", "))
                .mapToDouble(Double::valueOf)
                .toArray();
        double average = Arrays.stream(grades).average().getAsDouble();
        System.out.printf("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|%n", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average");
        System.out.printf("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|%n", name, grades[0], grades[1], grades[2], average);

    }
}

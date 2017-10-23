package EXAM;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BitSnow {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(", ");

        long[] numbers = new long[input.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Long.parseLong(input[i]);
        }

        for (int j = 0; j < numbers.length ; j++) {
            for (int i = numbers.length - 2; i >= 0; i--) {
                long first = numbers[i];
                long second = numbers[i + 1];
                numbers[i] = first & second;
                numbers[i + 1]  = first | second;
            }
        }

        System.out.println(Arrays.toString(numbers).replaceAll("[\\[\\]]", ""));
    }
}

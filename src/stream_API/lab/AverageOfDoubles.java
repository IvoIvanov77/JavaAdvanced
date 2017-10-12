package stream_API.lab;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;

public class AverageOfDoubles {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<String> elements = Arrays.asList(sc.nextLine().split(" "));

        OptionalDouble average = elements.stream()
                .filter(s -> !s.isEmpty())
                .mapToDouble(Double::valueOf)
                .average();

        if(average.isPresent()){
            System.out.printf("%.2f",average.getAsDouble());
        }else{
            System.out.println("No match");
        }
    }
}

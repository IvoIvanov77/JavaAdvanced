package functional_programming.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+");

        List<Integer> numbers = Arrays.stream(input)
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> minIndex = list -> {
            int index = 0;
            int min = list.get(0);
            for(int i = 1; i < list.size(); i ++){
                if(list.get(i) <= min){
                    index = i;
                    min = list.get(i);
                }
            }
            return index;
        };

        System.out.println(minIndex.apply(numbers));

    }
}

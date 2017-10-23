package exam_preparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Earthquake {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        ArrayDeque<List<Integer>> allNumbers = new ArrayDeque<>();

        List<Integer> input = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] token = reader.readLine().split(" ");
            List<Integer> numbers = new ArrayList<>();
            for (String s : token) {
                numbers.add(Integer.parseInt(s));
            }
            allNumbers.addLast(numbers);
        }

        while(!allNumbers.isEmpty()){
            List<Integer> list = allNumbers.poll();
            int firstNumber = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                if(firstNumber < list.get(i)){
                    allNumbers.addLast(list.subList(i, list.size()));
                    break;
                }
            }
            input.add(firstNumber);
        }

        System.out.println(input.size());
        System.out.println(input.toString().replaceAll("[\\[\\],]", ""));

    }


}

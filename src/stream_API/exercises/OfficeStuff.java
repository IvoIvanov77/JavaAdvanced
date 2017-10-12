package stream_API.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class OfficeStuff {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Map<String,Map<String, Integer>> stuff = new TreeMap<>();

        for (int i = 0; i < n; i++) {

            String line = reader.readLine();
            String[] input = line.replaceAll("\\|", "").split("\\s+-\\s+");
            String company = input[0];
            Integer amount = Integer.parseInt(input[1]);
            String product = input[2];

            if(!stuff.containsKey(company)){
                stuff.put(company, new LinkedHashMap<>());
            }

            if(!stuff.get(company).containsKey(product)){
                stuff.get(company).put(product, amount);
            }else {
                Integer newAmount =stuff.get(company).get(product) + amount;
                stuff.get(company).put(product, newAmount);
            }

        }

        stuff.forEach((key, value) -> System.out.printf("%s: %s%n", key, value.toString()
                .replaceAll("[{}]", "")
                .replaceAll("=", "-")));

    }
}

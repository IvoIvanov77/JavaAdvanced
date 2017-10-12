package objects_classes_and_collections.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class CountSymbols {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        TreeMap<Character, Integer> countOccurrence = new TreeMap<>();

        for (int i = 0; i < line.length(); i++) {
            Character ch = line.charAt(i);
            if(!countOccurrence.containsKey(ch)){
                countOccurrence.put(ch, 1);
            }else{
                int n = countOccurrence.get(ch) + 1;
                countOccurrence.put(ch, n);
            }
        }

        if(countOccurrence.isEmpty()){
            System.out.println();
            return;
        }

        System.out.println(countOccurrence.toString().replaceAll("[{}]", "")
                .replaceAll("=", ": ")
                .replaceAll(",\\s", " time/s\n") + " time/s");

    }
}

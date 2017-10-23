package exam_preparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FootballStats {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        Map<String, List<Match>> allMatches = new HashMap<>();

        while (!line.equals("Season End")){

            Match match = new Match(line);
            if(!allMatches.containsKey(match.home)){
                allMatches.put(match.home, new ArrayList<>());
            }
            if(!allMatches.containsKey(match.away)){
                allMatches.put(match.away, new ArrayList<>());
            }
            allMatches.get(match.home).add(match);
            String awayResult = new StringBuilder(match.result).reverse().toString();
            allMatches.get(match.away).add(new Match(match.away, match.home, awayResult));

            line = reader.readLine();
        }

        String[] input = reader.readLine().split(", ");
//        System.out.println(allMatches);

        for (String s : input) {
            allMatches.get(s)
                    .stream()
                    .sorted(Comparator.comparing(m -> m.away))
                    .forEach(m -> System.out.printf("%s - %s -> %s%n", m.home, m.away, m.result));
        }

    }

}

class Match {
    String home;
    String away;
    String result;

    public Match(String input) {
        String[] token = input.split("\\s+-\\s+|\\s+");
//        System.out.println(Arrays.toString(token));
        this.home = token[0];
        this.away = token[1];
        this.result = token[3];

    }

    public Match(String home, String away, String result) {
        this.home = home;
        this.away = away;
        this.result = result;
    }
}

package stream_API.lab;

import java.util.*;

public class MapDistricts {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, List<Integer>> cities = populateMap(sc);

        int bound = Integer.parseInt(sc.nextLine());

        cities.entrySet().stream()
                .filter(es -> totalPopulation(es.getValue()) > bound)
                .sorted(
                        (es1, es2) -> Integer.compare(totalPopulation(es2.getValue()),
                                totalPopulation(es1.getValue()))
                )

                .forEach(es -> {
                    System.out.printf("%s: ", es.getKey());
                    es.getValue().stream()
                            .sorted(Comparator.reverseOrder())
                            .limit(5)
                            .forEach(d -> System.out.printf("%d ", d));
                    System.out.println();
                });
    }

    private static Map<String, List<Integer>> populateMap(Scanner sc){
        Map<String, List<Integer>> cities = new HashMap<>();
        String[] entries = sc.nextLine().split("\\s+");
        for(String s : entries){

            String[] input = s.split(":");
            String key = input[0];
            Integer value = Integer.parseInt(input[1]);

            if(cities.containsKey(key)){
                cities.get(key).add(value);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(value);
                cities.put(key,list);
            }
        }
        return cities;
    }

    private static Integer totalPopulation(List<Integer> districts){
        return districts.stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }

}

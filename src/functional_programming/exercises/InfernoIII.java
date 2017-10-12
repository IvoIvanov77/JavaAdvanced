package functional_programming.exercises;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InfernoIII {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> gems = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        List<Integer> filteredList = new ArrayList<>(gems);
        String line = sc.nextLine();

        List<String[]> predicates = new LinkedList<>();

        while (!line.equalsIgnoreCase("Forge")){
            String[] token = line.split(";");
            String command = token[0];
            String filterType = token[1];
            String filterParameter = token[2];
            if(command.equals("Exclude")){
                String[] typeAndParameter = {filterType, filterParameter};
                predicates.add(typeAndParameter);
            }else if(command.equals("Reverse")) {
                predicates.removeIf(arr -> arr[0].equals(filterType) && arr[1].equals(filterParameter));
            }
            line = sc.nextLine();
        }

        for(String[] predicate : predicates){
            String filter = predicate[0];
            int parameter = Integer.parseInt(predicate[1]);
            switch (filter){
                case "Sum Left" :{
                    Predicate<Integer> pr = testSumLeft(gems, parameter);
                    filteredList(gems, filteredList, pr);
                }
                break;
                case "Sum Right" :{
                    Predicate<Integer> pr = testSumRight(gems, parameter);
                    filteredList(gems, filteredList, pr);
                }
                break;
                case "Sum Left Right" :{
                    Predicate<Integer> pr = testSumLeftRight(gems, parameter);
                    filteredList(gems, filteredList, pr);
                }
                break;

            }
        }
        filteredList.removeIf(Objects::isNull);
        System.out.println(filteredList.toString().replaceAll("[\\[\\],]", ""));

    }

    private static Predicate<Integer> testSumLeft(List<Integer> list, int item){
        return index -> index == 0 ? list.get(index) == item : list.get(index) + list.get(index - 1) == item;
    }

    private static Predicate<Integer> testSumRight(List<Integer> list, int item){
        return index -> index == list.size() - 1
                ? list.get(index) == item
                : list.get(index) + list.get(index + 1) == item;
    }

    private static Predicate<Integer> testSumLeftRight(List<Integer> list, int item){

        return index -> {
           if(index == 0){
               return testSumRight(list, item).test(index);
           }else if(index == list.size() -1){
               return testSumLeft(list, item).test(index);
           }else {
               return list.get(index - 1) + list.get(index) + list.get(index + 1) == item;
           }
        };
    }

    private static void filteredList(List<Integer> list, List<Integer> filterList, Predicate<Integer> pr){

        for (int i = 0; i < list.size(); i++) {
            if(pr.test(i)){
                filterList.set(i, null);
            }
        }

    }


}

package objects_classes_and_collections.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class TruckTour {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        LinkedList<int[]> pumpTour = new LinkedList<>();

        for (int i = 0; i < n ; i++) {
            int[] array = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            pumpTour.add(array);
        }

        int index = 0;

        while(!isCircleComplete(pumpTour)){
            pumpTour.add(pumpTour.removeFirst());
            index ++;
            if(index > pumpTour.size()){
                return;
            }
        }

        System.out.println(index);


    }

    private static boolean isCircleComplete(LinkedList<int[]> pumps){
        int fuel = 0;

        for (int[] aPump : pumps) {
            fuel += aPump[0];
            fuel -= aPump[1];
            if (fuel < 0) {
                return false;
            }
        }

        return true;
    }
}

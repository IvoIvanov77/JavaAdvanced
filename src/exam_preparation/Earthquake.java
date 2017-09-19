package exam_preparation;

import java.util.*;
import java.util.stream.Collectors;

public class Earthquake {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());


        Deque<Integer> waves = new ArrayDeque<>();

        List<Integer> seismicities = new ArrayList<>();

        int activity = 0;
        int shift = 0;

        for (int i = 0; i < n ; i++) {
            List<Integer> input = Arrays.stream(sc.nextLine().split(" "))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());

            activity = input.remove(0);
            waves.addAll(input);
            shiftQueue(waves, shift);
            while(activity >= waves.peek()){
               waves.poll();
            }
            seismicities.add(activity);
            shift = waves.size();

        }

//        System.out.println(waves);

        while(!waves.isEmpty()){
            System.out.println(seismicities);
            activity = waves.poll();
            while(!waves.isEmpty() && activity >= waves.peek()){
                waves.poll();
            }
            seismicities.add(activity);
        }

        System.out.println(seismicities);
    }

    static void shiftQueue(Deque<Integer> queue, int shift){
        for (int i = 0; i < shift; i++) {
            queue.offer(queue.poll());
        }
    }
}

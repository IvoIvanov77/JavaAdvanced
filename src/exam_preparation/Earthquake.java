package exam_preparation;

import java.util.*;
import java.util.stream.Collectors;

public class Earthquake {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());


        Deque<Integer> waves = new ArrayDeque<>();
        Deque<Integer> queue = new ArrayDeque<>();

        List<Integer> seismicities = new ArrayList<>();

        int activity = 0;
        int shift = 0;

        for (int i = 0; i < n ; i++) {
            List<Integer> input = Arrays.stream(sc.nextLine().split(" "))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());

            waves.addAll(input);
            System.out.println();
            System.out.println();
            System.out.println(waves);
            while(!queue.isEmpty()){
                waves.offer(queue.poll());
            }
            System.out.println(waves);

            activity = waves.poll();

            while(activity >= waves.peek()){
               waves.poll();

            }
            seismicities.add(activity);

            while(!waves.isEmpty()){
                queue.offer(waves.poll());
            }
        }

        System.out.println();
        System.out.println(waves);
        System.out.println();

        while(!waves.isEmpty()){


            activity = waves.poll();
            while(!waves.isEmpty() && activity >= waves.peek()){
                waves.poll();
            }
            seismicities.add(activity);
            shift = waves.size();
        }

        System.out.println(seismicities);
    }

//    private static void shiftQueue(Deque<Integer> queue, int shift){
//        for (int i = 0; i < shift; i++) {
//            queue.offer(queue.poll());
//        }
//    }
}

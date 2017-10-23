package EXAM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LittleAlchemy {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> stones = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        ArrayDeque<Integer> queue = new ArrayDeque<>(stones);
        int count = 0;

        String line = reader.readLine();

        while(!line.equals("Revision")){
            String[] input = line.split(" ");
            String command = input[0];
            int n = Integer.parseInt(input[2]);
            if(command.equals("Apply")){

                for (int i = 0; i < n; i++) {
                    if(!queue.isEmpty()){
                        int stone = queue.poll();
                        stone -= 1;
                        if(stone > 0){
                            queue.offer(stone);
                        }else{
                            count++;
                        }
                    }
                }
            }else {
                if(count > 0){
                    queue.offer(n);
                    count --;
                }

            }
            line = reader.readLine();
        }

        System.out.println(queue.toString().replaceAll("[\\[\\],]", ""));
        System.out.println(count);

    }
}

package asynchronous_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Benchmarking {
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Scanner sc = new Scanner(System.in);
        System.out.print("n = ");
        int to = Integer.valueOf(sc.nextLine());
        
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i <= to; i++) {
            numbers.add(i);
        }

        long start = System.nanoTime();

        ExecutorService es = Executors.newFixedThreadPool(4);

        Future[] result = new Future[numbers.size()];

        for(Integer number : numbers){
            Future<Boolean> future = es.submit(() -> isPrime(number));
            result[number] = future;
        }

        es.awaitTermination(100L, TimeUnit.MILLISECONDS);

        long total = System.nanoTime() - start;

        System.out.println("Execution time: " + total);

//        for(Future f : result){
//            System.out.println(f.get());
//        }
       
    }

    private static boolean isPrime(int number) {
        return number > 1 &&
                IntStream.rangeClosed(2, (int) Math.sqrt(number))
                        .noneMatch(i -> number % i == 0);
    }

    
}

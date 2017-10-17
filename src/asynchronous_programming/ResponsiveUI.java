package asynchronous_programming;

import stream_API.lab.TakeTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResponsiveUI {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("n = ");
        int to = Integer.valueOf(sc.nextLine());

        Runnable task = () -> printPrimes(to);
        Thread thread = new Thread(task);
        thread.start();

        while(true){
            String command = sc.nextLine();

            if(command.equalsIgnoreCase("stop")){
                thread.interrupt();
                break;
            }else{
                System.out.println("unknown command");
            }
        }

        thread.join();
    }

    static void printPrimes(int to){
        List<Integer> primes = new ArrayList<>();
        for (int i = 0; i < to; i++) {
            if(isPrime(i)){
                primes.add(i);
            }

            if(Thread.currentThread().isInterrupted()){
                System.out.println("Interrupted...");
                break;
            }
        }

        System.out.println(primes.stream()
                .limit(10)
                .collect(Collectors.toList()) + "...");
        System.out.printf("%s primes calculated", primes.size());
    }

    private static boolean isPrime(int number) {
        return number > 1 &&
                IntStream.rangeClosed(2, (int) Math.sqrt(number))
                        .noneMatch(i -> number % i == 0);
    }

}

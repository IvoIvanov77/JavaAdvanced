package asynchronous_programming;

public class MultiThread {

    public static void main(String[] args) {

        Runnable task = () -> {
            for (int i = 1; i <= 10; i++) {
                System.out.printf("[%s] ", i);
                Thread.yield();
            }
        };

        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for(Thread thread : threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



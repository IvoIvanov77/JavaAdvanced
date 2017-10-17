package asynchronous_programming;

public class Transactions {

    final static int transaction = 100;
    final static int operationsPerTransaction = 100;

    public static void main(String[] args) throws InterruptedException {

        Account account = new Account();

        Runnable task = () -> {
            for (int i = 0; i < operationsPerTransaction; i++) {
                account.threadSaveAdd(1);
                Thread.yield();
            }
        };

        Thread[] threads = new Thread[transaction];
        for (int i = 0; i < transaction; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (int i = 0; i < transaction; i++) {
            threads[i].join();
        }
        System.out.println(account.balance);

    }

    static class Account{

        int balance;

        void add(int amount){
            this.balance += amount;
        }

        synchronized void threadSaveAdd(int amount){
            this.balance += amount;
        }

    }


}

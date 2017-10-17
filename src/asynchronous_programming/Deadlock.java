package asynchronous_programming;

public class Deadlock {

//    X starts to use A.
//    X and Y try to start using B
//    Y 'wins' and gets B first
//    now Y needs to use A
//    A is locked by X, which is waiting for Y

    public static void main(String[] args) {

        MyClass first = new MyClass("First");
        MyClass second = new MyClass("Second");

        Thread tFirst = new Thread(() -> first.a(second));
        Thread tSecond = new Thread(() -> second.a(first));

        tFirst.start();
        tSecond.start();

    }

    static class MyClass{

        String id;

        MyClass(String id) {
            this.id = id;
        }

        synchronized void a(MyClass other){
            System.out.printf("%s called method A on %s%n", this.id, other.id);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            other.b(this);
        }

        synchronized void b(MyClass other) {
            System.out.printf("%s called method B on %s%n",  other.id, this.id);
            other.c();

        }

        synchronized void c() {

            System.out.println(this.id + " done");
        }
    }
}

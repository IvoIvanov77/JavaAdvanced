package intro_to_java.lab;

import java.util.Scanner;

public class TransportPrice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        String time = sc.nextLine();

        if(n < 20){
            if(time.equals("day")){
                System.out.printf("%.2f", 0.7 + n * 0.79);
            }else{
                System.out.printf("%.2f", 0.7 + n * 0.90);
            }

        }else if( n < 100){
            System.out.printf("%.2f", n * 0.09);
        }else {
            System.out.printf("%.2f", n * 0.06);
        }
    }
}

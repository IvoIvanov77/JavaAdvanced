package intro_to_java.lab;

import java.util.Scanner;

public class Greeting {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String firstName = sc.nextLine();
        String secondName = sc.nextLine();

        if(firstName.isEmpty()){
            firstName = "*****";
        }

        if(secondName.isEmpty()){
            secondName = "*****";
        }

        System.out.printf("Hello, %s %s!", firstName, secondName);

    }
}

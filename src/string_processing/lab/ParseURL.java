package string_processing.lab;

import java.util.Scanner;

public class ParseURL {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        String[] reminder = line.split("://");
        if(reminder.length != 2){
            System.out.println("Invalid URL");
            return;
        }
        String protocol = reminder[0];

        int serverEndIndex = reminder[1].indexOf("/");
        String server = reminder[1].substring(0, serverEndIndex);
        String resource = reminder[1].substring
                (serverEndIndex + 1, reminder[1].length());

        System.out.printf("Protocol = %s\n" +
                "Server = %s\n" +
                "Resources = %s\n", protocol, server, resource);

    }
}

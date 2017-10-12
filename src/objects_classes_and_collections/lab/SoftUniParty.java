package objects_classes_and_collections.lab;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Set<String> inviteList = new TreeSet<>();

        String line = sc.nextLine();

        while (!line.equalsIgnoreCase("party")){
            inviteList.add(line);
            line = sc.nextLine();
        }

        while (!line.equalsIgnoreCase("end")){
            inviteList.remove(line);
            line= sc.nextLine();
        }

        System.out.println(inviteList.size());
        for(String item : inviteList){
            System.out.println(item);
        }

    }
}

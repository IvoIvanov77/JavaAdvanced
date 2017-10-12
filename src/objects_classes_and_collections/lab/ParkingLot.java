package objects_classes_and_collections.lab;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        Set<String> parking = new HashSet<>();

        while (true){
            String input = sc.nextLine();
            if (input.equals("END")){
                break;
            }else{
                String[] reminder = input.split(", ");
                if (reminder[0].equals("IN")){
                    parking.add(reminder[1]);
                }
                else{
                    parking.remove(reminder[1]);
                }
            }
        }

        if(parking.isEmpty()){
            System.out.println("Parking Lot is Empty");
            return;
        }

        for(String car : parking){
            System.out.println(car);
        }


    }
}

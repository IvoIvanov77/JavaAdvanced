package files_and_streams.lab;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {

    public static void main(String[] args) {

        String inputPath = "input.txt";
        String outputPath = "output.txt";



        try(Scanner sc = new Scanner(new FileInputStream(inputPath));
            PrintWriter out = new PrintWriter(new FileOutputStream(outputPath))) {

            while(sc.hasNext()){
                if(sc.hasNextInt()){
                    out.println(sc.nextInt());
                }
                sc.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

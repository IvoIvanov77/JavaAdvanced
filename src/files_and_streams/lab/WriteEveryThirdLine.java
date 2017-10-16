package files_and_streams.lab;

import java.io.*;
import java.util.Scanner;

public class WriteEveryThirdLine {

    public static void main(String[] args) {

        String inputPath = "input.txt";
        String outputPath = "output.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(inputPath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

            int counter = 1;
            String line = reader.readLine();
            while(line != null){
                if(counter % 3 == 0){
                    writer.write(line);
                    writer.newLine();
                }
                counter ++;
                line = reader.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

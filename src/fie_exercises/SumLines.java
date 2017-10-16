package fie_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class SumLines {

    public static void main(String[] args) {

        try(BufferedReader reader = Files.newBufferedReader(Paths.get("file1.txt"))) {

            String line = reader.readLine();

            while(line != null){
                long sum = 0;
                for(char ch : line.toCharArray()){
                    sum += ch;
                }

                System.out.println(sum);
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

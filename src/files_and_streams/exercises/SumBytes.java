package files_and_streams.exercises;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumBytes {
    public static void main(String[] args) {

        try(BufferedReader reader = Files.newBufferedReader(Paths.get("file1.txt"))) {

            String line = reader.readLine();
            long sum = 0;
            while(line != null){
                for(char ch : line.toCharArray()){
                    sum += ch;
                }
                line = reader.readLine();
            }

            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

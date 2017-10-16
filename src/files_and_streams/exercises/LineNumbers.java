package files_and_streams.exercises;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;


public class LineNumbers {

    public static void main(String[] args) {

        try(BufferedReader reader = Files.newBufferedReader(Paths.get("file1.txt"));
            PrintWriter out = new PrintWriter(new FileOutputStream("output.txt"))) {

            String line = reader.readLine();
            int number = 1;
            while(line != null){
//                out.write(line.toUpperCase());
                out.printf("%d. %s%n", number, line);
                number ++;
                line = reader.readLine();
            }



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

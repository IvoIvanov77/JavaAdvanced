package files_and_streams.lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WriteToAFile {

    public static void main(String[] args) {

        String inputPath = "input.txt";
        String outputPath = "output.txt";

        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, '.', ',', '!','?');

        try(InputStream inputStream = new FileInputStream(inputPath);
            OutputStream outputStream = new FileOutputStream(outputPath)) {

            int oneByte = inputStream.read();

            while (oneByte >= 0){
                if(!symbols.contains((char)oneByte)){
                    outputStream.write(oneByte);
                }
                oneByte = inputStream.read();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

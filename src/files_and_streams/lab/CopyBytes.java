package files_and_streams.lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyBytes {

    public static void main(String[] args) {

        String inputPath = "input.txt";
        String outputPath = "output.txt";

        try(InputStream inputStream = new FileInputStream(inputPath);
            OutputStream outputStream = new FileOutputStream(outputPath)) {

            int oneByte = inputStream.read();

            while (oneByte >= 0){
                if(oneByte == 10 || oneByte == 32){
                    outputStream.write(oneByte);
                }else{
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        outputStream.write(digits.charAt(i));
                    }
                }
                oneByte = inputStream.read();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

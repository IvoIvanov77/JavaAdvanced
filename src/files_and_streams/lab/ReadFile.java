package files_and_streams.lab;

import java.io.FileInputStream;

public class ReadFile {

    public static void main(String[] args) {

        String path = "input.txt";

        try(FileInputStream inputStream = new FileInputStream(path)) {

            int oneByte = inputStream.read();

            while (oneByte >= 0){
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = inputStream.read();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

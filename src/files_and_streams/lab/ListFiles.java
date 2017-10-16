package files_and_streams.lab;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\Ivaylo\\Documents\\Java_Fundamentals\\Java_Advanced\\Files and Streams\\Files-and-Streams");

        if (file.exists()){
            File[] files = null;
            if (file.isDirectory()){
                files = file.listFiles();
            }

            assert files != null;
            for (File f : files){
                if (!f.isDirectory()){
                    System.out.printf("%s: %d%n",f.getName(),  f.length());
                }

            }

        }

    }
}

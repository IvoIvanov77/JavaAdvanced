package files_and_streams.exercises;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class GetFolderSize {

    public static void main(String[] args) throws IOException {


        long size = Files.size(Paths.get("C:\\Users\\ivaylo\\Downloads\\02. Earthquake_Условие.docx"));


        System.out.println(size);
    }
}

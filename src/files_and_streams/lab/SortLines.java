package files_and_streams.lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {

    public static void main(String[] args) {

        Path inPath = Paths.get("input.txt");
        Path outPath = Paths.get("output.txt");

        try {
            List<String> lines = Files.readAllLines(inPath);
            System.out.println(lines);
            Collections.sort(lines);

            Files.write(outPath, lines);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package fie_exercises;


import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountCharacterTypes {

    public static void main(String[] args) {

        List<Character> vowels = new ArrayList<>();
        List<Character> marks  = new ArrayList<>();
        Collections.addAll(vowels, 'a', 'e', 'i', 'o', 'u');
        Collections.addAll(marks, '.', '?', '!', ',');
        long vowelsCount = 0;
        long consonantsCount = 0;
        long punctuationCount = 0;

        try(BufferedReader reader = Files.newBufferedReader(Paths.get("file1.txt"));
            PrintWriter out = new PrintWriter(new FileOutputStream("output.txt"))) {

            String line = reader.readLine();

            while(line != null){
                for(char ch : line.toLowerCase().toCharArray()){
                    if(vowels.contains(ch)){
                        vowelsCount ++;
                    }else if(marks.contains(ch)){
                        punctuationCount ++;
                    }else if(ch == ' '){
                        continue;
                    }else {
                        consonantsCount ++;
                    }
                }
                line = reader.readLine();
            }

            out.printf("Vowels: %d\n" +
                    "Consonants: %d\n" +
                    "Punctuation: %d", vowelsCount, consonantsCount, punctuationCount);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}



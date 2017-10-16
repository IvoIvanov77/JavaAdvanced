package files_and_streams.lab;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolders {

    public static void main(String[] args) {

        String path = "C:\\Users\\Ivaylo\\Documents\\Java_Fundamentals\\Java_Advanced\\Files and Streams\\Files-and-Streams";
        File root = new File(path);

        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);

        int count = 0;

        while(!dirs.isEmpty()){
            File current = dirs.poll();
            System.out.println(current.getName());
            count ++;

            for(File dir : current.listFiles()){
                if(dir.isDirectory()){
                    dirs.offer(dir);
                }
            }

        }

        System.out.printf("%d folders", count);
    }
}

package EXAM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class TheVLogger{

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Logger> loggers = new TreeMap<>();

        String line = reader.readLine();

        while (!line.equals("Statistics")){
            String[] input = line.split("\\s+");
            String firstLoggerName = input[0];
            if(input.length >= 4 && !loggers.containsKey(firstLoggerName)){

                loggers.put(firstLoggerName, new Logger(firstLoggerName));
            }else {
                String secondLoggerName = input[2];
                if(loggers.containsKey(firstLoggerName) && loggers.containsKey(secondLoggerName)){
                    loggers.get(firstLoggerName).addFollowing(loggers.get(secondLoggerName));
                    loggers.get(secondLoggerName).addFollower(loggers.get(firstLoggerName));
                }
            }
            line = reader.readLine();
        }


        System.out.printf("The V-Logger has a total of %d vloggers in its logs.%n", loggers.size());

        List<Logger> loggerList= loggers.values().stream()
                .sorted(Comparator.comparing(Logger::getFollowers)
                        .reversed()
                        .thenComparing(Logger::getFollowing))
                .collect(Collectors.toList());


        for (int i = 0; i < loggerList.size(); i++) {
            Logger logger = loggerList.get(i);
            System.out.printf("%d. %s : %d followers, %d following%n",
                    i + 1, logger.name, logger.getFollowers(), logger.getFollowing());
            if(i == 0){
                logger.followers.forEach(s -> System.out.printf("*  %s%n", s));
            }
        }

    }

}

class Logger{
    String name;
    Set<String> followers;
    private Set<String> following;

    Logger(String name) {
        this.name = name;
        followers = new TreeSet<>();
        following = new TreeSet<>();
    }

    void addFollower(Logger logger){
        if(!logger.name.equals(this.name)){
            this.followers.add(logger.name);
        }

    }

    void addFollowing(Logger logger){
        if(!logger.name.equals(this.name)) {
            this.following.add(logger.name);
        }
    }

    int getFollowers(){
        return followers.size();
    }

    int getFollowing(){
        return following.size();
    }

    @Override
    public String toString() {
        return "Logger{" +
                "name='" + name + '\'' +
                ", followers=" + followers +
                ", following=" + following +
                '}';
    }
}

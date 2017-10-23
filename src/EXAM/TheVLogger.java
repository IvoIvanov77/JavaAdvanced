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
        int index = 1;

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

//    The V-Logger has a total of 3 vloggers in its logs.
//            1. VenomTheDoctor : 2 followers, 0 following
//*  EmilConrad
//*  Saffrona
//2. EmilConrad : 1 followers, 1 following
//3. Saffrona : 0 followers, 2 following

}

class Logger{
    String name;
    Set<String> followers;
    Set<String> following;

    public Logger(String name) {
        this.name = name;
        followers = new TreeSet<>();
        following = new TreeSet<>();
    }

    public void addFollower(Logger logger){
        if(!logger.name.equals(this.name)){
            this.followers.add(logger.name);
        }

    }

    public void addFollowing(Logger logger){
        if(!logger.name.equals(this.name)) {
            this.following.add(logger.name);
        }
    }

    public int getFollowers(){
        return followers.size();
    }

    public int getFollowing(){
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

package objects_classes_and_collections.exercises;

import java.util.*;
import java.util.stream.Collectors;

public class Robotics {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Robot> robots = Arrays.stream(sc.nextLine().split(";"))
                .map(Robot::new)
                .collect(Collectors.toList());

        Deque<Robot> robotQueue = new ArrayDeque<>();
        robotQueue.addAll(robots);

        String startTime = sc.nextLine();

    }

    public static int timeToSeconds(String input){
        int[] time = Arrays.stream(input.split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();

        return time[0] * 3600 + time[1] * 60 + time[2];
    }

    public static String secondsToTime(int totalSeconds){
        int hours = totalSeconds / 3600;
        int remainder = totalSeconds % 3600;
        int minutes = remainder / 60;
        int seconds = remainder % 60;

        return String.format("[%02d:%02d:%02d]", hours, minutes, seconds);

    }



}

class Robot{
    String name;
    int processingTime;

    public Robot(String line) {
        String[] input = line.split("-");
        this.name = input[0];
        this.processingTime = Integer.parseInt(input[1]);
    }
}

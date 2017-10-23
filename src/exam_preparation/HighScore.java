package exam_preparation;

import java.util.*;

public class HighScore {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        Map<String, Player> players = new LinkedHashMap<>();

        while(!line.equals("osu!")){
            String[] token = line.split("\\s+|<->");

            String firstPlayerName = token[1];
            int firstPlayerScore = Integer.parseInt(token[0]);

            String secondPlayerName = token[2];
            int secondPlayerScore = Integer.parseInt(token[3]);

            if(!players.containsKey(firstPlayerName)){
                players.put(firstPlayerName, new Player(firstPlayerName));
            }
            if(!players.containsKey(secondPlayerName)){
                players.put(secondPlayerName, new Player(secondPlayerName));
            }
            Player.play(players.get(firstPlayerName), players.get(secondPlayerName),
                    firstPlayerScore, secondPlayerScore);
            line = sc.nextLine();
        }

        players.values().stream()
                .sorted((p1, p2) -> Long.compare(p2.totalScore, p1.totalScore))
                .forEach(p -> {
                    System.out.printf("%s - (%d)%n", p.name, p.totalScore);
                    p.gameList.forEach(g -> System.out.printf("*   %s <-> %d%n", g.playerName, g.score));
                });
    }




}

class Player{
    String name;
    long totalScore;
    List<Game> gameList;

    Player(String name) {
        this.name = name;
        this.totalScore = 0;
        this.gameList = new ArrayList<>();
    }



    static void play(Player p1, Player p2, int p1Score, int p2Score){
        p1.totalScore += p1Score - p2Score;
        p2.totalScore += p2Score - p1Score;
        p1.gameList.add(new Game(p2.name, p1Score - p2Score));
        p2.gameList.add(new Game(p1.name, p2Score - p1Score));
    }

}

class Game {
    String playerName;
    int score;

    Game(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
    }
}



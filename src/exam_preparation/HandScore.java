package exam_preparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HandScore {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] cards = reader.readLine().split("\\s+");

        int handScore = 0;
        int subScore = 0;
        int countOfSequence = 1;

        for (int i = 0; i < cards.length ; i++) {
            char face = cards[i].charAt(0);
            char suit = cards[i].charAt(cards[i].length() - 1);
            subScore += getValue(face);
            while(i < cards.length - 1 && suit == cards[i + 1].charAt(cards[i + 1].length() - 1)){
                subScore += getValue(cards[i + 1].charAt(0));
                countOfSequence ++;
                i ++;

            }
            handScore += subScore * countOfSequence;
            subScore = 0;
            countOfSequence = 1;
        }

        System.out.println(handScore);
    }

    private static int getValue(char ch){

        switch (ch){
            case 'J' : return 12;
            case 'Q' : return 13;
            case 'K' : return 14;
            case 'A' : return 15;
            case '1' : return 10;
            default: return Integer.parseInt("" + ch);

        }
    }
}

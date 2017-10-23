package exam_preparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BitRoller {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Long number = Long.parseLong(reader.readLine());
        String binaryNumber = String.format("%19s", Long.toBinaryString(number)).replace(" ", "0");

        int f = Integer.parseInt(reader.readLine());
        int r = Integer.parseInt(reader.readLine());

        int pillarIndex = binaryNumber.length() - 1 - f;
        char pillar = binaryNumber.charAt(pillarIndex);
        String leftNumber = binaryNumber.substring(0, pillarIndex);
        String rightNumber = binaryNumber.substring(pillarIndex + 1);

        StringBuilder result = new StringBuilder();
        result.append(leftNumber).append(rightNumber);
        for (int i = 0; i < r; i++) {
            char lastDigit = result.charAt(result.length() - 1);
            result.insert(0, lastDigit);
            result.delete(result.length() - 1, result.length());

        }

        result.insert(pillarIndex, pillar);
        System.out.println(Long.parseLong(result.toString(), 2));

    }


}

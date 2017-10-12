package objects_classes_and_collections.lab;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class AcademyGraduation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            BigDecimal[] scores = Arrays.stream(sc.nextLine().split("\\s+"))
                    .map(BigDecimal::new)
                    .toArray(BigDecimal[]::new);

            System.out.printf("%s is graduated with %s%n", name,
                   getAverage(scores));
        }
    }

    private static String getAverage(BigDecimal[] array){
        BigDecimal sum = new BigDecimal("0");
        for(BigDecimal number : array){
            sum = sum.add(number);
        }

        return sum.divide(new BigDecimal(array.length)).toString();
    }
}

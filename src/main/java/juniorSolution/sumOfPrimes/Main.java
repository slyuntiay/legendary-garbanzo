package juniorSolution.sumOfPrimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SumsOfPrimes sumsOfPrimes = new SumsOfPrimes();
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();
        while (input != 0) {
            long startTime = System.currentTimeMillis();
            sumsOfPrimes.addSums(input);
            long endTime = System.currentTimeMillis();
            long finalTime = endTime - startTime;
            System.out.println("Time " + finalTime);
//            sumsOfPrimes.printSums();
            input = scanner.nextInt();
        }

    }
}

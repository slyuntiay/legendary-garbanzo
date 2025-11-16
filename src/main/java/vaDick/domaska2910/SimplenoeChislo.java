package vaDick.domaska2910;

import java.util.Scanner;

public class SimplenoeChislo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        long startTime = System.currentTimeMillis();

        for (int i = 2; i <= number; i++) {
            if (isNumber(i)) {
                System.out.println(i + "");
            }
        }
        //if (n < sqlt(t))
        //if  (n < sqlt(2,3,5,7,11,13,,,,25))
        long endTime = System.currentTimeMillis();
        long finalTime = endTime - startTime;

        System.out.println("Время " + finalTime);
        scanner.close();
    }

    public static boolean isNumber(int number) {
        if (number < 2) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= number / 2; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}


package vadya.domaska2910;

import java.util.Scanner;

public class NaturalnoeChislo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        for (int i = 2; i <= number; i++) {
            if (isNumber(i)) {
                System.out.println(i + "");
            }
        }
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


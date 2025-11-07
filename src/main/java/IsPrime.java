import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IsPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        // HashSet<Integer> setIsPrime = new HashSet<>();
        ArrayList<Integer> primesList = new ArrayList<Integer>();
        primesList.add(2);
        primesList.add(3);
        for (int i = 5; i <= number; i += 2) {
            if (isPrime(i)) {
                primesList.add(i);
            }
        }
        boolean found = false;
        for (int i = 0; i < primesList.size(); i++) {
            for (int j = i; j < primesList.size(); j++) {
                int firstPrime = primesList.get(i);
                int secondPrime = primesList.get(j);
                if (firstPrime + secondPrime == number) {
                    System.out.println(firstPrime + " + " + secondPrime + " = " + number);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("не нашел");
        }
    }

    public static boolean isPrime(int number) {
        if (number <= 2) {
            return false;
        }
            if(number % 2 == 0) {
                return false;

            }
            for (int i = 3; i * i <= number; i += 2) {
                if (number % i == 0) {
                    return false;
                }
            }
        return true;
        }
    }

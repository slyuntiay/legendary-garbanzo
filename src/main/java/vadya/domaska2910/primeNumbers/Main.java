package vadya.domaska2910.primeNumbers;

import vadya.domaska2910.PrimeNumbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int limit = scanner.nextInt();
        PrimeNumbers primeNumbers = new PrimeNumbers();
        long startTime = System.currentTimeMillis();
        primeNumbers.addPrimes(limit);
        primeNumbers.printPrimes();
        long endTime = System.currentTimeMillis();
        long finalTime = endTime - startTime;
        System.out.println("Время " + finalTime + "мс");
        scanner.close();
        //1 миллиард 238347мс, 3.9 минуты
    }
}

package juniorSolution.sumsOfPrimes;

import java.util.ArrayList;

public class ListOfPrimes {
    private ArrayList<Integer> primes;
    private int current;

    public ListOfPrimes() {
        primes = new ArrayList<>();
    }

    public ArrayList<Integer> getPrimes() {
        return primes;
    }

    public void addPrimes(int limit) {
        if (limit < 2) return;
        if (primes.isEmpty()) {
            primes.add(2);
            current = 3;
        }
        while (current <= limit) {
            if (isPrime(current)) {
                primes.add(current);
            }
            current += 2;
        }
    }

    public boolean isPrime(int number) {
        if (number < 2) return false;
        double numberSqrt = Math.sqrt(number);
        for (int index = 0; primes.get(index) <= numberSqrt; ++index) {
            if (number % primes.get(index) == 0) {
                return false;
            }
        }
        return true;
    }

    public void printPrimes() {
        StringBuilder listOfPrimes = new StringBuilder();
        for (int prime : primes) {
            listOfPrimes.append(prime + " ");
        }
        System.out.println(listOfPrimes);
    }

    public void removePrimes() {
        primes.clear();
    }
}

package juniorSolution.sumOfPrimes;

import java.util.*;

public class SumsOfPrimes {
    private LinkedHashMap<Integer, List<Integer>> sums;
    private ListOfPrimes primes;
    private int currentSum;

    public SumsOfPrimes() {
        sums = new LinkedHashMap<>();
        primes = new ListOfPrimes();
    }

    public void addSums (int limit) {
        if (sums.isEmpty()) {
            currentSum = 4;
        }
        primes.addPrimes(limit);
        while (currentSum <= limit) {
            addSum(currentSum);
            currentSum++;
        }
    }

    public void addSum(int sum) {
        ArrayList<Integer> values = new ArrayList<>();
        int difference = sum;
        for (int firstNumberI = searchPrime(difference); firstNumberI >= 0 && difference != 0; --firstNumberI) {
            difference -= primes.getPrimes().get(firstNumberI);
            if (difference < 2) {
                difference = sum;
                continue;
            }
            if (primes.isPrime(difference)) {
                values.add(difference);
                values.add(primes.getPrimes().get(firstNumberI));
                sums.put(sum, values);
                return;
            }
            for (int secondNumberI = searchPrime(difference); secondNumberI >= 0 && difference != 0; --secondNumberI) {
                difference -= primes.getPrimes().get(secondNumberI);
                if (difference == 0) {
                    values.add(primes.getPrimes().get(secondNumberI));
                    values.add(primes.getPrimes().get(firstNumberI));
                    sums.put(sum, values);
                }
            }
        }
    }

    public int searchPrime(int number) {
        for (int index = 0; index < primes.getPrimes().size(); index++) {
            if (primes.getPrimes().get(index) > number) {
                return index - 1;
            }
        }
        return -1;
    }

    public void printSums() {
        System.out.println(sums);
    }
}

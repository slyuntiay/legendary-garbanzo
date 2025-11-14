package juniorSolution.sumsOfPrimes;

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
        if (sum % 2 != 0) {
            if (primes.isPrime(sum - 2)) {
                values.add(2);
                values.add(sum - 2);
                sums.put(sum, values);
                return;
            } else {
                addSumOfThree(sum);
            }
        }
        int difference = sum;
        for (int indexOfPrime = 0; primes.getPrimes().get(indexOfPrime) <= sum / 2; ++indexOfPrime) {
            difference -= primes.getPrimes().get(indexOfPrime);
            if (primes.isPrime(difference)) {
                values.add(primes.getPrimes().get(indexOfPrime));
                values.add(difference);
                sums.put(sum, values);
                return;
            }
            difference = sum;
        }
    }

    public void addSumOfThree(int sum) {
        ArrayList<Integer> values = new ArrayList<>();
        int difference = sum;
        for (int indexOfPrime = 0; primes.getPrimes().get(indexOfPrime) <= sum / 2; ++indexOfPrime) {
            difference -= primes.getPrimes().get(indexOfPrime);
            if (sums.containsKey(difference) && sums.get(difference).size() < 3) {
                values.add(primes.getPrimes().get(indexOfPrime));
                values.addAll(sums.get(difference));
                sums.put(sum, values);
                return;
            }
            difference = sum;
        }
    }

    public void printSums() {
        System.out.println(sums);
    }
}

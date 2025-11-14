package gigachad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumOfPrimes {
    private static int largestComputedNumber = 4;
    private static final List<Integer> foundPrimes = new ArrayList<>();
    private static final Map<Integer, List<Integer>> preComputedResults = new HashMap<>();
    private static final boolean canRepeatPrimes = false;

    static {
        foundPrimes.add(2);
        foundPrimes.add(3);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int n = 0; n < 10000; n++) {
            computePrimesThatAddUpToN(n);
        }/*
        for (int n = 100000; n > 0; n--) {
            computePrimesThatAddUpToN(n);
        }*/
        long endTime = System.currentTimeMillis();
        long finalTime = endTime - startTime;
        System.out.println("Time " + finalTime);
    }

    public static List<Integer> computePrimesThatAddUpToN(int n) {
        if (n <= 2) {
            return Collections.emptyList();
        }
        if (preComputedResults.containsKey(n)) {
            return preComputedResults.get(n);
        }

        List<Integer> primesTillN = getPrimesTillN(n);
        List<Integer> result = computeResult(primesTillN, n);
        preComputedResults.put(n, result);
        return result;
    }

    private static List<Integer> getPrimesTillN(int n) {
        if (n == largestComputedNumber) {
            return foundPrimes;
        }
        if (n < largestComputedNumber) {
            for (int i = foundPrimes.size() - 1; i >= 0; i--) {
                if (n > foundPrimes.get(i)) {
                    return foundPrimes.subList(0, i);
                }
            }
        }

        findRemainingPrimes(n);
        return foundPrimes;
    }

    private static void findRemainingPrimes(int n) {
        int largestComputedPrime = foundPrimes.get(foundPrimes.size() - 1);
        for (int i = largestComputedPrime + 2; i < n; i += 2) {
            if (isPrime(i)) {
                foundPrimes.add(i);
            }
        }
        largestComputedNumber = n;
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        int limit = (int) Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> computeResult(List<Integer> primesTillN, int n) {
        for (int biggestPrimeIndex = primesTillN.size() - 1; biggestPrimeIndex >= 0; biggestPrimeIndex--) {
            List<Integer> result = new ArrayList<>();
            int remainder = n;
            for (int i = biggestPrimeIndex; i >= 0; i--) {
                int prime = primesTillN.get(i);
                remainder -= prime;
                if (remainder == 0) {
                    result.add(prime);
                    Collections.reverse(result);
                    return result;
                }
                if (remainder < 0) {
                    remainder += prime;
                    continue;
                }
                if (Collections.binarySearch(primesTillN, remainder) >= 0) {
                    if (Collections.binarySearch(result, remainder) < 0 && (remainder != prime || canRepeatPrimes)) {
                        result.add(prime);
                        result.add(remainder);
                        Collections.reverse(result);
                        return result;
                    }
                }

                result.add(prime);
            }
        }
        return Collections.emptyList();
    }
}

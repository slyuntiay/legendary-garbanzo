package vadya.domaska2910;

import lombok.Setter;

import java.util.ArrayList;

public class PrimeNumbers {
    private ArrayList<Integer> primesArrayList;
    int current;

    public void addPrimes(int limit) {
        if (primesArrayList == null || primesArrayList.get(0) == 0) {
            primesArrayList = new ArrayList<>();
            primesArrayList.add(2);
        }
        for (current = 3; current <= limit; current += 2) {
            if (isPrime(current)) {
                primesArrayList.add(current);
            }
        }
    }
//добавлять в лист простые числа

    public boolean isPrime(int current) {
        for (int i = 0; primesArrayList.get(i) <= Math.sqrt(current); i++) {
            if (current % primesArrayList.get(i) == 0) {
                return false;
            }
        }
        return true;
    }

    public void printPrimes() {
        System.out.println(primesArrayList);
    }
}

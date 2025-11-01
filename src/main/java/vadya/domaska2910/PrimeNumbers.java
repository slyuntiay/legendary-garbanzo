package vadya.domaska2910;
//добавлять в лист простые числа
//На вход число, на выходе список простых чисел до этого числа, которые в сумме дают это число
//
//Список должен быть максимально короткий
//
//Пример: на входе 9, на выходе 2,7
//
//Повторять числа нельзя, пример: на входе 4, на выходе могло бы быть 2,2
//
//Но будет пустой список
//Числа в выходном списке должны быть отсортированы в порядке возрастания

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {
    private ArrayList<Integer> primesArrayList;
    private List<Integer> sum;
    int current;

    public void addPrimes(int limit) {
        if (primesArrayList == null || primesArrayList.isEmpty()) {
            primesArrayList = new ArrayList<>();
            primesArrayList.add(2);
        }
        for (current = 3; current <= limit; current += 2) {
            if (isPrime(current)) {
                primesArrayList.add(current);
            }
        }
    }

    public boolean isPrime(int current) {
        for (int i = 0; primesArrayList.get(i) <= Math.sqrt(current); i++) {
            if (current % primesArrayList.get(i) == 0) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findPrimeSum(int target) {
        List<Integer> result = new ArrayList<>();
        addPrimes(target);

        for (int i = 0; i < primesArrayList.size(); i++) {
            int a = primesArrayList.get(i);
            int b = target - a;
            if (b >= a && isPrime(b) && a != b) {
                result.add(a);
                result.add(b);
                sum = result;
                return result;
            }
        }
        return result;
    }

    public void printPrimes() {
        System.out.println(primesArrayList);
    }
    public void printPrimesSum() {
        System.out.println(sum);
    }
}
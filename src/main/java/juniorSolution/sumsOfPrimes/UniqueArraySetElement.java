package juniorSolution.sumsOfPrimes;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UniqueArraySetElement {
    public static void main(String[] args) {
        Set<Integer> setUnique = new LinkedHashSet<>();
        int[] arrayElement = {3, 4, 5, 6, 7, 8, 9, 10, 10, 20, 30, 20, 11, 25, 6346, 647, 2, 1, 325, 2, 3, 5, 6, 77, 8};
        for (int i = 0; i < arrayElement.length; i++) {
            setUnique.add(arrayElement[i]);
        }

        if (!setUnique.isEmpty()) {
            Set<Integer> setStream = setUnique.stream()
                    .limit(1)
                    .collect(Collectors.toSet());
            System.out.println(setStream);
        }
    }
}

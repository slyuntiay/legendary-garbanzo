package juniorSolution.sumsOfPrimes;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UniqueArrayMapElement {
    public static void main(String[] args) {
       Map<Integer, Integer> mapElement = new HashMap<>();
        int[] arrayElement = {2, 3, 4, 5, 6,7};
        for (int i : arrayElement) {
            if (!mapElement.containsKey(i)) {
                mapElement.put(i, 1);
            } else {
                mapElement.put(i, mapElement.get(i) + 1);
            }
            if (!mapElement.isEmpty()) {
                Set<Integer> mapStream = mapElement.stream()
                        .limit(1)
                        .collect(Collectors.toMap());
                System.out.println(mapStream);
            }
        }

    }
}


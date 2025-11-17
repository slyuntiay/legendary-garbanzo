package vaDick.unique;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UniqueArrayMapElement {
    public static void main(String[] args) {
        Map<Integer, Integer> mapElement = new HashMap<>();
        Set<Integer> setUnique = new LinkedHashSet<>();
        int[] arrayElement = {1, 3, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 0, 0, 0, 0, 0, 1};
        for (int i : arrayElement) {
            if (!mapElement.containsKey(i)) {
                mapElement.put(i, 1);
            } else {
                mapElement.put(i, mapElement.get(i) + 1);
            }
        }
        for (Integer key : mapElement.keySet()) {
            if (mapElement.get(key) == 1) {
                setUnique.add(key);
            }
        }
        if (!setUnique.isEmpty()) {
            Set<Integer> setStream = setUnique.stream()
                    .limit(1)
                    .collect(Collectors.toSet());
            System.out.println(setStream);
        }
    }
}

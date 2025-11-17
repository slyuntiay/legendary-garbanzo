package vaDick.unique;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UniqueArrayMapElement {
    public static void main(String[] args) {
        Map<Integer, Integer> mapElement = new LinkedHashMap<>();
//        int[] arrayElement = {1, 3, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 0, 0, 0, 0, 0, 1};
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int quantity = scanner.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int index = 0; index < quantity; ++index) {
            list.add(random.nextInt(0, 21));
        }
        System.out.println(list);

        mapElement = list.stream()
                .filter(s -> !mapElement.containsKey(s));


//        for (int i : list) {
//            if (!mapElement.containsKey(i)) {
//                mapElement.put(i, 1);
//            } else {
//                mapElement.put(i, mapElement.get(i) + 1);
//            }
//        }

    }
}

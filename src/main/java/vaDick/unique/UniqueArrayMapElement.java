package vaDick.unique;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UniqueArrayMapElement {
    public static void main(String[] args) {
        Map<Integer, Boolean> map = new LinkedHashMap<>();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int quantity = scanner.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int index = 0; index < quantity; ++index) {
            list.add(random.nextInt(0, 21));
        }
        System.out.println(list);

        for (int i : list) {
            if (!map.containsKey(i)) {
                map.put(i, false);
            } else {
                map.put(i, true);
            }
        }

        for (int i : map.keySet()) {
            if (!map.get(i)) {
                System.out.print(i + " ");
            }
        }
    }
}

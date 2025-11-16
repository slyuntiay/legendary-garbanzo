package lAnat.uniqueNumber;

import java.util.*;

public class UniqueNumber {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int index = 0; index < size; ++index) {
            list.add(random.nextInt(0, 21));
        }
        System.out.println(list);

        for (int index = 0; index < list.size(); ++index) {
            boolean found = false;
            for (int index1 = 0; index1 < list.size(); ++index1) {
                if (index1 == index) continue;
                if ((int) list.get(index1) == list.get(index)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.print(list.get(index) + " ");
                break;
            }
        }
    }
}

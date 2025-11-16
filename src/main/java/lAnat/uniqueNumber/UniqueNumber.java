package lAnat.uniqueNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class UniqueNumber {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int index = 0; index < size; ++index) {
            list.add(random.nextInt());
        }

        System.out.println(list);

//        List<Integer> newList = new ArrayList<>(list);
//        for (int index = 0; index < list.size(); ++index) {
//            boolean found = false;
//            if (list.get(index) == null) {
//                continue;
//            }
//            for (int index1 = index + 1; index1 < list.size(); ++index1) {
//                if (list.get(index1) == list.get(index)) {
//                    newList.remove(index1);
//                    found = true;
//                }
//                if (found) {
//                    newList.remove(index);
//                }
//            }
//        }
//
//
//        System.out.println(list);
//        int index = 0;
//        while (newList.get(index) != null && index < list.size()) {
//            System.out.println(newList.get(index));
//        }
    }
}

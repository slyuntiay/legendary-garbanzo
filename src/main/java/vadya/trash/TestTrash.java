package vadya.trash;

import java.util.LinkedList;
import java.util.Scanner;

public class TestTrash {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberForConsole = scanner.nextInt();
        LinkedList<Integer> listNumber = new LinkedList<>();

        listNumber.add(numberForConsole);

        if (listNumber.isEmpty() || listNumber.get(0) == 0) {
            System.out.println("Empty List");
            return;
        }

        forListNumber(listNumber);
    }

    public static void forListNumber(LinkedList<Integer> listNumber) {
        for (int i = 0; i < listNumber.size(); i++) {
            if (10 < listNumber.get(i)) {
                System.out.println(listNumber.get(i));
            } else {
                System.out.println("число меньше 10: " + listNumber.get(i));
            }
        }
    }
}
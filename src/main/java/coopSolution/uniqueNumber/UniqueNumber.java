package coopSolution.uniqueNumber;

import java.util.*;

public class UniqueNumber {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int quantity = scanner.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int index = 0; index < quantity; ++index) {
            list.add(random.nextInt(0, 21));
        }
        System.out.println(list);


    }
}

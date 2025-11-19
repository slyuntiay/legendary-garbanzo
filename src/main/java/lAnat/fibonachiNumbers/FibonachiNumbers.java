package lAnat.fibonachiNumbers;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class FibonachiNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> fibonachiList = new ArrayList<>();
        int limit = scanner.nextInt();

        if (limit < 2) {
            System.out.println(fibonachiList);
            return;
        }

        fibonachiList.add(0);
        fibonachiList.add(1);
        int sum = fibonachiList.get(fibonachiList.size() - 1) + fibonachiList.get(fibonachiList.size() - 2);
        while (sum <= limit) {
            fibonachiList.add(sum);
            sum = fibonachiList.get(fibonachiList.size() - 1) + fibonachiList.get(fibonachiList.size() - 2);
        }
        System.out.println(fibonachiList);
    }
}
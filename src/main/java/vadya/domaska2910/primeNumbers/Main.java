package vadya.domaska2910.primeNumbers;

import vadya.domaska2910.PrimeNumbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrimeNumbers primeNumbers = new PrimeNumbers();

        while (true) {
            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1 - Сгенерировать простые числа");
            System.out.println("2 - Сгенерировать пару простых чисел");
            System.out.println("3 - Показать пару простых");
            System.out.println("4 - Показать простые числа");
            System.out.println("5 - Выход");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Введите предел: ");
                    int limit = scanner.nextInt();
                    primeNumbers.addPrimes(limit);
                    System.out.println("Простые числа сгенерированы!");
                    break;

                case 2:
                    System.out.print("Введите число для поиска пары: ");
                    int target = scanner.nextInt();
                    primeNumbers.findPrimeSum(target);
                    System.out.println("Поиск завершен!");
                    break;

                case 3:
                    primeNumbers.printPrimesSum();
                    break;

                case 4:
                    primeNumbers.printPrimes();
                    break;

                case 5:
                    System.out.println("Выход...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Введи правльное число");

            }
        }
    }
}
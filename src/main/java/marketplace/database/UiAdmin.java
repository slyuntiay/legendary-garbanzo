package marketplace.database;

import java.util.Scanner;

public class UiAdmin {

    public static void printOptions() {
        System.out.println("Интерфейс магазина");
        System.out.println("1-Создать таблицу продуктов");
        System.out.println("2-Удалить таблицу продуктов");
        System.out.println("3-Добавить продукт");
        System.out.println("4-удалить продукт");
        System.out.println("5-Посмотреть продукт");
        System.out.println("6-Посмотреть все продукты");
        System.out.println("7-Обновить продукты");
    }

    public static SqlScript makeChoice() {
        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();
        return SqlScript.getSql(choice);
    }
}

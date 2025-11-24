package marketplace.controller;

import marketplace.repository.SqlScript;

import java.util.Scanner;

public class UiAdminClients {
    public static void printOptions() {
        System.out.println("Интерфейс клиентов");
        System.out.println("1-Создать таблицу клиентов");
        System.out.println("2-Удалить таблицу клиентов");
        System.out.println("3-Добавить клиента");
        System.out.println("4-удалить клиента");
        System.out.println("5-Посмотреть клиента");
        System.out.println("6-Посмотреть все клиентов");
        System.out.println("7-Обновить клиентов");
    }

    public static SqlScript makeChoice() {
        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();
        return SqlScript.getSql(choice);
    }
}

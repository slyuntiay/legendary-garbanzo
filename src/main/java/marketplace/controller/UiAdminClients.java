package marketplace.controller;

import marketplace.repository.client.ClientSQLScript;

public class UiAdminClients {
    public static void printOptions() {
        System.out.println("Выберите действие");
        System.out.println("1 - Создать таблицу клиентов");
        System.out.println("2 - Удалить таблицу клиентов");
        System.out.println("3 - Добавить клиента");
        System.out.println("4 - Удалить клиента");
        System.out.println("5 - Посмотреть клиента");
//        System.out.println("6 - Посмотреть все клиентов");
//        System.out.println("7 - Обновить клиентов");
        System.out.println("8 - Вернуться к выбору БД");
    }

    public static ClientSQLScript getOption(int choice) {
        return ClientSQLScript.getSql(choice);
    }
}

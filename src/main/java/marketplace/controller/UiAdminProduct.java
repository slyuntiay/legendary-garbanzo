package marketplace.controller;

import marketplace.repository.PostgresConnector;
import marketplace.repository.SqlScript;

import java.util.Scanner;

public class UiAdminProduct {
    public static void printOptions() {
        System.out.println("Интерфейс магазина");
        System.out.println("1-Создать таблицу продуктов");
        System.out.println("2-Удалить таблицу продуктов");
        System.out.println("3-Добавить продукт");
        System.out.println("4-удалить продукт");
        System.out.println("5-Посмотреть продукт");
        System.out.println("6-Посмотреть все продукты");
        System.out.println("7-Обновить продукты");
        System.out.println("8-Выход");
    }

    public static SqlScript makeChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return SqlScript.getSql(choice);
    }

    public static void runOption(PostgresConnector postgresConnector) {
        Scanner scanner = new Scanner(System.in);
        boolean again = true;
        while (again) {
            SqlScript sql = UiAdminProduct.makeChoice();
            if (sql.getParametersCount() == 0) {
                postgresConnector.execute(sql.getSql());
            } else if (sql.equals(SqlScript.CREATE_PRODUCT)) {
                String name = scanner.nextLine();
                int price = scanner.nextInt();
                int quantity = scanner.nextInt();
                postgresConnector.createProduct(sql.getSql(), name, price, quantity);
            } else {
                String[] param = new String[sql.getParametersCount()];
                for (int i = 0; i < sql.getParametersCount(); i++) {
                    param[i] = scanner.nextLine();
                }
                postgresConnector.executeWithParam(sql.getSql(), param);
            }
        }
    }
}

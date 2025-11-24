import marketplace.controller.UiAdminClients;
import marketplace.repository.PostgresConnector;
import marketplace.repository.SqlScript;
import marketplace.controller.UiAdminProduct;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PostgresConnector postgresConnector = new PostgresConnector(args[0], args[1], args[2]);

        System.out.println("Хули тебе надо? \n 1 - клиенты \n 2 - продукты");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                UiAdminClients.printOptions();

            case 2:
                UiAdminProduct.printOptions();
                while (true) {
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
            default:
                System.out.println("Ну и пошёл тогда на хуй!");
        }
    }


}

import marketplace.database.PostgresConnector;
import marketplace.database.SqlScript;
import marketplace.database.UiAdmin;

import java.util.Scanner;

import static marketplace.database.UiAdmin.makeChoice;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PostgresConnector postgresConnector = new PostgresConnector(args[0], args[1], args[2]);
        UiAdmin.printOptions();
        while (true) {
            SqlScript sql = UiAdmin.makeChoice();
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

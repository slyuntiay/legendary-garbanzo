import marketplace.controller.UiAdminClients;
import marketplace.entity.Client;
import marketplace.repository.PostgresConnector;
import marketplace.controller.UiAdminProduct;
import marketplace.repository.client.ClientRepo;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


//        PostgresConnector postgresConnector = new PostgresConnector(args[0], args[1], args[2]);
//        System.out.println("Хули тебе надо? \n 1 - клиенты \n 2 - продукты");
//        int choice = scanner.nextInt();
//        switch (choice) {
//            case 1:
//                UiAdminClients.printOptions();
//                break;
//            case 2:
//                UiAdminProduct.printOptions();
//              UiAdminProduct.runOption(postgresConnector);
//              break;
//            default:
//                System.out.println("Ну и пошёл тогда на хуй!");
//        }

        ClientRepo clientRepo = new ClientRepo(args[0], args[1], args[2]);
        clientRepo.createTable();
        String buffer = scanner.nextLine();
        while (!"#".equals(buffer)) {
            String[] parts = buffer.split(" ");
            Client client = new Client(parts[0], parts[1]);
            clientRepo.create(client);
            buffer = scanner.nextLine();
        }

        buffer = scanner.nextLine();
        while (!"#".equals(buffer)) {
            clientRepo.delete(Integer.parseInt(buffer));
            buffer = scanner.nextLine();
        }


    }


}

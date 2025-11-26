import marketplace.controller.UiAdminClients;
import marketplace.controller.UiAdminProduct;
import marketplace.repository.client.ClientRepo;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClientRepo clientRepo = new ClientRepo(args[0], args[1], args[2]);


        boolean outsideAgain = true;
        while (outsideAgain) {
            System.out.println("Выберите вариант:");
            System.out.println("1 - Работа с клиентской БД");
            System.out.println("2 - Работа с продуктовой БД");
            System.out.println("3 - Выход");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    boolean again = true;
                    do {
                        UiAdminClients.printOptions();
                        option = scanner.nextInt();
                        try {
                            UiAdminClients.getOption(option);
                        } catch (Exception e) {
                            again = false;
                        }
                    }
                    while (again);
                    break;
                case 2:
                    UiAdminProduct.printOptions();
                    option = scanner.nextInt();
                    break;
                default:
                    System.out.println("Ну и пошёл тогда ты на хуй!");
                    outsideAgain = false;
            }
        }


    }


}

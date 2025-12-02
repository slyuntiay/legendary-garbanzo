package marketplace.service;

import marketplace.repository.client.ClientRepo;
import marketplace.repository.product.ProductRepo;

import java.util.Scanner;

public class ServiceUi {
    private final Scanner scanner;
    private final ProductRepo productRepo;
    private final ClientRepo clientRepo;
    private final HandleProducts handleProducts;
    private final HandleClients handleClients;

    public ServiceUi(String url, String username, String password) {
        this.scanner = new Scanner(System.in);
        this.productRepo = new ProductRepo(url, username, password);
        this.clientRepo = new ClientRepo(url, username, password);
        this.handleProducts = new HandleProducts(productRepo, scanner);
        this.handleClients = new HandleClients(clientRepo, scanner);
    }

    public void start() {
        while (true) {
            System.out.println("\n=== Главное меню ===");
            System.out.println("1. Управление продуктами");
            System.out.println("2. Управление клиентами");
            System.out.println("3. Выход");
            System.out.print("Выберите опцию: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    handleProducts.showMenu();
                    break;
                case 2:
                    handleClients.showMenu();
                    break;
                case 3:
                    System.out.println("");
                    return;
                default:
                    System.out.println("Неверный ввод, попробуйте снова");
            }
        }
    }
}

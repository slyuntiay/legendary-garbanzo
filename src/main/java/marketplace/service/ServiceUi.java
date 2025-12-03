package marketplace.service;

import marketplace.repository.client.ClientRepo;
import marketplace.repository.product.ProductRepo;

import java.util.Scanner;

public class ServiceUi {
    private final Scanner scanner;
    private final ProductRepo productRepo;
    private final ClientRepo clientRepo;
    private final ProductService productService;
    private final ClientService clientService;

    public ServiceUi(String url, String username, String password) {
        this.scanner = new Scanner(System.in);
        this.productRepo = new ProductRepo(url, username, password);
        this.clientRepo = new ClientRepo(url, username, password);
        this.productService = new ProductService(productRepo, scanner);
        this.clientService = new ClientService(clientRepo, scanner);
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
                    productService.showMenu();
                    break;
                case 2:
                    clientService.showMenu();
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

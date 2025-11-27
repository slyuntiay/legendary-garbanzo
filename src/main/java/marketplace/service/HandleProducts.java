package marketplace.service;

import java.util.Scanner;

import marketplace.entity.Product;
import marketplace.repository.product.ProductRepo;

public class HandleProducts {
    private final ProductRepo productRepo;
    private final Scanner scanner;

    public HandleProducts(ProductRepo productRepo, Scanner scanner) {
        this.productRepo = productRepo;
        this.scanner = scanner;
    }

    public void showMenu(String[] args) {
        while (true) {
            System.out.print("Меню продуктов:");
            System.out.print("1-Создать таблицу продукты:");
            System.out.print("2-Удалить таблицу продуктов:");
            System.out.print("3-Добавить продукт:");
            System.out.print("4-Удалить продукт:");
            System.out.print("5-Прочитать продукт:");
            System.out.print("6-Прочитать все продукты:");
            System.out.print("7-Обновить продукты:");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    this.createTable();
                    break;
                case 2:
                    this.dropTable();
                    break;
                case 3:
                    this.createProduct();
                    break;
                case 4:
                    this.deleteProduct();
                    break;
                case 5:
                    this.readProduct();
                    break;
                case 6:
                    this.readAllProducts();
                    break;
//                case 7:
//                    this.updateProducts();
//                    break;
            }

        }
    }

    private void createTable() {
        productRepo.createTable();
    }

    private void dropTable() {
        productRepo.dropTable();
    }

    private void createProduct() {
        System.out.println("Введите название продукта");
        String name = scanner.nextLine();
        System.out.println("Введите цену продукта");
        double price = scanner.nextDouble();
        System.out.println("Введите колличество продукта");
        int quantity = scanner.nextInt();
        productRepo.create(new Product(name, price, quantity));
    }

    private void deleteProduct() {
        System.out.println("Введите id продукта");
        int id = scanner.nextInt();
        productRepo.delete(id);
    }

    private void readProduct() {
        System.out.println("Введите id продукта");
        int id = scanner.nextInt();
        productRepo.read(id);
    }

    private void readAllProducts() {
        productRepo.readAll();
    }

    private void updateProducts(Product product) {
        System.out.println("Введите id продукта");
        int id = scanner.nextInt();
        productRepo.update(product);
    }
}


package marketplace.service;

import java.util.Scanner;

import marketplace.entity.Product;
import marketplace.repository.product.ProductRepo;

public class ProductService {
    private final ProductRepo productRepo;
    private final Scanner scanner;

    public ProductService(ProductRepo productRepo, Scanner scanner) {
        this.productRepo = productRepo;
        this.scanner = scanner;
    }

    public void showMenu() {
        boolean again = true;
        while (again) {
            System.out.println("Меню продуктов:");
            System.out.println("1-Создать таблицу продукты:");
            System.out.println("2-Удалить таблицу продуктов:");
            System.out.println("3-Добавить продукт:");
            System.out.println("4-Удалить продукт:");
            System.out.println("5-Прочитать продукт:");
            System.out.println("6-Прочитать все продукты:");
            System.out.println("7-Обновить продукты:");
            System.out.println("8-Выход");

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
                case 7:
                    this.updateProducts();
                    break;
                    case 8:
                        again = false;
                        break;
                default:
                    again = false;
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
        System.out.println(productRepo.read(id));
        System.out.println();
    }

    private void readAllProducts() {
        for (Product product : productRepo.readAll()) {
            System.out.println(product);
        }
        System.out.println();
    }

    private void updateProducts() {
        System.out.println("Введите id продукта");
        int id = scanner.nextInt();
        Product product = productRepo.read(id);
        System.out.println(product + "\n");
        scanner.nextLine();

        System.out.println("Введите новое название продукта");
        product.setName(scanner.nextLine());

        System.out.println("Введите новую цену");
        product.setPrice(scanner.nextDouble());

        System.out.println("Введите кол-во");
        product.setQuantity(scanner.nextInt());

        productRepo.update(product);
        System.out.println();
    }
}


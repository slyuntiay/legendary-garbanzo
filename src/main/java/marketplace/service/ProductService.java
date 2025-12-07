package marketplace.service;

import java.util.Scanner;

import marketplace.entity.Product;
import marketplace.repository.CRUDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends UserService {
    public ProductService(CRUDRepository<Product> crudRepository, Scanner scanner) {
        super(crudRepository, scanner);
    }

    @Override
    public void create() {
        System.out.println("Введите название продукта");
        String name = scanner.nextLine();
        System.out.println("Введите цену продукта");
        double price = scanner.nextDouble();
        System.out.println("Введите колличество продукта");
        int quantity = scanner.nextInt();
        crudRepository.create(new Product(name, price, quantity));
    }

    @Override
    public void update() {
        System.out.println("Введите id продукта");
        int id = scanner.nextInt();
        Object object = crudRepository.read(id);
        Product product = (Product) object;
        System.out.println(product + "\n");
        scanner.nextLine();

        System.out.println("Введите новое название продукта");
        product.setName(scanner.nextLine());

        System.out.println("Введите новую цену");
        product.setPrice(scanner.nextDouble());

        System.out.println("Введите кол-во");
        product.setQuantity(scanner.nextInt());

        crudRepository.update(product);
        System.out.println();
    }
}


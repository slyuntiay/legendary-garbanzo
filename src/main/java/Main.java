import marketplace.entity.Client;
import marketplace.entity.Product;
import marketplace.repository.client.ClientRepo;
import marketplace.repository.product.ProductRepo;
import marketplace.service.HandleClients;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClientRepo clientRepo = new ClientRepo(args[0], args[1], args[2]);
        ProductRepo productRepo = new ProductRepo(args[0], args[1], args[2]);
        HandleClients hc = new HandleClients(clientRepo, scanner);

        hc.showMenu();


        System.out.println("Ну и пошёл тогда ты на хуй!");
    }
}



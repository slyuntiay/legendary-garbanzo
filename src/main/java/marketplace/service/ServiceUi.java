package marketplace.service;

import marketplace.repository.client.ClientRepo;
import marketplace.repository.product.ProductRepo;

//import java.util.Scanner;
//
//public class ServiceUi {
//    private final ProductRepo productRepo;
//    private final Scanner scanner;
//    private final ClientRepo clientRepo;
//    private final HandleProducts handleProducts;
//    private final HandleClients handleClients;
//
//    public ServiceUi(ProductRepo productRepo, Scanner scanner, ClientRepo clientRepo, HandleProducts handleProducts) {
//        this.productRepo = productRepo;
//        this.scanner = scanner;
//        this.clientRepo = clientRepo;
//        this.handleProducts = handleProducts;
////        this.handleClients = handleClients;
////    }
////
////    private void switchMenu() {
////        switch (choice) {
////            case 1 -> handleClients.showMenu();
////            case 2 -> handleProducts.showMenu();
////            case 3 -> {
////                System.out.println("Выход");
////                return;
////            }
//            default:
//                System.out.println("Ну и пошёл тогда ты на хуй!");
//
//        }
//    }
//
//    private void printMenu() {
//
//        System.out.println("\n Меню");
//        System.out.println("\n1 - Клиент меню");
//        System.out.println("\n2 - Продукт меню");
//        System.out.println("\n3 - Вывох");
//    }
//}

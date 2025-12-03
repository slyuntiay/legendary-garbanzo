package marketplace.service;

import marketplace.entity.Client;
import marketplace.repository.client.ClientRepo;

import java.util.Scanner;

public class ClientService {
    private final ClientRepo clientRepo;
    private final Scanner scanner;

    public ClientService(ClientRepo clientRepo, Scanner scanner) {
        this.clientRepo = clientRepo;
        this.scanner = scanner;
    }

    public void showMenu() {
        boolean again = true;
        while (again) {
            System.out.println("Меню Клиентов:");
            System.out.println("1 - Создать таблицу клиентов");
            System.out.println("2 - Удалить таблицу клиентов");
            System.out.println("3 - Добавить клиента");
            System.out.println("4 - Удалить клиента");
            System.out.println("5 - Получить сведения о клиенте");
            System.out.println("6 - Получить сведения обо всех клиентах");
            System.out.println("7 - Обновить сведения о клиенте");
            System.out.println("8 - Выход");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    this.createTable();
                    break;
                case 2:
                    this.deleteTable();
                    break;
                case 3:
                    this.createClient();
                    break;
                case 4:
                    this.deleteClient();
                    break;
                case 5:
                    this.readClient();
                    break;
                case 6:
                    this.readAllClients();
                    break;
                case 7:
                    this.updateClient();
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
        clientRepo.createTable();
    }

    private void deleteTable() {
        clientRepo.dropTable();
    }

    private void createClient() {
        System.out.println("Введите фамилию");
        String surname = scanner.next();
        System.out.println("Введите имя");
        String name = scanner.next();
        clientRepo.create(new Client(name, surname));
    }

    private void deleteClient() {
        System.out.println("Введите id клиента");
        int id = scanner.nextInt();
        clientRepo.delete(id);
    }

    private void readClient() {
        System.out.println("Введите id клиента");
        int id = scanner.nextInt();
        System.out.println(clientRepo.read(id));
        System.out.println();
    }

    private void readAllClients() {
        for (Client client : clientRepo.readAll()) {
            System.out.println(client);
        }
        System.out.println();
    }

    private void updateClient() {
        System.out.println("Введите id клиента");
        int id = scanner.nextInt();
        Client client = clientRepo.read(id);
        System.out.println(client + "\n");
        scanner.nextLine();

        System.out.println("Введите новую фамилию");
        client.setSurname(scanner.nextLine());

        System.out.println("Введите новое имя");
        client.setName(scanner.nextLine());

        clientRepo.update(client);
        System.out.println();
    }
}



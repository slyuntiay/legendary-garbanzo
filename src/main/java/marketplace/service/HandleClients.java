package marketplace.service;

import marketplace.entity.Client;
import marketplace.repository.client.ClientRepo;

import java.util.Scanner;

public class HandleClients {
    private final ClientRepo clientRepo;
    private final Scanner scanner;

    public HandleClients(ClientRepo clientRepo, Scanner scanner) {
        this.clientRepo = clientRepo;
        this.scanner = scanner;
    }

    public void showMenu() {
        while (true) {
            System.out.print("Меню Клиентов:");
            System.out.print("1-Создать таблицу клиентов:");
            System.out.print("2-Удалить таблицу клиентов:");
            System.out.print("3-Добавить клиентов:");
            System.out.print("4-Удалить клиента:");
            System.out.print("5-Прочитать клиентов:");
            System.out.print("6-Прочитать все клиентов:");
            System.out.print("7-Обновить клиентов:");
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
        clientRepo.read(id);
    }

    private void readAllClients() {
    }

    private void updateClient() {
    }
}



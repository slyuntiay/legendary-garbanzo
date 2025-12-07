package marketplace.service;

import marketplace.entity.Entity;
import marketplace.repository.CRUDRepository;

import java.util.Scanner;

public abstract class EntityService <T extends Entity> {
    protected final CRUDRepository<T> crudRepository;
    protected final Scanner scanner;

    public EntityService(CRUDRepository<T> crudRepository, Scanner scanner) {
        this.crudRepository = crudRepository;
        this.scanner = scanner;
    }

    public void showMenu() {
        boolean again = true;
        while (again) {
            System.out.println("Меню:");
            System.out.println("1 - Создать таблицу");
            System.out.println("2 - Удалить таблицу");
            System.out.println("3 - Добавить элемент");
            System.out.println("4 - Удалить элемент");
            System.out.println("5 - Получить данные элемента");
            System.out.println("6 - Получить данные всех элементов");
            System.out.println("7 - Обновить данные элемента");
            System.out.println("8 - Выход");

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
                    this.create();
                    break;
                case 4:
                    this.delete();
                    break;
                case 5:
                    this.read();
                    break;
                case 6:
                    this.readAll();
                    break;
                case 7:
                    this.update();
                    break;
                case 8:
                    again = false;
                    break;
                default:
                    again = false;
            }

        }
    }

    public abstract void create();

    public abstract void update();

    public void createTable() {
        crudRepository.createTable();
    }

    public void dropTable() {
        crudRepository.dropTable();
    }

    public void delete() {
        System.out.println("Введите id");
        int id = scanner.nextInt();
        crudRepository.delete(id);
    }

    public void read() {
        System.out.println("Введите id");
        int id = scanner.nextInt();
        System.out.println(crudRepository.read(id));
        System.out.println();
    }

    public void readAll() {
        for (Object object : crudRepository.readAll()) {
            System.out.println(object);
        }
        System.out.println();
    }
}

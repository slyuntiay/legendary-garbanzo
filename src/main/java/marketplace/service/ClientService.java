package marketplace.service;

import marketplace.entity.Client;
import marketplace.entity.Entity;
import marketplace.repository.CRUDRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ClientService extends UserService {
    public ClientService(CRUDRepository<Client> crudRepository, Scanner scanner) {
        super(crudRepository, scanner);
    }

    public void create() {
        System.out.println("Введите фамилию");
        String surname = scanner.next();
        System.out.println("Введите имя");
        String name = scanner.next();
        crudRepository.create(new Client(name, surname));
    }

    public void update() {
        System.out.println("Введите id клиента");
        int id = scanner.nextInt();
        Object object = crudRepository.read(id);
        Client client = (Client) object;
        System.out.println(client + "\n");
        scanner.nextLine();

        System.out.println("Введите новую фамилию");
        client.setSurname(scanner.nextLine());

        System.out.println("Введите новое имя");
        client.setName(scanner.nextLine());

        crudRepository.update(client);
        System.out.println();
    }
}



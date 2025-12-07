package marketplace.service;

import marketplace.entity.Client;
import marketplace.repository.CRUDRepository;
import marketplace.repository.client.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ClientService extends EntityService<Client> {

    @Autowired
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
        Client client = crudRepository.read(id);
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



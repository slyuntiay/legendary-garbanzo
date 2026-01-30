package marketplace.service.clientService;

import lombok.RequiredArgsConstructor;
import marketplace.TransactionHelper;
import marketplace.dto.clientDto.CreateClientRequestDto;
import marketplace.entity.Client;
import marketplace.repository.client.ClientRepo;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ClientService{
    private final ClientRepo clientRepo;

    private final TransactionHelper transactionHelper;

    public Client create(CreateClientRequestDto createClientRequestDto) {
        Client client = new Client(createClientRequestDto);
        return clientRepo.create(client);
    }

    public Client read(int id) {
        return clientRepo.read(id)
                .orElseThrow(() -> new NoSuchElementException("Клиент не найден"));
    }

    public Client update(int id, CreateClientRequestDto createClientRequestDto) {
        Client client = read(id);
        client.setSurname(createClientRequestDto.getSurname());
        client.setName(createClientRequestDto.getName());
        return clientRepo.update(client);
    }

    public void delete(int id) {
        transactionHelper.executeInTransaction(session -> {
            Client client = session.get(Client.class, id);
            session.remove(client);
        });
    }
}



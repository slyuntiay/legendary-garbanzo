package marketplace.service.clientService;

import lombok.RequiredArgsConstructor;
import marketplace.dto.clientDto.CreateClientRequestDto;
import marketplace.dto.clientDto.CreateClientResponseDto;
import marketplace.entity.Client;
import marketplace.repository.client.ClientRepo;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService{
    private final ClientRepo clientRepo;

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
        clientRepo.delete(id);
    }
}



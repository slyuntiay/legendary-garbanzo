package marketplace.service.clientService;

import lombok.RequiredArgsConstructor;
import marketplace.dto.clientDto.CreateClientRequestDto;
import marketplace.entity.Client;
import marketplace.repository.client.ClientRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService{
    private final ClientRepo clientRepo;

    public Client create(CreateClientRequestDto createClientRequestDto) {
        Client client = new Client(createClientRequestDto);
        return clientRepo.create(client);
    }
    public Client delete(int id) {
        return clientRepo.delete(id);
    }
}



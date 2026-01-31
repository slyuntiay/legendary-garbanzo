package marketplace.service.clientService;

import lombok.RequiredArgsConstructor;
import marketplace.dto.clientDto.ClientDto;
import marketplace.entity.Client;
import marketplace.repository.client.ClientRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClientService{
    private final ClientRepo clientRepo;

    @Transactional
    public Client save(ClientDto clientDto) {
        Client client = new Client();
        client.setName(clientDto.getName());
        client.setSurname(clientDto.getSurname());
        return clientRepo.save(client);
    }
}



package marketplace.service.clientService;

import lombok.RequiredArgsConstructor;
import marketplace.dto.clientDto.ClientRequestDto;
import marketplace.entity.Client;
import marketplace.repository.client.ClientRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService{
    private final ClientRepo clientRepo;

    @Transactional
    public Client save(ClientRequestDto clientRequestDto) {
        Client client = new Client(clientRequestDto);;
        return clientRepo.save(client);
    }

    @Transactional(readOnly = true)
    public Optional<Client> find(long id) {
        return clientRepo.find(id);
    }

    @Transactional
    public Optional<Client> merge(long id, ClientRequestDto clientRequestDto) {
        return clientRepo.find(id).map(client -> {
            client.setSurname(clientRequestDto.getSurname());
            client.setName(clientRequestDto.getName());
            return clientRepo.merge(client);
        });
    }

    @Transactional
    public Optional<Boolean> remove(long id) {
        return clientRepo.find(id).map(client -> {
            clientRepo.remove(client);
            return true;
        });
    }
}



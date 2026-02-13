package marketplace.service.clientService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marketplace.dto.clientDto.ClientRequestDto;
import marketplace.dto.mapper.ClientMapper;
import marketplace.entity.Client;
import marketplace.repository.client.ClientRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientService{
    private final ClientRepo clientRepo;
    private final ClientMapper clientMapper;

    @Transactional
    public Client save(ClientRequestDto dto) {
        log.info("SAVE client: surname={}, name={}",
                dto.getSurname(), dto.getName());

        try {
            Client client = clientMapper.toEntity(dto);
            Client saved = clientRepo.save(client);
            log.info("SAVE OK: clientId={}", saved.getId());
            return saved;
        } catch (Exception e) {
            log.error("SAVE FAILED: surname={}, name={}, error={}",
                    dto.getSurname(), dto.getName(), e.getMessage(), e);
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Optional<Client> find(long id) {
        log.debug("FIND client: id={}", id);

        Optional<Client> client = clientRepo.find(id);
        if (client.isPresent()) {
            log.debug("FIND OK: clientId={}", id);
        } else {
            log.warn("FIND NOT FOUND: id={}", id);
        }
        return client;
    }

    @Transactional
    public Optional<Client> merge(long id, ClientRequestDto clientRequestDto) {
        log.info("MERGE client: id={}, surname={}, name={}",
                id, clientRequestDto.getSurname(), clientRequestDto.getName());

        return clientRepo.find(id).map(client -> {
            log.debug("MERGE updating client: id={}", id);
            client.setSurname(clientRequestDto.getSurname());
            client.setName(clientRequestDto.getName());
            Client merged = clientRepo.merge(client);
            log.info("MERGE OK: clientId={}", merged.getId());
            return merged;
        });
    }

    @Transactional
    public Optional<Boolean> remove(long id) {
        log.info("REMOVE client: id={}", id);

        return clientRepo.find(id).map(client -> {
            log.debug("REMOVE deleting client: id={}", id);
            clientRepo.remove(client);
            log.info("REMOVE OK: clientId={}", id);
            return true;
        });
    }
}



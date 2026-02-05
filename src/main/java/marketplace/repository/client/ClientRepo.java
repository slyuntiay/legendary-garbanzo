package marketplace.repository.client;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marketplace.entity.Client;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ClientRepo {

    @PersistenceContext
    private EntityManager entityManager;

    public Client save(Client client) {
        entityManager.persist(client);
        return client;
    }

    public Optional<Client> find(long id) {
        return Optional.ofNullable(entityManager.find(Client.class, id));
    }

    public Client merge(Client client) {
        return entityManager.merge(client);
    }

    @Transactional
    public void remove(Client client) {
        entityManager.remove(client);
    }
}
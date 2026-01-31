package marketplace.repository.client;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marketplace.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ClientRepo {
    private final SessionFactory sessionFactory;

    @Transactional
    public Client save(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(client);
//        log.info("save client {}", client);
        return client;
    }

    @Transactional(readOnly = true)
    public Optional<Client> find(int id) {
        Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.find(Client.class, id));
    }

    @Transactional
    public Client merge(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(client);
//        log.info("merge client {}", client);
        return client;
    }

   @Transactional
    public void remove(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(id);
//        log.info("remove client {}", id);
   }
}
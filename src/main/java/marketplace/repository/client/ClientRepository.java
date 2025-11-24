package marketplace.repository.client;

import lombok.RequiredArgsConstructor;
import marketplace.entity.Client;
import marketplace.repository.CRUDRepository;

import java.util.List;

@RequiredArgsConstructor
public class ClientRepository implements CRUDRepository<Client> {

    private final String url;
    private final String user;
    private final String password;

    @Override
    public Client create(Client entity) {
        return null;
    }

    @Override
    public Client read(int id) {
        return null;
    }

    @Override
    public Client update(Client entity) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Client> readAll() {
        return null;
    }
}

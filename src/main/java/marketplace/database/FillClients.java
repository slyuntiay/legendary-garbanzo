package marketplace.database;

import marketplace.entity.Client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FillClients {
    private Client client;
    private static Map<Integer, Client> clients;

    public static void addClients() {
        if (clients.isEmpty()) {
            clients = new HashMap<>();
        }
        Connection.createConnection();

        Client client = new Client();
        if (!clients.containsKey(client.getId())) {
            clients.put(client.getId(), client);
        }
    }
}

package marketplace.service;

import marketplace.entity.Client;
import marketplace.repository.PostgresConnector;

import java.util.HashMap;
import java.util.Map;

public class FillClients {
    private Client client;
    private static Map<Integer, Client> clients;

    public static void addClients(PostgresConnector postgresConnector) {
        if (clients.isEmpty()) {
            clients = new HashMap<>();
        }
        postgresConnector.execute("sql");

        Client client = new Client();
        if (!clients.containsKey(client.getId())) {
            clients.put(client.getId(), client);
        }
    }
}

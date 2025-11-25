package marketplace.repository.client;

import lombok.RequiredArgsConstructor;
import marketplace.entity.Client;
import marketplace.repository.CRUDRepository;

import java.sql.*;
import java.util.List;

@RequiredArgsConstructor
public class ClientRepo implements CRUDRepository<Client> {
    private final String url;
    private final String user;
    private final String password;

    public boolean createTable() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(ClientSQLScript.CREATE_TABLE.getSql())){
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return true;
    }

    public boolean dropTable() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(ClientSQLScript.DROP_TABLE.getSql())){
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return true;
    }

    @Override
    public Client create(Client client) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(ClientSQLScript.CREATE.getSql())){
            statement.setInt(1, client.getId());
            statement.setString(2, client.getSurname());
            statement.setString(3, client.getName());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int id = resultSet.getInt("id");
            client.setId(id);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
      return client;

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
    try (Connection connection = DriverManager.getConnection(url, user, password);
         PreparedStatement statement = connection.prepareStatement(ClientSQLScript.DELETE.getSql())){
        statement.setInt(1, id);
        int rowDeleted = statement.executeUpdate();
        if (rowDeleted > 0) {
            System.out.println("Клиент успешно удалён");
        }
        statement.executeUpdate();
    } catch (SQLException sqlException) {
        sqlException.printStackTrace();
    }
    return true;
}

@Override
public List<Client> readAll(int id) {
    return List.of();
}
}

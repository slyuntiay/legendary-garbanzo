package marketplace.repository.client;

import lombok.RequiredArgsConstructor;
import marketplace.config.DataSource;
import marketplace.entity.Client;
import marketplace.repository.CRUDRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ClientRepo implements CRUDRepository<Client> {
    private final DataSource dataSource;

    @Override
    public Client create(Client client) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     ClientSQLScript.CREATE.getSql(), Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, client.getSurname());
            statement.setString(2, client.getName());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    client.setId(id);
                } else {
                    throw new SQLException("ОШИБКА! Не удалось добавить клиента в БД");
                }
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return client;
    }

    @Override
    public Optional<Client> read(int id) {
        Client client = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(ClientSQLScript.READ.getSql())) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String surname = resultSet.getString("surname");
                String name = resultSet.getString("name");
                client = new Client(id, surname, name);
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return Optional.ofNullable(client);
    }

    @Override
    public Client update(Client client) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(ClientSQLScript.UPDATE.getSql())) {

            statement.setString(1, client.getSurname());
            statement.setString(2, client.getName());
            statement.setInt(3, client.getId());
            statement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return client;
    }

    @Override
    public void delete(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(ClientSQLScript.DELETE.getSql())) {

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}



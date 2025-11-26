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
             PreparedStatement statement = connection.prepareStatement(ClientSQLScript.CREATE_TABLE.getSql())) {
            statement.executeUpdate();
            System.out.println("Таблица успешно создана");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("ОШИБКА. Не удалось создать таблицу");
        }
        return true;
    }

    public boolean dropTable() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(ClientSQLScript.DROP_TABLE.getSql())) {
            statement.executeUpdate();
            System.out.println("Таблица успешно удалена");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("ОШИБКА. Не удалось удалить таблицу");
        }
        return true;
    }

    @Override
    public Client create(Client client) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(ClientSQLScript.CREATE.getSql(), Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, client.getSurname());
            statement.setString(2, client.getName());
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("ОШИБКА. Не удалось добавить клиента");
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    client.setId(id);
                } else {
                    throw new SQLException("ОШИБКА. Не удалось добавить клиента");
                }
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return client;

    }



    @Override
    public void update(Client client) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(ClientSQLScript.UPDATE.getSql())) {
            statement.setString(1, client.getSurname());
            statement.setString(2, client.getName());
            statement.setInt(3, client.getId());
            int affectedRows = statement.executeUpdate();
            System.out.println("Клиент изменен" + affectedRows);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }
    }

    @Override
    public boolean delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(ClientSQLScript.DELETE.getSql())) {
            statement.setInt(1, id);
            int rowDeleted = statement.executeUpdate();
            if (rowDeleted > 0) {
                System.out.println("Клиент успешно удалён");
            }
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("ОШИБКА. Не удалось создать клиента");
        }
        return true;
    }

    @Override
    public Client read(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(ClientSQLScript.UPDATE.getSql())) {
             statement.setInt(1, id);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("ОШИБКА. Не удалось прочитать клиента");
        }
        return null;
    }

    @Override
    public List<Client> readAll(int id) {
        return List.of();
    }
}

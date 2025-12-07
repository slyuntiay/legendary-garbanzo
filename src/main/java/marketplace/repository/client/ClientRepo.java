package marketplace.repository.client;

import lombok.RequiredArgsConstructor;
import marketplace.entity.Client;
import marketplace.params.ConnectionParams;
import marketplace.repository.CRUDRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ClientRepo implements CRUDRepository<Client> {
   ConnectionParams connectionParams =

    public void createTable() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(ClientSQLScript.CREATE_TABLE.getSql())) {
            statement.executeUpdate();
            System.out.println("Таблица успешно создана");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("ОШИБКА. Не удалось создать таблицу");
        }
    }

    public void dropTable() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(ClientSQLScript.DROP_TABLE.getSql())) {
            statement.executeUpdate();
            System.out.println("Таблица успешно удалена");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("ОШИБКА. Не удалось удалить таблицу");
        }
    }

    @Override
    public Client create(Client client) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(
                     ClientSQLScript.CREATE.getSql(), Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, client.getSurname());
            statement.setString(2, client.getName());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    client.setId(id);
                    System.out.println("Клиент " + '"' + client + '"' + " успешно добавлен");
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
            statement.executeUpdate();
            System.out.println("Сведения о клиенте успешно изменены");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("ОШИБКА. Не удалось изменить данные клиента");
        }
    }

    @Override
    public void delete(int id) {
        Client client = null;
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(ClientSQLScript.DELETE.getSql())) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String surname = resultSet.getString("surname");
                String name = resultSet.getString("name");
                client = new Client(id, surname, name);
            }

            System.out.println("Клиент " + client + " успешно удалён");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("ОШИБКА. Не удалось удалить клиента");
        }
    }

    @Override
    public Client read(int id) {
        Client client = null;
        try (Connection connection = DriverManager.getConnection(url, user, password);
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
            System.out.println("ОШИБКА. Не удалось прочитать клиента");
        }
        return client;
    }

    @Override
    public List<Client> readAll() {
        List<Client> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(ClientSQLScript.READ_ALL.getSql())) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setSurname(resultSet.getString("surname"));
                client.setName(resultSet.getString("name"));
                list.add(client);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("ОШИБКА. Не удалось прочитать БД");
        }
        return list;
    }
}



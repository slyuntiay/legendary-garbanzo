package marketplace.repository.basket;

import lombok.RequiredArgsConstructor;
import marketplace.entity.Basket;
import marketplace.entity.Client;
import marketplace.params.ConnectionParams;
import marketplace.repository.CRUDRepository;
import marketplace.repository.client.ClientSQLScript;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BasketRepo implements CRUDRepository<Basket> {
    private final ConnectionParams connectionParams;

    @Override
    public void createTable() {
        try (Connection connection = DriverManager.getConnection(connectionParams.getUrl(), connectionParams.getUser(), connectionParams.getPassword());
             PreparedStatement statement = connection.prepareStatement(BasketSQLScript.CREATE_TABLE.getSql())) {
            statement.executeUpdate();
            System.out.println("Таблица успешно создана");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("ОШИБКА. Не удалось создать таблицу");
        }
    }

    @Override
    public void dropTable() {
        try (Connection connection = DriverManager.getConnection(connectionParams.getUrl(), connectionParams.getUser(), connectionParams.getPassword());
             PreparedStatement statement = connection.prepareStatement(BasketSQLScript.DROP_TABLE.getSql())) {
            statement.executeUpdate();
            System.out.println("Таблица успешно удалена");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("ОШИБКА. Не удалось удалить таблицу");
        }
    }

    @Override
    public Basket create(Basket basket) {
        try (Connection connection = DriverManager.getConnection(connectionParams.getUrl(), connectionParams.getUser(), connectionParams.getPassword());
             PreparedStatement statement = connection.prepareStatement(BasketSQLScript.CREATE.getSql())) {
            statement.setInt(1, basket.getClient_id());
            statement.setInt(2, basket.getProduct_id());
            statement.setInt(3, basket.getQuantity());
            statement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return basket;

    }

    @Override
    public Basket read(int id) {
        Basket basket = null;
        try (Connection connection = DriverManager.getConnection(connectionParams.getUrl(), connectionParams.getUser(), connectionParams.getPassword());
             PreparedStatement statement = connection.prepareStatement(BasketSQLScript.READ.getSql())) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String surname = resultSet.getString("surname");
                String name = resultSet.getString("name");
                basket = new Basket();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("ОШИБКА. Не удалось прочитать клиента");
        }
        return basket;
    }

    @Override
    public void update(Basket basket) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List readAll() {
        return List.of();
    }
}


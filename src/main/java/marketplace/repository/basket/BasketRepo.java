package marketplace.repository.basket;

import lombok.RequiredArgsConstructor;
import marketplace.config.DataSource;
import marketplace.entity.Basket;
import marketplace.entity.Client;
import marketplace.repository.CRUDRepository;
import marketplace.repository.client.ClientSQLScript;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BasketRepo implements CRUDRepository<Basket> {
    private final DataSource dataSource;

//    @Override
//    public void createTable() {
//        try (Connection connection = DriverManager.getConnection(dataSource.getConnection());
//             PreparedStatement statement = connection.prepareStatement(BasketSQLScript.CREATE_TABLE.getSql())) {
//            statement.executeUpdate();
//            System.out.println("Таблица успешно создана");
//        } catch (SQLException sqlException) {
//            sqlException.printStackTrace();
//            System.out.println("ОШИБКА. Не удалось создать таблицу");
//        }
//    }

//    @Override
//    public void dropTable() {
//        try (Connection connection = DriverManager.getConnection(connectionParams.getUrl(), connectionParams.getUser(), connectionParams.getPassword());
//             PreparedStatement statement = connection.prepareStatement(BasketSQLScript.DROP_TABLE.getSql())) {
//            statement.executeUpdate();
//            System.out.println("Таблица успешно удалена");
//        } catch (SQLException sqlException) {
//            sqlException.printStackTrace();
//            System.out.println("ОШИБКА. Не удалось удалить таблицу");
//        }
//    }

    @Override
    public Basket create(Basket basket) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(BasketSQLScript.CREATE.getSql())) {
            statement.setInt(1, basket.getClientId());
            statement.setInt(2, basket.getProductId());
            statement.setInt(3, basket.getQuantity());
            statement.executeUpdate();
            System.out.println("Товар успешно добавлен в корзину");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Товар не удалось добавить в корзину");
        }
        return basket;

    }


//    public Basket read(int id) {
//        Basket basket = null;
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement statement = connection.prepareStatement(BasketSQLScript.READ.getSql())) {
//
//            statement.setInt(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                String surname = resultSet.getString("surname");
//                String name = resultSet.getString("name");
//                basket = new Basket();
//            }
//        } catch (SQLException sqlException) {
//            sqlException.printStackTrace();
//            System.out.println("ОШИБКА. Не удалось прочитать клиента");
//        }
//        return basket;
//    }
    @Override
    public Optional<Basket> read(int clientId) {
        Basket basket = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(BasketSQLScript.READ.getSql())) {

            statement.setInt(1, clientId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                int quantity = resultSet.getInt("quantity");
                basket = new Basket(clientId, productId, quantity);
            }
            System.out.println("Корзина" + basket);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("ОШИБКА! Корзина не найден");
        }
        return Optional.ofNullable(basket);
    }

    @Override
    public Basket update(Basket basket) {

        return basket;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List readAll() {
        return List.of();
    }
}


package marketplace.repository.basket;

import lombok.RequiredArgsConstructor;
import marketplace.config.DataSource;
import marketplace.entity.Basket;
import marketplace.repository.CRUDRepository;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BasketRepo implements CRUDRepository<Basket> {
    private final DataSource dataSource;

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

    @Override
    public Optional<Basket> read(int clientId) {
        Basket basket = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(BasketSQLScript.READ.getSql())) {

            statement.setInt(1, clientId);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("Корзина:");
            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                int quantity = resultSet.getInt("quantity");
                basket = new Basket(clientId, productId, quantity);
                System.out.println(basket);
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("ОШИБКА! Корзина не найден");
        }
        return Optional.ofNullable(basket);
    }

    public Optional<Basket> readProduct(int clientId, int productId) {
        Basket basket = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(BasketSQLScript.READ_PRODUCT.getSql())) {

            statement.setInt(1, clientId);
            statement.setInt(2, productId);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("Корзина:");
            while (resultSet.next()) {
                int quantity = resultSet.getInt("quantity");
                basket = new Basket(clientId, productId, quantity);
                System.out.println(basket);
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("ОШИБКА! Корзина не найден");
        }
        return Optional.ofNullable(basket);
    }


    @Override
    public Basket update(Basket basket) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(BasketSQLScript.UPDATE.getSql())) {

            statement.setInt(1, basket.getQuantity());
            statement.setInt(2, basket.getClientId());
            statement.setInt(3, basket.getProductId());
            statement.executeUpdate();
            System.out.println("Корзина обновлена");

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("ОШИБКА. Не удалось обновить корзину");
        }
        return basket;
    }

    @Override
    public void delete(int clientId) {
        Basket basket = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(BasketSQLScript.DELETE.getSql())) {

            statement.setInt(1, clientId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                int quantity = resultSet.getInt("quantity");
                basket = new Basket(clientId, productId, quantity);
                System.out.println(basket);
            }
            System.out.println("Корзина" + basket + "успешно удалена");

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("ОШИБКА. Не удалось удалить корзину");
        }
    }
    public void deleteProduct(int clientId, int productId) {
        Basket basket = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(BasketSQLScript.DELETE_PRODUCT.getSql())) {

            statement.setInt(1, clientId);
            statement.setInt(2, productId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int quantity = resultSet.getInt("quantity");
                basket = new Basket(clientId, productId, quantity);
                System.out.println(basket);
            }
            System.out.println("Корзина" + basket + "успешно удалена");

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("ОШИБКА. Не удалось удалить корзину");
        }
    }
}


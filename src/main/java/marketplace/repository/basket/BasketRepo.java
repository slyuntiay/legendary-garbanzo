//package marketplace.repository.basket;
//
//import lombok.RequiredArgsConstructor;
//import marketplace.entity.Basket;
//import marketplace.repository.CRUDRepository;
//import org.springframework.stereotype.Repository;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//@RequiredArgsConstructor
//public class BasketRepo implements CRUDRepository<Basket> {
//    private final DataSource dataSource;
//
//    @Override
//    public Basket create(Basket basket) {
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement statement = connection.prepareStatement(
//                     BasketSQLScript.CREATE.getSql(),  Statement.RETURN_GENERATED_KEYS)) {
//
//            statement.setInt(1, basket.getClientId());
//            statement.setInt(2, basket.getProductId());
//            statement.setInt(3, basket.getQuantity());
//            statement.executeUpdate();
//
//            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
//                if (generatedKeys.next()) {
//                    int id = generatedKeys.getInt(1);
//                    basket.setId(id);
//                } else {
//                    throw new SQLException("ОШИБКА! Не удалось добавить продукт в корзину");
//                }
//            }
//        } catch (SQLException sqlException) {
//            sqlException.printStackTrace();
//        }
//        return basket;
//    }
//
//    @Override
//    public Optional<Basket> read(int id) {
//        Basket basket = null;
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement statement = connection.prepareStatement(BasketSQLScript.READ.getSql())) {
//
//            statement.setInt(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                int clientId = resultSet.getInt("client_id");
//                int productId = resultSet.getInt("product_id");
//                int quantity = resultSet.getInt("quantity");
//                basket = new Basket(id, clientId, productId, quantity);
//            }
//
//        } catch (SQLException sqlException) {
//            sqlException.printStackTrace();
//        }
//        return Optional.ofNullable(basket);
//    }
//
//
//    @Override
//    public Basket update(Basket basket) {
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement statement = connection.prepareStatement(BasketSQLScript.UPDATE.getSql())) {
//
//            statement.setInt(1, basket.getQuantity());
//            statement.setInt(2, basket.getId());
//            statement.executeUpdate();
//
//        } catch (SQLException sqlException) {
//            sqlException.printStackTrace();
//        }
//        return basket;
//    }
//
//    @Override
//    public void delete(int id) {
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement statement = connection.prepareStatement(BasketSQLScript.DELETE.getSql())) {
//
//            statement.setInt(1, id);
//            statement.executeUpdate();
//
//        } catch (SQLException sqlException) {
//            sqlException.printStackTrace();
//        }
//    }
//
//    public List<Basket> readAll(int clientId) {
//        List<Basket> baskets = new ArrayList<>();
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement statement = connection.prepareStatement(BasketSQLScript.READ_ALL.getSql())) {
//
//            statement.setInt(1, clientId);
//            try(ResultSet resultSet = statement.executeQuery()) {
//                while (resultSet.next()) {
//                    baskets.add(new Basket(
//                            resultSet.getInt("id"),
//                            clientId,
//                            resultSet.getInt("product_id"),
//                            resultSet.getInt("quantity")
//                    ));
//                }
//            }
//
//        } catch (SQLException sqlException) {
//            sqlException.printStackTrace();
//        }
//        return baskets;
//    }
//
//    public void deleteAll(int clientId) {
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement statement = connection.prepareStatement(BasketSQLScript.DELETE_ALL.getSql())) {
//
//            statement.setInt(1, clientId);
//            statement.executeUpdate();
//
//        } catch (SQLException sqlException) {
//            sqlException.printStackTrace();
//        }
//    }
//}
//

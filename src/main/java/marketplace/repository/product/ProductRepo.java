package marketplace.repository.product;

import lombok.RequiredArgsConstructor;
import marketplace.config.DataSource;
import marketplace.entity.Product;
import marketplace.repository.CRUDRepository;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepo implements CRUDRepository<Product> {
    private final DataSource dataSource;

    @Override
    public Product create(Product product) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(ProductSQLScript.CREATE.getSql(), Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    product.setId(id);
                } else {
                    throw new SQLException("ОШИБКА. Не удалось добавить продукт в БД");
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return product;
    }

    @Override
    public Optional<Product> read(int id) {
        Product product = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(ProductSQLScript.READ.getSql())) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                product = new Product(id, name, price, quantity);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return Optional.ofNullable(product);
    }

    @Override
    public Product update(Product product) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(ProductSQLScript.UPDATE.getSql())) {

            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setInt(4, product.getId());
            statement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return product;
    }

    @Override
    public void delete(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(ProductSQLScript.DELETE.getSql())) {

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}



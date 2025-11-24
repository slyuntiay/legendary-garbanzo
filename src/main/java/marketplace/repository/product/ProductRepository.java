package marketplace.repository.product;

import lombok.RequiredArgsConstructor;
import marketplace.entity.Product;
import marketplace.repository.CRUDRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
public class ProductRepository implements CRUDRepository<Product> {

    private final String url;
    private final String user;
    private final String password;

    @Override
    public Product create(Product product) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(ProductSqlScript.CREATE.getSql())) {
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int id = resultSet.getInt("id");
            product.setId(id);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return product;
    }

    @Override
    public Product read(int id) {
        return null;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        int rowCount = 0;
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(ProductSqlScript.DELETE.getSql())) {
            statement.setInt(1, id);
            rowCount = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowCount == 1;
    }

    @Override
    public List<Product> readAll() {
        return null;
    }
}

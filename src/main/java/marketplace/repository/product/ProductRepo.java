package marketplace.repository.product;

import lombok.RequiredArgsConstructor;
import marketplace.config.DataSource;
import marketplace.entity.Product;
import marketplace.repository.CRUDRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepo implements CRUDRepository<Product> {
    private final DataSource dataSource;

    @Override
    public void createTable() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(ProductSQLScript.CREATE_TABLE.getSql())) {
            statement.executeUpdate();
            System.out.println("Таблица успешно создана");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("ОШИБКА. Не удалось создать таблицу");
        }
    }

    @Override
    public void dropTable() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(ProductSQLScript.DROP_TABLE.getSql())) {
            statement.executeUpdate();
            System.out.println("Таблица успешно удалена");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("ОШИБКА. Не удалось удалить таблицу");
        }
    }

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
                    System.out.println("Продукт " + '"' + product + '"' + " успешно добавлен");
                } else {
                    throw new SQLException("ОШИБКА. Не удалось добавить продукт");
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return product;
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

            System.out.println("Продукт успешно изменен");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("ОШИБКА. Не удалось изменить данные продукта");
        }
        return product;
    }

    @Override
    public Product delete(int id) {
        Product product = read(id);
        if (product != null) {
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement(ProductSQLScript.DELETE.getSql())) {

                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    double price = resultSet.getDouble("price");
                    int quantity = resultSet.getInt("quantity");

                    product = new Product(id, name, price, quantity);
                }
                System.out.println("Продукт " + product + " успешно удалён");
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                System.out.println("ОШИБКА. Не удалось удалить продукт");
            }

        }
        return product;
    }

    @Override
    public Product read(int id) {
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
            System.out.println("Продукт " + product + " успешно прочитан");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("ОШИБКА. Не удалось прочитать продукт");
        }
        return product;
    }

    @Override
    public List<Product> readAll() {
        List<Product> list = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(ProductSQLScript.READ_ALL.getSql())) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setQuantity(resultSet.getInt("quantity"));
                list.add(product);
            }
            System.out.println(list);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("ОШИБКА. Не удалось прочитать БД");
        }
        return list;
    }
}



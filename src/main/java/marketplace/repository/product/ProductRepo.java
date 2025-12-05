package marketplace.repository.product;

import lombok.RequiredArgsConstructor;
import marketplace.entity.Client;
import marketplace.entity.Product;
import marketplace.repository.CRUDRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ProductRepo implements CRUDRepository<Product> {
    private final String url;
    private final String user;
    private final String password;

    @Override
    public void createTable() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
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
        try (Connection connection = DriverManager.getConnection(url, user, password);
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
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(ProductSQLScript.CREATE.getSql(), Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            int affectedRows = statement.executeUpdate();
            System.out.println("Продукт создан");
            if (affectedRows == 0) {
                throw new SQLException("ОШИБКА. Не удалось добавить клиента");
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    product.setId(id);
                } else {
                    throw new SQLException("ОШИБКА. Не удалось добавить клиента");
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return product;
    }


    @Override
    public void update(Product product) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(ProductSQLScript.UPDATE.getSql())) {

            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setInt(4, product.getId());

            int affectedRows = statement.executeUpdate();
            System.out.println("Продукт успешно изменен");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("ОШИБКА. Не удалось изменить данные продукта");
        }
    }

    @Override
    public void delete(int id) {
        Product product = null;
        try (Connection connection = DriverManager.getConnection(url, user, password);
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

    @Override
    public Product read(int id) {
        Product product = null;
        try (Connection connection = DriverManager.getConnection(url, user, password);
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
            System.out.println("ОШИБКА. Не удалось прочитать продукт");
        }
        return product;
    }

    @Override
    public List<Product> readAll() {
        List<Product> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password);
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
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("ОШИБКА. Не удалось прочитать БД");
        }
        return list;
    }
}



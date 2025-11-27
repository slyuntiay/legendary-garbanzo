package marketplace.repository.product;

import lombok.RequiredArgsConstructor;
import marketplace.entity.Product;
import marketplace.repository.CRUDRepository;
import java.sql.*;
import java.util.List;

@RequiredArgsConstructor
    public class ProductRepo implements CRUDRepository<Product> {
        private final String url;
        private final String user;
        private final String password;

        public boolean createTable() {
            try (Connection connection = DriverManager.getConnection(url, user, password);
                 PreparedStatement statement = connection.prepareStatement(ProductSQLScript.CREATE_TABLE.getSql())) {
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
                     PreparedStatement statement = connection.prepareStatement(ProductSQLScript.DROP_TABLE.getSql())) {
                    statement.executeUpdate();
                    System.out.println("Таблица успешно удалена");
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                    System.out.println("ОШИБКА. Не удалось удалить таблицу");
                }
                return true;
            }

        @Override
        public Product create(Product product) {
            //
            return product;
        }


        @Override
        public void update(Product product) {
        }

        @Override
        public boolean delete(int id) {
            return true;
        }

        @Override
        public Product read(int id) {
            return null;
        }

        @Override
        public List<Product> readAll() {
            return List.of();
        }
    }



package marketplace.repository.product;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ProductSQLScript {
    CREATE_TABLE("CREATE TABLE PRODUCT_TABLE (id SERIAL PRIMARY KEY, " +
            "name TEXT NOT NULL, " +
            "price REAL NOT NULL, " +
            "quantity INTEGER NOT NULL" + ");"),
    DROP_TABLE("DROP TABLE PRODUCT_TABLE;"),
    CREATE("INSERT INTO PRODUCT_TABLE (name, price," +
            " quantity) VALUES (?, ?, ?);"),
    DELETE("DELETE FROM PRODUCT_TABLE WHERE id = ?;"),
    READ("SELECT * FROM PRODUCT_TABLE WHERE id = ?;"),
    READ_ALL("SELECT * FROM PRODUCT_TABLE;"),
    UPDATE("UPDATE PRODUCT_TABLE SET name = ?, price = ?, quantity = ? WHERE id = ?;");
    private final String sql;

    ProductSQLScript(String sql) {
        this.sql = sql;
    }

    public static ProductSQLScript getSql(int number) {
        return Arrays.stream(ProductSQLScript.values())
                .filter(productSQLScript -> productSQLScript.ordinal() == number - 1)
                .findFirst()
                .orElseThrow();
    }
}
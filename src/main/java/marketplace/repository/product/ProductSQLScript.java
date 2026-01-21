package marketplace.repository.product;

import lombok.Getter;

@Getter
public enum ProductSQLScript {
    CREATE("INSERT INTO PRODUCT_TABLE (name, price," +
            " quantity) VALUES (?, ?, ?);"),
    READ("SELECT * FROM PRODUCT_TABLE WHERE id = ?;"),
    UPDATE("UPDATE PRODUCT_TABLE SET name = ?, price = ?, quantity = ? WHERE id = ?;"),
    DELETE("DELETE FROM PRODUCT_TABLE WHERE id = ? RETURNING id, name, price, quantity;");
    private final String sql;

    ProductSQLScript(String sql) {
        this.sql = sql;
    }
}
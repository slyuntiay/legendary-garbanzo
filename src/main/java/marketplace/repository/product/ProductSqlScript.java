package marketplace.repository.product;

import lombok.Getter;


@Getter
public enum ProductSqlScript {
    CREATE_TABLE("CREATE TABLE PRODUCT_TABLE (id SERIAL PRIMARY KEY, name TEXT NOT NULL," +
            " price MONEY, quantity INTEGER NOT NULL);"),
    DROP_TABLE("DROP TABLE PRODUCT_TABLE;"),
    CREATE("INSERT INTO PRODUCT_TABLE (name, price, quantity) VALUES (?, ?, ?);"),
    DELETE("DELETE FROM PRODUCT_TABLE WHERE id = ?;"),
    READ("SELECT * FROM PRODUCT_TABLE WHERE id = ?;"),
    READ_ALL("SELECT * FROM PRODUCT_TABLE;"),
    UPDATE("UPDATE PRODUCT_TABLE SET name = ?, quantity = ? WHERE id = ?;");

    private String sql;

    ProductSqlScript(String sql) {
        this.sql = sql;
    }

}

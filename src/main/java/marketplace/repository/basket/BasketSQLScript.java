package marketplace.repository.basket;

import lombok.Getter;

@Getter
public enum BasketSQLScript {
    CREATE_TABLE("CREATE TABLE BASKET_TABLE (" +
            "client_id INTEGER NOT NULL, " +
            "product_id INTEGER NOT NULL, " +
            "quantity INTEGER NOT NULL DEFAULT 1, " +
            "PRIMARY KEY (client_id, product_id), " +
            "FOREIGN KEY (client_id) REFERENCES CLIENT_TABLE(id) ON DELETE CASCADE, " +
            "FOREIGN KEY (product_id) REFERENCES PRODUCT_TABLE(id) ON DELETE CASCADE);"),
    DROP_TABLE("DROP TABLE BASKET_TABLE;"),
    CREATE("INSERT INTO BASKET_TABLE (client_id, product_id, quantity) VALUES (?, ?, ?);"),
    DELETE("DELETE FROM BASKET_TABLE WHERE client_id = ? AND product_id = ? RETURNING client_id, product_id, quantity;"),
    READ("SELECT * FROM BASKET_TABLE WHERE client_id = ?;"),
    READ_ALL("SELECT * FROM BASKET_TABLE;"),
    UPDATE("UPDATE BASKET_TABLE SET quantity = ?" + " WHERE client_id = ? AND product_id = ?;"),;

    private final String sql;

    BasketSQLScript(String sql) {
        this.sql = sql;
    }
}

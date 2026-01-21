package marketplace.repository.basket;

import lombok.Getter;

@Getter
public enum BasketSQLScript {
    CREATE("INSERT INTO BASKET_TABLE (id, client_id, product_id, quantity) VALUES (?, ?, ?, ?);"),
    READ_ALL("SELECT * FROM BASKET_TABLE WHERE client_id = ?;"),
    READ_PRODUCT("SELECT * FROM BASKET_TABLE WHERE client_id = ? AND product_id = ?;"),
    UPDATE("UPDATE BASKET_TABLE SET quantity = ?" + " WHERE client_id = ? AND product_id = ?;"),
    DELETE("DELETE FROM BASKET_TABLE WHERE client_id = ? RETURNING client_id, product_id, quantity;"),
    DELETE_PRODUCT("DELETE FROM BASKET_TABLE WHERE client_id = ? AND product_id = ? RETURNING client_id, product_id, quantity;");
    private final String sql;

    BasketSQLScript(String sql) {
        this.sql = sql;
    }
}

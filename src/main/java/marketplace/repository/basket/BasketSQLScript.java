package marketplace.repository.basket;

import lombok.Getter;

@Getter
public enum BasketSQLScript {
    CREATE("INSERT INTO BASKET_TABLE (id, client_id, product_id, quantity) VALUES (?, ?, ?, ?);"),
    READ("SELECT * FROM BASKET_TABLE WHERE id = ?;"),
    UPDATE("UPDATE BASKET_TABLE SET quantity = ? WHERE id = ?;"),
    DELETE("DELETE FROM BASKET_TABLE WHERE id = ?;"),

    READ_ALL("SELECT * FROM BASKET_TABLE WHERE client_id = ?;"),
    DELETE_ALL("DELETE FROM BASKET_TABLE WHERE client_id = ?;");

    private final String sql;

    BasketSQLScript(String sql) {
        this.sql = sql;
    }
}

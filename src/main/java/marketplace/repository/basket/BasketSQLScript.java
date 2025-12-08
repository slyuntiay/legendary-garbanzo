package marketplace.repository.basket;

public enum BasketSQLScript {
    CREATE_TABLE("CREATE TABLE BASKET_TABLE (id SERIAL PRIMARY KEY, surname TEXT NOT NULL," +
            " name TEXT NOT NULL);"),
    DROP_TABLE("DROP TABLE BASKET_TABLE;"),
    CREATE("INSERT INTO BASKET_TABLE (surname, name) VALUES (?, ?);"),
    DELETE("DELETE FROM BASKET_TABLE WHERE id = ? RETURNING id, surname, name;"),
    READ("SELECT * FROM BASKET_TABLE WHERE id = ?;"),
    READ_ALL("SELECT * FROM BASKET_TABLE;"),
    UPDATE("UPDATE BASKET_TABLE SET surname = ?, name = ? WHERE id = ?;");

    private final String sql;

    BasketSQLScript(String sql) {
        this.sql = sql;
    }
}

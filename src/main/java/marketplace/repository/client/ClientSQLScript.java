package marketplace.repository.client;

import lombok.Getter;


@Getter
public enum ClientSQLScript {
    CREATE("INSERT INTO CLIENT_TABLE (surname, name) VALUES (?, ?);"),
    READ("SELECT * FROM CLIENT_TABLE WHERE id = ?;"),
    UPDATE("UPDATE CLIENT_TABLE SET surname = ?, name = ? WHERE id = ?;"),
    DELETE("DELETE FROM CLIENT_TABLE WHERE id = ? RETURNING id, surname, name;");

    private final String sql;

    ClientSQLScript(String sql) {
        this.sql = sql;
    }
}
package marketplace.repository.client;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ClientSQLScript {
    CREATE_TABLE("CREATE TABLE CLIENT_TABLE (id SERIAL PRIMARY KEY, surname TEXT NOT NULL," +
            " name TEXT NOT NULL);"),
    DROP_TABLE("DROP TABLE CLIENT_TABLE;"),

    CREATE("INSERT INTO CLIENT_TABLE (surname, name) VALUES (?, ?);"),
    READ("SELECT * FROM CLIENT_TABLE WHERE id = ?;"),
    UPDATE("UPDATE CLIENT_TABLE SET surname = ?, name = ? WHERE id = ?;"),
    DELETE("DELETE FROM CLIENT_TABLE WHERE id = ? RETURNING id, surname, name;"),

    READ_ALL("SELECT * FROM CLIENT_TABLE;");

    private final String sql;

    ClientSQLScript(String sql) {
        this.sql = sql;
    }
}
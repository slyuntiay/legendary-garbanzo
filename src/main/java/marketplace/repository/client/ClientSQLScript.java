package marketplace.repository.client;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ClientSQLScript {
    CREATE_TABLE("CREATE TABLE CLIENT_TABLE (id SERIAL PRIMARY KEY, surname TEXT NOT NULL," +
            " name TEXT NOT NULL);"),
    DROP_TABLE("DROP TABLE CLIENT_TABLE;"),
    CREATE("INSERT INTO CLIENT_TABLE (surname, name) VALUES (?, ?);"),
    DELETE("DELETE FROM CLIENT_TABLE WHERE id = ? RETURNING id, surname, name;"),
    READ("SELECT * FROM CLIENT_TABLE WHERE id = ?;"),
    READ_ALL("SELECT * FROM CLIENT_TABLE;"),
    UPDATE("UPDATE CLIENT_TABLE SET surname = ?, name = ? WHERE id = ?;");

    private final String sql;

    ClientSQLScript(String sql) {
        this.sql = sql;
    }

    public static ClientSQLScript getSql(int number) {
        return Arrays.stream(ClientSQLScript.values())
                .filter(clientSQLScript -> clientSQLScript.ordinal() == number - 1)
                .findFirst()
                .orElseThrow();
    }
}
package marketplace.database;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum SqlScript {
    CREATE_PRODUCT_TABLE("CREATE TABLE PRODUCT_TABLE (id SERIAL PRIMARY KEY, name TEXT NOT NULL, price MONEY, quantity INTEGER NOT NULL);",0),
    DROP_PRODUCT_TABLE("DROP TABLE PRODUCT_TABLE;",0),
    CREATE_PRODUCT("INSERT INTO PRODUCT_TABLE (name, price, quantity) VALUES (?, ?, ?);",3),
    DELETE_PRODUCT("DELETE FROM PRODUCT_TABLE WHERE id = ?;",1),
    READ_PRODUCT("SELECT * FROM PRODUCT_TABLE WHERE id = ?;",1),
    READ_ALL("SELECT * FROM PRODUCT_TABLE;",0),
    UPDATE_PRODUCT("UPDATE PRODUCT_TABLE SET name = ?, quantity = ? WHERE id = ?;",3);

    private String sql;
    private int parametersCount;
    SqlScript(String sql, int parametersCount) {
        this.sql = sql;
        this.parametersCount = parametersCount;
    }

    public static SqlScript getSql(int number) {
        return Arrays.stream(SqlScript.values())
                .filter(sqlScript -> sqlScript.ordinal() == number - 1)
                .findFirst()
                .orElseThrow();
    }
}

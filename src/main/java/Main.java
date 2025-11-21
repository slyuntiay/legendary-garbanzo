import marketplace.database.PostgresConnector;

public class Main {
    public static void main(String[] args) {
        PostgresConnector postgresConnector = new PostgresConnector(args[0], args[1], args[2]);
        String dropSql = "DROP TABLE clients1;";
        String createSql = "CREATE TABLE clients1();";
        postgresConnector.execute(createSql);
        postgresConnector.execute(dropSql);
    }
}

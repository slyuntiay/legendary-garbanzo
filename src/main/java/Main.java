import marketplace.database.TableEditor;

public class Main {
    public static void main(String[] args) {
        String str = "DROP TABLE clients1";
        TableEditor.editTable(str);
    }
}

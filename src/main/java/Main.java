import marketplace.database.TableEditor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = "DROP TABLE clients1";
        TableEditor.editTable(str);
        System.out.println("Интерфейс магазина");
        System.out.println("1-Добавить покупателя");
        System.out.println("2-Удалить покупателя");
        System.out.println("3-Посмотреть всех покупателей");
        System.out.println("4-Изменить покупателя");
        System.out.println("5-Посмотреть все продукты и кол-во");
        System.out.println("6-Купить товар");
        System.out.println("7-Выход");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                break;
                case 2:
                    break;
                    case 3:
                        break;
                        case 4:
                            break;
                            case 5:
                                break;
                                case 6:
                                    break;
        }
    }
}

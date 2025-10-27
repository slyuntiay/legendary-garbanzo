package vadya;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество боксов: ");
        int boxCount = scanner.nextInt();
        GarageCar garage = new GarageCar(boxCount);

        while (true) {
            System.out.println("\n1 - Поставить машину");
            System.out.println("2 - Взять машину");
            System.out.println("3 - Показать гараж");
            System.out.println("4 - Выход");
            System.out.print("Выберите: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    putCar(scanner, garage);
                    break;
                case 2:
                    getCar(scanner, garage);
                    break;
                case 3:
                    garage.showAllCars();
                    break;
                case 4:
                    System.out.println("Выход");
                    return;
                default:
                    System.out.println("не то ввел");
            }
        }
    }

    private static void putCar(Scanner scanner, GarageCar garage) {
        System.out.print("Марка: ");
        String brand = scanner.nextLine();

        System.out.print("Объем двигателя: ");
        double volume = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Номер бокса: ");
        int box = scanner.nextInt();
        scanner.nextLine();

        Car car = new Car(brand, volume);

        try {
            garage.putCar(car, box);
        } catch (ErrorBoxException e) {
            System.out.println("Ошибка: " + e.getMessage());
            int freeBox = garage.getFreeBoxNumber();
            if (freeBox != -1) {
                System.out.println("Ставим в свободный бокс " + freeBox);
                garage.putCar(car, freeBox);
            } else {
                System.out.println("Свободных боксов нет!");
            }
        }
    }

    private static void getCar(Scanner scanner, GarageCar garage) {
        System.out.print("Номер бокса: ");
        int box = scanner.nextInt();
        scanner.nextLine();

        try {
            Car car = garage.getCar(box);
            System.out.println("Получили: " + car.toString());
        } catch (ErrorBoxException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
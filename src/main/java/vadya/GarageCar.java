package vadya;

import java.util.stream.IntStream;

class GarageCar {
    private Car[] boxes;

    public GarageCar(int boxCount) {
        this.boxes = new Car[boxCount];
    }

    public void putCar(Car car, int boxNumber) {
        checkBoxNumber(boxNumber);

        if (boxes[boxNumber - 1] != null) {
            throw new ErrorBoxException("Бокс " + boxNumber + " занят");
        }

        boxes[boxNumber - 1] = car;
        System.out.println("Машина поставлена в бокс " + boxNumber);
    }

    public Car getCar(int boxNumber) {
        checkBoxNumber(boxNumber);

        if (boxes[boxNumber - 1] == null) {
            throw new ErrorBoxException("Бокс " + boxNumber + " пустой");
        }

        Car car = boxes[boxNumber - 1];
        boxes[boxNumber - 1] = null;
        return car;
    }

    public boolean isFree(int boxNumber) {
        return boxNumber >= 1 && boxNumber <= boxes.length &&
                boxes[boxNumber - 1] == null;
    }

    public int getFreeBoxNumber() {
        for (int i = boxes.length - 1; i >= 0; i--) {
            if (boxes[i] == null) {
                return i + 1;
            }
        }
        return -1;
    }

    public void showAllCars() {
        System.out.println("Машины в гараже:");
        for (int i = 0; i < boxes.length; i++) {
            String status;
            if (boxes[i] == null) {
                status = "Свободен";
            } else {
                status = boxes[i].toString();
            }
            System.out.println("Бокс " + (i + 1) + ": " + status);
        }//переписать на stream
    }


    private void checkBoxNumber(int boxNumber) {
        if (boxNumber < 1 || boxNumber > boxes.length) {
            throw new ErrorBoxException("неправильный номер бокса " + boxNumber);
        }
    }
}
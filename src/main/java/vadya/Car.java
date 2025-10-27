package vadya;

public class Car {
    private String modelCar;
    private double modelEngine;

    public Car(String modelCar, double modelEngine) {
        this.modelCar = modelCar;
        this.modelEngine = modelEngine;
    }

    public String getModelCar() {
        return modelCar;
    }

    public double getModelEngine() {
        return modelEngine;
    }

    public String toString() {
        return modelCar + " " + modelEngine;
    }
}
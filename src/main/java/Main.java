
import marketplace.service.ServiceUi;

public class Main {
    public static void main(String[] args) {
        ServiceUi serviceUi = new ServiceUi(args[0], args[1], args[2]);
        serviceUi.start();
        System.out.println("Ну и пошёл тогда ты на хуй!");
    }
}




import marketplace.Application;
import marketplace.params.ConnectionParams;
import marketplace.service.ServiceUi;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        Application application = context.getBean("application", Application.class);
        application.setConnectionParams(args[0], args[1], args[2]);
        ServiceUi serviceUi = context.getBean("serviceUi", ServiceUi.class);
        serviceUi.start();
        System.out.println("Ну и пошёл тогда ты на хуй!");
        context.close();
    }
}



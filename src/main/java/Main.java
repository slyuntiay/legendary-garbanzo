import marketplace.MarketplaceConfig;
import marketplace.service.ServiceUi;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        MarketplaceConfig marketplaceConfig = new MarketplaceConfig();
        marketplaceConfig.setConnectionParams(args[0], args[1], args[2]);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MarketplaceConfig.class);
        ServiceUi serviceUi = context.getBean(ServiceUi.class);
        serviceUi.start();
        System.out.println("Ну и пошёл тогда ты на хуй!");
        context.close();
    }
}



package marketplace.hibernate;

import marketplace.entity.Basket;
import marketplace.entity.Client;
import marketplace.entity.Product;
import marketplace.entity.Student;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfiguration {

    @Bean
    public SessionFactory sessionFactory() {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();

        configuration
                .addPackage("hibernate")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Basket.class)
                .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
                .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/ourMarketplace")
                .setProperty("hibernate.connection.username", "LAnat")
                .setProperty("hibernate.connection.password", "3815")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.hbm2ddl.auto", "update");

        return configuration.buildSessionFactory();
    }
}
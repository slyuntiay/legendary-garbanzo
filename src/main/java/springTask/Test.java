package springTask;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        Circle circle = context.getBean(Circle.class);
        circle.area();
        CalculatorService calculatorService = context.getBean(CalculatorService.class);
        calculatorService.calculateArea(circle);
    }
}

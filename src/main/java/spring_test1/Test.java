package spring_test1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        Mouse mouse = context.getBean(Mouse.class);
        mouse.mouseClick();
    }
}

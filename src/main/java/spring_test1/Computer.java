package spring_test1;

import org.springframework.stereotype.Component;

@Component
public class Computer {
    private Mouse mouse;
    private Keyboard keyboard;

    public Computer() {
        System.out.println("Computer is created");
    }
}

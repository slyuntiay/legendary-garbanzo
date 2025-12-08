package spring_test1;

import org.springframework.stereotype.Component;

@Component
public class Keyboard {
    private int keyQ;

    public Keyboard() {
        System.out.println("Keyboard is created");
    }
}

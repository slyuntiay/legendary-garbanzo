package spring_test1;

import org.springframework.stereotype.Component;

@Component
public class Mouse {
    private int buttonQ;

    public Mouse() {
        System.out.println("Mouse is created");
    }

    public void mouseClick() {
        System.out.println("Click, epta!");
    }
}

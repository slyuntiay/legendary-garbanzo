package spring_test;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

public class Dog implements Pet {
    @Override
    public void voice() {
        System.out.println("WOW");
    }
}

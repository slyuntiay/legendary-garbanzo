package springTask;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public void calculateArea(Shape shape) {
        System.out.println(shape.area());
    }
}

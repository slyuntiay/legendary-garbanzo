import lombok.Getter;
import lombok.Setter;

public class Person {
    @Getter
    @Setter
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

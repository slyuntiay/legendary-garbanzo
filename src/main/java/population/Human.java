package population;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Human {
    private int id;
    private String name;
    private int age;
    private String gender;

    public Human(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}

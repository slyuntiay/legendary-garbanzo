package commissariat.recruit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Recruit {
    private int id;
    private String name;
    private int age;
    private String gender;

    public Recruit (int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

}

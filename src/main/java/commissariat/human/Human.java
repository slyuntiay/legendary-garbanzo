package commissariat.human;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Human {
    private int id;
    private String name;
    private int age;
    private String gender;
    private boolean militaryService;
//
    public Human(int id, String name, int age, String gender, boolean militaryService) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.militaryService = militaryService;
    }
}

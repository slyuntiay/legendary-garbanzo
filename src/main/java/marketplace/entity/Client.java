package marketplace.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Client {
    private int id;
    private String surname;
    private String name;

    public Client() {
    }

    public Client(int id, String surname, String name) {
        this.id = id;
        this.surname = surname;
        this.name = name;
    }
}

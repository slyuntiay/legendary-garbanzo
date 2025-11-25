package marketplace.entity;

import lombok.Getter;
import lombok.Setter;

import java.beans.BeanProperty;

@Setter
@Getter
public class Client {

    private int id;
    private String surname;
    private String name;

    public Client() {
    }

    public Client(String surname, String name) {
        this.id = 1;
        this.surname = surname;
        this.name = name;
    }
}

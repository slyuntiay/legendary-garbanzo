package marketplace.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.beans.BeanProperty;
import java.util.Objects;

@Component
@Setter
@Getter
public class Client extends Entity {
    private String surname;
    private String name;

    public Client(int id, String surname, String name) {
        super(id);
        this.surname = surname;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " " + surname + " " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && Objects.equals(surname, client.surname) && Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name);
    }
}

package marketplace.entity;

import lombok.Getter;
import lombok.Setter;

import java.beans.BeanProperty;
import java.util.Objects;

@Setter
@Getter
public class Client extends Entity {
    private int id;
    private String surname;
    private String name;

    public Client() {
    }

    public Client(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

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

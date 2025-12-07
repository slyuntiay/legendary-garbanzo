package marketplace.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Entity {
    protected int id;

    public Entity(int id) {
        this.id = id;
    }
}

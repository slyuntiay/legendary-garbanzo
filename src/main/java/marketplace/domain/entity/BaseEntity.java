package marketplace.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;

    public BaseEntity(int id) {
        this.id = id;
    }

    public BaseEntity() {}
}

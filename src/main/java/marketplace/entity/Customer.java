package marketplace.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor  // ← JPA требует ЭТО
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table
public class Customer extends BaseEntity {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Basket> basketList = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "username")
    private User user;
}

package marketplace.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import marketplace.dto.clientDto.ClientRequestDto;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Customer extends BaseEntity {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "client")
    private List<Basket> basketList = new ArrayList<>();

    public Customer(ClientRequestDto clientRequestDto) {
        this.firstName = clientRequestDto.getSurname();
        this.lastName = clientRequestDto.getName();
    }
}

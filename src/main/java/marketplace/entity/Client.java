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
public class Client extends BaseEntity {

    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Basket> basketList = new ArrayList<>();

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String name;

    public Client(ClientRequestDto clientRequestDto) {
        this.surname = clientRequestDto.getSurname();
        this.name = clientRequestDto.getName();
    }
}

package marketplace.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import marketplace.dto.clientDto.ClientRequestDto;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Client extends BaseEntity {

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String name;

    public Client(ClientRequestDto clientRequestDto) {
        this.surname = clientRequestDto.getSurname();
        this.name = clientRequestDto.getName();
    }
}

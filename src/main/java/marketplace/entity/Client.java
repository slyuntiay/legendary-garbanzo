package marketplace.entity;

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
@Table(name = "client_table")
public class Client extends BaseEntity {
    private String surname;
    private String name;

    public Client(ClientRequestDto clientRequestDto) {
        this.surname = clientRequestDto.getSurname();
        this.name = clientRequestDto.getName();
    }

    public Client(int id, String surname, String name) {
        super(id);
        this.surname = surname;
        this.name = name;
    }

//    @Override
//    public String toString() {
//        return id + " " + surname + " " + name;
//    }
}

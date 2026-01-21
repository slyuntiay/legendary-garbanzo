package marketplace.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import marketplace.dto.clientDto.CreateClientRequestDto;

import java.util.Objects;

@NoArgsConstructor
@Setter
@Getter
public class Client extends Entity {
    private String surname;
    private String name;

    public Client(CreateClientRequestDto createClientRequestDto) {
        this.surname = createClientRequestDto.getSurname();
        this.name = createClientRequestDto.getName();
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
}

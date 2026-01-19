package marketplace.dto.clientDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import marketplace.entity.Client;

@RequiredArgsConstructor
@Getter
public class CreateClientResponseDto {
    private final int id;
    private final String surname;
    private final String name;

    public CreateClientResponseDto(Client client) {
        this.id = client.getId();
        this.surname = client.getSurname();
        this.name = client.getName();
    }
}

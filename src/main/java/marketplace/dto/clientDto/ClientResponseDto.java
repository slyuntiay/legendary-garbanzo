package marketplace.dto.clientDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import marketplace.entity.Customer;

@RequiredArgsConstructor
@Getter
public class ClientResponseDto {
    private final Long id;
    private final String surname;
    private final String name;

    public ClientResponseDto(Customer customer) {
        this.id = customer.getId();
        this.surname = customer.getFirstName();
        this.name = customer.getLastName();
    }
}

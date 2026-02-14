package marketplace.dto.customerDto;

import lombok.Data;

@Data
public class CustomerResponseDto {
    private final Long id;
    private final String firstName;
    private final String lastName;
}

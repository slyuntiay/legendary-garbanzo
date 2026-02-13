package marketplace.dto.customerDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import marketplace.entity.Customer;

@RequiredArgsConstructor
@Getter
public class CustomerResponseDto {
    private final Long id;
    private final String firstName;
    private final String lastName;
}

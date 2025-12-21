package marketplace.dto.clientDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CreateClientRequestDto {
    private final String surname;
    private final String name;

}

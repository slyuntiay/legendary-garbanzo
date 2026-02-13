package marketplace.dto.clientDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@Data
public class ClientRequestDto {
    @NotBlank(message = "")
    @Size(min = 2, max = 50)
    private String surname;

    @NotBlank
    @Size(min = 2, max = 30)
    private String name;
}

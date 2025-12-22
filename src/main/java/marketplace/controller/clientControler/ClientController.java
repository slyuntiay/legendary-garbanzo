package marketplace.controller.clientControler;

import lombok.RequiredArgsConstructor;
import marketplace.dto.clientDto.CreateClientRequestDto;
import marketplace.dto.clientDto.CreateClientResponseDto;
import marketplace.dto.productDto.CreateProductResponseDto;
import marketplace.entity.Client;
import marketplace.entity.Product;
import marketplace.service.clientService.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping(path = "/create")
    public ResponseEntity<CreateClientResponseDto> create(@RequestBody
                                                              CreateClientRequestDto createClientRequestDto) {
        Client client = clientService.create(createClientRequestDto);
        CreateClientResponseDto responseDto = new CreateClientResponseDto(client);
        return ResponseEntity.ok(responseDto);
    }
}

package marketplace.controller;

import lombok.RequiredArgsConstructor;
import marketplace.dto.CreateClientRequestDto;
import marketplace.dto.CreateClientResponseDto;
import marketplace.entity.Client;
import marketplace.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

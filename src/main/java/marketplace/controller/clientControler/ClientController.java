package marketplace.controller.clientControler;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import marketplace.dto.clientDto.CreateClientRequestDto;
import marketplace.dto.clientDto.CreateClientResponseDto;
import marketplace.entity.Client;
import marketplace.service.clientService.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping(path = "/create")
    public ResponseEntity<CreateClientResponseDto> create(
            @RequestBody CreateClientRequestDto createClientRequestDto) {
        Client client = clientService.create(createClientRequestDto);
        CreateClientResponseDto responseDto = new CreateClientResponseDto(client);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping(path = "/read/{id}")
    public ResponseEntity<CreateClientResponseDto> read(@PathVariable int id) {
        try {
            Client client = clientService.read(id);
            return ResponseEntity.ok(new CreateClientResponseDto(client));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<CreateClientResponseDto> update(
            @PathVariable int id,
            @Valid @RequestBody CreateClientRequestDto createClientRequestDto) {
        Client client = clientService.update(id, createClientRequestDto);
        CreateClientResponseDto responseDto = new CreateClientResponseDto(client);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<CreateClientResponseDto> delete(@PathVariable int id) {
        Client deletedClient = clientService.read(id);
        clientService.delete(id);
        CreateClientResponseDto responseDto = new CreateClientResponseDto(deletedClient);
        return ResponseEntity.ok(responseDto);
    }
}

package marketplace.controller.clientControler;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import marketplace.dto.clientDto.ClientRequestDto;
import marketplace.dto.clientDto.ClientResponseDto;
import marketplace.entity.Client;
import marketplace.service.clientService.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping(path = "/save")
    public ResponseEntity<ClientResponseDto> save(
            @RequestBody ClientRequestDto clientRequestDto) {
        Client client = clientService.save(clientRequestDto);
        ClientResponseDto responseDto = new ClientResponseDto(client);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<ClientResponseDto> find(@PathVariable Long id) {
        return clientService.find(id)
                .map(client -> ResponseEntity.ok(new ClientResponseDto(client)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/merge/{id}")
    public ResponseEntity<ClientResponseDto> merge(
            @PathVariable Long id,
            @Valid @RequestBody ClientRequestDto clientRequestDto) {
        return clientService.merge(id, clientRequestDto)
                .map(client -> ResponseEntity.ok(new ClientResponseDto(client)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/remove/{id}")
    public ResponseEntity<Object> remove(@PathVariable Long id) {
        return clientService.remove(id)
                .map(deleted -> ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());
    }
}

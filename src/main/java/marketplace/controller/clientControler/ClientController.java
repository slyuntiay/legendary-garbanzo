package marketplace.controller.clientControler;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marketplace.dto.clientDto.ClientRequestDto;
import marketplace.dto.clientDto.ClientResponseDto;
import marketplace.entity.Client;
import marketplace.service.clientService.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping(path = "/save")
    public ResponseEntity<ClientResponseDto> save(
            @RequestBody ClientRequestDto clientRequestDto) {
        log.info("SAVE client: surname={}, name={}",
                clientRequestDto.getSurname(), clientRequestDto.getName());

        Client client = clientService.save(clientRequestDto);
        ClientResponseDto responseDto = new ClientResponseDto(client);
        log.info("SAVE OK: clientId={}", client.getId());

        return ResponseEntity.ok(responseDto);
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<ClientResponseDto> find(@PathVariable int id) {
        log.info("FIND client by id={}", id);

        return clientService.find(id)
                .map(client -> {
                    log.info("FIND OK: clientId={}", client.getId());
                    return ResponseEntity.ok(new ClientResponseDto(client));
                })
                .orElseGet(() -> {
                    log.warn("FIND NOT FOUND: clientId={}", id);
                    return ResponseEntity.notFound().build();
                });
    }

    @PutMapping(path = "/merge/{id}")
    public ResponseEntity<ClientResponseDto> merge(
            @PathVariable int id,
            @Valid @RequestBody ClientRequestDto clientRequestDto) {
        log.info("MERGE client id={}, surname={}, name={}",
                id, clientRequestDto.getSurname(), clientRequestDto.getName());

        return clientService.merge(id, clientRequestDto)
                .map(client -> {
                    log.info("MERGE OK: clientId={}", client.getId());
                    return ResponseEntity.ok(new ClientResponseDto(client));
                })
                .orElseGet(() -> {
                    log.warn("MERGE NOT FOUND: clientId={}", id);
                    return ResponseEntity.notFound().build();
                });
    }

    @DeleteMapping(path = "/remove/{id}")
    public ResponseEntity<Object> remove(@PathVariable int id) {
        log.info("REMOVE client id={}", id);

        return clientService.remove(id)
                .map(deleted -> {
                    log.info("REMOVE OK: clientId={}", id);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> {
                    log.warn("REMOVE NOT FOUND: clientId={}", id);
                    return ResponseEntity.notFound().build();
                });
    }
}

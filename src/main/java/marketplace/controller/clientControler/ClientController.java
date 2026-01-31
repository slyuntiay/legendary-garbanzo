package marketplace.controller.clientControler;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import marketplace.dto.clientDto.ClientDto;
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
            @RequestBody ClientDto clientDto) {
        Client client = clientService.save(clientDto);
        CreateClientResponseDto responseDto = new CreateClientResponseDto(client);
        return ResponseEntity.ok(responseDto);
    }

//    @GetMapping(path = "/read/{id}")
//    public ResponseEntity<CreateClientResponseDto> read(@PathVariable int id) {
//        try {
//            Client client = clientService.read(id);
//            return ResponseEntity.ok(new CreateClientResponseDto(client));
//        } catch (NoSuchElementException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PutMapping(path = "/update/{id}")
//    public ResponseEntity<CreateClientResponseDto> update(
//            @PathVariable int id,
//            @Valid @RequestBody ClientDto clientDto) {
//        Client client = clientService.update(id, clientDto);
//        CreateClientResponseDto responseDto = new CreateClientResponseDto(client);
//        return ResponseEntity.ok(responseDto);
//    }
//
//    @DeleteMapping(path = "delete/{id}")
//    public void delete(@PathVariable int id) {
//        clientService.delete(id);
//    }
}

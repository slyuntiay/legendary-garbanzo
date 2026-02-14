package marketplace.controller.customerController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import marketplace.dto.customerDto.CustomerRequestDto;
import marketplace.dto.customerDto.CustomerResponseDto;
import marketplace.service.customerService.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping(path = "/save")
    public ResponseEntity<CustomerResponseDto> save(
            @RequestBody CustomerRequestDto customerRequestDto) {
        CustomerResponseDto responseDto = customerService.save(customerRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<CustomerResponseDto> find(@PathVariable long id) {
        return customerService.find(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/merge/{id}")
    public ResponseEntity<CustomerResponseDto> merge(
            @PathVariable long id,
            @Valid @RequestBody CustomerRequestDto customerRequestDto) {
        return customerService.merge(id, customerRequestDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/remove/{id}")
    public ResponseEntity<Object> remove(@PathVariable long id) {
        return customerService.remove(id)
                .map(deleted -> ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());
    }
}
package marketplace.controller.customerController;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import marketplace.dto.customerDto.CustomerRequestDto;
import marketplace.dto.customerDto.CustomerResponseDto;
import marketplace.dto.mapper.CustomerMapper;
import marketplace.entity.Customer;
import marketplace.service.customerService.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Customers")
@RequestMapping(path = "customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @PostMapping(path = "/save")
    public ResponseEntity<CustomerResponseDto> save(
            @RequestBody CustomerRequestDto customerRequestDto) {
        Customer saved = customerService.save(customerMapper.toEntity(customerRequestDto));
        CustomerResponseDto responseDto = customerMapper.toResponse(saved);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<CustomerResponseDto> find(@PathVariable long id) {
        return customerService.find(id)
                .map(customer -> ResponseEntity.ok(customerMapper.toResponse(customer)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/merge/{id}")
    public ResponseEntity<CustomerResponseDto> merge(
            @PathVariable long id,
            @Valid @RequestBody CustomerRequestDto customerRequestDto) {
        return customerService.merge(id, customerMapper.toEntity(customerRequestDto))
                .map(customer -> {
                    customerMapper.updateFromDto(customerRequestDto, customer);
                    Customer merged = customerService.save(customer);
                    return ResponseEntity.ok(customerMapper.toResponse(merged));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/remove/{id}")
    public ResponseEntity<Object> remove(@PathVariable long id) {
        return customerService.remove(id)
                .map(deleted -> ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());
    }
}
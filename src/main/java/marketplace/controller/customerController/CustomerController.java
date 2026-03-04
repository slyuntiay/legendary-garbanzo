package marketplace.controller.customerController;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import marketplace.dto.customerDto.CustomerRequest;
import marketplace.dto.customerDto.CustomerResponse;
import marketplace.mapper.CustomerMapper;
import marketplace.entity.Customer;
import marketplace.service.customerService.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Customers")
@RequestMapping(path = "customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @PostMapping(path = "/save")
    public ResponseEntity<CustomerResponse> save(
            @RequestBody CustomerRequest customerRequest) {
        Customer saved = customerService.save(customerMapper.toEntity(customerRequest));
        CustomerResponse responseDto = customerMapper.toResponse(saved);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<CustomerResponse> find(@PathVariable long id) {
        return customerService.find(id)
                .map(customer -> ResponseEntity.ok(customerMapper.toResponse(customer)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/merge/{id}")
    public ResponseEntity<CustomerResponse> merge(
            @PathVariable long id,
            @Valid @RequestBody CustomerRequest customerRequest) {
        return customerService.merge(id, customerMapper.toEntity(customerRequest))
                .map(customer -> {
                    customerMapper.updateFromDto(customerRequest, customer);
                    Customer merged = customerService.save(customer);
                    return ResponseEntity.ok(customerMapper.toResponse(merged));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/ADMIN/remove/{id}")
    public ResponseEntity<Object> remove(@PathVariable long id) {
        return customerService.remove(id)
                .map(deleted -> ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());
    }
}
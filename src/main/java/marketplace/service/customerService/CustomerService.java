package marketplace.service.customerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marketplace.dto.customerDto.CustomerRequestDto;
import marketplace.dto.customerDto.CustomerResponseDto;
import marketplace.dto.mapper.CustomerMapper;
import marketplace.entity.Customer;
import marketplace.repository.customer.CustomerRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;

    @Transactional
    public Customer save(CustomerRequestDto dto) {
        log.info("SAVE customer: lastname={}, name={}",
                dto.getLastName(), dto.getFirstName());

        try {
            Customer customer = customerMapper.toEntity(dto);
            Customer saved = customerRepo.save(customer);
            log.info("SAVE OK: customerId={}", saved.getId());
            return saved;
        } catch (Exception e) {
            log.error("SAVE FAILED: lastname={}, name={}, error={}",
                    dto.getLastName(), dto.getFirstName(), e.getMessage(), e);
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Optional<CustomerResponseDto> find(long id) {
        log.debug("FIND customer: id={}", id);
        return customerRepo.find(id).map(customerMapper::toResponse);
    }

    @Transactional
    public Optional<Customer> merge(long id, CustomerRequestDto customerRequestDto) {
        log.info("MERGE customer: id={}, lastname={}, name={}",
                id, customerRequestDto.getLastName(), customerRequestDto.getFirstName());

        return customerRepo.find(id).map(customer -> {
            log.debug("MERGE updating customer: id={}", id);
            customer.setFirstName(customerRequestDto.getFirstName());
            customer.setLastName(customerRequestDto.getLastName());
            Customer merged = customerRepo.merge(customer);
            log.info("MERGE OK: customerId={}", merged.getId());
            return merged;
        });
    }

    @Transactional
    public Optional<Boolean> remove(long id) {
        log.info("REMOVE customer: id={}", id);

        return customerRepo.find(id).map(customer -> {
            log.debug("REMOVE deleting customer: id={}", id);
            customerRepo.remove(customer);
            log.info("REMOVE OK: customerId={}", id);
            return true;
        });
    }
}



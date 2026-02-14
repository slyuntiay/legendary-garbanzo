package marketplace.service.customerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marketplace.dto.customerDto.CustomerRequestDto;
import marketplace.dto.customerDto.CustomerResponseDto;
import marketplace.dto.mapper.GeneralMapper;
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
    private final GeneralMapper generalMapper;

    @Transactional
    public CustomerResponseDto save(CustomerRequestDto customerRequestDto) {
        log.info("SAVE customer: lastname={}, name={}",
                customerRequestDto.getLastName(), customerRequestDto.getFirstName());

        try {
            Customer customer = customerRepo.save(generalMapper.toEntity(customerRequestDto));
            log.info("SAVE OK: customerId={}", customer.getId());
            return generalMapper.toResponse(customer);
        } catch (Exception e) {
            log.error("SAVE FAILED: lastname={}, name={}, error={}",
                    customerRequestDto.getLastName(), customerRequestDto.getFirstName(), e.getMessage(), e);
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Optional<CustomerResponseDto> find(long id) {
        log.debug("FIND customer: id={}", id);
        return customerRepo.find(id).map(generalMapper::toResponse);
    }

    @Transactional(readOnly = true)
    public Optional<Customer> findEntity(long id) {
        return customerRepo.find(id);
    }

    @Transactional
    public Optional<CustomerResponseDto> merge(long id, CustomerRequestDto customerRequestDto) {
        log.info("MERGE customer: id={}, lastname={}, name={}",
                id, customerRequestDto.getLastName(), customerRequestDto.getFirstName());

        return customerRepo.find(id).map(customer -> {
            log.debug("MERGE updating customer: id={}", id);
            generalMapper.updateFromDto(customerRequestDto, customer);
            Customer merged = customerRepo.merge(customer);
            log.info("MERGE OK: customerId={}", merged.getId());
            return generalMapper.toResponse(merged);
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



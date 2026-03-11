package marketplace.service.customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @Transactional
    public Customer save(Customer customer) {
        log.info("SAVE customer: lastname={}, name={}",
                customer.getLastName(), customer.getFirstName());

        try {
            log.info("SAVE OK: customerId={}", customer.getId());
            return customerRepo.save(customer);
        } catch (Exception e) {
            log.error("SAVE FAILED: lastname={}, name={}, error={}",
                    customer.getLastName(), customer.getFirstName(), e.getMessage(), e);
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Optional<Customer> find(long id) {
        log.debug("FIND customer: id={}", id);
        return customerRepo.find(id);
    }

    @Transactional
    public Optional<Customer> merge(long id, Customer customer) {
        log.info("MERGE customer: id={}, lastname={}, name={}",
                id, customer.getLastName(), customer.getFirstName());

        return customerRepo.find(id).map(c -> {
            log.debug("MERGE updating customer: id={}", id);
            Customer merged = customerRepo.merge(c);
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



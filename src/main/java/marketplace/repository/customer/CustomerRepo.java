package marketplace.repository.customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marketplace.entity.Customer;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CustomerRepo {

    @PersistenceContext
    private EntityManager entityManager;

    public Customer save(Customer customer) {
        entityManager.persist(customer);
        return customer;
    }

    public Optional<Customer> find(long id) {
        return Optional.ofNullable(entityManager.find(Customer.class, id));
    }

    public Customer merge(Customer customer) {
        return entityManager.merge(customer);
    }

    @Transactional
    public void remove(Customer customer) {
        entityManager.remove(customer);
    }
}
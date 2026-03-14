package ma.enset.ebankingbackend.repositories;

import ma.enset.ebankingbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //List<Customer> searchCustomer(String keyword);

    // Search by name containing the keyword
    List<Customer> findByNameContaining(String keyword);

    // Optional: search by email containing the keyword
    List<Customer> findByEmailContaining(String keyword);
}

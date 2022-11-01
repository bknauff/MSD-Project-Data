package spring.boot.project.repository;

import org.springframework.data.repository.CrudRepository;

import spring.boot.project.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}

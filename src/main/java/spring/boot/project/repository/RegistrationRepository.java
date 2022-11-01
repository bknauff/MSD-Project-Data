package spring.boot.project.repository;

import org.springframework.data.repository.CrudRepository;
import spring.boot.project.domain.Registration;

public interface RegistrationRepository extends CrudRepository<Registration, Long> {

}

package spring.boot.project.repository;

import org.springframework.data.repository.CrudRepository;

import spring.boot.project.domain.Event;

public interface EventRepository extends CrudRepository<Event, Long>{

}

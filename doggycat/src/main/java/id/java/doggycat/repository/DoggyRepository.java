package id.java.doggycat.repository;

import org.springframework.data.repository.CrudRepository;

import id.java.doggycat.model.db.Dog;

public interface DoggyRepository extends CrudRepository<Dog, Integer>{

    
}

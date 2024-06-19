package com.camunda.avipsa.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalImageDao extends CrudRepository<Animal, String> {

}

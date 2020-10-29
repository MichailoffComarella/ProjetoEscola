package com.example.demo.repository;

import com.example.demo.model.Programa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramaRepository extends CrudRepository<Programa, Long> {

}

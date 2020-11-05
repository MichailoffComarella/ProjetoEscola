package com.example.demo.repository;

import com.example.demo.model.Mentoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentoriaRepository extends CrudRepository<Mentoria, Long> {

}

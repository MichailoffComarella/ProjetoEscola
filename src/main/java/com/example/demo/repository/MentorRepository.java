package com.example.demo.repository;

import com.example.demo.model.Mentor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends CrudRepository<Mentor, Long> {

}

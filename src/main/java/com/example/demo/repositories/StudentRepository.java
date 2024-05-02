package com.example.demo.repositories;

import com.example.demo.entities.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

    public StudentEntity findByName(String name);

    public void deleteById(Integer id);
}

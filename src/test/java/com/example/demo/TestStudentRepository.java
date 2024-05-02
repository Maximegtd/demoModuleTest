package com.example.demo;

import com.example.demo.entities.StudentEntity;
import com.example.demo.repositories.StudentRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestStudentRepository {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Rollback(false)
    @Order(1)
    public void testCreateStudent() {
        StudentEntity savedStudent = studentRepository.save(new StudentEntity("Maxime", 24));

        assertThat(savedStudent.getId()).isGreaterThan(0);
    }

    @Test
    @Rollback(false)
    @Order(2)
    public void testFindStudentByName() {
        StudentEntity student = studentRepository.findByName("Maxime");

        assertThat(student.getName()).isEqualTo("Maxime");
    }

    @Test
    @Rollback(false)
    @Order(3)
    public void testUpdateStudent() {
        StudentEntity student = studentRepository.findByName("Maxime");
        student.setAge(25);

        studentRepository.save(student);

        StudentEntity updatedStudent = studentRepository.findByName("Maxime");

        assertThat(updatedStudent.getAge()).isEqualTo(25);
    }

    @Test
    @Rollback(false)
    @Order(4)
    public void testDeleteStudent() {
        studentRepository.deleteById(1);
        StudentEntity student = studentRepository.findByName("Maxime");
        assertThat(student).isNull();
    }
}

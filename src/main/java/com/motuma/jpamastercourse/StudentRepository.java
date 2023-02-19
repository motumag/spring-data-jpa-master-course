package com.motuma.jpamastercourse;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    //How to use custom query
    Optional<Student> findStudentByEmail(String email);
    List<Student > findStudentByFirstNameEqualsAndAgeEquals(String firstName,Integer age);

}

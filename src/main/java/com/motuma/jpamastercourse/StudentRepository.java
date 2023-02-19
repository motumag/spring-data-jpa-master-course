package com.motuma.jpamastercourse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    //How to use custom query
    @Query("SELECT s FROM Student s where s.email=?1 ") //Jpql query
    Optional<Student> findStudentByEmail(String email);
    @Query("SELECT s FROM Student s WHERE s.firstName=?1 AND s.age=?2")
    List<Student > findStudentByFirstNameEqualsAndAgeEquals(String firstName,Integer age);

}

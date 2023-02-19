package com.motuma.jpamastercourse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaMasterCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaMasterCourseApplication.class, args);
    }
    @Bean
 CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            try {
                Student student = new Student("Motuma", "Gishu", "mow2tuma12@gmail", 27);
//            studentRepository.save(student);
                Student bethy = new Student("Bethy", "Teferi", "be12twhy@gmail", 27);
                studentRepository.saveAll(List.of(student, bethy));
                //Custom query in which we can search a student using email
             studentRepository.findStudentByEmail("be12twhy@gmail")
                     .ifPresentOrElse(System.out::println,
                             () -> System.out.println("The student with be12twhy@gmail email is not found"));


            } catch (Exception e) {
                System.out.println("Exception is:" + e.getMessage());
            }
            ;
        };
 }

}

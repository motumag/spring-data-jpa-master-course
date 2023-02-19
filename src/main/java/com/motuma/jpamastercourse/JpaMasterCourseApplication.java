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
                System.out.println("How many student do we have on our database?"+"\n");
                System.out.println("No of Student"+studentRepository.count());
                studentRepository.findById(2L).ifPresentOrElse(student1 -> {
                    System.out.println(student1);
                },() -> {
                    System.out.println("Student Not found");
                });
            } catch (Exception e) {
                System.out.println("Exception is:" + e.getMessage());
            }
            ;
        };
 }

}

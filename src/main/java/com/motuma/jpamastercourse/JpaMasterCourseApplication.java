package com.motuma.jpamastercourse;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootApplication
public class JpaMasterCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaMasterCourseApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository
            , StudentIdCardRepository studentIdCardRepository) {
        return args -> {
            Faker faker = new Faker();
                String firstName = faker.name().firstName();
                String lastName = faker.name().lastName();
                String email = String.format("%s.%s@motumagishu.com", firstName, lastName);
                Student student = new Student(firstName, lastName, email, faker.number().numberBetween(20, 55));
                StudentIdCard studentIdCard = new StudentIdCard("1234567890", student);
                studentIdCardRepository.save(studentIdCard);
                studentIdCardRepository.findById(1L).ifPresent(System.out::println);
        };

    }

    private void generatedData(StudentRepository studentRepository) {
        Faker faker = new Faker();
        for (int i = 0; i < 20; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@motumagishu.com", firstName, lastName);
            Student student = new Student(firstName, lastName, email, faker.number().numberBetween(20, 55));
            studentRepository.save(student);
        }
    }
}

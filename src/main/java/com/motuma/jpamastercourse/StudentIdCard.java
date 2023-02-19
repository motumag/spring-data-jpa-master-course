package com.motuma.jpamastercourse;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.SEQUENCE;
@Entity(name = "StudentIdCard")
@Table(name = "student_id_card",
        uniqueConstraints = {
                @UniqueConstraint(name = "card_number_unique", columnNames = "card_number")
        })
public class StudentIdCard {
    @Id
    @SequenceGenerator(name = "student_id_card_sequence",
            sequenceName = "student_id_card_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "student_id_card_sequence"
    )
    @Column(
            name = "id",
            nullable = false
    )
    private Long id;
    @Column(
            name = "card_number",
            nullable = false,
            length = 15,
            unique = true
    )
    private String card_number;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "id"
    )
    private Student student;

    public StudentIdCard(String card_number, Student student) {
        this.card_number = card_number;
        this.student = student;
    }

    public StudentIdCard() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

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
    @SequenceGenerator(name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "student_sequence"
    )
    @Column(
            name = "id",
            nullable = false
    )
    private Long id;
    @Column(
            name = "card_number",
            columnDefinition = "TEXT",
            nullable = true,
            length = 15
    )
    private String card_number;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "id"
    )
    private Student student;


    public StudentIdCard() {
    }

    public StudentIdCard(String card_number) {
        this.card_number = card_number;
    }

    public StudentIdCard(Long id, String card_number) {
        this.id = id;
        this.card_number = card_number;
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
}

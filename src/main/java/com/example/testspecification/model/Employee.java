package com.example.testspecification.model;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Employee extends User {

    @Builder
    public Employee(Long id, String firstName, String lastName, String email, int age, DocumentState documentState, String company, double salary) {
        super(id, firstName, lastName, email, age, documentState);
        this.company = company;
        this.salary = salary;
    }

    private String company;
    private double salary;

}

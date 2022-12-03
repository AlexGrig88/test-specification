package com.example.testspecification.dto;


import com.example.testspecification.model.DocumentState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String lastNameDto;
    private int age;
    private DocumentState state;
    private String company;
    private double salary;
}

package com.example.testspecification.mapper;

import com.example.testspecification.dto.EmployeeDto;
import com.example.testspecification.model.DocumentState;
import com.example.testspecification.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(source = "lastName", target = "lastNameDto")
    @Mapping(source = "documentState", target = "state", defaultValue = "GOOD")
    @Mapping(source = "company", target = "company", ignore = true)
    EmployeeDto employeeToEmployeeDto(Employee employee);

}

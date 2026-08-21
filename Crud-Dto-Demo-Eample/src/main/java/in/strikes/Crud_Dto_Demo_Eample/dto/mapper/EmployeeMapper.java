package in.strikes.Crud_Dto_Demo_Eample.dto.mapper;

import in.strikes.Crud_Dto_Demo_Eample.dto.EmployeeRequestDTO;
import in.strikes.Crud_Dto_Demo_Eample.dto.EmployeeResponseDTO;
import in.strikes.Crud_Dto_Demo_Eample.entity.Employee;

public class EmployeeMapper {

    // EmployeeRequestDTO -> Employee Entity
    public static Employee toEntity(EmployeeRequestDTO dto) {

        Employee employee = new Employee();

        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setPassword(dto.getPassword());
        employee.setDepartment(dto.getDepartment());
        employee.setSalary(dto.getSalary());

        return employee;
    }


    // Employee Entity -> EmployeeResponseDTO
    public static EmployeeResponseDTO toResponseDTO(Employee employee) {

        return new EmployeeResponseDTO(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getDepartment(),
                employee.getSalary()
        );
    }
}
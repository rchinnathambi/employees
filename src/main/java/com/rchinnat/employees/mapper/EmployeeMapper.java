package com.rchinnat.employees.mapper;

import com.rchinnat.employees.entity.Employee;
import com.rchinnat.employees.model.EmployeeDTO;

public class EmployeeMapper {
    public static EmployeeDTO entityToDto(Employee emp) {
        return new EmployeeDTO(emp.getId(), emp.getName(), emp.getProfession(),
                emp.getMobile(), emp.getEmail(), emp.getLocation());
    }

    public static Employee dtoToEntity(EmployeeDTO dto, Employee emp) {
        emp.setLocation(dto.location());
        emp.setName(dto.name());
        emp.setEmail(dto.email());
        emp.setMobile(dto.mobile());
        emp.setProfession(dto.profession());
        return emp;
    }
}

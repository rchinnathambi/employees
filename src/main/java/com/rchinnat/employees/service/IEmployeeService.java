package com.rchinnat.employees.service;

import com.rchinnat.employees.entity.Employee;
import com.rchinnat.employees.model.EmployeeDTO;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeDTO> getEmployeeList();

    EmployeeDTO getEmployee(Integer id);

    Employee addEmployee(EmployeeDTO employeeDTO);
}

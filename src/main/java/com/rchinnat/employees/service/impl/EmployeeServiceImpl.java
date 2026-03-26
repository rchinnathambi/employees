package com.rchinnat.employees.service.impl;

import com.rchinnat.employees.entity.Employee;
import com.rchinnat.employees.mapper.EmployeeMapper;
import com.rchinnat.employees.model.EmployeeDTO;
import com.rchinnat.employees.repository.EmployeeRepository;
import com.rchinnat.employees.service.IEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> getEmployeeList() {
        return employeeRepository.findAll()
                .stream().map(EmployeeMapper::entityToDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployee(Integer id) {
        Employee emp = employeeRepository.findById(id).get();
        return EmployeeMapper.entityToDto(emp);
    }

    @Override
    public Employee addEmployee(EmployeeDTO employeeDTO) {
        Employee emp = EmployeeMapper.dtoToEntity(employeeDTO, new Employee());
        return employeeRepository.save(emp);
    }
}

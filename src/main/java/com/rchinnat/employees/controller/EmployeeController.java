package com.rchinnat.employees.controller;

import com.rchinnat.employees.entity.Employee;
import com.rchinnat.employees.mapper.EmployeeMapper;
import com.rchinnat.employees.model.EmployeeDTO;
import com.rchinnat.employees.service.IEmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController {

    private final IEmployeeService employeeService;

    @GetMapping()
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        List<EmployeeDTO> empList = employeeService.getEmployeeList();
        return ResponseEntity.ok(empList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("id") Integer id) {
        EmployeeDTO dto = employeeService.getEmployee(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping()
    public ResponseEntity<EmployeeDTO> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee emp = employeeService.addEmployee(employeeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(EmployeeMapper.entityToDto(emp));
        //return ResponseEntity.status(HttpStatus.CREATED).body("Student with ID Created - " + emp.getId() + " => Name: " + emp.getName());
    }
}

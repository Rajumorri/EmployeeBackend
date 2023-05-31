package com.jsp.Employee.Employee.controller;

import com.jsp.Employee.Employee.entity.Employee;
import com.jsp.Employee.Employee.exception.ResourceNotFoundException;
import com.jsp.Employee.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/employee")
@CrossOrigin

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/employeeList")
    public List<Employee> listAll()
    {
        return employeeService.findAll();
    }
    @PostMapping("/saveEmployee")
    public Employee saveEmployee(@RequestBody  Employee employee)
    {
        return employeeService.save(employee);
    }
    @GetMapping("getById/{id}")
    public ResponseEntity<Optional<Employee>> getById(@PathVariable int id){
        Optional<Employee> employee= employeeService.find(id);
        return ResponseEntity.ok(employee);
    }
    @PutMapping("/employeeUpdate/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id,@RequestBody Employee employee)
    {
        Employee old= employeeService.find(id).orElseThrow(
                () -> new ResourceNotFoundException("property not found"));
        old.setEmail(employee.getEmail());
        old.setFirstname(employee.getFirstname());
        old.setLastname(employee.getLastname());
        Employee updated=employeeService.save(old);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Map<String,Boolean>> delete(@PathVariable int id)
    {

        Employee old= employeeService.find(id).orElseThrow(() -> new ResourceNotFoundException("property not found"));
        employeeService.delete(old.getId());
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}

package com.jsp.Employee.Employee.service;

import com.jsp.Employee.Employee.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public void add();
    public void delete();
    public void fetchAll();

    List<Employee> findAll();
    Employee save(Employee employee);
    Optional<Employee> find(int id);
    void delete(int id);

}

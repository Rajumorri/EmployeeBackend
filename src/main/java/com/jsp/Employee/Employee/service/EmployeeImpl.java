package com.jsp.Employee.Employee.service;

import com.jsp.Employee.Employee.entity.Employee;
import com.jsp.Employee.Employee.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeImpl implements EmployeeService{
    @Autowired
    private EmployeeRepo repo;
    @Override
    public void add() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void fetchAll() {

    }

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) repo.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        repo.save(employee);
        return employee;
    }
    public Optional<Employee> find(int id)
    {
        return repo.findById(id);
    }

    @Override
    public void delete(int id)
    {
        repo.deleteById(id);
    }

}

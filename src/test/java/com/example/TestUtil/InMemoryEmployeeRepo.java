package com.example.TestUtil;

import com.example.Employee;
import com.example.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryEmployeeRepo implements EmployeeRepository {

    private final List<Employee> inMemoryEmployeeList = new ArrayList<>();

    @Override
    public List<Employee> findAll() {
        return inMemoryEmployeeList;
    }

    @Override
    public Employee save(Employee e) {
        String newUserId = e.getId();
        inMemoryEmployeeList.removeIf(emp -> newUserId.equals(emp.getId()));
        inMemoryEmployeeList.add(e);
        return e;
    }
}

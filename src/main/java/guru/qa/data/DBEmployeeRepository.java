package guru.qa.data;

import guru.qa.domain.Employee;

import java.util.Optional;

public class DBEmployeeRepository implements EmployeeRepository{
    @Override
    public Optional<Employee> lookup(String name, String surName) {
        return Optional.empty();
    }

    @Override
    public Employee save(Employee employee) {
        return null;
    }

    @Override
    public Employee update(Employee employee) {
        return null;
    }
}

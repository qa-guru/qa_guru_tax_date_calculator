package guru.qa.data;

import guru.qa.domain.Employee;

import java.util.Optional;

public interface EmployeeRepository {

    Optional<Employee> lookup(String name, String surName);

    Employee save(Employee employee);

    Employee update(Employee employee);
}

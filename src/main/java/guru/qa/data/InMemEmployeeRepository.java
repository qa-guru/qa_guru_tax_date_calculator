package guru.qa.data;

import guru.qa.domain.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class InMemEmployeeRepository implements EmployeeRepository {

    private static final Map<UUID, Employee> storage = new HashMap<>();

    static {
        Employee existingEmployee0 = new Employee(UUID.randomUUID(), "Вася", "Иванов");
        Employee existingEmployee1 = new Employee(UUID.randomUUID(), "Петя", "Петров");
        storage.put(existingEmployee0.getId(), existingEmployee0);
        storage.put(existingEmployee1.getId(), existingEmployee1);
    }

    @Override
    public Optional<Employee> lookup(String name, String surName) {
        for (Employee employee : storage.values()) {
            if (employee.getName().equals(name) && employee.getSurName().equals(surName)) {
                return Optional.of(employee);
            }
        }
        return Optional.empty();
    }

    @Override
    public Employee save(Employee employee) {
        if (employee.getId() != null && storage.get(employee.getId()) != null) {
            throw new IllegalArgumentException("Объект уже сохранен в storage!");
        }
        if (employee.getName() == null || employee.getName().equals("")) {
            throw new IllegalArgumentException("Сотрудник не может быть без имени");
        }
        employee.setId(UUID.randomUUID());
        storage.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        if (employee.getId() == null || storage.get(employee.getId()) == null) {
            throw new IllegalArgumentException("Объект не может быть изменен, т.к. отсутсвует в storage!");
        }
        storage.put(employee.getId(), employee);
        return employee;
    }
}

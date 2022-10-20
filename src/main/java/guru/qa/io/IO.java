package guru.qa.io;

import guru.qa.domain.Employee;

import javax.annotation.Nonnull;

public interface IO {

    @Nonnull
    Employee readEmployee();

    void printEmployee(String message, Employee employee);

    Employee inputDepartureDate(Employee employee);

}

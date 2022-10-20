package guru.qa.core;

import guru.qa.domain.Employee;
import guru.qa.io.IO;

import java.util.Date;

public class Application {

    private final IO io;
    private final TaxDateCalculator taxDateCalculator;

    public Application(IO io, TaxDateCalculator taxDateCalculator) {
        this.io = io;
        this.taxDateCalculator = taxDateCalculator;
    }
    public void run() {
        Employee employee = io.readEmployee();
        io.inputDepartureDate(employee);
        taxDateCalculator.calculateTaxResidenceLostDate(employee);
        io.printEmployee("Результат: ", employee);
    }
}

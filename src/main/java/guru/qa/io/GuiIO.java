package guru.qa.io;

import com.toedter.calendar.JDateChooser;
import guru.qa.data.EmployeeRepository;
import guru.qa.domain.Employee;

import javax.annotation.Nonnull;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.util.Optional;

import static javax.swing.JOptionPane.OK_OPTION;

public class GuiIO implements IO {

    private final EmployeeRepository employeeRepository;

    public GuiIO(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public @Nonnull Employee readEmployee() {
        JTextField name = new JTextField();
        JTextField surname = new JTextField();
        Object[] messageBody = {
                "Имя: ", name,
                "Фамилия: ", surname
        };

        int option = JOptionPane.showConfirmDialog(null, messageBody, "Введите данные сотрудника", JOptionPane.OK_CANCEL_OPTION);
        if (option == OK_OPTION) {
            Optional<Employee> employee = employeeRepository.lookup(name.getText(), surname.getText());
            if (employee.isPresent()) {
                printEmployee("Найден сотрудник: ", employee.get());
                return employee.get();
            } else {
                Employee addedEmployee = new Employee(name.getText(), surname.getText());
                employeeRepository.save(addedEmployee);
                printEmployee("Добавлен новый сотрудник: ", addedEmployee);
                return addedEmployee;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Действие отменено :(");
            System.exit(0);
        }
        return null;
    }

    @Override
    public void printEmployee(String message, Employee employee) {
        String msg = employee.getDateOfLoseTaxResidence() == null
                ? message + employee.getName() + " " + employee.getSurName()
                : message + employee.getName() + " " + employee.getSurName() + ", дата потери резидентства: " + employee.getDateOfLoseTaxResidence();

        JOptionPane.showMessageDialog(null, msg);
    }

    @Override
    public Employee inputDepartureDate(Employee employee) {
        JDateChooser jd = new JDateChooser();
        Object[] messageBody = {
                "Дата отъезда: ", jd
        };
        JOptionPane.showConfirmDialog(null, messageBody, "Введите данные сотрудника", JOptionPane.DEFAULT_OPTION);
        employee.setDepartureDate(jd.getDate());
        return employee;
    }
}

package guru.qa.data;

import guru.qa.domain.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemEmployeeRepositoryTest {

    private InMemEmployeeRepository tested = new InMemEmployeeRepository();

    @Test
    void saveTestWithEmptyName() {
        Employee employee0 = new Employee(null, "Иванов");

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    tested.save(employee0);
                }
        );
        Assertions.assertEquals("Сотрудник не может быть без имени", exception.getMessage());
    }
}
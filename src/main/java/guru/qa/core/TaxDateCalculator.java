package guru.qa.core;

import guru.qa.domain.Employee;

import java.util.Calendar;
import java.util.Date;

public class TaxDateCalculator {

    public void calculateTaxResidenceLostDate(Employee employee) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(employee.getDepartureDate());
        cal.add(Calendar.DATE, 183);
        employee.setDateOfLoseTaxResidence(cal.getTime());
    }
}

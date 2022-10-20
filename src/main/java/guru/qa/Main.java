package guru.qa;

import guru.qa.core.Application;
import guru.qa.core.TaxDateCalculator;
import guru.qa.data.InMemEmployeeRepository;
import guru.qa.io.ConsoleIO;
import guru.qa.io.GuiIO;
import guru.qa.io.IO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Application(
                new GuiIO(
                        new InMemEmployeeRepository()
                ),
                new TaxDateCalculator()
        ).run();
    }
}
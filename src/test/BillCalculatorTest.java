package test;

import static org.junit.jupiter.api.Assertions.*;

import main.Appointment;
import main.BillCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BillCalculatorTest {

    BillCalculator billCalculator;

    @BeforeEach
    void setup() {
        billCalculator = new BillCalculator();
    }

    @Test
    void StartAt5pmEndAt10pmAt15DollarsPerHourEquals75Dollars() {
        Appointment appointment;
        appointment = new Appointment("11/01/2018 5:00PM", "11/01/2018 10:00PM", 15.00);

        assertEquals(75.00, billCalculator.calculateCharge(appointment));
    }

    @Test
    void StartAt6pmEndAt10pmAt20DollarsPerHourEquals80Dollars() {
        Appointment appointment;
        appointment = new Appointment("11/01/2018 6:00PM", "11/01/2018 10:00PM", 20.00);

        assertEquals(80.00, billCalculator.calculateCharge(appointment));
    }

    @Test
    void StartAt5PMEndAt4AMAt25DollarsPerHourEquals275Dollars() {
        Appointment appointment;
        appointment = new Appointment("11/01/2018 5:00PM", "11/02/2018 4:00AM", 25.00);

        assertEquals(275.00, billCalculator.calculateCharge(appointment));
    }
}
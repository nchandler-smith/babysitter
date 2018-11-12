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
        appointment = new Appointment("5:00PM", "10:00PM", 15.00);

        assertEquals(75.00, billCalculator.calculateCharge(appointment));
    }

    @Test
    void StartAt6pmEndAt10pmAt20DollarsPerHourEquals80Dollars() {
        Appointment appointment;
        appointment = new Appointment("6:00PM", "10:00PM", 20.00);

        assertEquals(80.00, billCalculator.calculateCharge(appointment));
    }
}
package test;

import static org.junit.jupiter.api.Assertions.*;
import main.BillCalculator;
import org.junit.jupiter.api.Test;

class BillCalculatorTest {

    @Test
    void StartAt5pmEndAt10pmAt15DollarsPerHourEquals75Dollars() {
        BillCalculator billCalculator = new BillCalculator();

        assertEquals(75.00, billCalculator.calculateCharge());
    }
}
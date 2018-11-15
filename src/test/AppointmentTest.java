package test;

import main.Appointment;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppointmentTest {

    @Test
    void Start5PMEnd10PMAt10DollarsPerHourEarns50Dollars() {
        Appointment appointment = new Appointment("11/1/2018 5:00PM", "11/1/2018 10:00PM", 10);

        assertEquals(50, appointment.calculateDollarsEarned());
    }


    @Test
    void Start5PMEnd4AMAt10DollarsPerHourEarns110Dollars() {
        Appointment appointment = new Appointment("11/2/2018 5:00PM", "11/3/2018 4:00AM", 10);

        assertEquals(110, appointment.calculateDollarsEarned());
    }

    @Test
    void StartFivePMEndNineThirtyAMEarns50Dollars() {
        Appointment appointment = new Appointment("11/3/2018 5:00PM", "11/3/2018 9:30PM", 10);

        assertEquals(50, appointment.calculateDollarsEarned());
    }

}
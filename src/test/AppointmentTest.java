package test;

import main.Appointment;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AppointmentTest {

    @Test
    void start5PMEnd10PMAt10DollarsPerHourEarns50Dollars() {
        Appointment appointment = new Appointment("11/1/2018 5:00PM", "11/1/2018 10:00PM", 10);

        assertEquals(50, appointment.calculateDollarsEarned());
    }


    @Test
    void start5PMEnd4AMAt10DollarsPerHourEarns110Dollars() {
        Appointment appointment = new Appointment("11/2/2018 5:00PM", "11/3/2018 4:00AM", 10);

        assertEquals(110, appointment.calculateDollarsEarned());
    }

    @Test
    void startFivePMEndNineThirtyPMEarns50Dollars() {
        Appointment appointment = new Appointment("11/3/2018 5:00PM", "11/3/2018 9:30PM", 10);

        assertEquals(50, appointment.calculateDollarsEarned());
    }

    @Test
    void start530PMEnd10PMEarns50Dollars() {
        Appointment appointment = new Appointment("11/3/2018 5:30PM", "11/3/2018 10:00PM", 10);

        assertEquals(50, appointment.calculateDollarsEarned());
    }

    @Test
    void start459IsInWorkingHoursEqualsFalse() {
        Appointment appointment = new Appointment("11/4/2018 4:59PM", "11/5/2018 10:00PM", 10);

        assertFalse(appointment.isStartTimeValid());
    }

    @Test
    void start5PMIsInWorkingHoursEqualsTrue() {
        Appointment appointment = new Appointment("11/5/2018 5:00PM", "11/6/2018 10:00PM", 10);

        assertTrue(appointment.isStartTimeValid());
    }

    @Test
    void endTime401AMIsIsINWorkingHoursEqualsFalse() {
        Appointment appointment = new Appointment("11/6/2018 5:00PM", "11/7/2018 4:01AM", 10);

        assertFalse(appointment.isEndTimeValid());
    }

    @Test
    void endTimeFourAMIsInWorkingHoursEqualsTrue() {
        Appointment appointment = new Appointment("11/7/2018 5:00PM", "11/8/2018 4:00AM", 10);

        assertTrue(appointment.isEndTimeValid());
    }

    @Test
    void start5PMEnd11PMForFamilyAEarns90Dollars() {
        Appointment appointment = new Appointment("11/8/2018 5:00PM", "11/8/2018 11:00PM", "A");

        assertEquals(90, appointment.calculateDollarsEarned());
    }

    @Test
    void start5PMEnd4AMForFamilyAEarns190Dollars() {
        Appointment appointment = new Appointment("11/8/2018 5:00PM", "11/9/2018 4:00AM", "A");

        assertEquals(190, appointment.calculateDollarsEarned());
    }

    @Test
    void start5PMEnd6PMForFamilyAEarns15Dollars() {
        Appointment appointment = new Appointment("11/8/2018 5:00PM", "11/8/2018 6:00PM", "A");

        assertEquals(15, appointment.calculateDollarsEarned());
    }

    @Test
    void start5PMEnd9PMForFamilyCEarns84Dollars() {
        Appointment appointment = new Appointment("11/8/2018 5:00PM", "11/8/2018 9:00PM", "C");

        assertEquals(84, appointment.calculateDollarsEarned());
    }

    @Test
    void start5PMEnd6PMForFamilyCEarns21Dollars() {
        Appointment appointment = new Appointment("11/8/2018 5:00PM", "11/8/2018 6:00PM", "C");

        assertEquals(21, appointment.calculateDollarsEarned());
    }

    @Test
    void start5PMEnd4AMForFamilyCEarns189Dollars() {
        Appointment appointment = new Appointment("11/8/2018 5:00PM", "11/9/2018 4:00AM", "C");

        assertEquals(189, appointment.calculateDollarsEarned());
    }

    @Test
    void start5PMEnd10PMForFamilyBEarns60Dollars() {
        Appointment appointment = new Appointment("11/8/2018 5:00PM", "11/8/2018 10:00PM", "B");

        assertEquals(60, appointment.calculateDollarsEarned());
    }

    @Test
    void start5PMEnd6PMForFamilyBEarns12Dollars() {
        Appointment appointment = new Appointment("11/8/2018 5:00PM", "11/8/2018 6:00PM", "B");

        assertEquals(12, appointment.calculateDollarsEarned());
    }
}
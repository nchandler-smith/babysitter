package test;

import main.Appointment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {

    SimpleDateFormat simpleDateFormat;

    @BeforeEach
    void setup() {
        simpleDateFormat = new SimpleDateFormat("h:mma");
    }

    @Test
    void getStartTimeSixPM() {
        Appointment appointment;
        appointment = new Appointment("11/01/2018 6:00PM", "11/01/2018 7:00PM", 10.00);
        String appointmentString = simpleDateFormat.format(appointment.getStart());

        assertEquals("6:00PM", appointmentString);
    }

    @Test
    void getStartTime7PM() {
        Appointment appointment;
        appointment = new Appointment("11/01/2018 7:00PM", "11/01/2018 10:00PM", 12.00);
        String appointmentString = simpleDateFormat.format(appointment.getStart());

        assertEquals("7:00PM", appointmentString);
    }

    @Test
    void getEndTime10PM() {
        Appointment appointment;
        appointment = new Appointment("11/01/2018 5:00PM", "11/01/2018 10:00PM", 20.00);
        String appointmentString = simpleDateFormat.format(appointment.getEnd());

        assertEquals("10:00PM", appointmentString);
    }

    @Test
    void getEndTime2AM() {
        Appointment appointment;
        appointment = new Appointment("11/01/2018 5:00PM", "11/02/2018 2:00AM", 20.00);
        String appointmentString = simpleDateFormat.format(appointment.getEnd());

        assertEquals("2:00AM", appointmentString);
    }

    @Test
    void getHourlyRate15() {
        Appointment appointment;
        appointment = new Appointment("11/01/2018 8:00PM", "11/01/2018 11:00PM", 15.00);

        assertEquals(15.00, appointment.getHourlyRate());
    }

    @Test
    void getHourlyRate17() {
        Appointment appointment;
        appointment = new Appointment("11/01/2018 8:00PM", "11/01/2018 11:00PM", 17.00);

        assertEquals(17.00, appointment.getHourlyRate());
    }

    @Test
    void validateStartTimeOutsideWorkHoursReturnsFalse() {
        Appointment appointment;
        appointment = new Appointment("11/01/2018 4:00PM", "11/01/2018 10:00PM", 17.00);

        assertFalse(appointment.startTimeIsValid());
    }

    @Test
    void validateStartTimeInsideWorkHoursReturnsTrue() {
        Appointment appointment;
        appointment = new Appointment("11/01/2018 6:00PM", "11/01/2018 11:00PM", 17.00);

        assertTrue(appointment.startTimeIsValid());
    }

    @Test
    void validateEndTimeOutsideWorkingHoursReturnsFalse() {
        Appointment appointment;
        appointment = new Appointment("11/1/2018 5:00PM", "11/2/2018 8:00AM", 18);

        assertFalse(appointment.endTimeIsValid());
    }

    @Test
    void validateEndTimeInsideworkingHoursReturnsTrue() {
        Appointment appointment;
        appointment = new Appointment ("11/1/2018 5:00PM", "11/2/2018 12:00AM", 18);

        assertTrue(appointment.endTimeIsValid());
    }
}
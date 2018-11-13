package main;

public class BillCalculator {

    public double calculateCharge(Appointment appointment) {
        double duration = appointment.getEnd().getTime() - appointment.getStart().getTime();
        duration = duration / (1000 * 60 * 60);
        return duration * appointment.getHourlyRate();
    }
}

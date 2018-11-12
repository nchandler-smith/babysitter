package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Appointment implements TimeEntry {
    Date startTime;
    Date endTime;
    double rate;

    public Appointment(String startTime, String endTime, double rate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mma");
        try {
            this.startTime = simpleDateFormat.parse(startTime);
            this.endTime = simpleDateFormat.parse(endTime);
        } catch (ParseException e) {
            System.out.println("Could not parse date in appointment.");
        }
        this.rate = rate;
    }

    @Override
    public Date getStartTime() {
        return startTime;
    }

    @Override
    public Date getEndTime() {
        return endTime;
    }

    @Override
    public double getHourlyRate() {
        return rate;
    }
}

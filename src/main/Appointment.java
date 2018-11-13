package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Appointment implements TimeEntry {
    Date startTime;
    Date endTime;
    double rate;

    public Appointment(String startTime, String endTime, double rate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy h:mma");
        try {
            this.startTime = simpleDateFormat.parse(startTime);
            this.endTime = simpleDateFormat.parse(endTime);
        } catch (ParseException e) {
            System.out.println("Could not parse the following date(s) in appointment: "
                                + startTime + " or " + endTime);
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

    public boolean startTimeIsValid() {
        String stringMyStartTIme = "11/1/2018 5:00PM";
        try {
            Date myStartTime = new SimpleDateFormat("MM/dd/yyyy h:mma").parse(stringMyStartTIme);
            return this.startTime.after(myStartTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
}

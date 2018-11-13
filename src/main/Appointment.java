package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Appointment implements TimeEntry {
    Date start;
    Date end;
    double rate;

    public Appointment(String start, String end, double rate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy h:mma");
        try {
            this.start = simpleDateFormat.parse(start);
            this.end = simpleDateFormat.parse(end);
        } catch (ParseException e) {
            System.out.println("Could not parse the following date(s) in appointment: "
                                + start + " or " + end);
        }
        this.rate = rate;
    }

    @Override
    public Date getStart() {
        return start;
    }

    @Override
    public Date getEnd() {
        return end;
    }

    @Override
    public double getHourlyRate() {
        return rate;
    }

    public boolean startTimeIsValid() {
        Calendar actualStartCal = Calendar.getInstance();
        actualStartCal.setTime(this.start);
        String stringMyStartTIme = "5:00PM";
        try {
            Date myStartTime = new SimpleDateFormat("h:mma").parse(stringMyStartTIme);
            Calendar myStartCal = Calendar.getInstance();
            myStartCal.setTime(actualStartCal.getTime());
            myStartCal.setTime(myStartTime);

            return actualStartCal.getTime().after(myStartCal.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
}

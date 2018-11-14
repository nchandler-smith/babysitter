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
        int startYear = actualStartCal.get(Calendar.YEAR);
        int startMonth = actualStartCal.get(Calendar.MONTH);
        int startDay = actualStartCal.get(Calendar.DAY_OF_MONTH);

        String stringMyStartTIme = "5:00PM";
        try {
            Date myStartTime = new SimpleDateFormat("h:mma").parse(stringMyStartTIme);
            Calendar myStartCal = Calendar.getInstance();
            myStartCal.setTime(myStartTime);
            myStartCal.set(Calendar.YEAR, startYear);
            myStartCal.set(Calendar.MONTH, startMonth);
            myStartCal.set(Calendar.DAY_OF_MONTH, startDay);

            return actualStartCal.getTime().after(myStartCal.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean endTimeIsValid() {
        return false;
    }
}

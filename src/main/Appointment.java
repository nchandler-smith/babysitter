package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Appointment {
    private final Calendar start = Calendar.getInstance();
    private final Calendar end = Calendar.getInstance();
    private final double hourlyRate;

    public Appointment(String start, String end, double hourlyRate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy h:mma");
        try {
            this.start.setTime(simpleDateFormat.parse(start));
            this.end.setTime(simpleDateFormat.parse(end));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.hourlyRate = hourlyRate;
    }

    public double calculateDollarsEarned() {
        long duration = this.end.getTimeInMillis() - this.start.getTimeInMillis();
        return (int) Math.ceil( (double) duration / (1000 * 60 * 60)) * this.hourlyRate;
    }



    public boolean startTimeIsValid() {
        Calendar actualStartCal = Calendar.getInstance();
        actualStartCal.setTime(this.start.getTime());
        int startYear = actualStartCal.get(Calendar.YEAR);
        int startMonth = actualStartCal.get(Calendar.MONTH);
        int startDay = actualStartCal.get(Calendar.DAY_OF_MONTH);

        String stringMyStartTIme = "4:59PM";
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
/*
    public boolean endTimeIsValid() {
        Calendar actualEndCal = Calendar.getInstance();
        actualEndCal.setTime(this.end);
        int endYear = actualEndCal.get(Calendar.YEAR);
        int endMonth = actualEndCal.get(Calendar.MONTH);
        int endDay = actualEndCal.get(Calendar.DAY_OF_MONTH);

        String stringMyEndTime = "4:01AM";
        try {
            Date myEndTime = new SimpleDateFormat("h:mma").parse(stringMyEndTime);
            Calendar myEndCal = Calendar.getInstance();
            myEndCal.setTime(myEndTime);
            myEndCal.set(Calendar.YEAR, endYear);
            myEndCal.set(Calendar.MONTH, endMonth);
            myEndCal.set(Calendar.DAY_OF_MONTH, endDay);

            return actualEndCal.getTime().before(myEndCal.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
    */
}

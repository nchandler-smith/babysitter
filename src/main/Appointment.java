package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Appointment {
    private final Calendar start = Calendar.getInstance();
    private final Calendar end = Calendar.getInstance();
    private final double hourlyRate;
    private final String family;

    public Appointment(String start, String end, double hourlyRate) {
        this.start.setTime(dateTimeStringToDate(start));
        this.end.setTime(dateTimeStringToDate(end));
        this.hourlyRate = hourlyRate;
        this.family = "";
    }

    public Appointment(String start, String end, String family){
        this.start.setTime(dateTimeStringToDate(start));
        this.end.setTime(dateTimeStringToDate(end));
        this.hourlyRate = 0;
        this.family = family;
    }

    public double calculateDollarsEarned() {
        if (this.family == "") {
            return this.calculateEarningsAtRate(this.start, this.end, hourlyRate);
        }
        else if(this.family == "A") {
            Calendar elevenPM = this.stringTimeToCalendar("11:00PM", this.start);
            if ( this.end.getTime().after(elevenPM.getTime()) ) {
                return this.calculateEarningsAtRate(elevenPM, this.end, 20) + 90;
            }
            return this.calculateEarningsAtRate(this.start, this.end, 15);
        }
        else if (this.family == "B") {
            Calendar tenPM = this.stringTimeToCalendar("10:00PM", this.start);
            if ( this.end.getTime().after(tenPM.getTime()) ) {
                return this.calculateEarningsAtRate(tenPM, this.end, 8) + 60;
            }
            return this.calculateEarningsAtRate(this.start, this.end, 12);
        }
        else if ( this.family == "C"){
            Calendar ninePM = this.stringTimeToCalendar("9:00PM", this.start);
            if (this.end.getTime().after(ninePM.getTime()) ) {
                return this.calculateEarningsAtRate(ninePM, this.end, 15) + 84;
            }
            return this.calculateEarningsAtRate(this.start, this.end, 21);
        }
        return Double.parseDouble(null);
    }

    public boolean isStartTimeValid() {
        Calendar allowedStartAfter = stringTimeToCalendar("4:59PM", this.start);
        return this.start.getTime().after(allowedStartAfter.getTime());
    }

    public boolean isEndTimeValid() {
        Calendar allowedEndBefore = stringTimeToCalendar("4:01AM", this.end);
        return this.end.getTime().before(allowedEndBefore.getTime());
    }

    private Calendar stringTimeToCalendar(String stringTime, Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        try {
            Date time = new SimpleDateFormat("h:mma").parse(stringTime);
            Calendar calendarOut = Calendar.getInstance();
            calendarOut.setTime(time);
            calendarOut.set(Calendar.YEAR, year);
            calendarOut.set(Calendar.MONTH, month);
            calendarOut.set(Calendar.DAY_OF_MONTH, day);
            return calendarOut;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar errorCalendar = Calendar.getInstance();
        return errorCalendar;
    }

    private Date dateTimeStringToDate(String timeString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy h:mma");
        try {
            return simpleDateFormat.parse(timeString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private int calculateEarningsAtRate(Calendar start, Calendar end, double hourlyRate){
        long duration = end.getTimeInMillis() - start.getTimeInMillis();
        int earnings = (int) (hourlyRate * (int) Math.ceil( (double) duration  / 3600000));
        return Math.max(earnings, 0);
    }
}
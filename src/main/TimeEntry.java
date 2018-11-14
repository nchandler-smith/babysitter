package main;

import java.util.Calendar;
import java.util.Date;

public interface TimeEntry {
    public Calendar getStart();
    public Calendar getEnd();
    public double getHourlyRate();
}

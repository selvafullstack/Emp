package org.orgw.simples.core.util;

import org.joda.time.DateTime;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public final class DateUtil {

    private DateUtil() {
    }

    public static Date getCurrentQuarterStartDate() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) / 3 * 3);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return new DateTime(cal.getTime()).withTimeAtStartOfDay().toDate();
    }

    public static Date getCurrentQuarterEndDate() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) / 3 * 3 + 2);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return new DateTime(cal.getTime()).withTime(23, 59, 59, 999).toDate();
    }

    public static Date getPreviousQuarterStartDate() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH) / 3 * 3) - 3);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return new DateTime(cal.getTime()).withTimeAtStartOfDay().toDate();
    }

    public static Date getPreviousQuarterEndDate() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH) / 3 * 3 + 2) - 3);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return new DateTime(cal.getTime()).withTime(23, 59, 59, 999).toDate();
    }

    public static Date findClosestPastDateFor(List<Date> dates, Date date) {
        long dateInMillis = date.getTime();
        long minDateInMillis = -1;
        Date closestPastDate = null;
        for (Date date1 : dates) {
            long time = date1.getTime();
            if (time <= dateInMillis && minDateInMillis < time) {
                minDateInMillis = time;
                closestPastDate = date1;
            }
        }
        return closestPastDate;
    }
}

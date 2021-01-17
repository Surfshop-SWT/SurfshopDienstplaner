package Model;

import java.sql.Date;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Tim Lueneburg
 * Date: 12.01.2021
 */
public class Arbeitsplan {

    private final String[] months = {"Januar", "Februar", "März", "April", "Mai", "Juni",
            "Juli", "August", "September", "Oktober", "November", "Dezember"};

    private Date aktuellesDatum;
    private List<Tag> tage;

    public Arbeitsplan() {
        this.tage = new LinkedList<>();
        this.aktuellesDatum = new Date(System.currentTimeMillis());
    }

    public Arbeitsplan monatWaehlen(Date date) {
        return this;
    }

    public Date getAktuellesDatum() {
        return this.aktuellesDatum;
    }



    public String getMonat() {
        int month = this.aktuellesDatum.toLocalDate().getMonthValue();
        return months[month - 1];
    }

    public String getMonat(int month) {
        return months[month];
    }

    public Date getStartDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(aktuellesDatum.toLocalDate().getYear() - 1, aktuellesDatum.toLocalDate().getMonthValue() - 1, 1);
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.WEEK_OF_YEAR, weekOfYear);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return new Date(cal.getTimeInMillis());
    }

    public Date getStartDate(int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(aktuellesDatum.toLocalDate().getYear() - 1, month, 1);
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.WEEK_OF_YEAR, weekOfYear);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return new Date(cal.getTimeInMillis());
    }
}

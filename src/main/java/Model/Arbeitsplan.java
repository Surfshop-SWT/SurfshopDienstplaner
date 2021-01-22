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

    /**
     * Array mit allen Monaten
     */
    private final String[] months = {"Januar", "Februar", "März", "April", "Mai", "Juni",
            "Juli", "August", "September", "Oktober", "November", "Dezember"};


    private Date aktuellesDatum;
    private List<Tag> tage;


    public Arbeitsplan() {
        this.tage = new LinkedList<>();
        this.aktuellesDatum = new Date(System.currentTimeMillis());
    }



    /*---------------------------- Getter und Setter ----------------------------*/

    public Arbeitsplan monatWaehlen(Date date) {
        return this;
    }

    /**
     * Liefert das aktuelle {@link Date}
     * @return
     */
    public Date getAktuellesDatum() {
        return this.aktuellesDatum;
    }

    /**
     * Liefert den aktuellen Monat des aktuellen Jahres
     *
     * @return
     */
    public String getMonat() {
        int month = this.aktuellesDatum.toLocalDate().getMonthValue();
        return months[month - 1];
    }

    /**
     * Liefer einen bestimmten Monat ausgewählt anhand des Monat-Indexes
     *
     * @param month
     * @return
     */
    public String getMonat(int month) {
        return months[month];
    }

    /**
     * Liefert das erste {@link Date} der ersten Kalenderwoche für den aktuellen Monat
     *
     * @return
     */
    public Date getStartDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(aktuellesDatum.toLocalDate().getYear() - 1, aktuellesDatum.toLocalDate().getMonthValue() - 1, 1);
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.WEEK_OF_YEAR, weekOfYear);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return new Date(cal.getTimeInMillis());
    }

    /**
     * Liefert das erste {@link Date} der ersten Kalenderwoche für einen bestimmten Monat
     *
     * @return
     */
    public Date getStartDate(int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(aktuellesDatum.toLocalDate().getYear() - 1, month, 1);
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.WEEK_OF_YEAR, weekOfYear);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return new Date(cal.getTimeInMillis());
    }


    /**
     * Liefert das aktuelle Jahr
     *
     * @return
     */
    public int getYear() {
        return this.aktuellesDatum.toLocalDate().getYear();
    }
}

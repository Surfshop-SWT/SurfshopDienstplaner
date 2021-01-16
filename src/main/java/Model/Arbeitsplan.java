package Model;

import java.sql.Date;
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

/*    public int getKalenderWoche() {

        return;
    }*/
}

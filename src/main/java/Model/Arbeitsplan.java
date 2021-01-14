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

    private Date aktuellesDatum;
    private List<Tag> tage;

    public Arbeitsplan() {
        this.tage = new LinkedList<>();

    }

    public Arbeitsplan monatWaehlen(Date date) {
        return this;
    }
}

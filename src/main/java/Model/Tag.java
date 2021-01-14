package Model;

import java.sql.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Tim Lueneburg
 * Date: 12.01.2021
 */
public class Tag {

    private Benutzer benutzer;
    private Date datum;
    private Woche woche;
    private TagArt art;




    public void setArt(String kind) {
        if (kind.equalsIgnoreCase("Arbeit")) {
            this.art = TagArt.Arbeit;
        } else if (kind.equalsIgnoreCase("Urlaub")) {
            this.art = TagArt.Urlaub;
        } else {
            this.art = TagArt.Frei;
        }
    }

    public TagArt getArt() {
        return this.art;
    }



    public void setDatum(Date date) {
        this.datum = date;
    }

    public Date getDatum() {
        return this.datum;
    }



    public void setBenutzer(Benutzer user) {
        this.benutzer = user;
    }

    public Benutzer getBenutzer() {
        return this.benutzer;
    }
}

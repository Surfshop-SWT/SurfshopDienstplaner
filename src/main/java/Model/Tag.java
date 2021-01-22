package Model;

import java.sql.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Tim Lueneburg
 * Date: 12.01.2021
 */
public class Tag {

    private int tid;
    private Benutzer benutzer;
    private Date datum;
    private TagArt art;
    private Kommentar kommentar = null;


    /**
     * Setzt die Tag Id
     * @param id
     */
    public void setTid(int id) {
        this.tid = id;
    }

    /**
     * Liefer die Tag Id
     * @return
     */
    public int getTid() {
        return this.tid;
    }

    /**
     * Setzt die {@link TagArt} für den Tag
     * @param kind
     */
    public void setArt(String kind) {
        if (kind.equalsIgnoreCase("Arbeit")) {
            this.art = TagArt.Arbeit;
        } else if (kind.equalsIgnoreCase("Urlaub")) {
            this.art = TagArt.Urlaub;
        } else {
            this.art = TagArt.Frei;
        }
    }

    /**
     * Liefer die {@link TagArt}
     * @return {@link TagArt}
     */
    public TagArt getArt() {
        return this.art;
    }

    /**
     * Setzt das {@link Date} des Tages
     * @param date
     */
    public void setDatum(Date date) {
        this.datum = date;
    }

    /**
     * Liefert das {@link Date}
     * @return {@link Date}
     */
    public Date getDatum() {
        return this.datum;
    }

    /**
     * Setzt des {@link Benutzer}
     * @param user
     */
    public void setBenutzer(Benutzer user) {
        this.benutzer = user;
    }

    /**
     * Liefert den {@link Benutzer}
     * @return {@link Benutzer}
     */
    public Benutzer getBenutzer() {
        return this.benutzer;
    }

    /**
     * Setzt den {@link Kommentar} für den Tag
     * @param comment
     */
    public void setKommentar(Kommentar comment) {
        this.kommentar = comment;
    }

    /**
     * Liefert den {@link Kommentar}
     * @return {@link Kommentar}
     */
    public Kommentar getKommentar() {
        return this.kommentar;
    }
}

package Model;

import java.sql.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Tim Lueneburg
 * Date: 14.01.2021
 */
public class Kommentar {

    private int kid;
    private String inhalt;
    private Date datum;
    private Benutzer benutzer;
    private int tag_id;


    /*---------------------------- Getter und Setter ----------------------------*/

    /**
     * Setzt die Kommentar Id
     * @param id
     */
    public void setKid(int id) {
        this.kid = id;
    }

    /**
     * Liefer die Kommentar Id
     * @return
     */
    public int getKid() {
        return this.kid;
    }

    /**
     * Setzt den {@link Benutzer} des Kommentars
     * @param user
     */
    public void setBenutzer(Benutzer user) {
        this.benutzer = user;
    }

    /**
     * Liefert den {@link Benutzer} des Kommentars
     * @return
     */
    public Benutzer getBenutzer() {
        return this.benutzer;
    }

    /**
     * Setzt den Inhalt des Kommentars
     * @param kontext
     */
    public void setInhalt(String kontext) {
        this.inhalt = kontext;
    }

    /**
     * Liefert den Inhalt des Kommentars
     * @return
     */
    public String getKontext() {
        return this.inhalt;
    }

    /**
     * Setzt das Datum wo das Kommentar gesetzt wurde
     * @param tag
     */
    public void setTag(Date tag) {
        this.datum = tag;
    }

    /**
     * Liefert das Daum des Kommentars
     * @return
     */
    public Date getDataum() {
        return this.datum;
    }

    /**
     * Setzt die Id des {@link Tag}
     * @param id
     */
    public void setTag_id(int id) {
        this.tag_id = id;
    }

    /**
     * Liefer die Id des {@link Tag}
     * @return
     */
    public int getTag_id() {
        return this.tag_id;
    }
}

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

    public void setKid(int id) {
        this.kid = id;
    }

    public int getKid() {
        return this.kid;
    }

    public void setBenutzer(Benutzer user) {
        this.benutzer = user;
    }

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
     * Setzt den Tag wo das Kommentar gesetzt wurde
     * @param tag
     */
    public void setTag(Date tag) {
        this.datum = tag;
    }

    /**
     * Liefert den Tag des Kommentars
     * @return
     */
    public Date getDataum() {
        return this.datum;
    }

    public void setTag_id(int id) {
        this.tag_id = id;
    }

    public int getTag_id() {
        return this.tag_id;
    }
}

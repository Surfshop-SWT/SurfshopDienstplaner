package Model;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Tim Lueneburg
 * Date: 14.01.2021
 */
public class Kommentar {

    private int kid;
    private String inhalt;
    private Date datum;


    /*---------------------------- Getter und Setter ----------------------------*/

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
}

package Model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: Tim Lueneburg
 * Date: 23.12.2020
 */
public class Benutzer {

    /**
     * Datenfelder von {@link Benutzer}
     */
    private int bid;
    private String vorname;
    private String nachname;
    private String emailadresse;
    private String telefonnummer;
    private int urlaubstage;
    private String benutzername;
    private String passwort;
    private boolean angemeldet;
    private Arbeitszeit arbeitszeit;
    private boolean admin;

    private List<Tag> tag;

    public Benutzer() {
        this.tag = new LinkedList<>();
    }


    /*---------------------------- Getter und Setter ----------------------------*/

    /**
     * Setzen der BID
     *
     * @param id
     */
    public void setBid(int id) {
        this.bid = id;
    }

    /**
     * Liefert die BID
     *
     * @return
     */
    public int getBid() {
        return this.bid;
    }

    /**
     * Setzen des Vornamen
     *
     * @param vorname
     */
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    /**
     * Liefert den Vornamen
     *
     * @return
     */
    public String getVorname() {
        return this.vorname;
    }

    /**
     * Setzen des Nachnamen
     *
     * @param nachname
     */
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    /**
     * Leifert den Nachnamen
     *
     * @return
     */
    public String getNachname() {
        return this.nachname;
    }

    /**
     * Setzen des Benutzernamen
     *
     * @param benutzername
     */
    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    /**
     * Liefert den Benutzernamen
     *
     * @return
     */
    public String getBenutzername() {
        return this.benutzername;
    }

    /**
     * Setzen des Passworts
     *
     * @param passwort
     */
    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    /**
     * Liefert das Passwort
     *
     * @return
     */
    public String getPasswort() {
        return this.passwort;
    }

    /**
     * Setzen der Telefonnummer
     *
     * @param telefonnummer
     */
    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    /**
     * Liefert die Telefonnummer
     *
     * @return
     */
    public String getTelefonnummer() {
        return this.telefonnummer;
    }

    /**
     * Setzen der E-Mail Adresse
     *
     * @param eMailAdresse
     */
    public void setEMailadresse(String eMailAdresse) {
        this.emailadresse = eMailAdresse;
    }

    /**
     * Liefert die E-Mail Adresse
     *
     * @return
     */
    public String getEMailadresse() {
        return this.emailadresse;
    }

    /**
     * Setzen der Urlaubstage
     *
     * @param tage
     */
    public void setUrlaubstage(int tage) {
        this.urlaubstage = tage;
    }

    /**
     * Liefert die Urlaubstage
     *
     * @return
     */
    public int getUrlaubstage() {
        return this.urlaubstage;
    }

    /**
     * Setzt die Arbeitszeit
     *
     * @param jobart
     */
    public void setArbeitszeit(String jobart) {
        if (jobart.equalsIgnoreCase("vollzeit")) {
            this.arbeitszeit = Arbeitszeit.VOLLZEIT;
        } else {
            this.arbeitszeit = Arbeitszeit.TEILZEIT;
        }
    }

    /**
     * Liefert die Arbeitszeit
     *
     * @return
     */
    public Arbeitszeit getArbeitszeit() {
        return arbeitszeit;
    }

    /**
     * Setzen ob der User angemeldet ist
     */
    private void setAngemeldet() {
        this.angemeldet = true;
    }

    /**
     * Gibt an ob der User Online ist oder nicht
     *
     * @return
     */
    public boolean getAngemeldet() {
        return angemeldet;
    }

    /**
     * Setzen ob der USER ein ADMIN ist oder nicht anhand eines Strings
     *
     * @param role
     */
    public void setAdmin(String role) {
        if (role.equals("chef")) {
            this.admin = true;
        } else {
            this.admin = false;
        }
    }

    /**
     * Setzen ob der USER ein ADMIN ist oder nicht
     *
     * @param role
     */
    public void setAdmin(boolean role) {
        this.admin = role;
    }

    /**
     * Liefert ob der USER ein ADMIN ist oder nicht
     *
     * @return
     */
    public boolean getAdmin() {
        return this.admin;
    }

    public String getRolle() {
        if (this.admin) return "Chef";
        else return "Mitarbeiter";
    }

    /**
     * Methode zum erstellen eines Jahres für den neu angelegten Benutzer
     */
    public void createOneYear() {
        LocalDate startDate = LocalDate.of(2021,1,1);
        LocalDate endDate = startDate.plusYears(1);
        List<LocalDate> listofDates = startDate.datesUntil(endDate).collect(Collectors.toList());
        for (LocalDate d : listofDates) {
            Tag day = new Tag();
            day.setBenutzer(this);
            day.setDatum(Date.valueOf(d));
            day.setArt("Frei");
            tag.add(day);
        }
    }

    /**
     * Setzt die Liste der {@link Tag}
     * @param days
     */
    public void setTage(List<Tag> days) {
        this.tag = days;
    }

    /**
     * Liefer die Liste der {@link Tag}
     * @return
     */
    public List<Tag> getTage() {
        return this.tag;
    }

}

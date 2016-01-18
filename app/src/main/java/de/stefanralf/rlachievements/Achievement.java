package de.stefanralf.rlachievements;

/**
 * Created by Ralf on 16.01.2016.
 */
public class Achievement {

    private String titel;
    private int zielWert;
    private int derzeitigerWert;

    public Achievement(String titel, int zielWert)
    {
        this.titel = titel;
        this.zielWert = zielWert;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public int getZielWert() {
        return zielWert;
    }

    public void setZielWert(int zielWert) {
        this.zielWert = zielWert;
    }

    public int getDerzeitigerWert() {
        return derzeitigerWert;
    }

    public void setDerzeitigerWert(int derzeitigerWert) {
        this.derzeitigerWert = derzeitigerWert;
    }
}

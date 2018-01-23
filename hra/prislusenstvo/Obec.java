package osadnicizkatanu.hra.prislusenstvo;

import java.awt.Image;
import osadnicizkatanu.hra.Hrac;

/**
 * Abstraktna trieda obec, reprezentuje obec v hre Osadnici z Katanu (dedina, mesto)
 * @author Adam
 */
public abstract class Obec {
    private String nazov;
    private Hrac hrac;

    /**
     * Konstruktor vytvori obec patriacu istemu hracovi
     * @param nazov typ obce
     * @param hrac hrac, ktoremu obec patri
     */
    public Obec(String nazov, Hrac hrac) {
        this.nazov = nazov;
        this.hrac = hrac;
    }
    
    /**
     * metoda vracia o aky druh obce sa jedna
     * @return o aky druh obce sa jedna
     */
    public String getNazov() {
        return this.nazov;
    }
    
    /**
     * abstraktna metoda vracia obrazkovu reprezentaciu obce
     * @return obrazkova reprezentacia obce
     */
    public abstract Image getReprezentacia();
}

package osadnicizkatanu.policko;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JComponent;
import osadnicizkatanu.hra.Hrac;

/**
 * Trieda vytvori policko pre pridavanie obce
 * @author Adam
 */
public class PolickoPrePridavanieObce extends JComponent implements IPolickoPrePridavanie {
    private boolean jePouzitePreDedinu;
    private boolean jePouzitePreMesto;
    private final ArrayList<HraciePolicko> hraciePolickaKtorePrekryvam;
    private Image obrazok;

    /**
     * Konstruktor vytvori policko pre pridavanie obce, ktore zatial nie je pouzite
     */
    public PolickoPrePridavanieObce() {
        this.hraciePolickaKtorePrekryvam = new ArrayList<>();
        this.jePouzitePreDedinu = false;
        this.jePouzitePreMesto = false;
    }
    
    /**
     * metoda vykresluje obec na policko pre pridavanie obce
     * @param g grafika, na ktoru sa policko vykresluje
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(this.obrazok, 0, 0, null);
    }

    /**
     * metoda vracia nazov objektu, ktory mozno polozit na dane policko pre pridavanie
     * @return nazov objektu, ktory mozno polozit na dane policko
     */
    @Override
    public String getNazovPolozitelnehoObjektu() {
        return "obec";
    }

    /**
     * metoda nastavuje policku pre pridavanie hracie policko
     * @param hraciePolicko ktore sa nastavi policku pre pridavanie
     */
    @Override
    public void nastavHraciePolicko(HraciePolicko hraciePolicko) {
        this.hraciePolickaKtorePrekryvam.add(hraciePolicko);
    }

    /**
     * metoda vykresluje na policko dany objekt
     * @param hrac hrac prave na rade
     * @param indexY y-ovy index policka pre pridavanie
     * @param typ typ objektu (pri obci)
     */
    @Override
    public void vykresliSa(Hrac hrac, int indexY, String typ) {
        if (typ.equals("dedina")) {
            this.obrazok = hrac.getDedinaReprezentacia();
            this.jePouzitePreDedinu = true;
        } else if (typ.equals("mesto")) {
            this.obrazok = hrac.getMestoReprezentacia();
            this.jePouzitePreMesto = true;
            this.setVisible(false);
        }
        this.setVisible(true);
    }

    /**
     * metoda vracia, ci je dane policko uz pouzite pre obec
     * @return ci je pouzite
     */
    @Override
    public boolean jePouzite() {
        //nikdy nenastane
        return true;
    }

    /**
     * metoda vracia konkretne hracie policko zo zoznamu hracich policok, ktore policko pre pridavanie prekryva
     * @param index index v zozname hracich policok
     * @return hracie policko ktore prekryva polciko pre pridavanie
     */
    @Override
    public HraciePolicko getHraciePolicko(int index) {
        return this.hraciePolickaKtorePrekryvam.get(index);
    }

    /**
     * metoda vracia pocet hracich policok, ktore policko pre pridavanie prekryva
     * @return pocet hracich policok, ktore policko pre pridavanie prekryva
     */
    @Override
    public int getPocetHracichPolicokKtorePrekryvam() {
        return this.hraciePolickaKtorePrekryvam.size();
    }

    /**
     * metoda vracia, ci je dane policko uz pouzite pre dedinu
     * @return ci je dane policko uz pouzite pre dedinu
     */
    @Override
    public boolean jePouzitePreDedinu() {
        return this.jePouzitePreDedinu;
    }

    /**
     * metoda vracia, ci je dane policko uz pouzite pre mesto
     * @return ci je dane policko uz pouzite pre mesto
     */
    @Override
    public boolean jePouzitePreMesto() {
        return this.jePouzitePreMesto;
    }
}

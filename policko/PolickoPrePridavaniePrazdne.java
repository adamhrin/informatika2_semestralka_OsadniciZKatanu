package osadnicizkatanu.policko;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import osadnicizkatanu.hra.Hrac;

/**
 * Trieda reprezentuje policko pre pridavanie, na ktore sa neda nic pridat
 * @author Adam
 */
public class PolickoPrePridavaniePrazdne extends JComponent implements IPolickoPrePridavanie {
    private final int velkost;
    private final Color farba;

    /**
     * Konstruktor vytvori policko pre pridavanie prazdne o velkosti a zltej farbe
     * @param velkost velkost policka
     */
    public PolickoPrePridavaniePrazdne(int velkost) {
        this.velkost = velkost;
        this.farba = Color.YELLOW;
    }

    /**
     * metoda vykresluje stvorec na policko pre pridavanie prazdne
     * @param g grafika, na ktoru sa policko vykresluje
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(this.farba);
        g2.fill(new Rectangle(this.velkost, this.velkost));
    }

    /**
     * metoda vracia nazov objektu, ktory mozno polozit na dane policko pre pridavanie
     * @return nazov objektu, ktory mozno polozit na dane policko
     */
    @Override
    public String getNazovPolozitelnehoObjektu() {
        return "prazdne";
    }

    /**
     * metoda nastavuje policku pre pridavanie hracie policko
     * @param hraciePolicko ktore sa nastavi policku pre pridavanie
     */
    @Override
    public void nastavHraciePolicko(HraciePolicko hraciePolicko) {
        System.out.println("Tu sa neda polozit nic");
    }

    /**
     * metoda vykresluje na policko dany objekt
     * @param hrac hrac prave na rade
     * @param indexY y-ovy index policka pre pridavanie
     * @param typ typ objektu (pri obci)
     */
    @Override
    public void vykresliSa(Hrac hrac, int indexY, String typ) {
        //nikdy nenastane
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * metoda vracia, ci je dane policko uz pouzite pre nejaky objekt
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
        //nikdy nenastane
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * metoda vracia pocet hracich policok, ktore policko pre pridavanie prekryva
     * @return pocet hracich policok, ktore policko pre pridavanie prekryva
     */
    @Override
    public int getPocetHracichPolicokKtorePrekryvam() {
        //nikdy nenastane
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * metoda vracia, ci je dane policko uz pouzite pre dedinu
     * @return ci je dane policko uz pouzite pre dedinu
     */
    @Override
    public boolean jePouzitePreDedinu() {
        //nikdy nenastane
        return true;
    }

    /**
     * metoda vracia, ci je dane policko uz pouzite pre mesto
     * @return ci je dane policko uz pouzite pre mesto
     */
    @Override
    public boolean jePouzitePreMesto() {
        //nikdy nenastane
        return true;
    }
}

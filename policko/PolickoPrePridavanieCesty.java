package osadnicizkatanu.policko;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JComponent;
import osadnicizkatanu.hra.Hrac;

/**
 * Trieda vytvori policko pre pridavanie cesty
 * @author Adam
 */
public class PolickoPrePridavanieCesty extends JComponent implements IPolickoPrePridavanie {
    private Image obrazok;
    private boolean jePouzite;
    
    /**
     * Konstruktor vytvori policko pre pridavanie cesty, ktore zatial nie je pouzite
     */
    public PolickoPrePridavanieCesty() {
        this.jePouzite = false;
    }

    /**
     * metoda vykresluje cestu na policko pre pridavanie cesty
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
        return "cesta";
    }

    /**
     * metoda nastavuje policku pre pridavanie hracie policko
     * @param hraciePolicko ktore sa nastavi policku pre pridavanie
     */
    @Override
    public void nastavHraciePolicko(HraciePolicko hraciePolicko) {
        System.out.println("Tu mozes polozit iba cestu"); 
    }

    /**
     * metoda vykresluje na policko dany objekt
     * @param hrac hrac prave na rade
     * @param indexY y-ovy index policka pre pridavanie
     * @param typ typ objektu (pri obci)
     */
    @Override
    public void vykresliSa(Hrac hrac, int indexY, String typ) {
        if (indexY % 2 == 0) {
            this.obrazok = hrac.getCestaHorizontalnaReprezentacia();
        } else {
            this.obrazok = hrac.getCestaVertikalnaReprezentacia();
        }
        this.jePouzite = true;
        this.setVisible(true);
    }

    /**
     * metoda vracia, ci je dane policko uz pouzite pre cestu
     * @return ci je pouzite pre cestu
     */
    @Override
    public boolean jePouzite() {
        return this.jePouzite;
    }

    /**
     * metoda vracia konkretne hracie policko zo zoznamu hracich policok, ktore policko pre pridavanie prekryva
     * @param index index v zozname hracich policok
     * @return hracie policko ktore prekryva polciko pre pridavanie
     */
    @Override
    public HraciePolicko getHraciePolicko(int index) {
        //nenastane nikdy
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * metoda vracia pocet hracich policok, ktore policko pre pridavanie prekryva
     * @return pocet hracich policok, ktore policko pre pridavanie prekryva
     */
    @Override
    public int getPocetHracichPolicokKtorePrekryvam() {
        //nenastane nikdy
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * metoda vracia, ci je dane policko uz pouzite pre dedinu
     * @return ci je dane policko uz pouzite pre dedinu
     */
    @Override
    public boolean jePouzitePreDedinu() {
        //nenastane nikdy
        return true;
    }
    
    /**
     * metoda vracia, ci je dane policko uz pouzite pre mesto
     * @return ci je dane policko uz pouzite pre mesto
     */
    @Override
    public boolean jePouzitePreMesto() {
        //nenastane nikdy
        return true;
    }    
}

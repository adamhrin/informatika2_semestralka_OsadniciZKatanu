package osadnicizkatanu.hra.prislusenstvo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import osadnicizkatanu.hra.Hrac;

/**
 * Trieda, ktora sa pouziva na vykreslenie cesty na hraci panel hraca 
 * @author Adam
 */
public class VykreslovacCesty extends JComponent {
    private Hrac hrac;
    
    /**
     * Konstruktor, ktory sa vola pri pridani tohto komponentu do hlavneho okna
     */
    public VykreslovacCesty() {
    }

    /**
     * Konstruktor vykreslovaca cesty patriacej urcitemu hracovi
     * @param hrac hrac, ktoremu cesta patri
     */
    public VykreslovacCesty(Hrac hrac) {
        this.hrac = hrac;
    }

    /**
     * metoda vykreslujuca cestu na hraci panel hraca
     * @param g grafika, na ktoru sa vykresluje
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2 = (Graphics2D)g;
        
        //len aby vedel vykreslit komponent pred zapnutim programu v manazeri
        if (this.hrac == null) {
            this.hrac = new Hrac("nema byt", "nema byt");
        } 
        
        g2.drawImage(this.hrac.getCestaHorizontalnaReprezentacia(), 0, 0, null);
    }

}

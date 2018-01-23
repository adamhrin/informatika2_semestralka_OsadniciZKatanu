package osadnicizkatanu.hra.prislusenstvo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import osadnicizkatanu.hra.Hrac;

/**
 * Trieda, ktora sa pouziva na vykreslenie obce na hraci panel hraca 
 * @author Adam
 */
public class VykreslovacObce extends JComponent {

    private Hrac hrac;
    private String typObce;

    /**
     * Konstruktor, ktory sa vola pri pridani tohto komponentu do hlavneho okna
     */
    public VykreslovacObce() {
    }
    
    /**
     * Konstruktor vykreslovaca obce patriacej urcitemu hracovi
     * @param hrac hrac, ktoremu obec patri
     * @param typObce typ obce (dedina, mesto)
     */
    public VykreslovacObce(Hrac hrac, String typObce) {
        this.hrac = hrac;
        this.typObce = typObce;
    }

    /**
     * metoda vykreslujuca obec na hraci panel hraca
     * @param g grafika, na ktoru sa vykresluje
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        //len aby vedel komponent vykreslit manazer - hlavne okno, pred spustenim programu
        if (this.hrac == null) {
            this.hrac = new Hrac("nema byt", "nema byt");
        }
        
        if (this.typObce == null) {
            this.typObce = "";
        }
        
        if (this.typObce.equals("dedina")) {
            g2.drawImage(this.hrac.getDedinaReprezentacia(), 0, 0, null);
        } else if (this.typObce.equals("mesto")) {
            g2.drawImage(this.hrac.getMestoReprezentacia(), 0, 0, null);
        }
        
    }
    
}

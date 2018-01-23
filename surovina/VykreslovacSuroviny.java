package osadnicizkatanu.surovina;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 * Trieda vykresluje surovinu na hraciu plochu aj na hraci panel hraca
 * @author Adam
 */
public class VykreslovacSuroviny extends JComponent {
    private Surovina surovina;
    private final int x;
    private final int y;
    private String typ;

    /**
     * Konstruktor vytvori vykreslovac suroviny daneho druhu
     * @param surovina surovina, ktora sa vykresli
     * @param x x-ova pozicia obrazku
     * @param y y-ova pozicia obrazku
     * @param typVykreslenia typ obrazku (maly, velky)
     */
    public VykreslovacSuroviny(Surovina surovina, int x, int y, String typVykreslenia) {
        this.typ = typVykreslenia;
        this.surovina = surovina;
        this.x = x;
        this.y = y;
    }

    /**
     * metoda vykresli surovinu
     * @param g grafika, na ktoru sa vykresluje
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2 = (Graphics2D)g;
        
        if (this.surovina == null) {
            this.surovina = new Drevo();
        }
        
        if (this.typ == null) {
            this.typ = "";
        }
        
        if (this.typ.equals("velke")) {
            g2.drawImage(this.surovina.getReprezentaciaVelka(), this.x, this.y, null);
        } else {
            g2.drawImage(this.surovina.getReprezentaciaMala(), this.x, this.y, null);
        }
        
    }
    
    /**
     * metoda vrati instanciu tejto triedy ako JComponent
     * @return instancia tejto triedy ako JComponent
     */
    public JComponent dajKomponent() {
        return this;
    }
}

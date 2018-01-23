package osadnicizkatanu.policko;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JComponent;

/**
 * Trieda reprezentuje policko s cislom, ktore je umiestnene na hracom policku
 * @author Adam
 */
public class PolickoCislo extends JComponent {

    private RoundRectangle2D.Double zaoblenyStvorec;
    private final int velkost;
    private final int cislo;

    /**
     * Konstruktor vytvori policko s cislom a velkostou
     * @param velkost velkost policka s cislom
     * @param cislo cislo policka
     */
    public PolickoCislo(int velkost, int cislo) {
        this.velkost = velkost;
        this.cislo = cislo;
    }
    
    /**
     * metoda vytvori zaobleny stvorec pouzity na vykreslenie policka s cislom
     */
    public void vytvorZaoblenyStvorec() {
        this.zaoblenyStvorec = new RoundRectangle2D.Double(30, 30, this.velkost, this.velkost, 10, 10);
    }

    /**
     * meotoda vykresli zaobleny stvorec s cislom, ktoreho velkost prisposobi podla toho, ake cislo to je
     * (cim pravdepodonejsie je, ze sucet cisle padne na kocke, tym vacsie je cislo)
     * @param g grafika, na ktoru sa vykresluje
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        this.vytvorZaoblenyStvorec();
        g2.setColor(new Color(150, 200, 200, 200));
        g2.fill(this.zaoblenyStvorec);
        g2.setColor(Color.BLACK);
        Font font = new Font("Serif", Font.BOLD, 30);
        g2.setFont(font);
        switch (this.cislo) {
            case 2:
            case 3:
            case 4:
            case 12:
                if (this.cislo == 12) {
                    Font font12 = new Font("Serif", Font.BOLD, 20);
                    g2.setFont(font12);
                    g2.drawString(String.valueOf(this.cislo), 38, 55);
                } else {
                    Font font234 = new Font("Serif", Font.BOLD, 20);
                    g2.setFont(font234);
                    g2.drawString(String.valueOf(this.cislo), 43, 55);
                }   
                break;
            case 11:
            case 10:
            case 9:
            case 5:
                if (this.cislo == 10 || this.cislo == 11) {
                    Font font1011 = new Font("Serif", Font.BOLD, 25);
                    g2.setFont(font1011);
                    g2.drawString(String.valueOf(this.cislo), 34, 55);
                } else {
                    Font font59 = new Font("Serif", Font.BOLD, 25);
                    g2.setFont(font59);
                    g2.drawString(String.valueOf(this.cislo), 40, 57);
                }   
                break;
            default:
                Font font68 = new Font("Serif", Font.BOLD, 35);
                g2.setColor(Color.red);
                g2.setFont(font68);
                g2.drawString(String.valueOf(this.cislo), 39, 60);
                break;
        }
    }

    /**
     * metoda vrati cislo tohto policka
     * @return cislo tohto policka
     */
    public int getCislo() {
        return this.cislo;
    }
    
}

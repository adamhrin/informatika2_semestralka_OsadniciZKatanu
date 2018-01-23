package osadnicizkatanu.hra.prislusenstvo;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import osadnicizkatanu.hra.Hrac;

/**
 * Trieda reprezentuje cestu v hre Osadnici z Katanu
 * @author Adam
 */
public class Cesta {
    
    private final String farba;

    /**
     * Kontruktor vytvori cestu patriacu istemu hracovi
     * @param hrac hrac, ktoremu cesta patri
     */
    public Cesta(Hrac hrac) {
        this.farba = hrac.getFarba();
    }
    
    /**
     * metoda vrati obrazkovu reprezentaciu horizontalnej cesty, ktora sa vykresluje na hraciu plochu
     * @return obrazkova reprezentacia horizontalnej cesty
     */
    public Image getReprezentaciaHorizontalna() {
        Image cestaHorizontalna = null;
        
        if (this.farba.equals("modra")) {
            try {
                cestaHorizontalna = ImageIO.read(this.getClass().getResource("/OzK_cestaModraHorizontalna.png"));
                //cestaHorizontalna = ImageIO.read(new File("img/OzK_cestaModraHorizontalna.png"));
            } catch (IOException ex) {
                System.out.println("Obrazok neexistuje");
            }
        }
        
        if (this.farba.equals("cervena")) {
            try {
                cestaHorizontalna = ImageIO.read(this.getClass().getResource("/OzK_cestaCervenaHorizontalna.png"));
                //cestaHorizontalna = ImageIO.read(new File("img/OzK_cestaCervenaHorizontalna.png"));
            } catch (IOException ex) {
                System.out.println("Obrazok neexistuje");
            }
        }
        
        return cestaHorizontalna;
    }
    
    /**
     * metoda vrati obrazkovu reprezentaciu vertikalnej cesty, ktora sa vykresluje na hraciu plochu
     * @return obrazkova reprezentacia vertikalnej cesty
     */
    public Image getReprezentaciaVertikalna() {
        Image cestaVertikalna = null;
        
        if (this.farba.equals("modra")) {
            try {
                cestaVertikalna = ImageIO.read(this.getClass().getResource("/OzK_cestaModraVertikalna.png"));
                //cestaVertikalna = ImageIO.read(new File("img/OzK_cestaModraVertikalna.png"));
            } catch (IOException ex) {
                System.out.println("Obrazok neexistuje");
            }
        }
        
        if (this.farba.equals("cervena")) {
            try {
                cestaVertikalna = ImageIO.read(this.getClass().getResource("/OzK_cestaCervenaVertikalna.png"));
                //cestaVertikalna = ImageIO.read(new File("img/OzK_cestaCervenaVertikalna.png"));
            } catch (IOException ex) {
                System.out.println("Obrazok neexistuje");
            }
        }
        
        return cestaVertikalna;
    }
}
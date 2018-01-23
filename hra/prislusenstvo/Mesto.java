package osadnicizkatanu.hra.prislusenstvo;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import osadnicizkatanu.hra.Hrac;

/**
 * Trieda reprezentujuca mesto v hre Osadnici z Katanu
 * @author Adam
 */
public class Mesto extends Obec {
    
    private final String farba;

    /**
     * Konstruktor vytvori mesto patriace istemu hracovi
     * @param hrac hrac, ktoremu mesto patri
     */
    public Mesto(Hrac hrac) {
        super("mesto", hrac);
        this.farba = hrac.getFarba();
    }

    /**
     * metoda vracia obrazkovu reprezentaciu mesta, ktore sa vykresluje na hraciu plochu
     * @return obrazkova reprezentacia mesta
     */
    @Override
    public Image getReprezentacia() {
        Image mesto = null;
        
        if (this.farba.equals("modra")) {
            try {
                mesto = ImageIO.read(this.getClass().getResource("/OzK_mestoModre.png"));
                //mesto = ImageIO.read(new File("img/OzK_mestoModre.png"));
            } catch (IOException ex) {
                System.out.println("Obrazok neexistuje");
            }
        }
        
        if (this.farba.equals("cervena")) {
            try {
                mesto = ImageIO.read(this.getClass().getResource("/OzK_mestoCervene.png"));
                //mesto = ImageIO.read(new File("img/OzK_mestoCervene.png"));
            } catch (IOException ex) {
                System.out.println("Obrazok neexistuje");
            }
        }
        return mesto;
    }
    
}

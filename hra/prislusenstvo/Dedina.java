package osadnicizkatanu.hra.prislusenstvo;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import osadnicizkatanu.hra.Hrac;

/**
 * Trieda reprezentujuca dedinu v hre Osadnici z Katanu
 * @author Adam
 */
public class Dedina extends Obec {
    
    private final String farba;

    /**
     * Kontruktor vytvori dedinu patriacu istemu hracovi
     * @param hrac hrac, ktoremu dedina patri
     */
    public Dedina(Hrac hrac) {
        super("dedina", hrac);
        this.farba = hrac.getFarba();
    }

    /**
     * metoda vrati obrazkovu reprezentaciu dediny, ktora sa vykresluje na hraciu plochu
     * @return obrazkovu reprezentaciu dediny
     */
    @Override
    public Image getReprezentacia() {
        Image dedina = null;
        
        if (this.farba.equals("modra")) {
            try {
                dedina = ImageIO.read(this.getClass().getResource("/OzK_dedinaModra.png"));
                //dedina = ImageIO.read(new File("img/OzK_dedinaModra.png"));
            } catch (IOException ex) {
                System.out.println("Obrazok neexistuje");
            }
        }
        
        if (this.farba.equals("cervena")) {
            try {
                dedina = ImageIO.read(this.getClass().getResource("/OzK_dedinaCervena.png"));
                //dedina = ImageIO.read(new File("img/OzK_dedinaCervena.png"));
            } catch (IOException ex) {
                System.out.println("Obrazok neexistuje");
            }
        }
        
        return dedina;
    }
}

package osadnicizkatanu.surovina;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 * Abstraktna trieda reprezentujuvca surovinu v hra Osadnici z Katanu
 * @author Adam
 */
public abstract class Surovina {
  
    private final String nazov;
    private final String reprezentaciaVelka;
    private final String reprezentaciaMala;

    /**
     * Konstruktor suroviny s parametrami pre obrazkovu reprezentaciu danej suroviny
     * @param reprezentaciaVelka obrazok pre reprezentaciu suroviny velky
     * @param reprezentaciaMala obrazok pre reprezentaciu suroviny maly
     * @param nazov nazov suroviny
     */
    public Surovina(String reprezentaciaVelka, String reprezentaciaMala, String nazov) {
        this.reprezentaciaVelka = reprezentaciaVelka;
        this.reprezentaciaMala = reprezentaciaMala;
        this.nazov = nazov;
    }
    
    /**
     * metoda vracia malu obrazkovu reprezentaciu danej suroviny
     * @return mala obrazkova reprezentacia danej suroviny
     */
    public BufferedImage getReprezentaciaMala() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(this.getClass().getResource(this.reprezentaciaMala));
            //img = ImageIO.read(new File(this.reprezentaciaMala));
        } catch (Exception e) {
            System.out.println("obrazok sa nenasiel");
        }
        return img;
    }
    
    /**
     * metoda vracia velku obrazkovu reprezentaciu danej suroviny
     * @return velka obrazkova reprezentacia danej suroviny
     */
    public BufferedImage getReprezentaciaVelka() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(this.getClass().getResource(this.reprezentaciaVelka));
            //img = ImageIO.read(new File(this.reprezentaciaVelka));
        } catch (Exception e) {
            System.out.println("obrazok sa nenasiel");
        }
        return img;
    }

    /**
     * metoda vracia nazov suroviny
     * @return nazov suroviny
     */
    public String getNazov() {
        return this.nazov;
    }
}

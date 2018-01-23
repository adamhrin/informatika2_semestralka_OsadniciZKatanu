package osadnicizkatanu.uvod;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 * Trieda reprezentuje pozadie uvodnej obrazovky hry
 * @author Adam
 */
public class Pozadie extends JPanel {
    private final Image image;
    
    /**
     * Konstruktor vytvori pozadie uvodnej obrazovky
     * @param image 
     */
    public Pozadie(Image image) {
        this.image = image;
    }
    
    /**
     * metoda na vykreslenie pozadia uvodnej obrazovky
     * @param g 
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.image, 0, 0, this);
    }
}

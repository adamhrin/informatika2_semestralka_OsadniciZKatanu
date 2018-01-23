package osadnicizkatanu.hra.prislusenstvo;

import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import osadnicizkatanu.hra.Hrac;
import osadnicizkatanu.hra.HracPanel;

/**
 * Trieda reprezentujuca hraciu kocku v hre Osadnici z Katanu
 * @author Adam
 */
public class Kocka {
    private int pocitadloHodov;
    private int sucetHodov;
    private final Random nahodnyPokus;
    private boolean jePrvyHod;

    /**
     * Konstruktor vytvori hraciu kocku
     */
    public Kocka() {
        this.jePrvyHod = true;
        this.pocitadloHodov = 0;
        this.sucetHodov = 0;
        this.nahodnyPokus = new Random();
    }
    
    /**
     * metoda vygeneruje nahodne cislo z rozsahu 1-6 a pripocita ho k doterajsiemu vysledku
     */
    public void hodKockou() {
        this.sucetHodov += this.nahodnyPokus.nextInt(6) + 1;
        this.pocitadloHodov++;
    }
    
    /**
     * metoda nastavi poradove cislo hodu v jednom tahu hraca
     * @param prvyHod ci ma byt kocka nastavena na prvy hod
     */
    public void setJePrvyHod(boolean prvyHod) {
        this.jePrvyHod = prvyHod;
    }

    /**
     * metoda vykonava hod kockou a posiela hracovi spravu o tom, co hodil
     * @param hracNaRade hrac prave na rade
     * @param hracNehrajuci hrac prave nehrajuci
     * @param tah poradove cislo tahu
     * @param hlavneOkno hlavne okno hry
     * @param lblSucetHodov ukazovadlo vysledku hodov kockou
     */
    public void vykonajAkciu(Hrac hracNaRade, Hrac hracNehrajuci, int tah, JFrame hlavneOkno, JLabel lblSucetHodov) {
        HracPanel hracNaRadePanel = (HracPanel)hracNaRade.getPanel();
        if (this.jePrvyHod && this.pocitadloHodov != 1) {
            this.sucetHodov = 0;
            this.pocitadloHodov = 0;
            this.hodKockou();
            lblSucetHodov.setText("Prvý hod: " + this.sucetHodov);
            this.jePrvyHod = false;
        } else if (this.pocitadloHodov == 1) {
            if (tah <= 4) {
                hracNaRadePanel.aktivujTlacidloKupDedinu();
            } else {
                hracNaRadePanel.setStlacitelnostKupovacichTlacidiel(true);
            }
            hracNaRadePanel.aktualizujPocitadlaSurovin();
            hracNaRadePanel.aktualizujPocitadlaPrislusenstva();
            
            this.hodKockou();
            lblSucetHodov.setText("Súčet: "  + this.sucetHodov);
            
            hracNaRade.pridajSiSuroviny(hracNaRade, this.sucetHodov, hlavneOkno);
            hracNehrajuci.pridajSiSuroviny(hracNaRade, this.sucetHodov, hlavneOkno);
            
            hracNaRadePanel.aktualizujPocitadlaSurovin();
        } else {
            JOptionPane.showMessageDialog(hlavneOkno, "Nemôžeš hodiť viac ako dvakrát!");
        }
    }
    
} 
